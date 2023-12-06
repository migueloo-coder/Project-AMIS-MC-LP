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

import org.glassfish.jersey.client.ClientConfigFlight;

import com.google.gson.Gson;

import pt.upt.amis.lp.db.Passenger;

public class ClientTestClientConfigFlight {

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RESTServer/passenger/").build();
	}

	private static ClientConfigFlight config = new ClientConfigFlight();
	private static Client client = ClientBuilder.newClient(config);
	private static WebTarget service = client.target(getBaseURI());

	public static void main(String[] args) {
		
		//addBook();
		getPassengers();		
		//updateBook();
		//getBookById(59);
		//deleteBook(62);
		
	}

	private static void addPassenger() {

		
		Passenger passenger =new Passenger(1213,"Miguel","Pinzon","Masculino","20/10/2002","DNI", "Rua santa catarina", "32569856", "miguelp@gmail.com","AX2345","Colombiano");
		// create one book
		//Book book = new Book("Leo Tolstoy", "War and Peace", false);
		Response response = service.path("addPassenger").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(passenger, MediaType.APPLICATION_JSON), Response.class);

		if (response.getStatus() < 200 && response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			getPassengers();
		}

	}

	private static void updatePassenger() {

		Gson gson = new Gson();

		
		// Update Book with values below
		//Book book = new Book(62, "Frédéric Bastiat", "A lei", true);
		Passenger passenger =new Passenger(8585,"Pepe","Riveira","Masculino","20/10/2002","DNI", "Rua santa catarina", "32569856", "miguelp@gmail.com","AX2345","Colombiano");
		Response response = service.path("updateBook").request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(passenger, MediaType.APPLICATION_JSON), Response.class);

		// Return code
		System.out.println(response.getStatus());

		if (response.getStatus() < 200 && response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			getPassengers();
		}

	}

	private static void deletePassenger(int idDocument) {

		// Delete Book with id 1
		Response response = service.path("deletePassenger")
				.path(Integer.toString(idDocument)).request().delete();

		if (response.getStatus() < 200 && response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			getPassengers();
			
		}

	}

	private static void getPassengers() {

		// Get the Books
		Gson gson = new Gson();

		String responsePassengersList = service.path("getPassengers").request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		List<Passenger> passengers = Arrays.asList(gson.fromJson(responsePassengersList, Passenger[].class));
		System.out.println("\n Output JSON from Server getBooks .... \n");
		for (Passenger p : passengers) {
			System.out.println(p);
		}

	}

	private static void getPassengerById(int idDocument) {

		// Get Book with id {id}
		String responsePassenger = service.path("getPassenger").path(Integer.toString(idDocument)).request()
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		Gson gson = new Gson();
		Passenger passenger = gson.fromJson(responsePassenger, Passenger.class);
		System.out.println("\n Output JSON from Server getBookById .... \n");
		System.out.println(passenger);

	}

}