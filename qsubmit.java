import java.sql.*;
import javax.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class qsubmit extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
String x=req.getParameter("user");
String y=req.getParameter("qstn");
String a=req.getParameter("ans");
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

try
{
	Class.forName("com.mysql.jdbc.Driver");
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","akshay");
		Statement stmt=con.createStatement();
		stmt.execute("insert into userqstn(username,question,answer) values('"+x+"','"+y+"','"+a+"')");
		}catch(SQLException e){pw.print(e.toString());}
}
catch(Exception e){pw.print("<h1>class not found</h1>");}
pw.print("<script type='text/javascript'>");  
		pw.print("alert('Your question was submitted');");  
		pw.print("</script>");
		RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
		rd.include(req,res);
}
}
