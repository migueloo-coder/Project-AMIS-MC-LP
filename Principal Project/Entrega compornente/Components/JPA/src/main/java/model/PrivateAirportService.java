package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PrivateAirportService {
protected EntityManager em;
	
	public PrivateAirportService(EntityManager em) {
		this.em = em;
	}
	
	public PrivateAirport updatePrivateAirport( int idAirport, String name, String city, String country, Company[] c, String e[]) {
		PrivateAirport pa = em.find(PrivateAirport.class, idAirport);
		if (pa == null) {
			pa = new PrivateAirport();
			em.persist(pa);
		}
		pa.setIdAirport(idAirport);
		pa.setName(name);
		pa.setCity(city);
		pa.setCountry(country);
		pa.setListCompanys(c);
		pa.setListEnterprises(e);
		em.persist(pa);
		return pa;
	}

	public void removePrivateAirport( int idAirport) {
		PrivateAirport rmpa = findPrivateAirport(idAirport);
		if (rmpa != null)
			em.remove(rmpa);
		return;
	}

	public PrivateAirport findPrivateAirport( int idAirport) {
		return em.find(PrivateAirport.class, idAirport);
	}
	
	public List<PrivateAirport> findAllPrivateAirports() {
		 Query qd = em.createQuery("SELECT pa FROM PrivateAirport pa");
		 return qd.getResultList();
	}

}
