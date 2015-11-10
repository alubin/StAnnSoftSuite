package ccf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This structure holds the values of the CCF data that is
 *  either extracted from a file or the database.
 * @author AL
 *
 */
public class CCFData {

	private final int Id;
	private final double studentId;
	private final String parishId;
	private final String dob;
	private final String function;
	private final String active;
	private final String lastName;
	private final String firstName;
	private final String name;
	private final double classOffered;
	private final double hoursCredited;
	private final String classDate;
	private final String courseTitle;
	private final String instructor;
	private final String experienced;
	private final String courseLevel;
	private String emailAddress;
	private final Object[] objArray;

	public CCFData(Object[] dataArray) throws ParseException
	{
		Date date = null;
		objArray = dataArray;
		Id = (int) dataArray[0];
		studentId = (double) dataArray[1];
		parishId = (String) dataArray[2];
		dob = (String) dataArray[3];
		function = (String) dataArray[4];
		active = (String) dataArray[5];
		lastName = (String) dataArray[6];
		firstName = (String) dataArray[7];
		name = (String) dataArray[8];
		classOffered = (double) dataArray[9];
		hoursCredited = (double) dataArray[10];
		if(dataArray[11] != null)
		{
			if(dataArray[11] instanceof java.lang.String)
			{
				classDate = (String)dataArray[11];
			}
			else
			{
				date = new Date(((Date)dataArray[11]).getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YY HH:mm a, y");
				String dateFormatted = sdf.format(date);
				Date date2 = sdf.getInstance().parse(dateFormatted);
				classDate = dateFormatted;
			}
		}
		else
		{
			classDate = " ";
		}
		//		if(dataArray[11] == null)
		//		{
		//			date = new Date(0L);
		//
		//		}
		//		else
		//		{
		//			date = new Date(((Date)dataArray[11]).getTime());
		//		}
		//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YY HH:mm a, y");
		//		String dateFormatted = sdf.format(date);
		//		Date date2 = sdf.getInstance().parse(dateFormatted);
		//				System.out.println(((Date)date2).toString());
		//		classDate = date2.toString();
		//		classDate = DateFormat.getInstance().parse(sdf.parse(((Date)dataArray[11]).toString()).toString()) ;
		//		classDate = DateFormat.getInstance().parse("07/10/96 4:5 PM, PDT") ;
		//		"Mon Nov 30 00:00:00 CST 2009"
		courseTitle = (String) dataArray[12];
		instructor = (String) dataArray[13];
		experienced = (String) dataArray[14];
		courseLevel = (String) dataArray[15];
		emailAddress = "N/A";
	}
	public int getId() {
		return Id;
	}
	public double getStudentId() {
		return studentId;
	}
	public String getParishId() {
		return parishId;
	}
	public String getDob() {
		return dob;
	}
	public String getFunction() {
		return function;
	}
	public String getActive() {
		return active;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getName() {
		return name;
	}
	public double getClassOffered() {
		return classOffered;
	}
	public double getHoursCredited() {
		return hoursCredited;
	}
	public String getClassDate() {
		return classDate == null ? " " : classDate.toString();
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public String getInstructor() {
		return instructor;
	}
	public String getExperienced() {
		return experienced;
	}
	public String getCourseLevel() {
		return courseLevel;
	}
	@Override
	public String toString() {
		return "CCFData [Id=" + Id + ", studentId=" + studentId + ", parishId="
				+ parishId + ", dob=" + dob + ", function=" + function
				+ ", active=" + active + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", name=" + name
				+ ", classOffered=" + classOffered + ", hoursCredited="
				+ hoursCredited + ", classDate=" + classDate + ", courseTitle="
				+ courseTitle + ", instructor=" + instructor + ", experienced="
				+ experienced + ", courseLevel=" + courseLevel + ", Email=" + emailAddress + "]";
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public Object[] getObjArray()
	{
		return objArray;
	}
}
