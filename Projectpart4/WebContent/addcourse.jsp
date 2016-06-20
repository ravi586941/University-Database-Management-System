<!-- This JSP is used to ADD COURSE in any department -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript"> 
function validation()
{            
	//var el=document.getElementById('cn');
	var e2=document.getElementById('dn');
	var e3=document.getElementById('bc');
	var re=/^[A-z]+$/; 
	
	if(document.getElementById("cid").value=="")
	{
		alert("Please enter the CourseID");
			return false;
	}
	else if(isNaN(document.getElementById("cid").value))
	{
		alert("Please enter a valid CourseID");
			return false;
	}
	else if(document.getElementById("cn").value=="")
	{
		alert("Please enter the CourseName");
			return false;
	}
	else if(document.getElementById("iid").value=="")
	{
		alert("Please enter the InstructorID");
			return false;
	}
	else if(document.getElementById("dn").value=="")
	{
		alert("Please enter the Department Name");
			return false;
	}
	else if(document.getElementById("cr").value=="")
	{
		alert("Please enter the Credits");
			return false;
	}
	else if(isNaN(document.getElementById("cr").value))
	{
		alert("Please enter valid Credits");
			return false;
	}
	else if(document.getElementById("ofy").value=="")
	{
		alert("Please enter Offered Year Sem");
			return false;
	}
	else if(document.getElementById("bn").value=="")
	{
		alert("Please enter the Building Number");
			return false;
	}
	else if(isNaN(document.getElementById("bn").value))
	{
		alert("Please enter a valid Building Number");
			return false;
	}
	else if(document.getElementById("bc").value=="")
	{
		alert("Please enter the Building Name");
			return false;
	}
	else if(!re.test(e3.value)) 
	{ 
		alert("Building Code should have only characters"); 
	    return false;	
	}
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h2><font color="blue">Add Course to Any Department</font></h2></center>
<!-- This code is taking admin Username from the session which we set in adminsuccess.jsp -->
<%String s=(String)session.getAttribute("user");
System.out.println("addcourse.jsp"+s);%>
<form name="form1" action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
<table align="center">
    <tr><td>CourseID:</td><td><input type="text" name="courseid" id="cid"></tr>
	<tr><td>CourseName:</td><td><input type="text" name="coursename" id="cn"></tr>
	<tr><td>InstructorID:</td><td><input type="text" name="instructorid" id="iid"></tr>
	<tr><td>Instructor FirstName:</td><td><input type="text" name="firstname" id="fn"></tr>
	<tr><td>Instructor LastName:</td><td><input type="text" name="lastname" id="ln"></tr>
	<tr><td>DepartmentName:</td><td><input type="text" name="departmentname" id="dn"></tr>
	<tr><td>Credits:</td><td><input type="text" name="credits" id="cr"></tr>
    <tr><td>OfferedYearSemester:</td><td><input type="text" name="offeredyearsemester" id="ofy"></tr>
    <tr><td>BuildingNumber:</td><td><input type="text" name="buildingnumber" id="bn"></tr>
    <tr><td>BuildingCode:</td><td><input type="text" name="buildingcode" id="bc"></tr>
        </table>
        &nbsp;
        <center><input type="submit" name="add" value="Submit"></center>
        </form>
        <center><h3><a href="logout.jsp">Logout</a></h3></center>
</body>
</html>