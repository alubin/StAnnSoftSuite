package rcia;

import java.util.ArrayList;

public class RciaData {

	//EForm or Paper [Enum]
	private  String typeOfForm;
	//Y or N
	private  String badges;
	//Y or N
	private  String printForm;
	//???
	private  String value;
	//Y or N
	private  String verification;
	//Y or N
	private  String reconciliation;
	//Y or N
	private  String bapCert;
	//Y or N
	private  String birthCert;
	//Name of Saint
	private  String saintName;
	//Male or Female
	private  String gender;
	//zAuditor, Lead SP, Catholic, Inquirer, Sponsor [Enum]
	private  String role;
	//Last Name
	private  String lastName;
	//Desired name to be called
	private  String familiarName;
	//First name of Sponsor
	private  String sponFirst;
	//Last Name of Sponsor
	private  String sponLast;
	//Full name of sponsor
	private  String sponsor;
	//First Name
	private  String first;
	//middle Name
	private  String middle;
	private  String birthName;
	private  String address;
	private  String state;
	private  String zip;
	private  String emailAddress;
	private  String phoneNumber;
	//1/1/1999
	private  String dob;
	private  String age;
	private  String occupation;
	private  String birthplaceCity;
	//Birthplace City
	private  String bpState;
	private  String fatherFullName;
	private  String motherFullName;
	private  String baptizedInChrist;
	private  String dateOfBaptism;
	private  String godParentNames;
	private  String priestName;
	private  String churchName;
	private  String churchCity;
	private  String churchState;
	private  String denom;
	private  String currParish;
	private  String yrsOfRegEd;
	private  String monthAndYear;
	private  String sacramentDesired;
	private  String haveASponsor;
	private  String sponsorName;
	private  String sponsorNumber;
	private  String whySponsor;
	private  String goodStanding;
	private  String sponsorRole;
	private  String someoneInMind;
	private  String inquirerName;
	private  String inquirerPhone;
	private  String maritalStatus;
	private  String spouseName;
	private  String spouseReligion;
	private  String practicingCatholic;
	private  String attendSession;
	private  String catholicMarriage;
	private  String catholicDate;
	private  String civilMarriageDate;
	private  String conA;
	private  String conB;
	private  String conC;
	private  String conD;
	private  String children;
	private  String ages;
	private  String sponsorPotential;
	private  String city;
	private ArrayList<String> rowValues;
	
	

	public RciaData() {
		this.typeOfForm = "";
		this.badges = "";
		this.printForm = "";
		this.value  = "";
		this.verification  = "";
		this.reconciliation  = "";
		this.bapCert  = "";
		this.birthCert  = "";
		this.saintName  = "";
		this.gender  = "";
		this.role  = "";
		this.lastName  = "";
		this.familiarName  = "";
		this.sponFirst  = "";
		this.sponLast  = "";
		this.sponsor  = "";
		this.first = "";
		this.middle  = "";
		this.birthName  = "";
		this.address  = "";
		this.state = "";
		this.zip = "";
		this.emailAddress = "";
		this.phoneNumber = "";
		this.dob = "";
		this.age = "";
		this.occupation = "";
		this.birthplaceCity = "";
		this.bpState = "";
		this.fatherFullName = "";
		this.motherFullName = "";
		this.baptizedInChrist = "";
		this.dateOfBaptism = "";
		this.godParentNames = "";
		this.priestName = "";
		this.churchName = "";
		this.churchCity = "";
		this.churchState = "";
		this.denom = "";
		this.currParish = "";
		this.yrsOfRegEd = "";
		this.monthAndYear = "";
		this.sacramentDesired = "";
		this.haveASponsor = "";
		this.sponsorName = "";
		this.sponsorNumber = "";
		this.whySponsor = "";
		this.goodStanding = "";
		this.sponsorRole = "";
		this.someoneInMind = "";
		this.inquirerName = "";
		this.inquirerPhone = "";
		this.maritalStatus = "";
		this.spouseName = "";
		this.spouseReligion = "";
		this.practicingCatholic = "";
		this.attendSession = "";
		this.catholicMarriage = "";
		this.catholicDate = "";
		this.civilMarriageDate  = "";
		this.conA  = "";
		this.conB = "";
		this.conC = "";
		this.conD = "";
		this.children = "";
		this.ages = "";
		this.sponsorPotential = "";
		this.city = "";
		this.rowValues = new ArrayList<>();
	}

