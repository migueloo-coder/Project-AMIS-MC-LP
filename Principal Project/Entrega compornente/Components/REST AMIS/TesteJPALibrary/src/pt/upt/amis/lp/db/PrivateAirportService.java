package pt.upt.amis.lp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrivateAirportService {

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
	
	private boolean saveData(PrivateAirport privateAirport) {
		
		try {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.persist(privateAirport);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}

	public PrivateAirportService(EntityManager em) {
		this.em = em;
	}

	public PrivateAirportService() {
		this.em = getEM();
	}

	public PrivateAirport updatePrivateAirport(PrivateAirport privateAirport) {
		PrivateAirport pa = em.find(PrivateAirport.class, privateAirport.getIdAirport());
		if (pa == null) {
			pa = new PrivateAirport();
			em.persist(pa);
		}
		//pa.setIdAirport(privateAirport.getIdAirport());
		pa.setName(privateAirport.getName());
		pa.setCity(privateAirport.getCity());
		pa.setCountry(privateAirport.getCountry());
		pa.setListCompanys(privateAirport.getListCompanys());
		pa.setListEnterprises(privateAirport.getListEnterprises());
		saveData(pa);
		return pa;
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
		saveData(pa);
		return pa;
	}

	public boolean removePrivateAirport( int idAirport) {
		PrivateAirport rmpa = findPrivateAirport(idAirport);
		if (rmpa != null) {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.remove(rmpa);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
			return true;
	}
	return false;
	
	}

	public PrivateAirport findPrivateAirport( int idAirport) {
		return em.find(PrivateAirport.class, idAirport);
	}
	
	public List<PrivateAirport> findAllPrivateAirports() {
		 Query qd = em.createQuery("SELECT pa FROM PrivateAirport pa");
		 return qd.getResultList();
	}

}
