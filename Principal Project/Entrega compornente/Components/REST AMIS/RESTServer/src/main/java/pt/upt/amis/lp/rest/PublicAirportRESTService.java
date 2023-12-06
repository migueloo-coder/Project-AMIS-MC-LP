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

import pt.upt.amis.lp.db.PublicAirport;
import pt.upt.amis.lp.db.PublicAirportService;


@Path("/publicAirport")
public class PublicAirportRESTService {
	
	private PublicAirportService puas = new PublicAirportService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Hello World! I'm the Public Airports Controller";
	}

	@GET
	@Path("/getPublicAirport")
	public Response getPublicAirport() {		
		List<PublicAirport> publicAirports = puas.findAllPublicAirports();

		return Response.status(Response.Status.OK)
				.entity(publicAirports)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getPublicAirport/{id}")
	public Response getPublicAirport(@PathParam("id") int id) {
		PublicAirport publicAirportResponse = puas.findPublicAirport(id);
		
		return Response.status(Response.Status.OK)
				.entity(publicAirportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addPublicAirport")
	public Response addPublicAirport(PublicAirport publicAirport) {		
		PublicAirport publicAirportResponse = puas.updatePublicAirport(publicAirport);
		
		return Response.status(Response.Status.CREATED)
				.entity(publicAirportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updatePublicAirport")
	public Response updatePublicAirport(PublicAirport publicAirport) {
		PublicAirport publicAirportResponse = puas.updatePublicAirport(publicAirport);
		
		return Response.status(Response.Status.OK)
				.entity(publicAirportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deletePublicAirport/{id}")
	public Response deletePublicAirport(@PathParam("id") int id) {
		boolean publicAirportRemoved = puas.removePublicAirport(id);
		
		return Response.status(Response.Status.OK)
				.entity(publicAirportRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