	public RciaData(String typeOfForm, String badges, String printForm,
			String value, String verification, String reconciliation,
			String bapCert, String birthCert, String saintName, String gender,
			String role, String lastName, String familiarName,
			String sponFirst, String sponLast, String sponsor, String first,
			String middle, String birthName, String address, String state,
			String zip, String emailAddress, String phoneNumber, String dob,
			String age, String occupation, String birthplaceCity,
			String bpState, String fatherFullName, String motherFullName,
			String baptizedInChrist, String dateOfBaptism,
			String godParentNames, String priestName, String churchName,
			String churchCity, String churchState, String denom,
			String currParish, String yrsOfRegEd, String monthAndYear,
			String sacramentDesired, String haveASponsor, String sponsorName,
			String sponsorNumber, String whySponsor, String goodStanding,
			String sponsorRole, String someoneInMind, String inquirerName,
			String inquirerPhone, String maritalStatus, String spouseName,
			String spouseReligion, String practicingCatholic,
			String attendSession, String catholicMarriage, String catholicDate,
			String civilMarriageDate, String conA, String conB, String conC,
			String conD, String children, String ages, String sponsorPotential,
			String city, ArrayList<String> rowValues) {
		super();
		this.typeOfForm = typeOfForm;
		this.badges = badges;
		this.printForm = printForm;
		this.value = value;
		this.verification = verification;
		this.reconciliation = reconciliation;
		this.bapCert = bapCert;
		this.birthCert = birthCert;
		this.saintName = saintName;
		this.gender = gender;
		this.role = role;
		this.lastName = lastName;
		this.familiarName = familiarName;
		this.sponFirst = sponFirst;
		this.sponLast = sponLast;
		this.sponsor = sponsor;
		this.first = first;
		this.middle = middle;
		this.birthName = birthName;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.age = age;
		this.occupation = occupation;
		this.birthplaceCity = birthplaceCity;
		this.bpState = bpState;
		this.fatherFullName = fatherFullName;
		this.motherFullName = motherFullName;
		this.baptizedInChrist = baptizedInChrist;
		this.dateOfBaptism = dateOfBaptism;
		this.godParentNames = godParentNames;
		this.priestName = priestName;
		this.churchName = churchName;
		this.churchCity = churchCity;
		this.churchState = churchState;
		this.denom = denom;
		this.currParish = currParish;
		this.yrsOfRegEd = yrsOfRegEd;
		this.monthAndYear = monthAndYear;
		this.sacramentDesired = sacramentDesired;
		this.haveASponsor = haveASponsor;
		this.sponsorName = sponsorName;
		this.sponsorNumber = sponsorNumber;
		this.whySponsor = whySponsor;
		this.goodStanding = goodStanding;
		this.sponsorRole = sponsorRole;
		this.someoneInMind = someoneInMind;
		this.inquirerName = inquirerName;
		this.inquirerPhone = inquirerPhone;
		this.maritalStatus = maritalStatus;
		this.spouseName = spouseName;
		this.spouseReligion = spouseReligion;
		this.practicingCatholic = practicingCatholic;
		this.attendSession = attendSession;
		this.catholicMarriage = catholicMarriage;
		this.catholicDate = catholicDate;
		this.civilMarriageDate = civilMarriageDate;
		this.conA = conA;
		this.conB = conB;
		this.conC = conC;
		this.conD = conD;
		this.children = children;
		this.ages = ages;
		this.sponsorPotential = sponsorPotential;
		this.city = city;
		this.rowValues = rowValues;
	}

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

