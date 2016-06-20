package controller;

//Import required java libraries
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//Extend HttpServlet class
@SuppressWarnings("serial")
public class HelloWorld extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Hello World";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");
		try(Connection conn = createDatabaseConnection();) {
			// Actual logic goes here.
			PrintWriter out = response.getWriter();
			out.println("<h1>" + message + "</h1>");
			System.out.println("Connection Status: " + !conn.isClosed());
			out.println("Connection Status: " + !conn.isClosed());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void destroy() {
		// do nothing.
	}

	private static Connection createDatabaseConnection()
			throws ClassNotFoundException, SQLException, NamingException {
		Context initContext = null;
		Context envContext = null;
		Connection conn = null;
		DataSource ds = null;
		initContext = new InitialContext();
		envContext = (Context) initContext.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/MYSQLDB");
		conn = ds.getConnection();

		return conn;
	}
}