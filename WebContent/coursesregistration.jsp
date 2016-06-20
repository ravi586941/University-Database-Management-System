<!-- This JSP is used to REGISTER FOR COURSES -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses Registration</title>
<script type="text/javascript"> 
function validation()
{            
	
	if(document.getElementById("coursename").value=="")
	{
		alert("Please Enter Course Name");
			return false;
	}
	else if(isNaN(document.getElementById("sid").value))
	{
		alert("Please enter a valid Student Id");
			return false;
	}
	else if(document.getElementById("sid").value.length!=5)
	{
		alert("Student Id should have 5 digits");
			return false;
	}

}
</script>
</head>
<body>


<%int s=(Integer)session.getAttribute("username");
System.out.println("Student id in registercourses.jsp is"+s);%>
<center><h3><font color="blue">Welcome to Courses registration page</font></h3></center>

<form name="form6" action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">

<table align="center">
<tr>
<td><input type="hidden" value="<%=s%>" name="studentid"></td>

</tr>

<tr>

<td><input type="text" placeholder="coursename" name="coursename" id="coursename"></td>

</tr>
<tr>
<td><input value="Fall-2015" name="oys" readonly></td>
</tr>
<tr>
<td></td>
</tr>
<tr>
<td></td>
</tr>
<tr>

<td><center><input type="submit" name="register"  value="Register"></center></td>
</tr>

</table>

</form>
</body>
</html>