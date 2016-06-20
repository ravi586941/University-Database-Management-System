<!-- This JSP is used SHOW REGISTERED COURSES -->

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
<title>Course Registration</title>
</head>
<body>

<%int s=(Integer)session.getAttribute("username");%>
<%
System.out.println(request.getAttribute("courses"));
ArrayList<CoursesBean> courses = (ArrayList<CoursesBean>) request.getAttribute("registercourses");
%>
<table align="center">

<tr>

<%

for(CoursesBean course : courses) {
%>

<td><font color="blue"><h2>
You have Succesfully registerd to <%=course.getCourseName()%></font>
</h2>
</td>
<%
}
%>

</tr>

</table>


<center><h2><font color="blue">Registered Courses</font></h2></center>

<table align="center" border="1">

<tr border="collapse"><th>StudentID</th><th>CourseId</th><th>CourseName</th><th>InstructorID</th>
<th>DepartmentName</th><th>Credits</th><th>OfferedYearSemester</th><th>BuildingNumber</th><th>BuildingCode</th>
</tr>



<%

for(CoursesBean course : courses) {
%>

    
    	<tr>
    	    <td><%=course.getUsername() %></td>
    		<td><%=course.getCourseID() %></td>
    		<td><%=course.getCourseName() %></td>
    		<td><%=course.getInstructorID()%></td>
    		<td><%=course.getDepartmentName()%></td>    		
    		<td><%=course.getCredits() %></td>
    		 <td><%=course.getOfferedYearSemester()%></td>
    		 <td><%=course.getBuildingNumber()%></td>
    		  <td><%=course.getBuildingCode()%></td>
    		 
    		 
    		
    	</tr>
    

<%
}	%>
</table>

<h3><center><a href="index.jsp">Homepage</a></center></h3> 
</body>
</html>