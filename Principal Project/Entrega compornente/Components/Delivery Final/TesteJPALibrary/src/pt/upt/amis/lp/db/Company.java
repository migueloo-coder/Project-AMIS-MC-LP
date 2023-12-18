package pt.upt.amis.lp.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idCompany;
	private String name;
	private Flight listFlights[]=new Flight[10];
	private int numFlight=0;
	
	@OneToMany
	private List<Flight> flights = new ArrayList<Flight>();
	
	
	
	@Override
	public String toString() {
		return "Company [idCompany=" + idCompany 
				+ ", name=" + name 
				+ ", numFlight=" + numFlight 
			    + ", flights=" + flights + "]";
	}
	public Company() {}
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
	

	public Flight getFlights(String idFlight) {
		boolean find =false;
		int i=0;
		Flight f=null;
		while ((find==false)&&(i<listFlights.length)) {
			if(idFlight.equals(listFlights[i].getIdFlight())) {
				find=true;
				f=listFlights[i];
			}
			i++;
		}
		return f;
	}
	
	
}
