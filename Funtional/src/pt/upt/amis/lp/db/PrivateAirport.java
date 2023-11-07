package pt.upt.amis.lp.db;

public class PrivateAirport extends Airport {
	private String listEnterprises[]=new String[10];
	private int numEnterprise;
	
	public PrivateAirport(String name, String city, String country) {
		super(name, city, country);	
	}

	public PrivateAirport(String name, String city, String country, Company[] c, String e[]) {
		super(name, city, country, c);
		this.listEnterprises=e;
		numEnterprise=e.length;
		
	}
	
	public void insertEnterprises (String e[]) {
		this.listEnterprises = e;
		this.numEnterprise= e.length;
		
		}
		public void insertarEmpresa (String e) {
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
