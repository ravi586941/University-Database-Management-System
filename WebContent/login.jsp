
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
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
	<title>Admin Login</title>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
		<!--//webfonts-->
</head>
<body>
	
				 <!-----start-main---->
				<div class="login-form">
						<h1>Admin Login</h1>
						
				<form action="<%=request.getContextPath()%>/UniversityController" method="post" onsubmit="return validation()">
					<li>
						<input type="text" class="text" value="User Name" name="username" id="uname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Name';}" >
					</li>
					<li>
						<input type="password" value="Password" name="pass" id="pass" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
					</li>
					
					 <div class ="forgot">
						<h3><a href="index.jsp">HomePage</a></h3>
						<input type="submit" name="x" value="Login" > <a href="#" class=" icon arrow"></a>                                                                                                                                                                                                                                 </h4>
					</div>
				</form>
			</div>
			<!--//End-login-form-->
					<div class="ad728x90" style="text-align:center">
				<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
				<!-- w3layouts_demo_728x90 -->
				<ins class="adsbygoogle"
				     style="display:inline-block;width:728px;height:90px"
				     data-ad-client="ca-pub-9153409599391170"
				     data-ad-slot="8639520288"></ins>
				<script>
				(adsbygoogle = window.adsbygoogle || []).push({});
				</script>
		   </div>


		  <!-----start-copyright---->
   					<div class="copy-right">
						<p>Template by <a href="http://w3layouts.com">w3layouts</a></p> 
					</div>
				<!-----//end-copyright---->
		 		
</body>
</html>