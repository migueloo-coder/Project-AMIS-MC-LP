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

import pt.upt.amis.lp.db.Company;
import pt.upt.amis.lp.db.CompanyService;


@Path("/company")
public class CompanyRESTService {
	
	private CompanyService cs = new CompanyService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Hello World! I'm the Company Controller";
	}

	@GET
	@Path("/getCompanys")
	public Response getcompanys() {		
		List<Company> companys = cs.findAllCompanys();
		

		return Response.status(Response.Status.OK)
				.entity(companys)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getCompany/{idCompany}")
	public Response getCompany(@PathParam("idCompany") int idCompany) {
		Company companyResponse = cs.findCompany(idCompany);
		
		return Response.status(Response.Status.OK)
				.entity(companyResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addCompany")
	public Response addCompany(Company company) {		
		Company companyResponse = cs.updateCompany(company);
		
		return Response.status(Response.Status.CREATED)
				.entity(companyResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateCompany")
	public Response updateBook(Company company) {
		Company companyResponse = cs.updateCompany(company);
		
		return Response.status(Response.Status.OK)
				.entity(companyResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteCompany/{idCompany}")
	public Response deleteCompany(@PathParam("idCompany") int idCompany) {
		boolean companyRemoved = cs.removeCompany(idCompany);
		
		return Response.status(Response.Status.OK)
				.entity(companyRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
