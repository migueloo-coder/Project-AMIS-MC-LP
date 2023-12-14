package pt.upt.amis.lp.db;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idAirport;
	private String name;
	private String city;
	private String country;
	private Company listCompanys[]=new Company[10];
	private int numCompany;
	
	
	@Override
	public String toString() {
		return "Airport [idAirport=" + idAirport + ", name=" + name + ", city=" + city + ", country=" + country
				+ ", listCompanys=" + Arrays.toString(listCompanys) + ", numCompany=" + numCompany + "]";
	}
	public Airport() {}
	public Airport(int idAirport, String name, String city, String country) {
		this.idAirport= idAirport;
		this.name = name;
		this.city = city;
		this.country = country;
		this.numCompany=0;
	}
	
	public Airport(int idAirport, String name, String city, String country, Company c[]) {	
		this.idAirport= idAirport;
		this.name = name;
		this.city = city;
		this.country = country;
		listCompanys=c;
		this.numCompany=c.length;
	}
	
	public void insertCompany(Company company) {
		listCompanys[numCompany]=company;
		numCompany++;
	}

	public int getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(int idAirport) {
		this.idAirport = idAirport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Company[] getListCompanys() {
		return listCompanys;
	}

	public void setListCompanys(Company[] listCompanys) {
		this.listCompanys = listCompanys;
	}

	public int getNumCompany() {
		return numCompany;
	}

	public void setNumCompany(int numCompany) {
		this.numCompany = numCompany;
	}
	
	public Company getCompany(int i) {
		return listCompanys[i];
	}
	
	public Company getCompany(String name) {
		boolean find =false;
		int i=0;
		Company c=null;
		while ((find==false)&&(i<listCompanys.length)) {
			if(name.equals(listCompanys[i].getName())) {
				find=true;
				c=listCompanys[i];
			}
			i++;
		}
		return c;
	}
	
}
