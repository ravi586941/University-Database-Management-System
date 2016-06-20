<!-- This JSP is used to SHOW OPTIONS OF COMPUTER SCIENCE DEPARTMENT -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h3><font color="blue">Department Of COMPUTER SCIENCE</font></h3>
<a href="<%=request.getContextPath()%>/UniversityController?action=computerScienceFaculty">FACULTY</a><br/>
<a href="<%=request.getContextPath()%>/UniversityController?action=computerScienceCourses">COURSES</a><br/>
<a href="searchinstructorsforcourses.jsp">Click here</a>to know Instructors for the each course</center>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<h3><center><a href="index.jsp">Homepage</a></center></h3>
</body>
</html>