<%@page import="bean.ComputerScienceFaculty"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%System.out.println("In csfaculty.jsp before going to object"); %>
<%ComputerScienceFaculty faculty=(ComputerScienceFaculty)request.getAttribute("csfaculty"); %>
<%System.out.println("In csfaculty.jsp after object"); %>
<h3>Computer Science Faculty</h3>
<%for(int i=0;i<(faculty.getStore().size());i++)
	{
	System.out.println("In for loop of departments.jsp");%>
	<%System.out.println(faculty.getStore().get(i));%>
	<%=faculty.getStore().get(i)%><br/>
	<%}%>

</body>
</html>