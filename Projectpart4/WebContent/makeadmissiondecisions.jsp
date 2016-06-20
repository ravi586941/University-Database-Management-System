<!-- This JSP is used by ADMIN TO MAKE ADMISSION DECISIONS -->

<%@page import="bean.AdmissionsBean"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String s=(String)session.getAttribute("user");%>
<%
System.out.println(request.getAttribute("courses"));
ArrayList<AdmissionsBean> admissions = (ArrayList<AdmissionsBean>) request.getAttribute("admissionapplications");
%>
<center><h2><font color="blue">Available Applications</font></h2><br/><br/>
<form name="form5" action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
<table align="center">
<tr><th>UserName</th></tr>
<%
for(AdmissionsBean admission : admissions) {
%>

    <tr><td>

<input type="checkbox" value="<%=admission.getUserName()%>" name="applications"/><%=admission.getUserName()%></td><br/>
	
</tr>
    	
    

<%
}	%>
</table><br/>
<center><input type="submit" value="Admit" name="giveadmission"/>&nbsp;&nbsp;&nbsp;
<input type="submit" value="Reject" name="rejectadmission"/></center>
</form><br/>
<center><h3><a href="logout.jsp">Logout</a></h3></center>
</body>
</html>