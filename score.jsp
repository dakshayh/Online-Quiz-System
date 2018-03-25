<html>
<head>
<style>
html { 
background: url(scored.jpg) no-repeat center center fixed; 
-webkit-background-size: cover; 
-moz-background-size: cover; 
-o-background-size: cover; 
background-size: cover; 
}
#cent {
	
		background:#ffffff;
    
		background-color: rgba(255, 255, 255, 0.6);
}
</style>
</head>
<body>

<%@ page import="java.sql.*,javax.sql.*,java.io.*,javax.servlet.*,javax.servlet.http.*" %>
<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","akshay");
		Statement stmt=con.createStatement();
		stmt.executeQuery("set @rowno=0");
		try
		{
		ResultSet rs= stmt.executeQuery("select *,@rowno:=@rowno+1 as rank from login order by rating DESC");
%>


			<div id="cent" align="center"><h1><B>CURRENT RANKINGS</B></h1></div> 	
			<table  id="cent" border="2" cellpadding="20px" align="center" width="80%" >
			<tr><th><font size="6"><u>Rank</u></font></th>
			<th><font size="6"><u>Name</u></font></th>
			<th><font size="6"><u>Score</u></font></th></tr>
			<%
			while(rs.next())
			{ 
		    %>
				 <tr><td align="center"><font size="5"><b><%=rs.getInt("rank")%></b></font></td>	
				 <td align="center" ><font size="5"><b><i><%=rs.getString("fname") + " "+rs.getString("lname")%></i></b></font></td>
				 <td align="center"><font size="5"><b><%=rs.getString("rating")%></b></font></td></tr>
				
				
			<%
			}
		}catch(SQLException e ){out.println(e.toString());}		
				
%></div>

 </body>
</html>
