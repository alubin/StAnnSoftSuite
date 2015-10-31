package rcia;

public class RciaData {
	
	//EForm or Paper [Enum]
	String typeOfForm = "";
	//Y or N
	boolean badges;
	//Y or N
	boolean printForm;
	//???
	char[] value = new char[2];
	//Y or N
	boolean verification;
	//Y or N
	boolean reconciliation;
	//Y or N
	boolean bapCert;
	//Y or N
	boolean birthCert;
	//Name of Saint
	String saintName = "";
	//Male or Female
	String gender;
	//zAuditor, Lead SP, Catholic, Inquirer, Sponsor [Enum]
	String role;
	//Last Name
	String LastName;
	//Desired name to be called
	String familiarName;
	//First name of Sponsor
	String sponFirst;
	//Last Name of Sponsor
	String sponLast;
	//Full name of sponsor
	String sponsor;
	//First Name
	String first;
	//middle Name
	String middle;
	String birthName;
	String address;
	char[] city = new char[2];
	int[] zip = new int[5];
	String emailAddress;
	String phoneNumber;
	//1/1/1999
	String DOB;
	int age;
	String occupation;
	String birthplaceCity;
	//Birthplace City
	char[] bpCity = new char[2];
	String fatherFullName;
	String motherFullName;
	boolean baptizedInChrist;
	String dateOfBaptism;
	String godParentNames;
	
	

}
