package pt.upt.amis.lp.db;

public class PublicAirport extends Airport{
	private double subsidy;

	public PublicAirport(String name, String city, String country) {
		super(name, city, country);	
	}

	public PublicAirport(String name, String city, String country, Company[] c, double subsidy) {
		super(name, city, country, c);
		this.subsidy=subsidy;
	}

	public PublicAirport(String name, String city, String country, double subsidy) {
		super(name, city, country);
		this.subsidy=subsidy;
	}

	public double getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}
	
	
	

}
