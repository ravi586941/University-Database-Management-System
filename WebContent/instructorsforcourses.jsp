<!-- This JSP is used to display INSTRUCTORS FOR SELECTED COURSE in COMPUTER SCIENCE DEPARTMENT -->

<%@page import="bean.CoursesBean"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
 	table {
    border-collapse: collapse;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instructors for Courses</title>
</head>
<body>

<%System.out.println("entered instructorsforcourses.jsp page");
		ArrayList<CoursesBean> courses = (ArrayList<CoursesBean>) request.getAttribute("instructorsforcourses");
		if(courses!=null){
		%>
		<center><h2><font color="blue">List Of Instructors for a selected Course</font></h2></center>
		<table align="center" border="1">
		<tr border="collapse"><th>CourseId</th><th>CourseName</th><th>InstructorID</th><th>FirstName</th><th>LastName</th><th>OfferedYearSemester</th></tr>
		<%
		for(CoursesBean course : courses) {
		
System.out.println("entered for loop in instructorsforcourses.jsp");%>
		    
		    	<tr>
		    		<td><%=course.getCourseID() %></td>
		    		<td><%=course.getCourseName() %></td>
		    		<td><%=course.getInstructorID() %></td>
		    		<td><%=course.getFirstName() %></td>
		    		<td><%=course.getLastName() %></td>
		    		<td><%=course.getOfferedYearSemester() %></td>
		    	</tr>
		    

		<%
		}	
		%>
		</table>
		<h3><center><a href="index.jsp">Homepage</a></center></h3> 
		<%}else{%>
			<center><h2><font color="red">Entered Course Doesn't exist. Please provide correct course details<br/>
			<a href="index.jsp">Homepage</a> </h2></center>
		<%}%>
		</body>
</html>