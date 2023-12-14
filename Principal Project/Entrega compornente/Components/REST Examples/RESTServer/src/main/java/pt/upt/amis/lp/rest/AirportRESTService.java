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

import pt.upt.amis.lp.db.Airport;
import pt.upt.amis.lp.db.AirportService;


@Path("/airport")
public class AirportRESTService {
	
	private AirportService as = new AirportService();
	static Airport airports[];

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Servser : Hello World! I'm the Airport Controller";
	}

	@GET
	@Path("/getAirport")
	public Response getAirports() {	
		
		List<Airport> airports = as.findAllAirports();

		return Response.status(Response.Status.OK)
				.entity(airports)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getAiport/{idAirport}")
	public Response getAirport(@PathParam("idAirport") int idAirport) {
		Airport airportResponse = as.findAirport(idAirport);
		
		return Response.status(Response.Status.OK)
				.entity(airportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addAirport")
	public Response addAirport(Airport airport) {		
		Airport airportResponse = as.updateAirport(airport);
		
		return Response.status(Response.Status.CREATED)
				.entity(airportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateAirport")
	public Response updateAirport(Airport airport) {
		Airport airportResponse =as.updateAirport(airport);
		
		return Response.status(Response.Status.OK)
				.entity(airportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteAirport/{idAirport}")
	public Response deleteAirport(@PathParam("idAirport") int idAirport) {
		boolean airportRemoved = as.removeAirport(idAirport);
		return Response.status(Response.Status.OK)
				.entity(airportRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
