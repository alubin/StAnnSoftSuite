package database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import rcia.RciaData;
import ccf.CCFData;

public class DbWorker {

	private static String ipAddress;
	private static int port;
	private static Connection con1 = null;
	private static Connection con2 = null;
	private String user;
	private String pass;


	public DbWorker()
	{
		user = "root";
		pass = "Sunshine222";
	}
	
	public DbWorker(String ipAddress, int port, String userName, String password)
	{
		this();
		this.user = userName;
		this.pass = password;
		dbConnect(ipAddress, port);
		
	}
//	public DbWorker(String ipAddress, int port)
//	{
//		this();
//		dbConnect(ipAddress, port);
//	}

	public void dbConnect(String ipAddress, int port) {
		String url = "jdbc:mysql://"+ipAddress+":"+port+"/";
		String dbName1 = "ccf";
		String dbName2 = "rcia";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver).newInstance();
			con1 = DriverManager.getConnection(url+dbName1,user,pass);
			con2 = DriverManager.getConnection(url+dbName2,user,pass);
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
			try{
				PreparedStatement pStmt = con1.prepareStatement("INSERT INTO `ccf`.`parishdata`(`ID`,`StuID`,`lblParishID`,"
						+ "`DOB1`,`StuFunction`,`StuStatus`,`StuLnm`,`StuFnm`,`Student`,`ClsOfferedID`,`HrsCredited`,"
							+ "`ClsDate`,`CrsTitle`,`Instructor`,`Expr1`,`CrsLevel`) "
								+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				long classTime = results.getClassDate().getTime();
				//Must convert the millisecond epoch to epoch days for the localDate.
				LocalDate localDate = LocalDate.ofEpochDay(classTime/86400000); 
				Date classDate = Date.valueOf(localDate);
				
				pStmt.setInt(1, results.getId());
				pStmt.setDouble(2, results.getStudentId());
				pStmt.setString(3, results.getParishId());
				pStmt.setString(4, results.getDob());
				pStmt.setString(5, results.getFunction());
				pStmt.setString(6, results.getActive());
				pStmt.setString(7, results.getLastName());
				pStmt.setString(8, results.getFirstName());
				pStmt.setString(9, results.getName());
				pStmt.setDouble(10, results.getClassOffered());
				pStmt.setDouble(11, results.getHoursCredited());
				pStmt.setDate(12, classDate);
				pStmt.setString(13, results.getCourseTitle());
				pStmt.setString(14, results.getInstructor());
				pStmt.setString(15, results.getExperienced());
				pStmt.setString(16, results.getCourseLevel());
				
				pStmt.executeUpdate();
				pStmt.close();
			}
			catch (SQLException e) {
				
			}
			results.getId();
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
	
	/**
	 * This function gets all the fields in the CCF Database
	 * @return A collection of the different fields in the database.
	 */
	public ArrayList<CCFData> retrieveCCFData()
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the RCIA Database
	 * @return A collection of the different fields in the database.
	 */
	public ArrayList<RciaData> retrieveRciaData()
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the CCF Database with the name
	 * @return A collection of the different fields in the database that match the criteria.
	 */
	public ArrayList<CCFData> retrieveCCFDataByName(String... name)
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the RCIA Database with the name
	 * @return A collection of the different fields in the database that match the criteria.
	 */
	public ArrayList<RciaData> retrieveRciaDataByName(String... name)
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the CCF Database with the First name
	 * @return A collection of the different fields in the database that match the criteria.
	 */
	public ArrayList<CCFData> retrieveCCFDataByFirstName(String... name)
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the RCIA Database with the First name
	 * @return A collection of the different fields in the database that match the criteria.
	 */
	public ArrayList<RciaData> retrieveRciaDataByFirstName(String... name)
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the CCF Database with the name
	 * @return A collection of the different fields in the database that match the criteria.
	 */
	public ArrayList<CCFData> retrieveCCFDataByLastName(String... name)
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the RCIA Database with the last name
	 * @return A collection of the different fields in the database that match the criteria.
	 */
	public ArrayList<RciaData> retrieveRciaDataByLastName(String... name)
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the CCF Database with the ID
	 * @return A collection of the different fields in the database that match the criteria.
	 */
	public ArrayList<CCFData> retrieveCCFDataById(String... name)
	{
		return null;
	}
	
	/**
	 * This function gets all the fields in the RCIA Database with the ID
	 * @return A collection of the different fields in the database that match the criteria.
	 */
	public ArrayList<RciaData> retrieveRciaDataById(String... name)
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
