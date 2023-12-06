package pt.upt.amis.lp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PassengerService {

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
	
	private boolean saveData(Passenger passenger) {
		
		try {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.persist(passenger);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}

	public PassengerService(EntityManager em) {
		this.em = em;
	}

	public PassengerService() {
		this.em = getEM();
	}
	public Passenger updatePassenger(Passenger passenger ) {
		Passenger pass = em.find(Passenger.class, passenger.getIdDocument());
		if (pass == null) {
			pass = new Passenger();
			em.persist( pass);
		}
		//pass.setIdDocument(passenger.getIdDocument());
		pass.setNames(passenger.getNames());
		pass.setSurnames(passenger.getSurnames());
		pass.setGenre(passenger.getGenre());
		pass.setDateBirth(passenger.getDateBirth());
		pass.setTypeId(passenger.getTypeId());
		pass.setAddress(passenger.getAddress());
		pass.setTelephone(passenger.getTelephone());
		pass.setEmail(passenger.getEmail());
		pass.setPassport(passenger.getPassport());
		pass.setNationality(passenger.getNationality());
		saveData(pass);
		return pass;
	}
	public Passenger updatePassenger( int idDocument, String names, String surnames, String genre, String dateBirth, String typeId, 
			String address, String telephone, String email, String passport, String nationality) {
		Passenger pass = em.find(Passenger.class, idDocument);
		if (pass == null) {
			pass = new Passenger();
			saveData(pass);
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
		saveData(pass);
		return pass;
	}

	public boolean removePassenger( int idDocument) {
		Passenger rmpass = findPassenger(idDocument);
		if (rmpass != null) {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.remove(rmpass);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();

			return true;
	}
	return false;
	
	}

	public Passenger findPassenger( int idDocument) {
		return em.find(Passenger.class, idDocument);
	}
	
	public List<Passenger> findAllPassengers() {
		 Query qd = em.createQuery("SELECT pass FROM Passenger pass");
		 return qd.getResultList();
	}
}
