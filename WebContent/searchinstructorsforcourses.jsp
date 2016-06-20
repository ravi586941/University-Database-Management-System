<!-- This JSP is used to SEARCH INSTRUCTORS FOR A GIVEN COURSE -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Instructors for Courses</title>
<script type="text/javascript"> 
function validation()
{            
	
	if(document.getElementById("cn").value=="")
	{
		alert("Please Enter Course Name");
			return false;
	}
	
}
</script>
</head>
<body>
<h2><center><font color="blue">Search a course in COMPUTER SCIENCE Department</font></center></h2>
<form name="form1" action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
<table align="center">
    <tr><td>CourseName:</td><td><input type="text" name="coursename" id="cn"></tr>
	        </table>
	        &nbsp;
	        &nbsp;
<center><input type="submit" name="searchcourse" value="Submit"></center>
</form>
</body>
</html>