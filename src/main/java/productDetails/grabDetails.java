package productDetails;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("grabDetails")
public class grabDetails 
{
	 public void dopost(HttpServletRequest request, HttpServletResponse response)
	    {
			try
			  {
				
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection( "jdbc:mysql:// localhost:3306/grabDetails",
                            "root", "12345" );
				Statement stmt = con.createStatement();
			    PreparedStatement st = con
		                 .prepareStatement("insert the Product IB : (?)");
		  
		          
		        st.setInt(1, Integer.valueOf(request.getParameter("pid")));
				ResultSet rs = stmt.executeQuery("select * from grabDetails where pid=123");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
		
				if(rs.next())				
				{
					out.println("<li>"+rs.getString("pid")+" "+rs.getString("pname")+" "+(Integer.valueOf(rs.getString("prate")))+"</li>");
				}
	
			  }
			 catch (Exception e) 
			   {
		            e.printStackTrace();
		        }
				
			}

}
