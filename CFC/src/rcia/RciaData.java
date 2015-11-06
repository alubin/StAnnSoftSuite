package rcia;

import java.util.ArrayList;

public class RciaData {

	//EForm or Paper [Enum]
	private String typeOfForm;
	//Y or N
	private String badges;
	//Y or N
	private String printForm;
	//???
	private String value;
	//Y or N
	private String verification;
	//Y or N
	private String reconciliation;
	//Y or N
	private String bapCert;
	//Y or N
	private String birthCert;
	//Name of Saint
	private String saintName = "";
	//Male or Female
	private String gender;
	//zAuditor, Lead SP, Catholic, Inquirer, Sponsor [Enum]
	private String role;
	//Last Name
	private String lastName;
	//Desired name to be called
	private String familiarName;
	//First name of Sponsor
	private String sponFirst;
	//Last Name of Sponsor
	private String sponLast;
	//Full name of sponsor
	private String sponsor;
	//First Name
	private String first;
	//middle Name
	private String middle;
	private String birthName;
	private String address;
	private String state;
	private double zip;
	private String emailAddress;
	private String phoneNumber;
	//1/1/1999
	private String dob;
	private double age;
	private String occupation;
	private String birthplaceCity;
	//Birthplace City
	private String bpState;
	private String fatherFullName;
	private String motherFullName;
	private String baptizedInChrist;
	private String dateOfBaptism;
	private String godParentNames;
	private String priestName;
	private String churchName;
	private String churchCity;
	private String churchState;
	private String denom;
	private String currParish;
	private double yrsOfRegEd;
	private String monthAndYear;
	private String sacramentDesired;
	private String haveASponsor;
	private String sponsorName;
	private String sponsorNumber;
	private String whySponsor;
	private String goodStanding;
	private String sponsorRole;
	private String someoneInMind;
	private String inquirerName;
	private String inquirerPhone;
	private String maritalStatus;
	private String spouseName;
	private String spouseReligion;
	private String practicingCatholic;
	private String attendSession;
	private String catholicMarriage;
	private String catholicDate;
	private String civilMarriageDate;
	private String conA;
	private String conB;
	private String conC;
	private String conD;
	private String children;
	private double ages;
	private String sponsorPotential;

