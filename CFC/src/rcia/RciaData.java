package rcia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class RciaData {

	//EForm or Paper [Enum]
	private final String typeOfForm;
	//Y or N
	private final String badges;
	//Y or N
	private final String printForm;
	//???
	private final String value;
	//Y or N
	private final String verification;
	//Y or N
	private final String reconciliation;
	//Y or N
	private final String bapCert;
	//Y or N
	private final String birthCert;
	//Name of Saint
	private final String saintName;
	//Male or Female
	private final String gender;
	//zAuditor, Lead SP, Catholic, Inquirer, Sponsor [Enum]
	private final String role;
	//Last Name
	private final String lastName;
	//Desired name to be called
	private final String familiarName;
	//First name of Sponsor
	private final String sponFirst;
	//Last Name of Sponsor
	private final String sponLast;
	//Full name of sponsor
	private final String sponsor;
	//First Name
	private final String first;
	//middle Name
	private final String middle;
	private final String birthName;
	private final String address;
	private final String state;
	private final String zip;
	private final String emailAddress;
	private final String phoneNumber;
	//1/1/1999
	private final String dob;
	private final String age;
	private final String occupation;
	private final String birthplaceCity;
	//Birthplace City
	private final String bpState;
	private final String fatherFullName;
	private final String motherFullName;
	private final String baptizedInChrist;
	private final String dateOfBaptism;
	private final String godParentNames;
	private final String priestName;
	private final String churchName;
	private final String churchCity;
	private final String churchState;
	private final String denom;
	private final String currParish;
	private final String yrsOfRegEd;
	private final String monthAndYear;
	private final String sacramentDesired;
	private final String haveASponsor;
	private final String sponsorName;
	private final String sponsorNumber;
	private final String whySponsor;
	private final String goodStanding;
	private final String sponsorRole;
	private final String someoneInMind;
	private final String inquirerName;
	private final String inquirerPhone;
	private final String maritalStatus;
	private final String spouseName;
	private final String spouseReligion;
	private final String practicingCatholic;
	private final String attendSession;
	private final String catholicMarriage;
	private final String catholicDate;
	private final String civilMarriageDate;
	private final String conA;
	private final String conB;
	private final String conC;
	private final String conD;
	private final String children;
	private final String ages;
	private final String sponsorPotential;
	private final String city;
	private ArrayList<String> rowValues;

	public RciaData(ArrayList<String> rowValue) {

		//Need to check the size of rowValue.

		this.rowValues = rowValue;
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
		this.city = rowValue.get(20);
		this.state = rowValue.get(21);
		this.zip = rowValue.get(22);
		this.emailAddress = rowValue.get(23);
		this.phoneNumber = rowValue.get(24);
		this.dob = rowValue.get(25);
		this.age = rowValue.get(26);
		this.occupation = rowValue.get(27);
		this.birthplaceCity = rowValue.get(28);
		this.bpState = rowValue.get(29);
		this.fatherFullName = rowValue.get(30);
		this.motherFullName = rowValue.get(31);
		this.baptizedInChrist = rowValue.get(32);
		this.dateOfBaptism = rowValue.get(33);
		this.godParentNames = rowValue.get(34);
		this.priestName = rowValue.get(35);
		this.churchName = rowValue.get(36);
		this.churchCity = rowValue.get(37);
		this.churchState = rowValue.get(38);
		this.denom = rowValue.get(39);
		this.currParish = rowValue.get(41);
		this.yrsOfRegEd = rowValue.get(41);
		this.monthAndYear = rowValue.get(42);
		this.sacramentDesired = rowValue.get(43);
		this.haveASponsor = rowValue.get(44);
		this.sponsorName = rowValue.get(45);
		this.sponsorNumber = rowValue.get(46);
		this.whySponsor = rowValue.get(47);
		this.goodStanding = rowValue.get(48);
		this.sponsorRole = rowValue.get(49);
		this.someoneInMind = rowValue.get(50);
		this.inquirerName = rowValue.get(51);
		this.inquirerPhone = rowValue.get(52);
		this.maritalStatus = rowValue.get(53);
		this.spouseName = rowValue.get(54);
		this.spouseReligion = rowValue.get(55);
		this.practicingCatholic = rowValue.get(56);
		this.attendSession = rowValue.get(57);
		this.catholicMarriage = rowValue.get(58);
		this.catholicDate = rowValue.get(59);
		this.civilMarriageDate = rowValue.get(60);
		this.conA = rowValue.get(61);
		this.conB = rowValue.get(62);
		this.conC = rowValue.get(63);
		this.conD = rowValue.get(64);
		this.children = rowValue.get(65);
		this.ages = rowValue.get(66);
		this.sponsorPotential = rowValue.get(67);

	}

	public final String getTypeOfForm() {
		return typeOfForm;
	}

	public final String getBadges() {
		return badges;
	}

	public final String getPrintForm() {
		return printForm;
	}

	public final String getValue() {
		return value;
	}

	public final String getVerification() {
		return verification;
	}

	public final String getReconciliation() {
		return reconciliation;
	}

	public final String getBapCert() {
		return bapCert;
	}

	public final String getBirthCert() {
		return birthCert;
	}

	public final String getSaintName() {
		return saintName;
	}

	public final String getGender() {
		return gender;
	}

	public final String getRole() {
		return role;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getFamiliarName() {
		return familiarName;
	}

	public final String getSponFirst() {
		return sponFirst;
	}

	public final String getSponLast() {
		return sponLast;
	}

	public final String getSponsor() {
		return sponsor;
	}

	public final String getFirst() {
		return first;
	}

	public final String getMiddle() {
		return middle;
	}

	public final String getBirthName() {
		return birthName;
	}

	public final String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public final String getState() {
		return state;
	}

	public final String getZip() {
		return zip;
	}

	public final String getEmailAddress() {
		return emailAddress;
	}

	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public final String getDob() {
		return dob;
	}

	public final String getAge() {
		return age;
	}

	public final String getOccupation() {
		return occupation;
	}

	public final String getBirthplaceCity() {
		return birthplaceCity;
	}

	public final String getBpState() {
		return bpState;
	}

	public final String getFatherFullName() {
		return fatherFullName;
	}

	public final String getMotherFullName() {
		return motherFullName;
	}

	public final String getBaptizedInChrist() {
		return baptizedInChrist;
	}

	public final String getDateOfBaptism() {
		return dateOfBaptism;
	}

	public final String getGodParentNames() {
		return godParentNames;
	}

	public final String getPriestName() {
		return priestName;
	}

	public final String getChurchName() {
		return churchName;
	}

	public final String getChurchCity() {
		return churchCity;
	}

	public final String getChurchState() {
		return churchState;
	}

	public final String getDenom() {
		return denom;
	}

	public final String getCurrParish() {
		return currParish;
	}

	public final String getYrsOfRegEd() {
		return yrsOfRegEd;
	}

	public final String getMonthAndYear() {
		return monthAndYear;
	}

	public final String getSacramentDesired() {
		return sacramentDesired;
	}

	public final String getHaveASponsor() {
		return haveASponsor;
	}

	public final String getSponsorName() {
		return sponsorName;
	}

	public final String getSponsorNumber() {
		return sponsorNumber;
	}

	public final String getWhySponsor() {
		return whySponsor;
	}

	public final String getGoodStanding() {
		return goodStanding;
	}

	public final String getSponsorRole() {
		return sponsorRole;
	}

	public final String getSomeoneInMind() {
		return someoneInMind;
	}

	public final String getInquirerName() {
		return inquirerName;
	}

	public final String getInquirerPhone() {
		return inquirerPhone;
	}

	public final String getMaritalStatus() {
		return maritalStatus;
	}

	public final String getSpouseName() {
		return spouseName;
	}

	public final String getSpouseReligion() {
		return spouseReligion;
	}

	public final String getPracticingCatholic() {
		return practicingCatholic;
	}

	public final String getAttendSession() {
		return attendSession;
	}

	public final String getCatholicMarriage() {
		return catholicMarriage;
	}

	public final String getCatholicDate() {
		return catholicDate;
	}

	public final String getCivilMarriageDate() {
		return civilMarriageDate;
	}

	public final String getConA() {
		return conA;
	}

	public final String getConB() {
		return conB;
	}

	public final String getConC() {
		return conC;
	}

	public final String getConD() {
		return conD;
	}

	public final String getChildren() {
		return children;
	}

	public final String getAges() {
		return ages;
	}

	public final String getSponsorPotential() {
		return sponsorPotential;
	}

	public String toValueString() {
		return "RciaData [typeOfForm=" + typeOfForm + ", badges=" + badges
				+ ", printForm=" + printForm + ", value=" + value
				+ ", verification=" + verification + ", reconciliation="
				+ reconciliation + ", bapCert=" + bapCert + ", birthCert="
				+ birthCert + ", saintName=" + saintName + ", gender=" + gender
				+ ", role=" + role + ", lastName=" + lastName
				+ ", familiarName=" + familiarName + ", sponFirst=" + sponFirst
				+ ", sponLast=" + sponLast + ", sponsor=" + sponsor
				+ ", first=" + first + ", middle=" + middle + ", birthName="
				+ birthName + ", address=" + address + ", state=" + state
				+ ", zip=" + zip + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", age="
				+ age + ", occupation=" + occupation + ", birthplaceCity="
				+ birthplaceCity + ", bpState=" + bpState + ", fatherFullName="
				+ fatherFullName + ", motherFullName=" + motherFullName
				+ ", baptizedInChrist=" + baptizedInChrist + ", dateOfBaptism="
				+ dateOfBaptism + ", godParentNames=" + godParentNames
				+ ", priestName=" + priestName + ", churchName=" + churchName
				+ ", churchCity=" + churchCity + ", churchState=" + churchState
				+ ", denom=" + denom + ", currParish=" + currParish
				+ ", yrsOfRegEd=" + yrsOfRegEd + ", monthAndYear="
				+ monthAndYear + ", sacramentDesired=" + sacramentDesired
				+ ", haveASponsor=" + haveASponsor + ", sponsorName="
				+ sponsorName + ", sponsorNumber=" + sponsorNumber
				+ ", whySponsor=" + whySponsor + ", goodStanding="
				+ goodStanding + ", sponsorRole=" + sponsorRole
				+ ", someoneInMind=" + someoneInMind + ", inquirerName="
				+ inquirerName + ", inquirerPhone=" + inquirerPhone
				+ ", maritalStatus=" + maritalStatus + ", spouseName="
				+ spouseName + ", spouseReligion=" + spouseReligion
				+ ", practicingCatholic=" + practicingCatholic
				+ ", attendSession=" + attendSession + ", catholicMarriage="
				+ catholicMarriage + ", catholicDate=" + catholicDate
				+ ", civilMarriageDate=" + civilMarriageDate + ", conA=" + conA
				+ ", conB=" + conB + ", conC=" + conC + ", conD=" + conD
				+ ", children=" + children + ", ages=" + ages
				+ ", sponsorPotential=" + sponsorPotential + "]";
	}

	public Object[] getArray() {
		return rowValues.toArray();
	}

	public String toString()
	{
		return this.first + " " + this.middle + " " + this.lastName;
	}

	public String getId()
	{
		byte[] results = new byte[rowValues.size()];
		Byte[] byteObj = new Byte[results.length];
		byte[] hash = null;
		String resultStr = "";
		for(int i = 0; i < results.length; i ++)
		{
			byteObj[i] = results[i];
		}

		for(int i = 0; i < byteObj.length; i++)
		{
			results[i] = byteObj[i].byteValue();
		}

		try {
			hash = MessageDigest.getInstance("MD5").digest(results);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultStr = (hash == null) ? "" : new String(hash);
		return resultStr;

	}


}
