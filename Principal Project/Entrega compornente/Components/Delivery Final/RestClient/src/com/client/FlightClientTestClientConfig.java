package com.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;


import pt.upt.amis.lp.db.Flight;

public class FlightClientTestClientConfig {

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RESTServer/flight/").build();
	}

	private static ClientConfig config = new ClientConfig();
	private static Client client = ClientBuilder.newClient(config);
	private static WebTarget service = client.target(getBaseURI());

	public static void main(String[] args) {
		
		//addPassenger();
		getFlights();		
		//updatePassenger();
		//getPassengerById(1212);
		//deletePassenger(1212);
		
	}
	
	private static void getFlights() {

		// Get the Airports
		Gson gson = new Gson();

		String responseFlightList = service.path("getFlight").request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		List<Flight>  flights= Arrays.asList(gson.fromJson(responseFlightList, Flight[].class));
		System.out.println("\n Output JSON from Server getAirports .... \n");
		for (Flight fli : flights) {
			System.out.println(fli);
		}

	}


}