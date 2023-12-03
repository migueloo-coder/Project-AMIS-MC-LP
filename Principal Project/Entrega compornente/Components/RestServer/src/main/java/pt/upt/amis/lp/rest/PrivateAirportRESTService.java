package pt.upt.amis.lp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reader")
public class PrivateAirportRESTService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "REST Server : Hello World! I'm the Reader Controller";
	}

}
