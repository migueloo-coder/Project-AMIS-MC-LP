package com.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;

import pt.upt.ei.lp.db.Book;

public class ClientTestClientConfig {

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RESTServer/book/").build();
	}

	private static ClientConfig config = new ClientConfig();
	private static Client client = ClientBuilder.newClient(config);
	private static WebTarget service = client.target(getBaseURI());

	public static void main(String[] args) {
		
		//addBook();
		getBooks();		
		//updateBook();
		//getBookById(59);
		//deleteBook(62);
		
	}

	private static void addBook() {

		// create one book
		Book book = new Book("Leo Tolstoy", "War and Peace", false);
		Response response = service.path("addBook").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(book, MediaType.APPLICATION_JSON), Response.class);

		if (response.getStatus() < 200 && response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			getBooks();
		}

	}

	private static void updateBook() {

		Gson gson = new Gson();

		// Update Book with values below
		Book book = new Book(62, "Frédéric Bastiat", "A lei", true);
		Response response = service.path("updateBook").request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(book, MediaType.APPLICATION_JSON), Response.class);

		// Return code
		System.out.println(response.getStatus());

		if (response.getStatus() < 200 && response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			getBooks();
		}

	}

	private static void deleteBook(int bookId) {

		// Delete Book with id 1
		Response response = service.path("deleteBook")
				.path(Integer.toString(bookId)).request().delete();

		if (response.getStatus() < 200 && response.getStatus() > 299) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		} else {
			getBooks();
		}

	}

	private static void getBooks() {

		// Get the Books
		Gson gson = new Gson();

		String responseBooksList = service.path("getBooks").request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		List<Book> books = Arrays.asList(gson.fromJson(responseBooksList, Book[].class));
		System.out.println("\n Output JSON from Server getBooks .... \n");
		for (Book b : books) {
			System.out.println(b);
		}

	}

	private static void getBookById(int bookId) {

		// Get Book with id {id}
		String responseBook = service.path("getBook").path(Integer.toString(bookId)).request()
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		Gson gson = new Gson();
		Book book = gson.fromJson(responseBook, Book.class);
		System.out.println("\n Output JSON from Server getBookById .... \n");
		System.out.println(book);

	}

}