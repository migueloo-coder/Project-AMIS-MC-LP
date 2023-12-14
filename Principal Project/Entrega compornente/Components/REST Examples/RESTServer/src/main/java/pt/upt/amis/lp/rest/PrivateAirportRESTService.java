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

import pt.upt.amis.lp.db.PrivateAirport;
import pt.upt.amis.lp.db.PrivateAirportService;


@Path("/privateAirport")
public class PrivateAirportRESTService {
	
	private PrivateAirportService pas = new PrivateAirportService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Hello World! I'm the Private Airport Controller";
	}

	@GET
	@Path("/getBooks")
	public Response getPrivateAirport() {		
		List<PrivateAirport> privateAirports = pas.findAllPrivateAirports();

		return Response.status(Response.Status.OK)
				.entity(privateAirports)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	
	@GET
	@Path("/getPrivateAirport/{idAirport}")
	public Response getPrivateAirportk(@PathParam("idAirport") int idAirport) {
		PrivateAirport privateAirportResponse = pas.findPrivateAirport(idAirport);
		
		return Response.status(Response.Status.OK)
				.entity(privateAirportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addPrivateAirport")
	public Response addPrivateAirport(PrivateAirport privateAirport) {		
		PrivateAirport privateAirportResponse = pas.updatePrivateAirport(privateAirport);
		
		return Response.status(Response.Status.CREATED)
				.entity(privateAirportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updatePrivateAirport")
	public Response updatePrivateAirport(PrivateAirport privateAirport) {
		PrivateAirport privateAirportResponse = pas.updatePrivateAirport(privateAirport);
		
		return Response.status(Response.Status.OK)
				.entity(privateAirportResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deletePrivateAirport/{idAirport}")
	public Response deletePrivateAirport(@PathParam("idAirport") int idAirport) {
		boolean privateAirportRemoved = pas.removePrivateAirport(idAirport);
		
		return Response.status(Response.Status.OK)
				.entity(privateAirportRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
