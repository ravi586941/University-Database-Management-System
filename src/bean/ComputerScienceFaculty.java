package bean;

import java.util.ArrayList;

public class ComputerScienceFaculty {
	
	String InstructorID ;
	String FirstName ;
	String LastName ;
	String Gender; 
	String DATEOFBIRTH ;
	String DepartmentName ;
	String JoiningDate ;
	String EmailID ;
	String Address ;
	String Qualification ;
	String Designation;
	String PhoneNumber;
	int flag=0;
	public ArrayList store;
	
	public String getInstructorID() {
		return InstructorID;
	}
	public void setInstructorID(String instructorID) {
		InstructorID = instructorID;
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
	public String getJoiningDate() {
		return JoiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		JoiningDate = joiningDate;
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
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
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
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	

}
