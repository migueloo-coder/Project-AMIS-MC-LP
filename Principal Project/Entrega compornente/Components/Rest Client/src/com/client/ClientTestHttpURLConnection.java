package com.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import pt.upt.ei.lp.db.Book;

public class ClientTestHttpURLConnection {

	public static void main(String[] args) {

		addBook();
		getBooks();
		updateBook();
		getBookById(250);
		deleteBook(251);

	}

	private static void addBook() {
		HttpURLConnection conn = null;
		Gson gson = new Gson();

		try {

			URL url = new URL("http://localhost:8080/RESTServer/book/addBook");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");

			con.setDoOutput(true);
			con.setDoInput(true);

			String postData = gson.toJson(new Book("George Orwell", "Animal Farm", true), Book.class);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postData);
			wr.flush();
			wr.close();

			if (con.getResponseCode() < 200 && con.getResponseCode() > 299) {
				throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
			} else {
				getBooks();
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private static void updateBook() {
		HttpURLConnection conn = null;
		Gson gson = new Gson();

		try {

			URL url = new URL("http://localhost:8080/RESTServer/book/updateBook");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");

			con.setDoOutput(true);
			con.setDoInput(true);

			String postData = gson.toJson(new Book(251, "Murray Rothbard", "Anatomy of the State", true), Book.class);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postData);
			wr.flush();
			wr.close();

			if (con.getResponseCode() < 200 && con.getResponseCode() > 299) {
				throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
			} else {
				getBooks();
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private static void deleteBook(int bookId) {
		HttpURLConnection conn = null;

		try {

			URL url = new URL("http://localhost:8080/RESTServer/book/deleteBook/" + Integer.toString(bookId));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("DELETE");

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");

			if (con.getResponseCode() < 200 && con.getResponseCode() > 299) {
				throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
			} else {
				getBooks();
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private static void getBooks() {
		HttpURLConnection conn = null;

		try {

			URL url = new URL("http://localhost:8080/RESTServer/book/getBooks");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.connect();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			Gson gson = new Gson();
			List<Book> books = Arrays.asList(gson.fromJson(br, Book[].class));
			System.out.println("Output JSON from Server .... \n");
			for (Book b : books) {
				System.out.println(b);
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private static void getBookById(int bookId) {
		HttpURLConnection conn = null;

		try {

			URL url = new URL("http://localhost:8080/RESTServer/book/getBook/" + Integer.toString(bookId));
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.connect();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			Gson gson = new Gson();
			Book book = gson.fromJson(br, Book.class);
			System.out.println("Output JSON from Server .... \n");
			System.out.println(book);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
