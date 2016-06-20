<!-- This JSP is used to display FACULTY of COMPUTER SCIENCE DEPARTMENT -->

<%@page import="bean.InstructorsBean"%>
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
<title>Computer Science Faculty</title>
</head>
<body>

<%System.out.println("In csfaculty.jsp before going to object"); %>
<%InstructorsBean faculty=(InstructorsBean)request.getAttribute("csfaculty"); %>
<%System.out.println("In csfaculty.jsp after object"); %>
<h2 align="center"><font color="blue">Computer Science Faculty</font></h3>

<table border="1" style="width:100%">

 <tr>
    <th align="left">Name</th>
    <th align="left">EmailID</th>
    <th align="left">Designation</th>
    <th align="left">Qualification</th>
    <th align="left">PhoneNumber</th>
  </tr>
<%for(int i=0;i<(faculty.getNameArray().size());i++)
	{
	System.out.println("In for loop of faculty.jsp");%>
	
	<tr>
	
	<td><%=faculty.getNameArray().get(i)%></td>
	<td><%=faculty.getEmailIDArray().get(i)%></td>
	<td><%=faculty.getDesignationArray().get(i)%></td>
	<td><%=faculty.getQualificationArray().get(i)%></td>
	
	<td><%=faculty.getPhoneNumberArray().get(i)%></td>
	</tr>
	<%} %>	

</table>
</body>
</html>