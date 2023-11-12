package model;


public class Flight {
	
	private String idFlight;
	private String originCity;
	private String destinationCity;
	private double cost;
	private int numMaxPassengers;
	private int numCurrentPassengers;
	private Passenger listPassengers[];
	
	public Flight(String idFlight, String originCity, String destinationCity, double cost, int numMaxPassengers) {
		
		this.idFlight = idFlight;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.cost = cost;
		this.numMaxPassengers = numMaxPassengers;
		this.numCurrentPassengers = 0;
		this.listPassengers = new Passenger[numMaxPassengers];
	}
	
	public void insertPassenger(Passenger passenger) {
		listPassengers[numCurrentPassengers]=passenger;
		numCurrentPassengers++;
	}

	public String getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(String idFlight) {
		this.idFlight = idFlight;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getNumMaxPassengers() {
		return numMaxPassengers;
	}

	public void setNumMaxPassengers(int numMaxPassengers) {
		this.numMaxPassengers = numMaxPassengers;
	}

	public int getNumCurrentPassengers() {
		return numCurrentPassengers;
	}

	public void setNumCurrentPassengers(int numCurrentPassengers) {
		this.numCurrentPassengers = numCurrentPassengers;
	}
	
	public Passenger getPassenger(int i) {
		return listPassengers[i];
	}
	
	public Passenger getPassenger(String passport) {
		boolean find =false;
		int i=0;
		Passenger pas=null;
		while ((find==false)&&(i<listPassengers.length)) {
			if(passport==listPassengers[i].getPassport()) {
				find=true;
				pas=listPassengers[i];
			}
			i++;
		}
		return pas;
		
	}
}
