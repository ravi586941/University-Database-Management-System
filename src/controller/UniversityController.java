package controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDAO;
import bean.ComputerScienceFaculty;
import bean.DepartmentBean;

/**
 * Servlet implementation class UniversityController
 */
@WebServlet("/UniversityController")
public class UniversityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UniversityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entered controller: In doGet");
				DepartmentBean db=new DepartmentBean();
				ComputerScienceFaculty csf=new ComputerScienceFaculty();
		
		if (request.getParameter("action").equalsIgnoreCase("departments")){
			
			try {
				System.out.println("Entered try block in controller");
				DepartmentBean a=DepartmentDAO.departmentslist(db);
				if(a.getFlag()==1){
					request.setAttribute("departments", a);
					getServletContext().getRequestDispatcher("/departments.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (request.getParameter("action").equalsIgnoreCase("computerScienceFaculty")){
			
			try {
				System.out.println("Entered try block in controller");
				ComputerScienceFaculty cs=DepartmentDAO.csfaculty(csf);
				if(cs.getFlag()==1){
					
					request.setAttribute("csfaculty", cs);
					getServletContext().getRequestDispatcher("/csfaculty.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (request.getParameter("action").equalsIgnoreCase("computerScienceCourses")){
			/*
			try {
				System.out.println("Entered try block in controller");
				DepartmentBean a=DepartmentDAO.departmentslist(db);
				if(a.getFlag()==1){
					request.setAttribute("departments", a);
					getServletContext().getRequestDispatcher("/departments.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Entered controller: In doPost");
		
			
			}

}