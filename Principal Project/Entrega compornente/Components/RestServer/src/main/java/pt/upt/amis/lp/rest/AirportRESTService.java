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

import model.Company;
import model.CompanyService;




@Path("/Company")
public class CompanyRESTService {
	
	private CompanyService pas = new CompanyService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Hello World! I'm the Company Controller";
	}

	@GET
	@Path("/getCompany")
	public Response getCompany() {		
		List<Company> Company = pas.findAllCompanys();

		return Response.status(Response.Status.OK)
				.entity(Companys)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getCompany/{idDocument}")
	public Response getCompany(@PathParam("idDocument") int idDocument) {
		Company CompanyResponse = pas.findCompany(idDocument);
		
		return Response.status(Response.Status.OK)
				.entity(CompanyResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addCompany")
	public Response addCompany(Company Company) {		
		Company CompanyResponse = pas.updateCompany(Company);
		
		return Response.status(Response.Status.CREATED)
				.entity(CompanyResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateCompany")
	public Response updateCompany(Company Company) {
		Company CompanyResponse = pas.updateCompany(Company);
		
		return Response.status(Response.Status.OK)
				.entity(CompanyResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteCompany/{idDocument}")
	public Response deleteCompany(@PathParam("idDocument") int id) {
		boolean CompanyRemoved = pas.removeCompany(idDocument);
		
		return Response.status(Response.Status.OK)
				.entity(CompanyRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
