<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">

a:hover{

	color: red;
}


h1	
{
    text-align: center;

}

nav
{

	overflow: hidden;
	transition:all;
}
.text{

	clear: both;
}
.box{

  background: #2db34a;
  float: left;
  margin: 1.858736059%;
  padding: 10px 0px;
  text-align: center;
  width: 15.615861214%;
}
.box-set,.box{
     text-align: center;
	border-radius: 10 px

}

.body {
  background-color: blue;
  font: 600 14px/24px "Open Sans", "HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", Sans-Serif;
}
li:last-child
{

	border-bottom: 0;
}

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="white">	
	<h1>PDA Application for University Of New Mexico</h1>
  <div class="box-set">
  <a href="http://www.unm.edu/welcome/index.html"><figure class="box">About University </figure></a>
  <figure class="box">Students</figure>
  <figure class="box">Academics</figure>
  <%System.out.println("I'm in JSP"); %>>
  	<a href="<%=request.getContextPath()%>/UniversityController?action=departments"><figure class="box">Departments</figure></a>
  	 <a href="file:///C:/Users/maheshwarreddy/Desktop/admissions.html"><figure class="box">Admissions</figure></a>
  </div>
	</body>
</html>