package com.client;

import java.net.URI;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
import pt.upt.amis.lp.db.Passenger;

public class AirportClientTestClientConfig {

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RESTServer/airport/").build();
	}

	private static ClientConfig config = new ClientConfig();
	private static Client client = ClientBuilder.newClient(config);
	private static WebTarget service = client.target(getBaseURI());

	public static void main(String[] args) {
		
		menu1();
		//addPassenger();
		//getAirports();		
		//updatePassenger();
		//getAirportById(2020);
		//deletePassenger(1212);
		
	}
	
	public static void menu1() {
		Scanner scanner = new Scanner(System.in);
        int op, numAirports;
        
        do {
        	try {
            showMenu1();
            System.out.print(">>: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                	
                	System.out.println("\nEnter the number of airports: ");
                	getAirports();
                    System.out.println("\nDATA LOADED CORRECTLY!!.\n");
                   
                    scanner.nextLine();
                    break;
                case 2:     	
                	System.out.println("\nINSERT MENU\n");
                	addAirport();
                	scanner.nextLine();
                    break;
                case 3:                	
                    System.out.println("\nMANAGEMENT MENU\n");
                    updateAirport();
                    scanner.nextLine();
                    break;  
                case 4:                	
                    System.out.println("\nMANAGEMENT MENU\n");
                    getAirportById(2020);
                    scanner.nextLine();
                    break;
                case 5:                	
                    System.out.println("\nMANAGEMENT MENU\n");
                    deleteAirport(1010);
                    scanner.nextLine();
                    break; 
                case 6:             	     
                    System.out.println("Leaving the programme - see you later!");
                    
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");                 
            }
        	} catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid value.");
                scanner.nextLine(); 
                op = 0; 
            } catch (Exception e) {
                System.out.println("Error ocurred: " + e.getMessage());
                op = 0; 
            }
            
        } while (op != 6);

        
	}
	
	public static void showMenu1() {
		System.out.println("\n*************************************");
        System.out.println("************* Main Menu *************");
        System.out.println("* 1. Get Airport                    *");
        System.out.println("* 2. Add Airport                    *");
        System.out.println("* 3. Update Airport                 *");
        System.out.println("* 4. Get Airport By ID Document     *");
        System.out.println("* 5. Delete Airport                 *");
        System.out.println("* 6. Log out of the system          *");
        System.out.println("*************************************");
    }
	
	

	private static void getAirports() {

		// Get the Airports
		Gson gson = new Gson();

		String responseAirportList = service.path("getAirports").request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		List<Airport>  airports= Arrays.asList(gson.fromJson(responseAirportList, Airport[].class));
		System.out.println("\n Output JSON from Server getAirports .... \n");
		for (Airport a : airports) {
			System.out.println(a);
		}

	}
	private static void addAirport() {

		
	// create one book
	//Book book = new Book("Leo Tolstoy", "War and Peace", false);
		Airport airport=new Airport(1010,"Aereopuerto de Proba desde Client Rest","Faro","Portugal");
	Response response = service.path("addAirport").request(MediaType.APPLICATION_JSON)
			.post(Entity.entity(airport, MediaType.APPLICATION_JSON), Response.class);

	if (response.getStatus() < 200 && response.getStatus() > 299) {
		throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
	} else {
		getAirports();
	}

}

	private static void updateAirport() {

		Gson gson = new Gson();

		
		// Update Book with values below
		//Book book = new Book(62, "Frédéric Bastiat", "A lei", true);
		Airport airport=new Airport(20203,"Aereopuerto de Proba desde Client Rest Update","Faro","Portugal");
		Response response = service.path("updateBook").request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(airport, MediaType.APPLICATION_JSON), Response.class);

		// Return code
		System.out.println(response.getStatus());

		if (response.getStatus() < 200 && response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			getAirports();
		}

	}
	private static void getAirportById(int idAirport) {

		// Get Book with id {id}
		String responseAirport = service.path("getAirports").path(Integer.toString(idAirport)).request()
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		Gson gson = new Gson();
		Airport airport = gson.fromJson(responseAirport, Airport.class);
		System.out.println("\n Output JSON from Server getAirportById .... \n");
		System.out.println(airport);

	}

	private static void deleteAirport(int idAirport) {

		// Delete Book with id 1
		Response response = service.path("deletePassenger")
				.path(Integer.toString(idAirport)).request().delete();

		if (response.getStatus() < 200 && response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			getAirports();
			
		}

	}
}