<!-- This JSP is used to SIGN UP & SHOW MESSAGE AFTER SIGNING UP for STUDENTS -->

<%@page import="bean.AdmissionsBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
 </head>
<body>
<%AdmissionsBean a=(AdmissionsBean)request.getAttribute("newstudent");
if(a!=null){%>
<center><h2><font color="blue">You have Successfully Applied for Admission</font></h2></center>
<center>Your Credentials are as below. Please use these to check your admission status</center></br>
<center>User ID is: <%=a.getUserName() %></center>
<center>Password is: <%=a.getPassword() %></center>
<%
}
else{
	 %>
<h2 align="center">Signup Form</h2>
<form action="<%=request.getContextPath()%>/UniversityController" method="post">
<table align="center">
<tr><td><input type="text" name="firstname" placeholder="First Name"></td></tr>
<tr><td><input type="text" name="lastname" placeholder="Last Name"></td></tr>
<tr><td><input type="text" name="gender" placeholder="Gender"></td></tr>
<tr><td><input type="text" name="dob" id="datepicker" placeholder="Date of Birth"></td></tr>
<tr><td><input type="text" name="departmentname" placeholder="Department Name"></td></tr>
<tr><td><input type="text" name="address" placeholder="Address"></td></tr>
<tr><td><input type="text" name="emailid" placeholder="EmailID"></td></tr>
<tr><td><input type="text" name="grescore" placeholder="GRE SCORE"></td></tr>
<tr><td><input type="text" name="preferredyearsem" placeholder="Preferred Year Sem"></td></tr>
</table>
&nbsp;
<center><input type="submit" name="signupform" value="Submit"></center>
</form><%}%>
<h3><center><a href="index.jsp">Homepage</a></center></h3> 
</body>
</html>