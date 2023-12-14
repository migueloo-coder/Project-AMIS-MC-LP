package pt.upt.amis.lp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pt.upt.amis.lp.db.PublicAirport;
public class PublicAirportService {
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
	
	private boolean saveData(PublicAirport publicAirport) {
		
		try {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.persist(publicAirport);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}

	public PublicAirportService(EntityManager em) {
		this.em = em;
	}

	public PublicAirportService() {
		this.em = getEM();
	}

	
	
	public PublicAirport updatePublicAirport( int idAirport, String name, String city, String country, Company[] c, double subsidy) {
		PublicAirport pua = em.find(PublicAirport.class, idAirport);
		if (pua == null) {
			pua = new PublicAirport();
			em.persist(pua);
		}
		pua.setIdAirport(idAirport);
		pua.setName(name);
		pua.setCity(city);
		pua.setCountry(country);
		pua.setListCompanys(c);
		pua.setSubsidy(subsidy);
		em.persist(pua);
		return pua;
	}
	public PublicAirport updatePublicAirport(PublicAirport publicAirport) {
		PublicAirport pua = em.find(PublicAirport.class, publicAirport.getIdAirport());
		if (pua == null) {
			pua = new PublicAirport();
			em.persist(pua);
		}
		pua.setIdAirport(publicAirport.getIdAirport());
		pua.setName(publicAirport.getName());
		pua.setCity(publicAirport.getCity());
		pua.setCountry(publicAirport.getCountry());
		pua.setListCompanys(publicAirport.getListCompanys());
		pua.setSubsidy(publicAirport.getSubsidy());
		em.persist(pua);
		return pua;
	}

	public boolean removePublicAirport( int idAirport) {
		PublicAirport rmpua = findPublicAirport(idAirport);
		if (rmpua != null)
			em.remove(rmpua);
		return true;
	}

	public PublicAirport findPublicAirport( int idAirport) {
		return em.find(PublicAirport.class, idAirport);
	}
	
	public List<PublicAirport> findAllPublicAirports() {
		 Query qd = em.createQuery("SELEClicT pua FROM PrivateAirport pua");
		 return qd.getResultList();
	}

}
