package bean;

import java.util.ArrayList;


/* Bean class for Students */

public class StudentsBean {
	public String StudentId;
	public String FirstName;
	public String LastName;
	public String Gender;
	public String DATEOFBIRTH;
	public String DepartmentName;
	public String EmailID;
	public String Address;
	public String JoinedYearSem;
	int flag=0;
    public ArrayList store;
	
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
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
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getDATEOFBIRTH() {
		return DATEOFBIRTH;
	}
	public void setDATEOFBIRTH(String dATEOFBIRTH) {
		DATEOFBIRTH = dATEOFBIRTH;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getJoinedYearSem() {
		return JoinedYearSem;
	}
	public void setJoinedYearSem(String joinedYearSem) {
		JoinedYearSem = joinedYearSem;
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
