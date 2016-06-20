<!-- This JSP is used to ADMIN PRIVILAGES after successful login -->

<%@page import="bean.AdminLoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin</title>
</head>
<body>
<%String s=(String)session.getAttribute("user");
System.out.println("adminsucess.jsp"+s);
AdminLoginBean alb=(AdminLoginBean)request.getAttribute("credentials"); %>
<%
if(alb!=null){
	String uname=(String)alb.getUsername(); 

System.out.println("Admin success jsp"+uname);
session.setAttribute("user", uname);%>
<center><h2><font color="blue">Welcome Admin</font></h2>
<a href="addcourse.jsp">Add Course</a><br/><br/>
<a href="searchstudent.jsp">Update Student</a><br/><br/>
<a href="<%=request.getContextPath()%>/UniversityController?action=makeAdmissionDecisions">Make Admission Decisions</a><br/><br/>
<a href="numberofapplications.jsp">Number of Applications</a><br/><br/>
<a href="<%=request.getContextPath()%>/UniversityController?action=getrejectedapplications">Delete Rejected Students</a><br/><br/>
<h3><a href="index.jsp">Home page</a><br/><br/>
<a href="logout.jsp">Logout</a></h3></center>
<%}
else{%>
<center><h2><font color="blue">Welcome Admin</font></h2>
<a href="addcourse.jsp">Add Course</a><br/><br/>
<a href="searchstudent.jsp">Update Student</a><br/><br/>
<a href="<%=request.getContextPath()%>/UniversityController?action=makeAdmissionDecisions">Make Admission Decisions</a><br/><br/>
<a href="numberofapplications.jsp">Number of Applications</a><br/><br/>
<a href="<%=request.getContextPath()%>/UniversityController?action=getrejectedapplications">Delete Rejected Students</a><br/><br/>
<h3><a href="index.jsp">Home page</a><br/><br/>
<a href="logout.jsp">Logout</a></h3></center>
<%} %>
</body>
</html>