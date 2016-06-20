package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import bean.ComputerScienceFaculty;
import bean.DepartmentBean;

public class DepartmentDAO {

	Connection conn = null;

	public static DepartmentBean departmentslist(DepartmentBean db)
			throws ClassNotFoundException, NamingException {

		try {
			/*
			 * Connection myConn=DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/databaseproject","root","123456");
			 * Statement mystmt=myConn.createStatement();
			 */
			System.out.println("Entered try block in DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			Statement mystmt = myConn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from department order by DepartmentName asc");
			System.out.println("Entering while loop :IN DAO");
			//db.store=rs.getString("DepartmentName");
			ArrayList a = new ArrayList();
			while (rs.next()) {
				a.add(rs.getString("DepartmentName"));
				db.DepartmentName=rs.getString("DepartmentName");
				//System.out.println(rs.getString("DepartmentName"));
				db.setFlag(1);
				db.store=a;
				System.out.println(db.store);
					}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return db;

	}

	public static ComputerScienceFaculty csfaculty(ComputerScienceFaculty csf) throws ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		try {
			/*
			 * Connection myConn=DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/databaseproject","root","123456");
			 * Statement mystmt=myConn.createStatement();
			 */
			System.out.println("Entered try block in csf DAO");
			Connection myConn = DBConnection.createDatabaseConnection();
			Statement mystmt = myConn.createStatement();
			ResultSet rs = mystmt.executeQuery("select * from instructors where DepartmentName='COMPUTER SCIENCE'");
			System.out.println("Entering while loop csf:IN DAO");
			ArrayList a = new ArrayList();
			while (rs.next()) {
				a.add(rs.getString("FirstName")+" "+rs.getString("EmailID")+" "+rs.getString("Qualification")+" "+rs.getString("Designation")+" "+rs.getString("PhoneNumber"));
				/*
				a.add(rs.getString("FirstName"));
				a.add(rs.getString("LastName"));
				a.add(rs.getString("Gender"));
				a.add(rs.getString("DATEOFBIRTH"));
				a.add(rs.getString("DepartmentName"));
				a.add(rs.getString("JoiningDate"));
				a.add(rs.getString("EmailID"));
				a.add(rs.getString("Address"));
				a.add(rs.getString("Qualification"));
				*/
				System.out.println(rs.getString("DepartmentName"));
				csf.setFlag(1);
				csf.store=a;
				System.out.println(csf.store);
					}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return csf;
	}

}