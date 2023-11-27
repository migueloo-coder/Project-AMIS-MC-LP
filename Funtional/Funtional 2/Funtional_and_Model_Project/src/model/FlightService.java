package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FlightService {
protected EntityManager em;
	
	public FlightService(EntityManager em) {
		this.em = em;
	}
	
	public Flight updateFlight(String idFlight, String originCity, String destinationCity, double cost, int numMaxPassengers) {
		Flight fli = em.find(Flight.class, idFlight);
		if (fli == null) {
			fli = new Flight(idFlight, originCity, destinationCity, cost, numMaxPassengers);
			em.persist( fli);
		}
		
		fli.setIdFlight(idFlight);
		fli.setOriginCity(originCity);
		fli.setDestinationCity(destinationCity);
		fli.setCost(cost);
		fli.setNumMaxPassengers(numMaxPassengers);
		
		em.persist( fli);
		return fli;
	}

	public void removeFlight( int idFlight) {
		Flight rmfli = findFlight(idFlight);
		if (rmfli != null)
			em.remove(rmfli);
		return;
	}

	public Flight findFlight( int idFlight) {
		return em.find(Flight.class, idFlight);
	}
	
	public List<Airport> findAllFlights() {
		 Query qd = em.createQuery("SELECT fli FROM Flight fli");
		 return qd.getResultList();
	}
}
