package ccf;

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
	private final Object classDate;
	private final String courseTitle;
	private final String instructor;
	private final String experienced;
	private final String courseLevel;

	public CCFData(Object[] dataArray)
	{
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
		classDate = (Object) dataArray[11];
		courseTitle = (String) dataArray[12];
		instructor = (String) dataArray[13];
		experienced = (String) dataArray[14];
		courseLevel = (String) dataArray[15];
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
	public Object getClassDate() {
		return classDate;
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
				+ experienced + ", courseLevel=" + courseLevel + "]";
	}
}
