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

import pt.upt.amis.lp.db.Flight;
import pt.upt.amis.lp.db.FlightService;


@Path("/flight")
public class FlightRESTService {
	
	private FlightService fls = new FlightService();
	static Flight flights[];

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Hello World! I'm the Flights Controller";
	}

	@GET
	@Path("/getFlight")
	public Response getFlights() {		
		
		List<Flight> flights = fls.findAllFlights();

		return Response.status(Response.Status.OK)
				.entity(flights)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getFlight/{idDBFlight}")
	public Response getFlight(@PathParam("idDBFlight") int idDBFlight) {
		Flight flightResponse = fls.findFlight(idDBFlight);
		
		return Response.status(Response.Status.OK)
				.entity(flightResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addFlight")
	public Response addFlight(Flight flight) {		
		Flight flightResponse = fls.updateFlight(flight);
		
		return Response.status(Response.Status.CREATED)
				.entity(flightResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateFlight")
	public Response updateFlight(Flight flight) {
		Flight flightResponse = fls.updateFlight(flight);
		
		return Response.status(Response.Status.OK)
				.entity(flightResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteFlight/{idDBFlight}")
	public Response deleteFlight(@PathParam("idDBFlight") int idDBFlight) {
		boolean flightRemoved = fls.removeFlight(idDBFlight);
		
		return Response.status(Response.Status.OK)
				.entity(flightRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
