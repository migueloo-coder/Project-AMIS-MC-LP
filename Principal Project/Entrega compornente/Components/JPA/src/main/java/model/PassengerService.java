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
			pass = new Passenger();
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

	public void removePassenger( int idDocument) {
		Passenger rmpass = findPassenger(idDocument);
		if (rmpass != null)
			em.remove(rmpass);
		return;
	}

	public Passenger findPassenger( int idDocument) {
		return em.find(Passenger.class, idDocument);
	}
	
	public List<Passenger> findAllPassengers() {
		 Query qd = em.createQuery("SELECT pass FROM Passenger pass");
		 return qd.getResultList();
	}
}
