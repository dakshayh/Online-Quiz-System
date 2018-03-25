<html>
<head>
<style>
* {
	margin:0;
	padding:0;
}
html { 
background: url(homimg.jpg) no-repeat center center fixed; 
-webkit-background-size: cover; 
-moz-background-size: cover; 
-o-background-size: cover; 
background-size: cover; 
}

#log1 {
	position:absolute;
	left:70px;
	top:50px;
	border-radius: 25px;
     	background:#ffffff;
    	padding: 20px;
    	width:1200px;
    	height:200px;
	background-color: rgba(255, 255, 255, 0.3);
}

#log2 {
	position:absolute;
	left:70px;
	top:350px;
	border-radius: 25px;
     	background:#ffffff;
    	padding: 20px;
    	width:1200px;
    	height:200px;
	background-color: rgba(255, 255, 255, 0.3);
}
#word
{
	position:absolute;
	top:40px;
}

#tb{
float:right;
padding:5px;
}

</style> 
</head>
<body>
<div id="log1">
<div id="word">
	<% HttpSession hs=request.getSession(false);%>
 <h1><b>WELCOME,<%=hs.getAttribute("name")%> </b></h1>
</div>
<div id="tb">
<form action="http://localhost:8080/newproj/qsubmit" method="post">
<p><font size="5"><b><u>Submit a Question</u></b></font></p><br><br>
<p>Question:<input type="text" name="qstn" size="50" placeholder="Enter a question" ></p> <br>
<p>Answer:<input type="text" name="ans" size="20" placeholder="Answer Must be short"></p><br>
<input type="hidden" name="user" value=<%= request.getParameter("uname")%> >
<input type="submit" style="background-color:#ccffff;" value="SUBMIT"><BR><br>
</form>
</div>
</div>
<div id="log2">
<div id="word">
	
 <h1><b>TAKE THE TEST? </b></h1>
</div>
<div id="tb">
<form action="http://localhost:8080/newproj/testing" method="post">
<p><font size="5"><b><u>Click Here To Launch Test</u></b></font></p><br><br>
<input type="hidden" name="user" value=<%= request.getParameter("uname")%> >
<input type="submit" style="background-color:#32CE3D;height:80px;width:100px" value="LAUNCH"><BR><br>
</form>
</div>
</div>

</body>
</html>