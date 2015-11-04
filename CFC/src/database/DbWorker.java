package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ccf.CCFData;
import rcia.RciaData;

public class DbWorker {

	static String ipAddress;
	static int port;
	static Connection con1 = null;
	static Connection con2 = null;


	public DbWorker()
	{

	}
	public DbWorker(String ipAddress, int port)
	{
		this();
		dbConnect(ipAddress, port);
	}

	public static void dbConnect(String ipAddress, int port) {
		System.out.println("Address = " + ipAddress);
		System.out.println("Port = " + port);
		String url = "jdbc:mysql://"+ipAddress+":"+port+"/";
		String dbName1 = "ccf";
		String dbName2 = "rcia";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "Sunshine222";

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

	public static void storeCCF(ArrayList<CCFData> data){


	}

	public static void storeRCIA(ArrayList<RciaData> data){

	}

	public static void dbClose() {

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
