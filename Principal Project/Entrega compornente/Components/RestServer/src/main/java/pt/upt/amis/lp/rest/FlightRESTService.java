package pt.upt.amis.lp.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import model.Flight;
import model.FlightService;




@Path("/Flight")
public class FlightRESTService {
	
	private FlightService bks = new FlightService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Hello World! I'm the Flights Controller";
	}

	@GET
	@Path("/getFlights")
	public Response getFlights() {		
		List<Flight> flights = bks.findAllFlights();

		return Response.status(Response.Status.OK)
				.entity(flights)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getFlight/{id}")
	public Response getFlight(@PathParam("id") int id) {
		Flight FlightResponse = bks.findFlight(id);
		
		return Response.status(Response.Status.OK)
				.entity(flightResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addFlight")
	public Response addFlight(Flight Flight) {		
		Flight FlightResponse = bks.updateFlight(Flight);
		
		return Response.status(Response.Status.CREATED)
				.entity(flightResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateFlight")
	public Response updateFlight(Flight Flight) {
		Flight flightResponse = bks.updateFlight(Flight);
		
		return Response.status(Response.Status.OK)
				.entity(flightResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteFlight/{id}")
	public Response deleteFlight(@PathParam("id") int id) {
		boolean FlightRemoved = bks.removeFlight(id);
		
		return Response.status(Response.Status.OK)
				.entity(FlightRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
