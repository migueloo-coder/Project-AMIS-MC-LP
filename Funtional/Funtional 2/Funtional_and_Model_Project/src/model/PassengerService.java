package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PassengerService {
protected EntityManager em;
	
	public PassengerService(EntityManager em) {
		this.em = em;
	}
	
	public Passenger updatePassenger( int idDocument, String names, String surnames, String genre, String dateBirth, String typeId, 
			String address, String telephone, String email, String passport, String nationality) {
		Passenger pass = em.find(Passenger.class, idDocument);
		if (pass == null) {
			pass = new Passenger(idDocument, names, surnames, genre, dateBirth, typeId, address, telephone,email,passport, nationality);
			em.persist( pass);
		}
		pass.setIdDocument(idDocument);
		pass.setNames(names);
		pass.setSurnames(surnames);
		pass.setGenre(genre);
		pass.setDateBirth(dateBirth);
		pass.setTypeId(typeId);
		pass.setAddress(address);
		pass.setTelephone(telephone);
		pass.setEmail(email);
		pass.setPassport(passport);
		pass.setNationality(nationality);
		em.persist( pass);
		return pass;
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
