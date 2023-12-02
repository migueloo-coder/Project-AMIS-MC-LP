package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FlightService {
protected EntityManager em;
	
	public FlightService(EntityManager em) {
		this.em = em;
	}
	
	public Flight updateFlight(int idDBFlight, String idFlight, String originCity, String destinationCity, double cost, int numMaxPassengers) {
		Flight fli = em.find(Flight.class, idDBFlight);
		if (fli == null) {
			fli = new Flight();
			em.persist( fli);
		}
		fli.setIdDBFlight(idDBFlight);
		fli.setIdFlight(idFlight);
		fli.setOriginCity(originCity);
		fli.setDestinationCity(destinationCity);
		fli.setCost(cost);
		fli.setNumMaxPassengers(numMaxPassengers);
		
		em.persist( fli);
		return fli;
	}

	public void removeFlight( int idDBFlight) {
		Flight rmfli = findFlight(idDBFlight);
		if (rmfli != null)
			em.remove(rmfli);
		return;
	}

	public Flight findFlight( int idDBFlight) {
		return em.find(Flight.class, idDBFlight);
	}
	
	public List<Flight> findAllFlights() {
		 Query qd = em.createQuery("SELECT fli FROM Flight fli");
		 return qd.getResultList();
	}
}
