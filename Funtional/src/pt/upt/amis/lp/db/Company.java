package pt.upt.amis.lp.db;

public class Company {
	private String name;
	private Flight listFlights[]=new Flight[10];
	private int numFlight=0;
	
	public Company(String name) {
		this.name = name;
	}
	public Company(String name, Flight f[]) {
		this.name = name;
		listFlights=f;
		numFlight=f.length;
	}
	public void insertFlight(Flight flight) {
		listFlights[numFlight]=flight;
		numFlight++;
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
	
	public Flight getFlight(String id) {
		boolean find =false;
		int i=0;
		Flight f=null;
		while ((find==false)&&(i<listFlights.length)) {
			if(id==listFlights[i].getIdflight()) {
				find=true;
				f=listFlights[i];
			}
			i++;
		}
		return f;
	}

}
