package org.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mul")
public class Mul extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String n=request.getParameter("name");
		String m=request.getParameter("pass");
		
		if(n.equals("admin") && (m.equals("admin")))
		{
			
			RequestDispatcher ds=request.getRequestDispatcher("new.html");
			ds.forward(request, response);
		}
		else
		{
			RequestDispatcher dd=request.getRequestDispatcher("NewFile.html");
			dd.include(request, response);
			out.println("<h1>Invalid Password And Username...</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
