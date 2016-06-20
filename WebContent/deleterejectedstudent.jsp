<!-- This JSP is used to display REJECTED STUDENTS IN UNIVERSITY -->

<%@page import="bean.AdmissionsBean"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Rejected Students</title>
</head>
<body>
<%String s=(String)session.getAttribute("user");%>
<%
ArrayList<AdmissionsBean> rejectedadmissions = (ArrayList<AdmissionsBean>) request.getAttribute("rejectedapplications");
if(rejectedadmissions!=null){
%>
<center><h2><font color="blue">Rejected Applications</font></h2><br/><br/>
<form name="form5" action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
<table align="center">
<tr><th>UserName</th></tr>
<%
for(AdmissionsBean admission : rejectedadmissions) {
%>

    <tr><td>

<input type="checkbox" value="<%=admission.getUserName()%>" name="rejectedapplications"/><%=admission.getUserName()%></td><br/>
	
</tr>
    	
    

<%
}	%>
</table><br/>
<center><input type="submit" value="Delete" name="deleteapplication" onclick="if(!this.form.rejectedapplications.checked){alert('Please select a UserName');return false}"/></center>&nbsp;&nbsp;&nbsp;
</form><br/><%}
else{%>

	<center><h3><font color="blue">Selected students were Deleted successfully.</font><br/>
	<a href="adminsuccess.jsp">Admin Home Page</a><br/>
        <center><h3><a href="logout.jsp">Logout</a></h3></center>
		
<%} %>
<center><h3><a href="index.jsp">Home page</a><br/><br/>
<a href="logout.jsp">Logout</a></h3></center></html>