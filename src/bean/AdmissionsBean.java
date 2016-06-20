package bean;

/* Bean class for Admissions */

public class AdmissionsBean {
    public int UserName;
    public int Password;
    public String FirstName;
    public String LastName;
    public String Gender;
    public String DATEOFBIRTH;
    public String DepartmentName;
    public String Address;
    public String EmailID;
	public int GreScore;
	public int flag=0;
	public int admission=0;
	public String PreferredYearSem;
	public String Admittedmsg;
	public int count=0;
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	public int getUserName() {
		return UserName;
	}
	public void setUserName(int userName) {
		UserName = userName;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getAdmittedmsg() {
		return Admittedmsg;
	}
	public void setAdmittedmsg(String admittedmsg) {
		Admittedmsg = admittedmsg;
	}
	public String getPreferredYearSem() {
		return PreferredYearSem;
	}
	public void setPreferredYearSem(String preferredYearSem) {
		PreferredYearSem = preferredYearSem;
	}
	public int getPassword() {
		return Password;
	}
	public void setPassword(int password) {
		Password = password;
	}
	public int getAdmission() {
		return admission;
	}
	public void setAdmission(int admission) {
		this.admission = admission;
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
		public String getDATEOFBIRTH() {
		return DATEOFBIRTH;
	}
	public void setDATEOFBIRTH(String dATEOFBIRTH) {
		DATEOFBIRTH = dATEOFBIRTH;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	
	public int getGreScore() {
		return GreScore;
	}
	public void setGreScore(int greScore) {
		GreScore = greScore;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	
	
	
}