	public RciaData(ArrayList<String> rowValue) {
		this.typeOfForm = rowValue.get(0);
		this.badges = rowValue.get(1);
		this.printForm = rowValue.get(2);
		this.value = rowValue.get(3);
		this.verification = rowValue.get(4);
		this.reconciliation = rowValue.get(5);
		this.bapCert = rowValue.get(6);
		this.birthCert = rowValue.get(7);
		this.saintName = rowValue.get(8);
		this.gender = rowValue.get(9);
		this.role = rowValue.get(10);
		this.lastName = rowValue.get(11);
		this.familiarName = rowValue.get(12);
		this.sponFirst = rowValue.get(13);
		this.sponLast = rowValue.get(14);
		this.sponsor = rowValue.get(15);
		this.first = rowValue.get(16);
		this.middle = rowValue.get(17);
		this.birthName = rowValue.get(18);
		this.address = rowValue.get(19);
		this.state = rowValue.get(20);
		this.zip = Integer.valueOf(rowValue.get(21));
		this.emailAddress = rowValue.get(22);
		this.phoneNumber = rowValue.get(23);
		this.dob = rowValue.get(24);
		this.age = Integer.valueOf(rowValue.get(25));
		this.occupation = rowValue.get(26);
		this.birthplaceCity = rowValue.get(27);
		this.bpState = rowValue.get(28);
		this.fatherFullName = rowValue.get(29);
		this.motherFullName = rowValue.get(30);
		this.baptizedInChrist = rowValue.get(31);
		this.dateOfBaptism = rowValue.get(32);
		this.godParentNames = rowValue.get(33);
		this.priestName = rowValue.get(34);
		this.churchName = rowValue.get(35);
		this.churchCity = rowValue.get(36);
		this.churchState = rowValue.get(37);
		this.denom = rowValue.get(38);
		this.currParish = rowValue.get(39);
		this.yrsOfRegEd = Integer.valueOf(rowValue.get(40));
		this.monthAndYear = rowValue.get(41);
		this.sacramentDesired = rowValue.get(42);
		this.haveASponsor = rowValue.get(43);
		this.sponsorName = rowValue.get(44);
		this.sponsorNumber = rowValue.get(45);
		this.whySponsor = rowValue.get(46);
		this.goodStanding = rowValue.get(47);
		this.sponsorRole = rowValue.get(48);
		this.someoneInMind = rowValue.get(49);
		this.inquirerName = rowValue.get(50);
		this.inquirerPhone = rowValue.get(51);
		this.maritalStatus = rowValue.get(52);
		this.spouseName = rowValue.get(53);
		this.spouseReligion = rowValue.get(54);
		this.practicingCatholic = rowValue.get(55);
		this.attendSession = rowValue.get(56);
		this.catholicMarriage = rowValue.get(57);
		this.catholicDate = rowValue.get(58);
		this.civilMarriageDate = rowValue.get(59);
		this.conA = rowValue.get(60);
		this.conB = rowValue.get(61);
		this.conC = rowValue.get(62);
		this.conD = rowValue.get(63);
		this.children = rowValue.get(65);
		this.ages = Integer.valueOf(rowValue.get(66));
		this.sponsorPotential = rowValue.get(67);

	}

//	public RciaData(Object[] objArray)
//	{
//		this.typeOfForm = typeOfForm;
//		this.badges = badges;
//		this.printForm = printForm;
//		this.value = value;
//		this.verification = verification;
//		this.reconciliation = reconciliation;
//		this.bapCert = bapCert;
//		this.birthCert = birthCert;
//		this.saintName = saintName;
//		this.gender = gender;
//		this.role = role;
//		this.lastName = lastName;
//		this.familiarName = familiarName;
//		this.sponFirst = sponFirst;
//		this.sponLast = sponLast;
//		this.sponsor = sponsor;
//		this.first = first;
//		this.middle = middle;
//		this.birthName = birthName;
//		this.address = address;
//		this.state = state;
//		this.zip = zip;
//		this.emailAddress = emailAddress;
//		this.phoneNumber = phoneNumber;
//		this.dob = dob;
//		this.age = age;
//		this.occupation = occupation;
//		this.birthplaceCity = birthplaceCity;
//		this.bpState = bpState;
//		this.fatherFullName = fatherFullName;
//		this.motherFullName = motherFullName;
//		this.baptizedInChrist = baptizedInChrist;
//		this.dateOfBaptism = dateOfBaptism;
//		this.godParentNames = godParentNames;
//		this.priestName = priestName;
//		this.churchName = churchName;
//		this.churchCity = churchCity;
//		this.churchState = churchState;
//		this.denom = denom;
//		this.currParish = currParish;
//		this.yrsOfRegEd = yrsOfRegEd;
//		this.monthAndYear = monthAndYear;
//		this.sacramentDesired = sacramentDesired;
//		this.haveASponsor = haveASponsor;
//		this.sponsorName = sponsorName;
//		this.sponsorNumber = sponsorNumber;
//		this.whySponsor = whySponsor;
//		this.goodStanding = goodStanding;
//		this.sponsorRole = sponsorRole;
//		this.someoneInMind = someoneInMind;
//		this.inquirerName = inquirerName;
//		this.inquirerPhone = inquirerPhone;
//		this.maritalStatus = maritalStatus;
//		this.spouseName = spouseName;
//		this.spouseReligion = spouseReligion;
//		this.practicingCatholic = practicingCatholic;
//		this.attendSession = attendSession;
//		this.catholicMarriage = catholicMarriage;
//		this.catholicDate = catholicDate;
//		this.civilMarriageDate = civilMarriageDate;
//		this.conA = conA;
//		this.conB = conB;
//		this.conC = conC;
//		this.conD = conD;
//		this.children = children;
//		this.ages = ages;
//		this.sponsorPotential = sponsorPotential;
//	}





}
