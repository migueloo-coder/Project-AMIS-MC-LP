package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PublicAirportService {
protected EntityManager em;
	
	public PublicAirportService(EntityManager em) {
		this.em = em;
	}
	
	public PublicAirport updatePublicAirport( int idAirport, String name, String city, String country, Company[] c, double subsidy) {
		PublicAirport pua = em.find(PublicAirport.class, idAirport);
		if (pua == null) {
			pua = new PublicAirport();
			em.persist(pua);
		}
		pua.setIdAirport(idAirport);
		pua.setName(name);
		pua.setCity(city);
		pua.setCountry(country);
		pua.setListCompanys(c);
		pua.setSubsidy(subsidy);
		em.persist(pua);
		return pua;
	}

	public void removePublicAirport( int idAirport) {
		PublicAirport rmpua = findPublicAirport(idAirport);
		if (rmpua != null)
			em.remove(rmpua);
		return;
	}

	public PublicAirport findPublicAirport( int idAirport) {
		return em.find(PublicAirport.class, idAirport);
	}
	
	public List<PublicAirport> findAllPublicAirports() {
		 Query qd = em.createQuery("SELEClicT pua FROM PrivateAirport pua");
		 return qd.getResultList();
	}

}
