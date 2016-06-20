<%@page import="bean.DepartmentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ArrayList al;
String myString="";%>
<%System.out.println("In departments.jsp before going to object"); %>
<%DepartmentBean dept=(DepartmentBean)request.getAttribute("departments"); %>
<%System.out.println("In departments.jsp after object"); %>
<h3>Departments List</h3>
<%for(int i=0;i<(dept.getStore().size());i++)
	{
	System.out.println("In for loop of departments.jsp");%>
	<%System.out.println(dept.getStore().get(i));	
	}%>
	<ul>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(0)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(1)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(2)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(3)%></br></a></li>
	<li><a href="computerScience.jsp"><%=dept.getStore().get(4)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(5)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(6)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(7)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(8)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(9)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(10)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(11)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(12)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(13)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(14)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(15)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(16)%></br></a></li>
	<li><a href="http://www.cs.unm.edu/~mueen/Teaching/CS_464_564/"><%=dept.getStore().get(17)%></br></a></li>
	
	
</body>
</html>