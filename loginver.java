import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class loginver extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","prithvi");

try{
	
	String x=req.getParameter("uname");
	String y=req.getParameter("pwd");
	Statement st=con.createStatement();
	String sql="select * from login where username='"+x+"' and password='"+y+"'";
	ResultSet rs=st.executeQuery(sql);
	if(rs.next())
	{
		String fullname=rs.getString("fname")+" " +rs.getString("lname");
		HttpSession hs=req.getSession();
		hs.setAttribute("name",fullname);
		//Cookie ck=new Cookie("fullname",fullname);
		//ck.setMaxAge(7200);		
		//res.addCookie(ck);
		RequestDispatcher rd= req.getRequestDispatcher("/home.jsp");
		rd.forward(req,res);
		
	}
	else
	{
		pw.print("<p><b><u><font size='6' color='red' >Username or password is wrong!</font></u></b></p>");
		RequestDispatcher rd=req.getRequestDispatcher("/login.html");
		rd.include(req,res);
	}

	}
catch(SQLException e){pw.print(e.toString());}
}catch(Exception e)
{pw.print(e.toString());}
}}