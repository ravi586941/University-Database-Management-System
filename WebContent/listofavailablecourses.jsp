<!-- This JSP is used to GET LIST OF AVAILABKE COURSES FOR THE GIVEN YEAR SEMESTER -->

<%@page import="bean.CoursesBean"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Courses</title>
</head>
<body>
<table align="center">
<tr>
<td><center><h1><font color="blue">courselist</font></p></h1></center></td>
</tr>
</table>
<%

ArrayList<CoursesBean> courses = (ArrayList<CoursesBean>) request.getAttribute("listofavailablecourses");

%>
<table align="center" border="1">
<tr border="collapse"><th>CourseId</th><th>CourseName</th><th>OfferedYearSemester</th>
<th>Credits</th>
<th>InstructorID</th>
<th>DepartmentName</th>
<th>BuildingCode</th>
<th>BuildingNumber</th>
</tr>
<%
for(CoursesBean course : courses) {
%>

    
    	<tr>
   			<td><%=course.getCourseID() %></td>
    		<td><%=course.getCourseName() %></td>
    		<td><%=course.getOfferedYearSemester() %>
    		<td><%=course.getCredits() %></td>
    		<td><%=course.getInstructorID() %></td>
    		<td><%=course.getDepartmentName() %></td>
    		<td><%= course.getBuildingCode() %></td>
    		<td><%=course.getBuildingNumber() %></td>
    	</tr>
    

<%
}	%>
</table>
</body>
</html>