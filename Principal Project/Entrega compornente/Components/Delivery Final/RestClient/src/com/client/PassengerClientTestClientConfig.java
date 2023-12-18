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

import pt.upt.amis.lp.db.Airport;

public class PassengerClientTestClientConfig {

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RESTServer/airport/").build();
	}

	private static ClientConfig config = new ClientConfig();
	private static Client client = ClientBuilder.newClient(config);
	private static WebTarget service = client.target(getBaseURI());

	public static void main(String[] args) {
		
		//addPassenger();
		getPassengers();		
		//updatePassenger();
		//getPassengerById(1212);
		//deletePassenger(1212);
		
	}
	
	private static void getPassengers() {

		// Get the Airports
		Gson gson = new Gson();

		String responseAirportList = service.path("getAirport").request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		List<Airport>  airports= Arrays.asList(gson.fromJson(responseAirportList, Airport[].class));
		System.out.println("\n Output JSON from Server getAirports .... \n");
		for (Airport a : airports) {
			System.out.println(a);
		}

	}


}