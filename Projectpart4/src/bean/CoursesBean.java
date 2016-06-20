package bean;

import java.util.ArrayList;

/* Bean class for Courses */

public class CoursesBean {
	public int username;
	public int CourseID;
	public String CourseName;
	public String  InstructorID;
	public String DepartmentName;
	public int Credits;
    public String OfferedYearSemester;
    public int BuildingNumber;
    public String BuildingCode;
    public int flag=0;
    public ArrayList store;
    public String FirstName;
    public String LastName;
    
    
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getCourseID() {
		return CourseID;
	}
	
	
	
	
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getInstructorID() {
		return InstructorID;
	}
	public void setInstructorID(String instructorID) {
		InstructorID = instructorID;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public int getCredits() {
		return Credits;
	}
	public void setCredits(int credits) {
		Credits = credits;
	}
	public String getOfferedYearSemester() {
		return OfferedYearSemester;
	}
	public void setOfferedYearSemester(String offeredYearSemester) {
		OfferedYearSemester = offeredYearSemester;
	}
	public int getBuildingNumber() {
		return BuildingNumber;
	}
	public void setBuildingNumber(int buildingNumber) {
		BuildingNumber = buildingNumber;
	}
	public String getBuildingCode() {
		return BuildingCode;
	}
	public void setBuildingCode(String buildingCode) {
		BuildingCode = buildingCode;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public ArrayList getStore() {
		return store;
	}
	public void setStore(ArrayList store) {
		this.store = store;
	}

    
    
}
