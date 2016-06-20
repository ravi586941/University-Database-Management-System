<!-- This JSP is used for ADMIN LOGIN -->

<%@page import="bean.AdminLoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript"> 
function validation()
{            
	var el=document.getElementById('uname');
	var re=/^[A-z]+$/; 
	
	if(document.getElementById("uname").value=="")
	{
		alert("Please enter Username");
			return false;
	}
	else if(!re.test(el.value)) 
	{ 
		alert("Username should have only characters"); 
	    return false;	
	}
	else if(document.getElementById("pass").value=="")
	{
		alert("Please enter Password");
			return false;
	}
	
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="layout/styles/framework.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>
<h2><center><font color="blue">Admin Login</font></center></h2>
<form action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
<table align="center">
    <tr><td>Username:</td><td><input type="text" name="username" id="uname"></tr>
	<tr><td>Password:</td><td><input type="password" name="pass" id="pass"></tr>
	        </table>
        &nbsp;
        <center><input type="submit" name="x" value="Login"></center>
        </form><br/>
       <h3><center><a href="index.jsp">Homepage</a></center></h3> 
</body>
</html>