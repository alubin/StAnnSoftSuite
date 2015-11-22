package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import com.sun.jmx.snmp.SnmpStringFixed;

import rcia.RciaData;
import ccf.CCFData;
import print.PrintData;

public class DbWorker {

	private static final int ccfColumnSize = 17;
	private static final int rciaColumnSize = 68;
	private static final int printColumnSize = 20;
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
						+ "`ClsDate`,`CrsTitle`,`Instructor`,`Expr1`,`CrsLevel`,`Email`) "
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


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
				pStmt.setString(12, results.getClassDate());
				pStmt.setString(13, results.getCourseTitle());
				pStmt.setString(14, results.getInstructor());
				pStmt.setString(15, results.getExperienced());
				pStmt.setString(16, results.getCourseLevel());
				pStmt.setString(17, results.getEmailAddress());

				pStmt.executeUpdate();
				pStmt.close();
			}
			catch (SQLException e) {
				System.err.println(e);
			}
			//			System.out.println(results);
		}
	}

	public void storeRCIA(ArrayList<RciaData> data){
		System.out.println("Writing to RCIA Database.");
		//TODO: Extract the data from the array and store the data.
		for(RciaData results : data)
		{
			try{
				PreparedStatement pStmt = con1.prepareStatement("INSERT INTO `rcia`.`inquirer` (`Eform_Paper`,`Badges`,`Print_Form`,`Value`,"
						+ "`Verification_Form`,`Reconciliation`,`Bap_Cert`,`Birth_Cert`,`Saint`,`Gender`,`Roles`,`Last_Name`,"
						+ "`Familiar_Name`,`Sponsor_First_Name`,`Sponsor_Last_Name`,`Sponsor`,`First_Name`,`Middle_Name`,"
						+ "`Birth_Name`,`Address`,`City`,`State`,`Zip`,`Email`,`Phone`,`DOB`,`Age`,`Occupation`,`Birthplace_City`,"
						+ "`Birthplace_State`,`Father_Full_Name`,`Mother_Full_Name`,`Been_Baptized`,`Date_Of_Baptism`,`Godparent_Names`,"
						+ "`Priest_Name`,`Church_Name`,`Church_City`,`Church_State`,`Denomination_Note`,`Current_Parish`,`Years_Of_Religious_Education`,"
						+ "`Month_Year_Confirmed`,`Sacraments`,`Have_Sponsor`,`Sponsor_Name`,`Sponsor_Phone`,`Why_Sponsor`,`Good_Standing`,"
						+ "`Sponsor_Role`,`Someone_In_Mind`,`Inquirers_Name`,`Inquirers_Phone`,`Marital_Status`,`Spouse_Fiance_Name`,"
						+ "`Spouse_Fiance_Religious`,`Practicing_Catholic`,`Attending_Sessions`,`Catholic_Church_Marriage`,`Catholic_Convalidation_Date`,"
						+ "`Civil_Marriage_Date`,`CON_A`,`CON_B`,`CON_C`,`CON_D`,`Children`,`Ages`,`Sponsor_Potential`) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?)");

				pStmt.setString(1, results.getTypeOfForm());
				pStmt.setString(2, results.getBadges());
				pStmt.setString(3, results.getPrintForm());
				pStmt.setString(4, results.getValue());
				pStmt.setString(5, results.getVerification());
				pStmt.setString(6, results.getReconciliation());
				pStmt.setString(7, results.getBapCert());
				pStmt.setString(8, results.getBirthCert());
				pStmt.setString(9, results.getSaintName());
				pStmt.setString(10, results.getGender());
				pStmt.setString(11, results.getRole());
				pStmt.setString(12, results.getLastName());
				pStmt.setString(13, results.getFamiliarName());
				pStmt.setString(14, results.getSponFirst());
				pStmt.setString(15, results.getSponLast());
				pStmt.setString(16, results.getSponsor());
				pStmt.setString(17, results.getFirst());
				pStmt.setString(18, results.getMiddle());
				pStmt.setString(19, results.getBirthName());
				pStmt.setString(20, results.getAddress());
				pStmt.setString(21, results.getCity());
				pStmt.setString(22, results.getState());
				pStmt.setString(23, results.getZip());
				pStmt.setString(24, results.getEmailAddress());
				pStmt.setString(25, results.getPhoneNumber());
				pStmt.setString(26, results.getDob());
				pStmt.setString(27, results.getAge());
				pStmt.setString(28, results.getOccupation());
				pStmt.setString(29, results.getBirthplaceCity());
				pStmt.setString(30, results.getBpState());
				pStmt.setString(31, results.getFatherFullName());
				pStmt.setString(32, results.getMotherFullName());
				pStmt.setString(33, results.getBaptizedInChrist());
				pStmt.setString(34, results.getDateOfBaptism());
				pStmt.setString(35, results.getGodParentNames());
				pStmt.setString(36, results.getPriestName());
				pStmt.setString(37, results.getChurchName());
				pStmt.setString(38, results.getChurchCity());
				pStmt.setString(39, results.getChurchState());
				pStmt.setString(40, results.getDenom());
				pStmt.setString(41, results.getCurrParish());
				pStmt.setString(42, results.getYrsOfRegEd());
				pStmt.setString(43, results.getMonthAndYear());
				pStmt.setString(44, results.getSacramentDesired());
				pStmt.setString(45, results.getHaveASponsor());
				pStmt.setString(46, results.getSponsorName());
				pStmt.setString(47, results.getSponsorNumber());
				pStmt.setString(48, results.getWhySponsor());
				pStmt.setString(49, results.getGoodStanding());
				pStmt.setString(50, results.getSponsorRole());
				pStmt.setString(51, results.getSomeoneInMind());
				pStmt.setString(52, results.getInquirerName());
				pStmt.setString(53, results.getInquirerPhone());
				pStmt.setString(54, results.getMaritalStatus());
				pStmt.setString(55, results.getSpouseName());
				pStmt.setString(56, results.getSpouseReligion());
				pStmt.setString(57, results.getPracticingCatholic());
				pStmt.setString(58, results.getAttendSession());
				pStmt.setString(59, results.getCatholicMarriage());
				pStmt.setString(60, results.getCatholicDate());
				pStmt.setString(61, results.getCivilMarriageDate());
				pStmt.setString(62, results.getConA());
				pStmt.setString(63, results.getConB());
				pStmt.setString(64, results.getConC());
				pStmt.setString(65, results.getConD());
				pStmt.setString(66, results.getChildren());
				pStmt.setString(67, results.getAges());
				pStmt.setString(68, results.getSponsorPotential());

				pStmt.executeUpdate();
				pStmt.close();
			}
			catch (SQLException e) {
				System.err.println(e);
			}

			System.out.println(results);
		}

	}

	/**
	 * This function gets all the fields in the CCF Database
	 * @return A collection of the different fields in the database.
	 * @throws SQLException
	 */
	public ArrayList<CCFData> retrieveCCFData(QueryType type, String input) throws SQLException
	{
		String query = "select * from parishData";
		Statement stmt = null;
		ArrayList<CCFData> resultArray = new ArrayList<CCFData>();

		switch(type)
		{
		case ccfId:
			query = "SELECT * FROM parishData WHERE student_id = '" + input + "'";
			break;
		case ccfEmail:
			query = "SELECT * FROM parishData WHERE email = '" + input + "'";
			break;
		default:
			query = "SELECT * FROM parishData";
			break;

		}

		try {

			stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				//				System.out.println(rs.getObject(1));
				Object[] results = new Object[ccfColumnSize];
				for(int i = 0; i < 17; i++)
				{
					results[i] = rs.getObject(i+1);
				}
				CCFData data = new CCFData(results);
				resultArray.add(data);
				//				System.out.println(data);
			}


		} catch (SQLException | ParseException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}


		return resultArray;
	}

	/**
	 * This function gets all the fields in the RCIA Database
	 * @return A collection of the different fields in the database.
	 * @throws SQLException
	 */
	public ArrayList<RciaData> retrieveRciaData(String fname, String lname) throws SQLException
	{
		String query = "SELECT * FROM inquirer WHERE First_Name LIKE '" + fname + "%' AND Last_Name LIKE '" + lname + "%'";
		Statement stmt = null;
		ArrayList<RciaData> resultArray = new ArrayList<RciaData>();

		try {

			stmt = con2.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				ArrayList<String> results = new ArrayList<String>(rciaColumnSize);
				for(int i = 0; i < rciaColumnSize; i++)
				{
					results.add(rs.getString(i +1));
				}
				RciaData data = new RciaData(results);
				resultArray.add(data);
				System.out.println(data);
			}


		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}


		return resultArray;
	}
	
	public ArrayList<PrintData> retrievePrintData(String fname, String lname) throws SQLException
	{
		System.out.println(fname + " " + lname);
		String query = "SELECT First_Name, Last_Name, Middle_Name, Familiar_Name, Sponsor_First_Name, Sponsor_Last_Name, Sponsor, Print_Form, "
					+ "Eform_Paper, Bap_Cert, Birth_Name, DOB, Been_Baptized, Date_Of_Baptism, Month_Year_Confirmed, Sponsor_Name, Have_Sponsor, "
						+ "Father_Full_Name, Mother_Full_Name, Sacraments FROM inquirer WHERE First_Name LIKE '" + fname + "%' AND "
								+ "Last_Name LIKE '" + lname + "%'";
		Statement stmt = null;
		ArrayList<PrintData> resultArray = new ArrayList<PrintData>();

		try {

			stmt = con2.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{
				ArrayList<String> results = new ArrayList<String>(printColumnSize);
				for(int i = 0; i < printColumnSize; i++)
				{
					results.add(rs.getString(i +1));
				}
				PrintData data = new PrintData(results);
				resultArray.add(data);
				System.out.println(data);
			}


		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}


		return resultArray;
	}



	public void updateCCF(final int studID, final String email) throws SQLException
	{
		String query = "UPDATE ccf SET Email = '"+ email + "' WHERE StuID = " + studID;
		Statement stmt = null;

		try {

			stmt = con2.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())
			{

			}


		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}

	}

	public void updateRcia()
	{

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
