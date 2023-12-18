package pt.upt.amis.lp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pt.upt.amis.lp.db.Flight;

public class FlightService {
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
	
	private boolean saveData(Flight flight) {
		
		try {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.persist(flight);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}

	public FlightService(EntityManager em) {
		this.em = em;
	}

	public FlightService() {
		this.em = getEM();
	}

	public Flight updateFlight(Flight flight) {
		Flight fli = em.find(Flight.class, flight.getIdDBFlight());
		if (fli == null) {
			saveData(fli);
			//em.persist( a);
			return flight;
		}
		fli.setIdDBFlight(flight.getIdDBFlight());
		fli.setIdFlight(flight.getIdFlight());
		fli.setOriginCity(flight.getOriginCity());
		fli.setDestinationCity(flight.getDestinationCity());
		fli.setCost(flight.getCost());
		fli.setNumMaxPassengers(flight.getNumMaxPassengers());
		
		saveData(fli);
		
		return fli;
	}
	
	public Flight updateFlight(int idDBFlight, String idFlight, String originCity, String destinationCity, double cost, int numMaxPassengers) {
		Flight fli = em.find(Flight.class, idDBFlight);
		if (fli == null) {
			fli = new Flight();
			saveData(fli);
		}
		fli.setIdDBFlight(idDBFlight);
		fli.setIdFlight(idFlight);
		fli.setOriginCity(originCity);
		fli.setDestinationCity(destinationCity);
		fli.setCost(cost);
		fli.setNumMaxPassengers(numMaxPassengers);
		saveData(fli);
		return fli;
	}
	

	public boolean removeFlight( int idDBFlight) {
		Flight fli = findFlight(idDBFlight);
		if (fli != null)
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.remove(fli);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
			//em.remove(a);
		return true;
	}

	public Flight findFlight( int idDBFlight) {
		return em.find(Flight.class, idDBFlight);
	}
	
	public List<Flight> findAllFlights() {
		 Query qd = em.createQuery("SELECT fli FROM Flight fli");
		 return qd.getResultList();
	}
}
