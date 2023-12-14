package pt.upt.amis.lp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pt.upt.amis.lp.db.Company;
public class CompanyService {
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
	
	private boolean saveData(Company company) {
		
		try {
			// Begin a new local transaction so that we can persist new entities
			em.getTransaction().begin();
			em.persist(company);
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			em.getTransaction().commit();
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}

	public CompanyService(EntityManager em) {
		this.em = em;
	}

	public CompanyService() {
		this.em = getEM();
	}

	
	public Company updateCompany(int idCompany, String name) {
		Company comp = em.find(Company.class, idCompany);
		if (comp == null) {
			comp = new Company();
			em.persist( comp);
		}
		comp.setIdCompany(idCompany);
		comp.setName(name);
		
		em.persist( comp);
		return comp;
	}
	public Company updateCompany(Company company) {
		Company comp = em.find(Company.class, company.getIdCompany());
		if (comp == null) {
			comp = new Company();
			em.persist( comp);
		}
		comp.setIdCompany(company.getIdCompany());
		comp.setName(company.getName());
		
		em.persist( comp);
		return comp;
	}

	public boolean removeCompany( int idCompany) {
		Company rmcomp = findCompany(idCompany);
		if (rmcomp != null)
			em.remove(rmcomp);
		return true;
	}

	public Company findCompany( int idCompany) {
		return em.find(Company.class, idCompany);
	}
	
	public List<Company> findAllCompanys() {
		 Query qd = em.createQuery("SELECT comp FROM Company comp");
		 return qd.getResultList();
	}
}
