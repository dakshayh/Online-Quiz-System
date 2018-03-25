import java.sql.*;
import javax.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class valida extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String ua=req.getParameter("userans");
	int qno=Integer.parseInt(req.getParameter("qno"));
try
	{
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","prithvi");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from userqstn");
			if(rs.next())
			{
				pw.print(qno);
				pw.print(ua);
			
			}
			}catch(SQLException e){pw.print(e.toString() + ":user may already exist");}
	}
	
catch(Exception e){pw.print("<h1>class not found</h1>");}
		
}

}