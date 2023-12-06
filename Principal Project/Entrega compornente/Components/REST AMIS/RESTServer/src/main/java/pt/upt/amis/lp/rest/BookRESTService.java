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

import pt.upt.amis.lp.db.Book;
import pt.upt.amis.lp.db.BookService;


@Path("/book")
public class BookRESTService {
	
	private BookService bks = new BookService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Hello World! I'm the Books Controller";
	}

	@GET
	@Path("/getBooks")
	public Response getBooks() {		
		List<Book> books = bks.findAllBooks();

		return Response.status(Response.Status.OK)
				.entity(books)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getBook/{id}")
	public Response getBook(@PathParam("id") int id) {
		Book bookResponse = bks.findBook(id);
		
		return Response.status(Response.Status.OK)
				.entity(bookResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addBook")
	public Response addBook(Book book) {		
		Book bookResponse = bks.updateBook(book);
		
		return Response.status(Response.Status.CREATED)
				.entity(bookResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateBook")
	public Response updateBook(Book book) {
		Book bookResponse = bks.updateBook(book);
		
		return Response.status(Response.Status.OK)
				.entity(bookResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteBook/{id}")
	public Response deleteBook(@PathParam("id") int id) {
		boolean bookRemoved = bks.removeBook(id);
		
		return Response.status(Response.Status.OK)
				.entity(bookRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
