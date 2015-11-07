package database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.ArrayList;

import org.apache.poi.hwpf.usermodel.DateAndTime;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			try{
				PreparedStatement pStmt = con1.prepareStatement("INSERT INTO `ccf`.`parishdata`(`ID`,`StuID`,`lblParishID`,"
						+ "`DOB1`,`StuFunction`,`StuStatus`,`StuLnm`,`StuFnm`,`Student`,`ClsOfferedID`,`HrsCredited`,"
							+ "`ClsDate`,`CrsTitle`,`Instructor`,`Expr1`,`CrsLevel`) "
								+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				pStmt.setInt(1, results.getId());
				pStmt.setDouble(2, results.getStudentId());
				pStmt.setString(3, results.getParishId());
				pStmt.setString(4, results.getDob());
				pStmt.setString(5, results.getFunction());
				pStmt.setString(6, results.getStatus());
				pStmt.setString(7, results.getLastName());
				pStmt.setString(8, results.getFirstName());
				pStmt.setString(9, results.getName());
				pStmt.setDouble(10, results.getClassOffered());
				pStmt.setDouble(11, results.getHoursCredited());
				pStmt.setDate(12, (Date)results.getClassDate());
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
