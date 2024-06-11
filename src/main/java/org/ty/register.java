package org.ty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class register extends HttpServlet {    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String na=request.getParameter("name");
		String em=request.getParameter("email");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
	try {
		//com.mysql.cj.jdbc.Driver
		//Class.forName("com.mysql.cj.jdbc.Driver");
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapplication","root","9975920068@9307354589");
		if(conn!=null)
		{
			
			PreparedStatement stmt=conn.prepareStatement("insert into calculator values(0,?,?,?,?)");
			stmt.setString(1, na);
			stmt.setString(2, uname);
			stmt.setString(3, pass);
			stmt.setString(4, em);
			
			int value=stmt.executeUpdate();
			if(value>0)
			{
				out.println("Sucessfully registration done...");
				RequestDispatcher dq=request.getRequestDispatcher("login.html");
				dq.forward(request, response);
			}
			else
			{
				out.println("Registration Not done");
			}
			 conn.close();
		}
		else
		{
			out.println("Database Not connected....");
		}
		
		
		
	} catch (  SQLException e) {
		
		out.println("Error is Form Sql Exception:"+e.getMessage());
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
