package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import rcia.RciaData;
import ccf.CCFData;

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

	public void dbConnect(String ipAddress, int port) {
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

	public void storeCCF(ArrayList<CCFData> data){
		System.out.println("Writing to CCF Database.");
		//TODO: Extract the data from the array and store the data.
		for(CCFData results : data)
		{
			System.out.println(results);
		}


	}

	public void storeRCIA(ArrayList<RciaData> data){
		System.out.println("Writing to RCIA Database.");
		//TODO: Extract the data from the array and store the data.
		for(RciaData results : data)
		{
			System.out.println(results);
		}

	}
	
	public ArrayList<CCFData> retrieveCCFData()
	{
		return null;
	}
	
	public ArrayList<RciaData> retrieveRciaData()
	{
		return null;
	}
	
	public ArrayList<CCFData> retrieveCCFDataByName(String... name)
	{
		return null;
	}
	
	public ArrayList<RciaData> retrieveRciaDataByName(String... name)
	{
		return null;
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
