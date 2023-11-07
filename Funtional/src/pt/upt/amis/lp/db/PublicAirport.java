package pt.upt.amis.lp.db;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class PublicAirport extends Airport{
	@Basic
	private double subsidy;

	public PublicAirport(int idAirport, String name, String city, String country) {
		super(idAirport, name, city, country);	
	}

	public PublicAirport(int idAirport, String name, String city, String country, Company[] c, double subsidy) {
		super(idAirport, name, city, country, c);
		this.subsidy=subsidy;
	}

	public PublicAirport(int idAirport,String name, String city, String country, double subsidy) {
		super(idAirport, name, city, country);
		this.subsidy=subsidy;
	}

	public double getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}
	
	
	

}
