package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.NamingException;

import bean.AdmissionsBean;
import bean.CoursesBean;
import bean.DepartmentBean;
import bean.InstructorsBean;
import bean.StudentsBean;

public class DepartmentDAO {

	Connection conn = null;
	
	/* This method is used to get all the DEPARTMENTS in the University*/
	
		public static DepartmentBean departmentslist(DepartmentBean db)
			throws ClassNotFoundException, NamingException {

		try {
			
			System.out.println("Entered try block in DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			Statement mystmt = myConn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from department order by DepartmentName asc");
			System.out.println("Entering while loop :IN DAO");
			ArrayList a = new ArrayList();
			while (rs.next()) {
				a.add(rs.getString("DepartmentName"));
				db.DepartmentName=rs.getString("DepartmentName");
				db.setFlag(1);
				db.store=a;
				System.out.println(db.store);
					}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return db;
	}

		
		/* This method is used to get all the FACULTY of COMPUTER SCIENCE DEPARTMENT in the University*/
		
	public static InstructorsBean csfaculty(InstructorsBean csf) throws ClassNotFoundException, NamingException {
		
try {
			
			System.out.println("Entered try block in csf DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			Statement mystmt = myConn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from instructors where DepartmentName='COMPUTER SCIENCE'");
			System.out.println("Entering while loop csf:IN DAO");
			ArrayList Name= new ArrayList();
			ArrayList EmailID= new ArrayList();
			ArrayList Qualification= new ArrayList();
			ArrayList Designation= new ArrayList();
			ArrayList PhoneNumber= new ArrayList();
			
			while (rs.next()) {
				
				Name.add(rs.getString("LastName")+","+rs.getString("FirstName"));
				Qualification.add(rs.getString("Qualification"));
				Designation.add(rs.getString("Designation"));
				EmailID.add(rs.getString("EmailID"));
				PhoneNumber.add(rs.getString("PhoneNumber"));			
				csf.setFlag(1);
				csf.NameArray=Name;
				csf.EmailIDArray=EmailID;
				csf.DesignationArray=Designation;
				csf.PhoneNumberArray=PhoneNumber;
				csf.QualificationArray=Qualification;
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return csf;
	}
	
	/* This method is used to get all the COURSES in COMPUTER SCIENCE DEPARTMENT in the University*/
	

	public static ArrayList<CoursesBean> courselist(CoursesBean cb) throws ClassNotFoundException, NamingException {
		
		ArrayList<CoursesBean> cbList = null;
try {
			
			System.out.println("Entered try block in cb DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			Statement mystmt = myConn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from courses where DepartmentName='COMPUTER SCIENCE'");
			System.out.println("Entering while loop cb:IN DAO");
			
			
			cbList = new ArrayList<CoursesBean>();
			CoursesBean cb1;
			
			while (rs.next()) {
				
				cb1 = new CoursesBean();
				cb1.setCourseID(Integer.parseInt(rs.getString("CourseID")));
				cb1.setCourseName(rs.getString("CourseName"));
				cb1.setCredits(Integer.parseInt(rs.getString("Credits")));
				cb1.setInstructorID(rs.getString("InstructorID"));
				cbList.add(cb1);
				
				cb.setFlag(1);
					}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

     return cbList;
		
			}
	
	/* This method is used to ADD A COURSE in ANY DEPARTMENT in University */
	
	

	public static ArrayList<CoursesBean> addcourse(CoursesBean cb) throws ClassNotFoundException, NamingException {
		
		ArrayList<CoursesBean> cbList = null;
try {
			
			System.out.println("Entered try block in add course DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			System.out.println("Course Id is"+cb.getCourseID());
			System.out.println("queary started");
			Statement mystmt = myConn.createStatement();
			Statement mystmt2 = myConn.createStatement();
			PreparedStatement ps1=myConn.prepareStatement("insert into instructors (InstructorID,FirstName,LastName) values (?,?,?)");
			PreparedStatement ps2= myConn.prepareStatement("insert into courses values(?,?,?,?,?,?,?,?)");
			System.out.println("Department Name in DAO"+cb.getDepartmentName());
			ps2.setInt(1, cb.getCourseID());
			ps2.setString(2, cb.getCourseName());
			ps2.setString(3, cb.getInstructorID());
			ps2.setString(4, cb.getDepartmentName());
			ps2.setInt(5, cb.getCredits());
			ps2.setString(6, cb.getOfferedYearSemester());
			ps2.setInt(7, cb.getBuildingNumber());
			ps2.setString(8, cb.getBuildingCode());
			ps1.setString(1, cb.getInstructorID());
			ps1.setString(2, cb.getFirstName());
			ps1.setString(3, cb.getLastName());
			System.out.println("Instructor Id is: "+cb.getInstructorID());
			ResultSet rs2 = mystmt.executeQuery("select * from instructors where InstructorID='"+cb.getInstructorID()+"'");
			if(rs2.next())
			{
				if(cb.getInstructorID().equals(rs2.getString("InstructorID"))){
					ps2.execute();
					System.out.println("Inserted course only in courses");
				}
			}
			else{
				ps1.execute();
				ps2.execute();
				System.out.println("Inserted course in courses and Instructor Id in instructors");
			}
		
			System.out.println("after if else loop");
			
			ResultSet rs = mystmt.executeQuery("select * from courses where DepartmentName='"+cb.getDepartmentName()+"'");
			System.out.println("Entering while loop cb:IN DAO");
			ArrayList a = new ArrayList();
			
			cbList = new ArrayList<CoursesBean>();
			CoursesBean cb1;
			while (rs.next()) {
				cb1 = new CoursesBean();
				cb1.setCourseID(Integer.parseInt(rs.getString("CourseID")));
				cb1.setCourseName(rs.getString("CourseName"));
				cb1.setCredits(Integer.parseInt(rs.getString("Credits")));
				cb1.setInstructorID(rs.getString("InstructorID"));
				cbList.add(cb1);
				
				cb.setFlag(1);
				
					}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       cb.setFlag(1);
       System.out.println(cbList);
		return cbList;
		
	}

	/* This method is used to SEARCH A STUDENT in University DATABASE */
	
	
	
	public static StudentsBean searchstudent(StudentsBean sb) throws ClassNotFoundException, NamingException {
		
		System.out.println("Entered student search DAO");
		
try {
			
			System.out.println("Entered try block in sb DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			Statement mystmt = myConn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from students where StudentID='"+sb.getStudentId()+"'");
			System.out.println("Entering if loop sb:IN DAO");
			ArrayList a = new ArrayList();
			if(rs.next())
			 {
				System.out.println("Entered if loop sb:IN DAO");
				sb.StudentId=rs.getString("StudentID");
		        sb.FirstName=rs.getString("FirstName");
		        sb.LastName=rs.getString("LastName");
		        sb.Gender=rs.getString("Gender");
		        sb.DATEOFBIRTH=rs.getString("DATEOFBIRTH");
		        sb.DepartmentName=rs.getString("DepartmentName");
		        sb.EmailID=rs.getString("EmailID");
		        sb.Address=rs.getString("Address");
		        sb.JoinedYearSem=rs.getString("JoinedYearSem");
		        sb.setFlag(1);
		      }

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return sb;
		
	}
	
	/* This method is used to Update the Selected student in the University DATABASE */
	
	

	public static StudentsBean updatestudent(StudentsBean sb) throws ClassNotFoundException, NamingException {
		 
		try{
		
		System.out.println("Entered try block in update student DAO");
		Connection myConn = DBConnection.createDatabaseConnection();
		System.out.println("update queary started");
		PreparedStatement ps=myConn.prepareStatement("update students set FirstName=?, LastName=?, Gender=?, DATEOFBIRTH=?, DepartmentName=?, EmailID=?, Address=?, JoinedYearSem=? where StudentId=?");
		ps.setString(1, sb.getFirstName());
		ps.setString(2, sb.getLastName());
		ps.setString(3, sb.getGender());
		ps.setString(4, sb.getDATEOFBIRTH());	
		ps.setString(5, sb.getDepartmentName());
		ps.setString(6, sb.getEmailID());
		ps.setString(7, sb.getAddress());
		ps.setString(8, sb.getJoinedYearSem());
		ps.setString(9, sb.getStudentId());
		ps.execute();
		System.out.println("update queary executed");
		Statement mystmt = myConn.createStatement();
		ResultSet rs = mystmt.executeQuery("select * from students where StudentId='"+sb.getStudentId()+"'");
		System.out.println("Entering while loop sb:IN DAO");
		ArrayList a = new ArrayList();
		if(rs.next())
		 {
			System.out.println("Entered if loop sb:IN DAO");
			sb.StudentId=rs.getString("StudentID");
	        sb.FirstName=rs.getString("FirstName");
	        sb.LastName=rs.getString("LastName");
	        sb.Gender=rs.getString("Gender");
	        sb.DATEOFBIRTH=rs.getString("DATEOFBIRTH");
	        sb.DepartmentName=rs.getString("DepartmentName");
	        sb.EmailID=rs.getString("EmailID");
	        sb.Address=rs.getString("Address");
	        sb.JoinedYearSem=rs.getString("JoinedYearSem");
	        sb.setFlag(1);
	      }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    sb.setFlag(1);
	return sb;
	}

	
	/* This method is used to INSERT A NEW APPLICATION FROM STUDENT to the University DATABASE*/
	
	
	public static AdmissionsBean newstudent(AdmissionsBean ab) throws ClassNotFoundException, NamingException, ParseException {
		
		
try {
			
			System.out.println("Entered try block in add admission DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			System.out.println("queary started");
			System.out.println("UserName is "+ab.getUserName());
			System.out.println("Password is "+ab.getPassword());
			DateFormat outputformatter = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat inputformatter=new SimpleDateFormat("mm/dd/yyyy");
            System.out.println(ab.getDATEOFBIRTH());

            System.out.println(outputformatter.format(inputformatter.parse(ab.getDATEOFBIRTH())));
            
			PreparedStatement ps= myConn.prepareStatement("insert into admissions values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, ab.getUserName());
			ps.setInt(2, ab.getPassword());
			ps.setString(3, ab.getFirstName());
			ps.setString(4, ab.getLastName());
			ps.setString(5, ab.getGender());
			ps.setString(6, outputformatter.format(inputformatter.parse(ab.getDATEOFBIRTH())));
			ps.setString(7, ab.getDepartmentName());
			ps.setString(8, ab.getAddress());
			ps.setString(9, ab.getEmailID());
			ps.setInt(10, ab.getGreScore());
			ps.setString(11, ab.getPreferredYearSem());
			ps.setInt(12, ab.getFlag());
			ps.execute();
			System.out.println("insert queary executed");
			Statement mystmt = myConn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from admissions where Username='"+ab.getUserName()+"'");
			System.out.println("Entering if loop ab:IN DAO");
			if(rs.next()){
				System.out.println("Entered if loop sb:IN DAO");
				ab.UserName=rs.getInt("UserName");
				ab.Password=rs.getInt("Password");
				ab.FirstName=rs.getString("FirstName");
				ab.LastName=rs.getString("LastName");
				ab.Gender=rs.getString("Gender");
				ab.DATEOFBIRTH=rs.getString("DATEOFBIRTH");
				ab.DepartmentName=rs.getString("DepartmentName");
				ab.Address=rs.getString("Address");
				ab.EmailID=rs.getString("EmailID");
				ab.GreScore=rs.getInt("GreScore");
				ab.PreferredYearSem=rs.getString("PreferredYearSem");
				ab.setFlag(1);
			}
			else
			{
				ab.setFlag(0);
			}
		      		} catch (SQLException e) {
			
			e.printStackTrace();
		}


		return ab;
			}

	/* This method is used to CHECK STUDENT CREDENTIALS and TO SHOW STUDENT APPLICATION STATUS */
	
	
	public static AdmissionsBean checkstudentlogin(AdmissionsBean ab) throws ClassNotFoundException, SQLException, NamingException {
		
		System.out.println("Entered try block in check student login DAO");
		Connection myConn = DBConnection.createDatabaseConnection();
		Statement mystmt = myConn.createStatement();
		ResultSet rs = mystmt.executeQuery("select * from admissions where UserName='"+ab.getUserName()+"'");
		if(rs.next()){
			if(rs.getInt("Password")==ab.getPassword()){
				ab.setFlag(1);
				ab.UserName=rs.getInt("UserName");
				ab.Password=rs.getInt("Password");
				ab.FirstName=rs.getString("FirstName");
				ab.LastName=rs.getString("LastName");
				ab.Gender=rs.getString("Gender");
				ab.DATEOFBIRTH=rs.getString("DATEOFBIRTH");
				ab.DepartmentName=rs.getString("DepartmentName");
				ab.Address=rs.getString("Address");
				ab.EmailID=rs.getString("EmailID");
				ab.GreScore=rs.getInt("GreScore");
				ab.PreferredYearSem=rs.getString("PreferredYearSem");
				ab.admission=rs.getInt("Admission");
				if(ab.admission==0){
					ab.setAdmittedmsg("Your Application is Pending");
				}
				else if(ab.admission==1){
					ab.setAdmittedmsg("Congratulations!! You are admitted in the University");
				}
				else if(ab.admission==2){
					ab.setAdmittedmsg("We are sorry. Your application is declined");
				}
			}
			else
				ab.setFlag(0);
		}
		
		return ab;
	}

	/* This method is used to SHOW ALL APPLICATIONs APPLIED to the University*/
	
	
	public static ArrayList<AdmissionsBean> makeAdmissionDecisons(AdmissionsBean ab) throws ClassNotFoundException, SQLException, NamingException {
		
		ArrayList<AdmissionsBean> abList = null;
		try{
		System.out.println("Entered try block in check student login DAO");
		Connection myConn = DBConnection.createDatabaseConnection();
		Statement mystmt = myConn.createStatement();
		ResultSet rs = mystmt.executeQuery("select * from admissions where Admission='0'");
		abList = new ArrayList<AdmissionsBean>();
		AdmissionsBean ab1;
		
		while (rs.next()) {
			ab1 = new AdmissionsBean();
			ab1.setUserName(Integer.parseInt(rs.getString("UserName")));
			abList.add(ab1);			
			ab.setFlag(1);
		}
		}
		 catch (SQLException e) {
				
				e.printStackTrace();
			}
		return abList;
	}

	/* This method is used to get all the INSTRUCTORS FOR THE GIVEN COURSES in the University*/
	
	
	public static ArrayList<CoursesBean> instructorsforcourse(CoursesBean cb) throws ClassNotFoundException, NamingException {
		
		
		System.out.println("Entered course search DAO");
		ArrayList<CoursesBean> ifcList = null;
		CoursesBean cb1;
		
		try {
					
					System.out.println("Entered try block in cb DAO");
					Connection myConn = DBConnection.createDatabaseConnection();
					Statement mystmt = myConn.createStatement();
					ResultSet rs = mystmt.executeQuery("select 	CourseID, CourseName, courses.InstructorID as IID, FirstName, LastName,OfferedYearSemester from courses INNER JOIN instructors on courses.InstructorID=instructors.InstructorID and courses.DepartmentName='COMPUTER SCIENCE' and CourseName='"+cb.getCourseName()+"'");
					ifcList = new ArrayList<CoursesBean>();
					System.out.println("Entering while loop cb:IN DAO");
					
					while (rs.next()) {
						System.out.println("Entered while loop cb:IN DAO");
						cb1 = new CoursesBean();
						cb1.setCourseID(Integer.parseInt(rs.getString("CourseID")));
						
						cb1.setCourseName(rs.getString("CourseName"));
						cb1.setInstructorID(rs.getString("IID"));
						cb1.setFirstName(rs.getString("FirstName"));
						cb1.setLastName(rs.getString("LastName"));
						cb1.setOfferedYearSemester(rs.getString("OfferedYearSemester"));
						System.out.println("Details obtained in DAO are"+cb1.getCourseID()+cb1.getCourseName()+cb1.getInstructorID()+cb1.getFirstName()+cb1.getLastName()+cb1.getOfferedYearSemester());
						ifcList.add(cb1);			
						cb.setFlag(1);
					}

				} catch (SQLException e) {
					
					e.printStackTrace();
				}

				return ifcList;
		
	}

	/* This method is used to GIVE ADMISSION in the University*/
	
	
	public static AdmissionsBean giveadmission(AdmissionsBean ab) throws SQLException, ClassNotFoundException, NamingException {
		
		
		System.out.println("Entered try block in give admission DAO");
		Connection myConn = DBConnection.createDatabaseConnection();
		System.out.println("UserName is"+ab.getUserName());
		System.out.println("queary started");
		PreparedStatement ps1=myConn.prepareStatement("update admissions set Admission='1' where UserName='"+ab.getUserName()+"'");
		ps1.execute();
		ab.setFlag(1);
		return ab;
	}

	/* This method is used to REJECT ADMISSION in the University*/
	
	
	public static AdmissionsBean rejectadmission(AdmissionsBean ab) throws SQLException, ClassNotFoundException, NamingException {
		
		
		System.out.println("Entered try block in reject admission DAO");
		Connection myConn = DBConnection.createDatabaseConnection();
		System.out.println("UserName is"+ab.getUserName());
		System.out.println("queary started");
		PreparedStatement ps1=myConn.prepareStatement("update admissions set Admission='2' where UserName='"+ab.getUserName()+"'");
		ps1.execute();
		ab.setFlag(1);
		return ab;
	}
	
	/* This method is used to get NUMBER OF APPLICATIONS FOR A GIVEN SEMESTER in the University*/
	

	public static AdmissionsBean numberOfApplications(AdmissionsBean abb) throws SQLException, ClassNotFoundException, NamingException {
		
		
		System.out.println("Entered try block in numberOfApplications DAO");
		Connection myConn = DBConnection.createDatabaseConnection();
		System.out.println("queary started");
		Statement mystmt = myConn.createStatement();
		ResultSet rs = mystmt.executeQuery("select count(*) as applications from admissions where PreferredYearSem='"+abb.getPreferredYearSem()+"'");
		System.out.println("Entering if loop abb:IN DAO");
		if(rs.next()){
			System.out.println("Entered if loop abb:IN DAO");
			abb.count=rs.getInt("applications");
			abb.setFlag(1);
		}
		return abb;
	}
	
	/* This method is used to GET ALL THE REJECTED APPLICATIONS in the University*/
	
	

	public static ArrayList<AdmissionsBean> rejectedApplications(
			AdmissionsBean ab) throws ClassNotFoundException, NamingException {
		
		
		ArrayList<AdmissionsBean> abList = null;
		try{
		System.out.println("Entered try block in check student login DAO");
		Connection myConn = DBConnection.createDatabaseConnection();
		Statement mystmt = myConn.createStatement();
		ResultSet rs = mystmt.executeQuery("select * from admissions where Admission='2'");
		abList = new ArrayList<AdmissionsBean>();
		AdmissionsBean ab1;
		
		while (rs.next()) {
			ab1 = new AdmissionsBean();
			ab1.setUserName(Integer.parseInt(rs.getString("UserName")));
			abList.add(ab1);			
			ab.setFlag(1);
		}
		}
		 catch (SQLException e) {
				
				e.printStackTrace();
			}
		return abList;
		
	}

	/* This method is used to DELETE REJECTED APPLICATIONS in the University*/
	
	
	public static AdmissionsBean deleteadmission(AdmissionsBean ab) throws SQLException, ClassNotFoundException, NamingException {
		
		Connection myConn = DBConnection.createDatabaseConnection();
		System.out.println("UserName is"+ab.getUserName());
		System.out.println("queary started");
		PreparedStatement ps1=myConn.prepareStatement("delete from admissions where UserName in ('"+ab.getUserName()+"')");
		ps1.execute();
		System.out.println("queary executed");
		ab.setFlag(1);
		return ab;
	}
	
	
	public static ArrayList<CoursesBean> availablecourselist(CoursesBean cb) throws ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		ArrayList<CoursesBean> cbList = null;
try {
			
			System.out.println("Entered try block in cb DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			Statement mystmt = myConn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from courses where OfferedYearSemester='Spring-2016'");
			System.out.println("Entering while loop cb:IN DAO");
			//ArrayList a = new ArrayList();
			
			cbList = new ArrayList<CoursesBean>();
			CoursesBean cb1;
			
			while (rs.next()) {
				/*a.add(rs.getString("CourseID")+" "+rs.getString("CourseName")+" "+rs.getString("Credits")+" "+rs.getString("InstructorID"));
				System.out.println(rs.getString("CourseID"));
				cb.setFlag(1);
				cb.store=a;
				*///System.out.println(cb.store);
				cb1 = new CoursesBean();
				cb1.setCourseID(Integer.parseInt(rs.getString("CourseID")));
				cb1.setCourseName(rs.getString("CourseName"));
				cb1.setOfferedYearSemester(rs.getString("OfferedYearSemester"));
				cb1.setCredits(Integer.parseInt(rs.getString("Credits")));
				cb1.setInstructorID(rs.getString("InstructorID"));
				cb1.setDepartmentName(rs.getString("DepartmentName"));
				cb1.setBuildingCode(rs.getString("BuildingCode"));
				cb1.setBuildingNumber(rs.getInt("BuildingNumber"));
				
				cbList.add(cb1);
				
				cb.setFlag(1);
					}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     return cbList;
		
			}
	
	
	
	public static ArrayList<CoursesBean> register(CoursesBean cb) throws ClassNotFoundException, NamingException, ParseException, SQLException {
		// TODO Auto-generated method stub
		
		int CourseID = 0;
		String CourseName=null;
		String InstructorID=null;				
		String DepartmentName=null;
		int Credits=0;
		String OfferedYearSemester=null;
		int BuildingNumber=0;
		String BuildingCode=null;
		ArrayList<CoursesBean> cbList = new ArrayList<CoursesBean>();

			System.out.println("Entered try block in  registration DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
		
			System.out.println("query started");
			System.out.println("UserName is "+cb.getUsername());
			System.out.println("Coursename is "+cb.getCourseName());

			Statement mystmt = myConn.createStatement();
			ResultSet rs1 = mystmt.executeQuery("select * from courses where CourseName='"+cb.getCourseName()+"' and OfferedYearSemester='"+cb.getOfferedYearSemester()+"'");
			System.out.println("Entering if loop cb:IN DAO");
			while(rs1.next()){
				System.out.println("Entered if loop sb:IN DAO");				
				CourseID=rs1.getInt("CourseID");
				CourseName=rs1.getString("CourseName");
				InstructorID=rs1.getString("InstructorID");				
				DepartmentName=rs1.getString("DepartmentName");
				Credits=rs1.getInt("Credits");
				OfferedYearSemester=rs1.getString("OfferedYearSemester");
				BuildingNumber=rs1.getInt("BuildingNumber");
				BuildingCode=rs1.getString("BuildingCode");		
			}
	                rs1.close(); 
                
	    ResultSet rs2 = mystmt.executeQuery("select * from registration where StudentID='"+cb.getUsername()+"' and CourseName='"+cb.getCourseName()+"'");
            /*if(CourseID!=rs2.getInt("CourseID")&&cb.getUsername()!=rs2.getInt("StudentID"))
*/           
if(rs2.next()){
            	
				
					cbList=null;
				}
				else
				{
					PreparedStatement ps= myConn.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, cb.getUsername());
					ps.setInt(2,CourseID);
					ps.setString(3,CourseName);
					ps.setString(4,InstructorID);
					ps.setString(5,DepartmentName);
					ps.setInt(6,Credits);
					ps.setString(7,OfferedYearSemester);
					ps.setInt(8, BuildingNumber);
					ps.setString(9,BuildingCode);
					
					ps.execute();
					System.out.println("insert queary executed");
					ResultSet rs = mystmt.executeQuery("select * from registration where StudentID='"+cb.getUsername()+"'");
					System.out.println("Entering if loop ab:IN DAO");
					if(rs.next()){
						System.out.println("Entered if loop sb:IN DAO");				
						cb.username=rs.getInt("StudentID");		
						System.out.println(cb.username);
						cb.CourseID=rs.getInt("CourseID");
						cb.CourseName=rs.getString("CourseName");
						cb.InstructorID=rs.getString("InstructorID");				
						cb.DepartmentName=rs.getString("DepartmentName");
						cb.Credits=rs.getInt("Credits");
						cb.OfferedYearSemester=rs.getString("OfferedYearSemester");
						cb.BuildingNumber=rs.getInt("BuildingNumber");
						cb.BuildingCode=rs.getString("BuildingCode");
						cb.setFlag(1);
						cbList.add(cb);
						
				}
			
			
            }
            
            


		return cbList;
			}
	}

