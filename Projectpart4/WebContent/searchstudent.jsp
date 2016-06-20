<!-- This JSP is used to SEARCH A STUDENT IN UNIVERSITY -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"> 
function validation()
{            
	
	if(document.getElementById("sid").value=="")
	{
		alert("Please Enter Student Id");
			return false;
	}
	else if(isNaN(document.getElementById("sid").value))
	{
		alert("Please enter a valid Student Id");
			return false;
	}
	else if(document.getElementById("sid").value.length!=5)
	{
		alert("Connection Number should have 5 digits");
			return false;
	}

}
</script>
</head>
<body>
<h2><center><font color="blue">Search a Student in Any Department</font></center></h2>
<form name="form1" action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
<table align="center">
    <tr><td>StudentId:</td><td><input type="text" name="studentid" id="sid"></tr>
	        </table>
	        &nbsp;
	        &nbsp;
<center><input type="submit" name="searchstudent" value="Submit"></center>
</form>
<h3><center><a href="logout.jsp">Logout</a></center></h3> 
</body>
</html>