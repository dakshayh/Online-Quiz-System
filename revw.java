import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class revw extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","akshay");

try{
	
	String x=req.getParameter("uname");
	String y=req.getParameter("comments");
	Statement st=con.createStatement();
	String sql="select *from login where username='"+x+"' ";
	ResultSet rs=st.executeQuery(sql);
	if(rs.next())
	{	
		
		Statement stmt=con.createStatement();
		stmt.execute("insert into feedback values('"+x+"','"+y+"')");
		pw.print("<script type='text/javascript'>");  
		pw.print("alert('Your response was recorded');");  
		pw.print("</script>");
		RequestDispatcher rd=req.getRequestDispatcher("/pp.html");
		rd.include(req,res);

		
	}
	else
	{
		pw.print("<p><b><u><font size='6' color='red' >User does not exist!</font></u></b></p>");
		RequestDispatcher rd=req.getRequestDispatcher("/review.html");
		rd.include(req,res);
	}

	}
catch(SQLException e){pw.print(e.toString());}
}catch(Exception e)
{pw.print(e.toString());}
}}
