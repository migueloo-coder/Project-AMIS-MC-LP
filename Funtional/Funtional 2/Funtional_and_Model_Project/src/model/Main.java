package model;

import java.util.Scanner;

public class Main {
	static Scanner input=new Scanner (System.in);
	final static int num=4;//numero de aereopuertos
	static Airport airports[]=new Airport[num];
	

	public static void main(String[] args) {
		//insertar datos del aereopuerto

	}

	public static void insertDataAirport (Airport air[]) {
		air[0]= new PublicAirport(1020,"Airport International ElDorado","Bogota. D.C.","Colombia",5000000);
		air[0].insertCompany(new Company(2010,"Avianca"));
		air[0].insertCompany(new Company(2011,"LATAM"));
		//air[0].insertCompany(new Company(2011,""));
		air[0].getCompany("Avianca").insertFlight(new Flight("AV123", "Bogota", "Mexico", 300.00, 200));
		//revisar add passenger clase passenger air[0].getCompany(2010).getFlight("AV123").insertPassenger()
	}
}
