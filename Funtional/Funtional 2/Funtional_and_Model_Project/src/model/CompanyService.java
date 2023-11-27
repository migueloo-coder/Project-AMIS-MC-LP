package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CompanyService {
protected EntityManager em;
	
	public CompanyService(EntityManager em) {
		this.em = em;
	}
	
	public Company updatecompany(int idCompany, String name) {
		Company comp = em.find(Company.class, idCompany);
		if (comp == null) {
			comp = new Company(idCompany, name);
			em.persist( comp);
		}
		comp.setIdCompany(idCompany);
		comp.setName(name);
		
		em.persist( comp);
		return comp;
	}

	public void removeCompany( int idCompany) {
		Company rmcomp = findCompany(idCompany);
		if (rmcomp != null)
			em.remove(rmcomp);
		return;
	}

	public Company findCompany( int idCompany) {
		return em.find(Company.class, idCompany);
	}
	
	public List<Company> findAllCompanys() {
		 Query qd = em.createQuery("SELECT comp FROM Company comp");
		 return qd.getResultList();
	}
}
