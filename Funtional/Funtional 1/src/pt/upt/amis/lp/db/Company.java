package pt.upt.amis.lp.db;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idCompany;
	@Basic
	private String name;
	private Flight listFlights[]=new Flight[10];
	private int numFlight=0;
	
	public Company(int idCompany, String name) {
		this.idCompany=idCompany;
		this.name = name;
	}
	public Company(int idCompany, String name, Flight f[]) {
		this.idCompany= idCompany;
		this.name = name;
		listFlights=f;
		numFlight=f.length;
	}
	public void insertFlight(Flight flight) {
		listFlights[numFlight]=flight;
		numFlight++;
	}
	
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumFlight() {
		return numFlight;
	}
	public void setNumFlight(int numFlight) {
		this.numFlight = numFlight;
	}
	

	public Flight getFlight(int i) {
		return listFlights[i];
	}
	
	

}
