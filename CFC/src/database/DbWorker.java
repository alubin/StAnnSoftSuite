package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbWorker {
	
	public static void dbConnect() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName1 = "ccf";
		String dbName2 = "rcia";
		String driver = "com.mysql.jdbc.Driver"; 
		String userName = "root";
		String password = "Sunshine222";
		Connection con1 = null;
		Connection con2 = null; 

		try { 
			Class.forName(driver).newInstance(); 
			con1 = DriverManager.getConnection(url+dbName1,userName,password); 
			con2 = DriverManager.getConnection(url+dbName2,userName,password); 
			System.out.println("Successfully connected to databases");
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}
	}
	
	public static void dbClose(Connection con1, Connection con2) {

	    try { 
	    	con1.close(); 
	    	 if (con1.isClosed()) {
	    	        System.out.println("Connection to db1 closed.");
	    	 } 
	    }
	    catch (Exception e1) {
	    	System.err.println("Could NOT close connection to db1.");
	    }
	    
	    try { 
	    	con2.close(); 
	    	 if (con2.isClosed()) {
	    		 System.out.println("Connection to db2 closed.");
	    	 } 
	    }
	    catch (Exception e2) {
	    	System.err.println("Could NOT close connection to db2.");
	    }
	}
}
