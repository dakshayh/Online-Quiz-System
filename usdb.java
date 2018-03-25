import java.sql.*;
import javax.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class usdb extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
String fn=req.getParameter("fname");
String ln=req.getParameter("lname");
String un=req.getParameter("uname");
String ps=req.getParameter("pwd");
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

try
	{
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","akshay");
			Statement stmt=con.createStatement();
			stmt.execute("insert into login values('"+fn+"','"+ln+"','"+un+"','"+ps+"',0,0)");
			}catch(SQLException e){pw.print(e.toString() + ":user may already exist");}
	}
	
catch(Exception e){pw.print("<h1>class not found</h1>");}
		String z= fn+" "+ln;
		HttpSession hs=req.getSession();
		hs.setAttribute("name",z);
		RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
		rd.forward(req,res);
}

}