	public final String getLast() {
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

	public Object[] getArray() {
		return rowValues.toArray();
	}

	public String getId()
	{
	
		return Integer.toString(this.toString().hashCode());
	
	}

	public void setTypeOfForm(String typeOfForm) {
		this.typeOfForm = typeOfForm;
	}

	public void setBadges(String badges) {
		this.badges = badges;
	}

	public void setPrintForm(String printForm) {
		this.printForm = printForm;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public void setReconciliation(String reconciliation) {
		this.reconciliation = reconciliation;
	}

	public void setBapCert(String bapCert) {
		this.bapCert = bapCert;
	}

	public void setBirthCert(String birthCert) {
		this.birthCert = birthCert;
	}

	public void setSaintName(String saintName) {
		this.saintName = saintName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFamiliarName(String familiarName) {
		this.familiarName = familiarName;
	}

	public void setSponFirst(String sponFirst) {
		this.sponFirst = sponFirst;
	}

	public void setSponLast(String sponLast) {
		this.sponLast = sponLast;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public void setBirthName(String birthName) {
		this.birthName = birthName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setBirthplaceCity(String birthplaceCity) {
		this.birthplaceCity = birthplaceCity;
	}

	public void setBpState(String bpState) {
		this.bpState = bpState;
	}

	public void setFatherFullName(String fatherFullName) {
		this.fatherFullName = fatherFullName;
	}

	public void setMotherFullName(String motherFullName) {
		this.motherFullName = motherFullName;
	}

	public void setBaptizedInChrist(String baptizedInChrist) {
		this.baptizedInChrist = baptizedInChrist;
	}

	public void setDateOfBaptism(String dateOfBaptism) {
		this.dateOfBaptism = dateOfBaptism;
	}

	public void setGodParentNames(String godParentNames) {
		this.godParentNames = godParentNames;
	}

	public void setPriestName(String priestName) {
		this.priestName = priestName;
	}

	public void setChurchName(String churchName) {
		this.churchName = churchName;
	}

	public void setChurchCity(String churchCity) {
		this.churchCity = churchCity;
	}

	public void setChurchState(String churchState) {
		this.churchState = churchState;
	}

	public void setDenom(String denom) {
		this.denom = denom;
	}

	public void setCurrParish(String currParish) {
		this.currParish = currParish;
	}

	public void setYrsOfRegEd(String yrsOfRegEd) {
		this.yrsOfRegEd = yrsOfRegEd;
	}

	public void setMonthAndYear(String monthAndYear) {
		this.monthAndYear = monthAndYear;
	}

	public void setSacramentDesired(String sacramentDesired) {
		this.sacramentDesired = sacramentDesired;
	}

	public void setHaveASponsor(String haveASponsor) {
		this.haveASponsor = haveASponsor;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public void setSponsorNumber(String sponsorNumber) {
		this.sponsorNumber = sponsorNumber;
	}

	public void setWhySponsor(String whySponsor) {
		this.whySponsor = whySponsor;
	}

	public void setGoodStanding(String goodStanding) {
		this.goodStanding = goodStanding;
	}

	public void setSponsorRole(String sponsorRole) {
		this.sponsorRole = sponsorRole;
	}

	public void setSomeoneInMind(String someoneInMind) {
		this.someoneInMind = someoneInMind;
	}

	public void setInquirerName(String inquirerName) {
		this.inquirerName = inquirerName;
	}

	public void setInquirerPhone(String inquirerPhone) {
		this.inquirerPhone = inquirerPhone;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public void setSpouseReligion(String spouseReligion) {
		this.spouseReligion = spouseReligion;
	}

	public void setPracticingCatholic(String practicingCatholic) {
		this.practicingCatholic = practicingCatholic;
	}

	public void setAttendSession(String attendSession) {
		this.attendSession = attendSession;
	}

	public void setCatholicMarriage(String catholicMarriage) {
		this.catholicMarriage = catholicMarriage;
	}

	public void setCatholicDate(String catholicDate) {
		this.catholicDate = catholicDate;
	}

	public void setCivilMarriageDate(String civilMarriageDate) {
		this.civilMarriageDate = civilMarriageDate;
	}

	public void setConA(String conA) {
		this.conA = conA;
	}

	public void setConB(String conB) {
		this.conB = conB;
	}

	public void setConC(String conC) {
		this.conC = conC;
	}

	public void setConD(String conD) {
		this.conD = conD;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public void setAges(String ages) {
		this.ages = ages;
	}

	public void setSponsorPotential(String sponsorPotential) {
		this.sponsorPotential = sponsorPotential;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setRowValues(ArrayList<String> rowValues) {
		this.rowValues = rowValues;
	}

	public String toString()
	{
		return this.first + " " + this.middle + " " + this.lastName;
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


}
