package pt.upt.amis.lp.db;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PrivateAirport extends Airport implements Serializable{

	private String listEnterprises[]=new String[10];
	private int numEnterprise;
	
	public PrivateAirport() {}
	public PrivateAirport(int idAirport, String name, String city, String country) {
		super(idAirport, name, city, country);	
	}

	public PrivateAirport(int idAirport, String name, String city, String country, Company[] c, String e[]) {
		super(idAirport, name, city, country, c);
		this.listEnterprises=e;
		numEnterprise=e.length;
		
	}
	
	public void insertEnterprises (String e[]) {
		this.listEnterprises = e;
		this.numEnterprise= e.length;
		
		}
		public void insertEnterprise (String e) {
		listEnterprises [numEnterprise] = e;
		numEnterprise++;
		}

		public String[] getListEnterprises() {
			return listEnterprises;
		}

		public void setListEnterprises(String[] listEnterprises) {
			this.listEnterprises = listEnterprises;
		}

		public int getNumEnterprise() {
			return numEnterprise;
		}

		public void setNumEnterprise(int numEnterprise) {
			this.numEnterprise = numEnterprise;
		}
	
}
