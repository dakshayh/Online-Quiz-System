import java.sql.*;
import javax.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class testing extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	

try
	{
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","akshay");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from userqstn ");
			if(rs.next())
			{
				String qst=rs.getString("question");
				int x=rs.getInt("qid");
				
				pw.print(x+")"+qst+"<br>");
				pw.print("<form action='http://localhost:8080/newproj/valida' method='post'>");
				pw.print("<input type='text' name='userans' placeholder='enter answer'>");
				pw.print("<imput type='hidden' name='qno' value=x >");
				pw.print("<input type='submit' value='next'>" );
				
				
			}	
			}catch(SQLException se){pw.print(se.toString());}
	
	}catch(Exception e){pw.print(e.toString());}
		
}

}
