package pt.upt.amis.lp.db;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PassengerService {
protected EntityManager em;
	
	public PassengerService(EntityManager em) {
		this.em = em;
	}
	
	public Passenger updatePassenger(int idDocument, String names, String surnames, String genre, Date dateBirth, String typeId, 
			String address, String telephone, String email, String passport, String nationality) {	
		Passenger p = em.find(Passenger.class, idDocument);
		if (p == null) {
			p = new Passenger(idDocument, nationality, nationality, nationality, dateBirth, nationality, nationality, nationality, nationality, nationality, nationality);
			em.persist(p);
		}
		p.setIdDocument(idDocument);
		p.setNames(names);
		p.setSurnames(surnames);
		p.setGenre(genre);
		p.setDateBirth(dateBirth);
		p.setTypeId(typeId);
		p.setAddress(address);
		p.setTelephone(telephone);
		p.setEmail(email);
		p.setPassport(passport);
		p.setNationality(nationality);
		return p;
	}
	
	public void removePassenger(int idDocument) {
		Passenger l = findPassenger(idDocument);
		if(l != null) 
			em.remove(l);
		return;
	}
	
	public Passenger findPassenger(int idDocument) {
		return em.find(Passenger.class, idDocument);
	}
	
}
