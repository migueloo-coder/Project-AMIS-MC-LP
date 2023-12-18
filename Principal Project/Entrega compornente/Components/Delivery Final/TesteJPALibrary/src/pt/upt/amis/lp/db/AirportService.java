package pt.upt.amis.lp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//import pt.upt.amis.lp.db.Airport;


public class AirportService {
	
	private static final String PERSISTENCE_UNIT_NAME = "LibraryJPA";
	private static EntityManagerFactory factory;
	private static EntityManager em = null;

	private static EntityManager getEM() {
		if (em == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();
		}
		return em;
	}
	
	private boolean saveData(Airport airport) {
		
		try {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.persist(airport);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}

	public AirportService(EntityManager em) {
		this.em = em;
	}

	public AirportService() {
		this.em = getEM();
	}

	public Airport updateAirport( Airport airport) {
		Airport a = em.find(Airport.class, airport.getIdAirport());
		if (a == null) {
			
			//a = new Airport();
			saveData(airport);
			//em.persist( a);
			return airport;
		}
		a.setIdAirport(airport.getIdAirport());
		a.setName(airport.getName());
		a.setCity(airport.getCity());
		a.setCountry(airport.getCountry());
		a.setListCompanys(airport.getListCompanys());
		
		saveData(a);
		//em.persist( a);
		
		return a;
	}

	public Airport updateAirport( int idAirport, String name, String city, String country, Company c[]) {
		Airport a = em.find(Airport.class, idAirport);
		if (a == null) {
			a = new Airport();
			saveData(a);
			//em.persist( a);
		}
		a.setIdAirport(idAirport);
		a.setName(name);
		a.setCity(city);
		a.setCountry(country);
		a.setListCompanys(c);
		//em.persist( a);
		saveData(a);
		return a;
	}
	
	
	public boolean removeAirport( int idAirport) {
		Airport a = findAirport(idAirport);
		if (a != null)
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.remove(a);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
			//em.remove(a);
		return true;
	}

	public Airport findAirport( int idAirport) {
		return em.find(Airport.class, idAirport);
	}
	
	public List<Airport> findAllAirports() {
		 Query qd = em.createQuery("SELECT a FROM Airport a");
		 return qd.getResultList();
	}

}
