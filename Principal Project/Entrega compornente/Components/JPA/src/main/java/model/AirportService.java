package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class AirportService {
	protected EntityManager em;
	
	public AirportService(EntityManager em) {
		this.em = em;
	}
	
	public Airport updateAirport( int idAirport, String name, String city, String country, Company c[]) {
		Airport a = em.find(Airport.class, idAirport);
		if (a == null) {
			a = new Airport();
			em.persist( a);
		}
		a.setId(idAirport);
		a.setName(name);
		a.setCity(city);
		a.setCountry(country);
		a.setListCompanys(c);
		em.persist( a);
		return a;
	}

	public void removeAirport( int idAirport) {
		Airport rma = findAirport(idAirport);
		if (rma != null)
			em.remove(rma);
		return;
	}

	public Airport findAirport( int idAirport) {
		return em.find(Airport.class, idAirport);
	}
	
	public List<Airport> findAllAirports() {
		 Query qd = em.createQuery("SELECT a FROM Airport a");
		 return qd.getResultList();
	}

}
