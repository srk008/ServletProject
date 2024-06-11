package org.ty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String una=request.getParameter("uname");
		String pa=request.getParameter("pass");
		
		try {
			com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapplication","root","9975920068@9307354589");
			if(conn!=null)
			{
				//out.println("Database Connecteed......");
				PreparedStatement stmt=conn.prepareStatement("select *from calculator where username=? and password=?");
				stmt.setString(1, una);
				stmt.setString(2, pa);
				
				ResultSet rs=stmt.executeQuery();
				
				if(rs.next())
				{
					out.println("Well-come to Calculator...");
					RequestDispatcher dd=request.getRequestDispatcher("Main.html");
					dd.forward(request, response);
				}
				else
				{
					out.println("<h1>Register Here...</h1>");
					RequestDispatcher r=request.getRequestDispatcher("register.html");
					r.include(request, response);
					
				}
				 conn.close();
			}
			
		} catch (Exception e) {
			
			out.println(e.getMessage());
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
