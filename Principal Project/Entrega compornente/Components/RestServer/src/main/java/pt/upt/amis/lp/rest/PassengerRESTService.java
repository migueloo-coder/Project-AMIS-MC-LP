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

import model.Passenger;
import model.PassengertService;




@Path("/passenger")
public class PassengerRESTService {
	
	private PassengerService pas = new PassengerService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Hello World! I'm the Passenger Controller";
	}

	@GET
	@Path("/getPassenger")
	public Response getPassenger() {		
		List<Passenger> passenger = pas.findAllPassengers();

		return Response.status(Response.Status.OK)
				.entity(passengers)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getPassenger/{idDocument}")
	public Response getPassenger(@PathParam("idDocument") int idDocument) {
		Passenger passengerResponse = pas.findPassenger(idDocument);
		
		return Response.status(Response.Status.OK)
				.entity(passengerResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addPassenger")
	public Response addPassenger(Passenger passenger) {		
		Passenger passengerResponse = pas.updatePassenger(passenger);
		
		return Response.status(Response.Status.CREATED)
				.entity(PassengerResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updatePassenger")
	public Response updatePassenger(Passenger passenger) {
		Passenger passengerResponse = pas.updatePassenger(passenger);
		
		return Response.status(Response.Status.OK)
				.entity(PassengerResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deletePassenger/{idDocument}")
	public Response deletePassenger(@PathParam("idDocument") int id) {
		boolean passengerRemoved = pas.removePassenger(idDocument);
		
		return Response.status(Response.Status.OK)
				.entity(passengerRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
