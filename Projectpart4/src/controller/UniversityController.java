package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDAO;
import bean.AdminLoginBean;
import bean.AdmissionsBean;
import bean.InstructorsBean;
import bean.CoursesBean;
import bean.DepartmentBean;
import bean.StudentsBean;


@WebServlet("/UniversityController")
public class UniversityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UniversityController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entered controller: In doGet");
				DepartmentBean db=new DepartmentBean();
				InstructorsBean csf=new InstructorsBean();
				CoursesBean cb=new CoursesBean();
				AdmissionsBean ab=new AdmissionsBean();
		
		/* The following code is invoked when the user selects DEPARTMENTS in Home page (index.jsp).
		 * This is used to get all the departments in the University */
				
				
		if (request.getParameter("action").equalsIgnoreCase("departments")){
			
			try {
				System.out.println("Entered try block in controller");
				DepartmentBean a=DepartmentDAO.departmentslist(db);
				if(a.getFlag()==1){
					request.setAttribute("departments", a);					
					getServletContext().getRequestDispatcher("/departments.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
			
		}
		
		/* The following code is invoked when the user selects COMPUTER SCIENCE DEPARTMENT FACULTY in Departments page (computerScience.jsp).
		 * This is used to get all the FACULTY of COMPUTER SCIENCE DEPARTMENT in the University */
		
		
		if (request.getParameter("action").equalsIgnoreCase("computerScienceFaculty")){
			
			try {
				System.out.println("Entered try block in controller");
				InstructorsBean cs=DepartmentDAO.csfaculty(csf);
				if(cs.getFlag()==1){
					
					request.setAttribute("csfaculty", cs);
					getServletContext().getRequestDispatcher("/csfaculty.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
			
		/* The following code is invoked when the user selects COMPUTER SCIENCE DEPARTMENT COURSES in Departments page (computerScience.jsp).
		* This is used to get all the COURSES of COMPUTER SCIENCE DEPARTMENT in the University */
			
			
		}
		if (request.getParameter("action").equalsIgnoreCase("computerScienceCourses")){
			
			try {
				System.out.println("Entered try block in controller");
				ArrayList<CoursesBean> c=DepartmentDAO.courselist(cb);
				request.setAttribute("courses", c);
				getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
				} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		/* The following code is invoked when the Admin selects MAKE ADMISSION DECISIONS after successfully login. (adminsuccess.jsp).
		* This is used to MAKE ADMISSIOIN DECISION for the applied students in the University */
		
		
		if (request.getParameter("action").equalsIgnoreCase("makeAdmissionDecisions")){
			
			AdmissionsBean abb;
				System.out.println("Entered try block in controller");
				
				
					try {
						ArrayList<AdmissionsBean> abl = DepartmentDAO.makeAdmissionDecisons(ab);
						request.setAttribute("admissionapplications", abl);
						getServletContext().getRequestDispatcher("/makeadmissiondecisions.jsp").forward(request, response);
						
					} catch (ClassNotFoundException | SQLException
							| NamingException e) {
						
						e.printStackTrace();
					}
			
						}
		
		
		/* The following code is invoked when the Admin selects DELETE REJECTED STUDENTS after successfully login. (adminsuccess.jsp).
		 * This is used to get all the REJECTED STUDENTS in the University */
		
		
		if (request.getParameter("action").equalsIgnoreCase("getrejectedapplications")){
			
			AdmissionsBean abb;
				System.out.println("Entered try block in controller to get rejected applications");
				
				
					try {
						ArrayList<AdmissionsBean> abl = DepartmentDAO.rejectedApplications(ab);
						request.setAttribute("rejectedapplications", abl);
						getServletContext().getRequestDispatcher("/deleterejectedstudent.jsp").forward(request, response);
						
					} catch (ClassNotFoundException | NamingException e) {
						
						e.printStackTrace();
					}
			
						}
		/* The following code is invoked when the student selects LIST OF AVAILABLE COURSES (studentsuccess.jsp).
		 * This is used by Student to get list of available courses for the given YearSemester*/
		
		if(request.getParameter("action").equalsIgnoreCase("listofavailablecourses"))
		{
			System.out.println("in the list of courses available controller loop");
			try {
				ArrayList<CoursesBean> lac=DepartmentDAO.availablecourselist(cb);
				request.setAttribute("listofavailablecourses", lac);
				getServletContext().getRequestDispatcher("/listofavailablecourses.jsp").forward(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CoursesBean cb=new CoursesBean();
		AdminLoginBean alb=new AdminLoginBean();
		StudentsBean sb=new StudentsBean();
		AdmissionsBean ab=new AdmissionsBean();
		System.out.println("Entered controller: In doPost");
		
		
		
		
		
		/* The following code is invoked when the Admin selects ADD COURSE after successfully login. (adminsuccess.jsp).
		 * This is used to get add a course in the University */
		
		if (request.getParameter("add")!=null){
			if(request.getParameter("add").equalsIgnoreCase("Submit")){
			System.out.println("Entered if condition");
			try {
				System.out.println("Entered try");
				int courseid=Integer.parseInt(request.getParameter("courseid"));
				String coursename=request.getParameter("coursename");
				String instructorid=request.getParameter("instructorid");
				String firstname=request.getParameter("firstname");
				String lastname=request.getParameter("lastname");
				String departmentname=request.getParameter("departmentname");
				int credits=Integer.parseInt(request.getParameter("credits"));
				String offeredyearsemester=request.getParameter("offeredyearsemester");
				int buildingnumber=Integer.parseInt(request.getParameter("buildingnumber"));
				String buildingcode=request.getParameter("buildingcode");
				System.out.println(courseid);
				System.out.println(coursename);
				System.out.println(instructorid);
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(departmentname);
				System.out.println(credits);
				System.out.println(offeredyearsemester);
				System.out.println(buildingnumber);
				System.out.println(buildingcode);
				cb.setCourseID(courseid);
				cb.setCourseName(coursename);
				cb.setInstructorID(instructorid);
				cb.setFirstName(firstname);
				cb.setLastName(lastname);
				cb.setDepartmentName(departmentname);
				cb.setCredits(credits);
				cb.setOfferedYearSemester(offeredyearsemester);
				cb.setBuildingNumber(buildingnumber);
				cb.setBuildingCode(buildingcode);
				
				ArrayList<CoursesBean> c=DepartmentDAO.addcourse(cb);
				request.setAttribute("courses", c);
				getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (NamingException e) {
				
				e.printStackTrace();
			}
		}
		}
		
		/* The following code is invoked when the Admin tries to login. (login.jsp).
		 * This is used to login with Admin access */
		
		
		if (request.getParameter("x")!=null){
		if (request.getParameter("x").equalsIgnoreCase("Login")){
			System.out.println("entered login admin");
			
			String username=request.getParameter("username");
			String password=request.getParameter("pass");
			alb.setUsername(username);
			alb.setPassword(password);
			System.out.println(alb.getUsername());
			System.out.println(alb.getPassword());
			if(alb.getUsername().equals("ravimahi") && alb.getPassword().equals("ravimahi")){
				request.setAttribute("credentials", alb);
				getServletContext().getRequestDispatcher("/adminsuccess.jsp").forward(request, response);
			}
			else{
							
				getServletContext().getRequestDispatcher("/adminfailure.jsp").forward(request, response);
			}
				
		}
		}
		
		
		/* The following code is invoked when the Student tries to login. (admissionslogin.jsp).
		 * This is used to get login with student credentials in the University */
		
		
		if (request.getParameter("studentlogin")!=null){
			if (request.getParameter("studentlogin").equalsIgnoreCase("Login")){
				System.out.println("entered student admin");
				
				int username=Integer.parseInt(request.getParameter("username"));
				int password=Integer.parseInt(request.getParameter("password"));
				ab.setUserName(username);
				ab.setPassword(password);
				System.out.println(ab.getUserName());
				System.out.println(ab.getPassword());
				
				try {
					AdmissionsBean abb=(AdmissionsBean)DepartmentDAO.checkstudentlogin(ab);
					if(ab.getFlag()==1){
						request.setAttribute("studentdetails", abb);
						getServletContext().getRequestDispatcher("/studentsuccess.jsp").forward(request, response);
					}
					else{
									
						getServletContext().getRequestDispatcher("/studentfailure.jsp").forward(request, response);
					}
				} catch (ClassNotFoundException | SQLException
						| NamingException e) {
					
					e.printStackTrace();
				}
				
					
			}
			}
		
		
		/* The following code is invoked when the Admin selects UPDATE STUDENT after successfully login. (adminsuccess.jsp).
		 * This is used to search a student with student id in the University */
		
		
		if (request.getParameter("searchstudent")!=null){
			if(request.getParameter("searchstudent").equalsIgnoreCase("Submit")){
				String studentid=request.getParameter("studentid");
				System.out.println("searching student with emailid "+studentid);
				sb.setStudentId(studentid);
				try {
					StudentsBean s=DepartmentDAO.searchstudent(sb);
					if(s.getFlag()==1){
						request.setAttribute("student", s);
						getServletContext().getRequestDispatcher("/updatestudent.jsp").forward(request, response);
				} }catch (ClassNotFoundException | NamingException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		
		/* The following code is invoked when the user selects INSTRUCTORS FOR EACH COURSE in COMPUTER SCIENCE DEPARTMENT. (computerScience.jsp).
		 * This is used to search instructors for the given course in COMPUTER SCIENCE DEPARTMENT */
		
		
		
		if (request.getParameter("searchcourse")!=null){
			if(request.getParameter("searchcourse").equalsIgnoreCase("Submit")){
				String coursename=request.getParameter("coursename");
				System.out.println("searching course with name "+coursename);
				cb.setCourseName(coursename);
				ArrayList<CoursesBean> s;
				try {
					s = DepartmentDAO.instructorsforcourse(cb);
					System.out.println("Got input from DAO for instructorsforcourses");
					request.setAttribute("instructorsforcourses", s);
					getServletContext().getRequestDispatcher("/instructorsforcourses.jsp").forward(request, response);
				} catch (ClassNotFoundException | NamingException e) {
					
					e.printStackTrace();
				}
					
			}
		}
		
		
		/* The following code is invoked when the Admin updates a student details by selecting UPDATE STUDENT after successfully login. (updatestudent.jsp).
		 * Once the student details are updated, it will be shown in updatedstudent.jsp */
		
		
		if (request.getParameter("updatestudent")!=null){
			if(request.getParameter("updatestudent").equalsIgnoreCase("Update")){
				String studentid=request.getParameter("studentid");
				String firstname=request.getParameter("firstname");
				String lastname=request.getParameter("lastname");
				String gender=request.getParameter("gender");
				String dob=request.getParameter("dob");
				String departmentname=request.getParameter("departmentname");
				String emailid=request.getParameter("emailid");
				String address=request.getParameter("address");
				String joinedyearsem=request.getParameter("joinedyearsem");
				sb.setStudentId(studentid);
				sb.setFirstName(firstname);
				sb.setLastName(lastname);
				sb.setGender(gender);
				sb.setDATEOFBIRTH(dob);
				sb.setDepartmentName(departmentname);
				sb.setEmailID(emailid);
				sb.setAddress(address);
				sb.setJoinedYearSem(joinedyearsem);
									
					try {
						StudentsBean s = DepartmentDAO.updatestudent(sb);
						if(s.getFlag()==1){
							request.setAttribute("studentupdate", s);
							getServletContext().getRequestDispatcher("/updatedstudent.jsp").forward(request, response);
					
					} }catch (ClassNotFoundException | NamingException e) {
						
						e.printStackTrace();
					}
					
				
			}
		}
		
		/* The following code is invoked when the Student selects SignUp form. (admissionslogin.jsp).
		 * This is used by student to apply to the university*/
		
		
		if (request.getParameter("signupform")!=null){
			if(request.getParameter("signupform").equalsIgnoreCase("Submit")){
				Random rand = new Random();
				int uname = rand.nextInt((50000 - 15001) + 1) + 15001;
				int pass = rand.nextInt((50000 - 15001) + 1) + 15001;
				System.out.println("UserName is "+uname);
				System.out.println("Password is "+pass);
				String firstname=request.getParameter("firstname");
				String lastname=request.getParameter("lastname");
				String gender=request.getParameter("gender");
				String dob=request.getParameter("dob");
				String departmentname=request.getParameter("departmentname");
				String address=request.getParameter("address");
				String emailid=request.getParameter("emailid");
				int grescore=Integer.parseInt(request.getParameter("grescore"));
				String preferredyearsem=request.getParameter("preferredyearsem");
				ab.setUserName(uname);
				ab.setPassword(pass);
				ab.setFirstName(firstname);
				ab.setLastName(lastname);
				ab.setGender(gender);
				ab.setDATEOFBIRTH(dob);
				ab.setDepartmentName(departmentname);
				ab.setAddress(address);
				ab.setEmailID(emailid);
				ab.setGreScore(grescore);
				ab.setPreferredYearSem(preferredyearsem);
				AdmissionsBean abb;
				try {
					abb = DepartmentDAO.newstudent(ab);
					if(abb.getFlag()==1){
						request.setAttribute("newstudent", abb);
						getServletContext().getRequestDispatcher("/admissionssignup.jsp").forward(request, response);
							}
				} catch (ClassNotFoundException | NamingException | ParseException e) {
					
					e.printStackTrace();
				}
				
			}
		}
		
		/* The following code is invoked when the admin selects MAKE ADMISSION DECISIONS and selects students to give admission. (makeadmissiondecision.jsp).
		 * This is used by Admin to give admission to applied students*/
		
		
		if (request.getParameter("giveadmission")!=null){
			if(request.getParameter("giveadmission").equalsIgnoreCase("Admit")){
			System.out.println("Entered if condition");
			
			int username=Integer.parseInt(request.getParameter("applications"));
			ab.setUserName(username);
			try {
				AdmissionsBean aab=DepartmentDAO.giveadmission(ab);
				if(ab.getFlag()==1){
					
					getServletContext().getRequestDispatcher("/admissiongiven.jsp").forward(request, response);	
					
				}
				
			} catch (ClassNotFoundException | SQLException | NamingException e) {
				
				e.printStackTrace();
			}
			
			
			
			}
		}
		
		/* The following code is invoked when the admin selects MAKE ADMISSION DECISIONS and selects students to reject admission. (makeadmissiondecision.jsp).
		 * This is used by Admin to reject admission to applied students*/
		
		
		
		if (request.getParameter("rejectadmission")!=null){
			if(request.getParameter("rejectadmission").equalsIgnoreCase("Reject")){
			System.out.println("Entered if condition");			
			int username=Integer.parseInt(request.getParameter("applications"));
			ab.setUserName(username);
			try {
				AdmissionsBean aab=DepartmentDAO.rejectadmission(ab);
				if(ab.getFlag()==1){
					
					getServletContext().getRequestDispatcher("/admissionrejected.jsp").forward(request, response);	
					
				}
				
			} catch (ClassNotFoundException | SQLException | NamingException e) {
				
				e.printStackTrace();
			}
			
			
			
			}
		}
		
		/* The following code is invoked when the admin selects DELETE REJECTED STUDENTS and selects rejected students to delete from DB. (makeadmissiondecision.jsp).
		 * This is used by Admin to delete rejected applications from database*/
		
		
		if (request.getParameter("deleteapplication")!=null){
			if(request.getParameter("deleteapplication").equalsIgnoreCase("Delete")){
			System.out.println("Entered if condition");			
			int username=Integer.parseInt(request.getParameter("rejectedapplications"));
			ab.setUserName(username);
			try {
				AdmissionsBean aab=DepartmentDAO.deleteadmission(ab);
				if(ab.getFlag()==1){
					
					getServletContext().getRequestDispatcher("/deleterejectedstudent.jsp").forward(request, response);	
					
				}
				
			} catch (ClassNotFoundException | SQLException | NamingException e) {
				
				e.printStackTrace();
			}
			
			
			
			}
		}
		
		/* The following code is invoked when the admin selects NUMBER OF APPLICATIONS and gives YearSemester. (numberofapplications.jsp).
		 * This is used by Admin to get number of applications obtained for the YearSemester*/
		
		if (request.getParameter("numberOfApplications")!=null){
		if (request.getParameter("numberOfApplications").equalsIgnoreCase("Submit")){
			
			System.out.println("Entered try block in controller for numberOfApplications");
			
			
				AdmissionsBean abl;
				try {
					String oys=request.getParameter("offeredYearSemester");
					ab.setPreferredYearSem(oys);
					abl = DepartmentDAO.numberOfApplications(ab);
					request.setAttribute("numberapplications", abl);
					getServletContext().getRequestDispatcher("/numberofapplications.jsp").forward(request, response);
					
				} catch (ClassNotFoundException | SQLException
						| NamingException e) {
					
					e.printStackTrace();
				}
				
		
					}
		
		}
		
		
		/* The following code is invoked when the student selects REGISTER FOR COURSES.
		 * This is used by Students to register for courses*/
		
			
		if(request.getParameter("register")!=null){
			
		if(request.getParameter("register").equalsIgnoreCase("Register"))
		{
			System.out.println("in the registration of courses");
			
			int uname=Integer.parseInt(request.getParameter("studentid"));
			String coursename=request.getParameter("coursename");
			String oys=request.getParameter("oys");
			System.out.println("in the registration of courses"+uname+coursename+oys);
			cb.setUsername(uname);
			cb.setCourseName(coursename);
			cb.setOfferedYearSemester(oys);
			
				 
				
					 
					try {
						List<CoursesBean> cb1 = DepartmentDAO.register(cb);
					
						if(cb1==null || cb1.isEmpty())
						{
							
							System.out.println("IN loop of error");

							request.setAttribute("registercourses", " You have already registerd to this Course ");
							getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);

						}
						else
						{
							
							System.out.println("IN loop of register");
							request.setAttribute("registercourses", cb1);
							getServletContext().getRequestDispatcher("/registredcourses.jsp").forward(request, response);
						}
					} catch (SQLException | ClassNotFoundException | NamingException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		}
				
		}
				
			
		
	
		
		
		
	}
}