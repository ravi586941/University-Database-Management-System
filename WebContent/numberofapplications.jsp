<!-- This JSP is used to display NUMBER OF APPLICATIONS for a given Semester -->

<%@page import="bean.AdmissionsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript"> 
function validation()
{      
	if(document.getElementById("oys").value=="")
	{
		alert("Please enter Offered Year Semester");
			return false;
	}
		
}
</script>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>No.Of.Applications</title>
</head>
<body>
<%System.out.println("started numberofapplications.jsp page");%>
<%AdmissionsBean ab=(AdmissionsBean)request.getAttribute("numberapplications");
//int count=ab.getCount();
%>
<%
// System.out.println("entered numberofapplications.jsp page "+count); 
if(ab==null){%>
<h2 align="center">Check No.Of Applications Here</h2>
<form action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
<table align="center">
<tr><td><input type="text" name="offeredYearSemester" placeholder="YearSemester" id="oys"></td></tr>
</table>
&nbsp;
<center><input type="submit" name="numberOfApplications" value="Submit"></center> 
</form>
<%} else{
	if(ab.getFlag()==1){
	System.out.println("entered numberofapplications.jsp page if loop"); %>
	<h2 align="center"><font color="blue">No. Of Applications for <%=ab.getPreferredYearSem()%> are <%=ab.getCount() %></font></h2>
<%}
	else{
		System.out.println("entered YearSem doesn't exist"); %>
		<h2 align="center"><font color="blue">Entered YearSemester doesn't exist</font></h2>
	<%}
		} %>
<center><h3><a href="index.jsp">Homepage</a><br/><br/>
<a href="logout.jsp">Logout</a></h3></center> 
</body>
</html>