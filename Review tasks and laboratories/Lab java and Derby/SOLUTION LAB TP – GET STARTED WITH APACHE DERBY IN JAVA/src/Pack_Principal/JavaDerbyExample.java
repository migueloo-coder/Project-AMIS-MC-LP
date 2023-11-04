package Pack_Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaDerbyExample {

	public static void main(String[] args) {
		String jdbcURL="jdbc:derby:C:\\Users\\Miguel Pinzon\\Desktop\\Project-AMIS-MC-LP\\Review tasks and laboratories\\SOLUTION LAB TP – GET STARTED WITH APACHE DERBY IN JAVA\\MyDB;create=true";
		try {
			Connection connection= DriverManager.getConnection(jdbcURL);
			System.out.println("New derby DB Created");
		}
		catch (SQLException e){
			e.printStackTrace();
			
		}

	}

}
