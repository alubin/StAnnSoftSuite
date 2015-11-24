package print;

import java.util.ArrayList;

public class PrintData {

	/*SELECT First_Name, Middle_Name, Last_Name, Familiar_Name, Sponsor_First_Name, Sponsor_Last_Name, Sponsor, 
	Print_Form, Eform_Paper, Bap_Cert, Birth_Name, DOB, Been_Baptized, Date_Of_Baptism, Month_Year_Confirmed, 
	Sponsor_Name, Have_Sponsor, Father_Full_Name, Mother_Full_Name, Sacraments*/

	//EForm or Paper [Enum]
	private final String typeOfForm;
	//Y or N
	private final String printForm;
	//???
	private final String bapCert;
	//Y or N
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

	private final String dob;

	private final String fatherFullName;
	private final String motherFullName;
	private final String baptizedInChrist;
	private final String dateOfBaptism;

	private final String monthAndYear;
	private final String sacramentDesired;
	private final String haveASponsor;
	private final String sponsorName;

	private ArrayList<String> rowValues;

	public PrintData(ArrayList<String> rowValue) {

		//Need to check the size of rowValue.

		this.rowValues = rowValue;
		this.first = rowValue.get(0);
		this.lastName = rowValue.get(1);
		this.middle = rowValue.get(2);
		this.familiarName = rowValue.get(3);
		this.sponFirst = rowValue.get(4);
		this.sponLast = rowValue.get(5);
		this.sponsor = rowValue.get(6);
		this.printForm = rowValue.get(7);
		this.typeOfForm = rowValue.get(8);
		this.bapCert = rowValue.get(9);
		this.birthName = rowValue.get(10);
		this.dob = rowValue.get(11);
		this.baptizedInChrist = rowValue.get(12);
		this.dateOfBaptism = rowValue.get(13);
		this.monthAndYear = rowValue.get(14);
		this.sponsorName = rowValue.get(15);
		this.haveASponsor = rowValue.get(16);
		this.fatherFullName = rowValue.get(17);
		this.motherFullName = rowValue.get(18);
		this.sacramentDesired = rowValue.get(19);
	}

	public final String getTypeOfForm() {
		return typeOfForm;
	}

	public final String getPrintForm() {
		return printForm;
	}

	public final String getBapCert() {
		return bapCert;
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

	public final String getDob() {
		return dob;
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

	/*SELECT First_Name, Middle_Name, Last_Name, Familiar_Name, Sponsor_First_Name, Sponsor_Last_Name, Sponsor, 
	Print_Form, Eform_Paper, Bap_Cert, Birth_Name, DOB, Been_Baptized, Date_Of_Baptism, Month_Year_Confirmed, 
	Sponsor_Name, Have_Sponsor, Father_Full_Name, Mother_Full_Name, Sacraments*/

	@Override
	public String toString() {
		return "PrintData [first=" + first + ", lastName=" + lastName + ", middle=" + middle + ","
				+ "familiarName=" + familiarName + ", sponFirst=" + sponFirst + ", sponLast=" + sponLast + ","
				+ "sponsor=" + sponsor + ", printForm=" + printForm + ", typeOfForm=" + typeOfForm + ","
				+ "bapCert=" + bapCert + ", birthName=" + birthName + ", dob=" + dob + ","
				+ "baptizedInChrist=" + baptizedInChrist + ", dateOfBaptism=" + dateOfBaptism + ","
				+ "monthAndYear=" + monthAndYear + ", sponsorName=" + sponsorName + ","
				+ "haveASponsor=" + haveASponsor + ", fatherFullName=" + fatherFullName + ","
				+ "motherFullName=" + motherFullName +", sacramentDesired=" + sacramentDesired + "]";
	}

	public Object[] getArray() {
		return rowValues.toArray();
	}


}
