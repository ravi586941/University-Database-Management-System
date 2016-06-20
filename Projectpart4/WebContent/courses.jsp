<!-- This JSP is used to display COURSES of COMPUTER SCIENCE DEPARTMENT -->

<%@page import="bean.CoursesBean"%>
<%@page import="bean.AdminLoginBean"%>
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
<title>Insert title here</title>
</head>
<body>

<center><h2><font color="blue">COMPUTER SCIENCE Department Courses</font></h2></center>
<%String s=(String)session.getAttribute("user");%>
<%
System.out.println(request.getAttribute("courses"));
ArrayList<CoursesBean> courses = (ArrayList<CoursesBean>) request.getAttribute("courses");
%>
<table align="center" border="1">
<tr border="collapse"><th>CourseId</th><th>CourseName</th><th>Credits</th><th>InstructorID</th></tr>
<%
for(CoursesBean course : courses) {
%>

    
    	<tr>
    		<td><%=course.getCourseID() %></td>
    		<td><%=course.getCourseName() %></td>
    		<td><%=course.getCredits() %></td>
    		<td><%=course.getInstructorID() %></td>
    	</tr>
    

<%
}	%>
</table>
<%if(s!=null){
	if(s.equals("ravimahi")){
		System.out.println("In if loop of courses.jsp");%>
		<center><a href="addcourse.jsp">Add Course</a></center>
		<center><a href="logout.jsp">logout</a></center>
		<%

	}
	}
	else
		session.invalidate(); %>
<h3><center><a href="index.jsp">Homepage</a></center></h3> 
</body>
</html>