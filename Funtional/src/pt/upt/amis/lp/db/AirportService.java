package pt.upt.amis.lp.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pt.upt.amis.lp.db.Airport;


public class AirportService {
protected EntityManager em;
	
	public AirportService(EntityManager em) {
		this.em = em;
	}
	
	public Airport updateAirport(int idAirport, String name, String city, String country, Company c[]) {	
		Airport a = em.find(Airport.class, idAirport);
		if (a == null) {
			a = new Airport();
			em.persist(a);
		}
		a.setId(idAirport);
		a.setName(name);
		a.setCity(city);
		a.getCompany().clear();
		a.getNotas().addAll(notas);
		return a;
	}
	
	public Aluno updateAluno(int id, String name, int num) {	
		Aluno a = em.find(Aluno.class, id);
		if (a == null) {
			a = new Aluno();
			em.persist(a);
		}
		a.setId(id);
		a.setName(name);
		a.setNum(num);
		a.getNotas().clear();
		return a;
	}
	
	public void removeAluno(int id) {
		Aluno l = findAluno(id);
		if(l != null) 
			em.remove(l);
		return;
	}
	
	public Aluno findAluno(int id) {
		return em.find(Aluno.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> findAllAlunos() {
		Query qd = em.createQuery("Select a from Aluno a");
		return qd.getResultList();
	}
}
