package org.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Div
 */
@WebServlet("/div")
public class Div extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String n=request.getParameter("num");
		String m=request.getParameter("num1");
		
		if(Integer.parseInt(m)>0)
		{
			float res=Integer.parseInt(n)/Integer.parseInt(m);
			out.println("Division is "+res);
			out.println("<a href=\"Main.html\"><input type=\"button\" value=\"Home\"></a>");
		}
		else
		{
			out.println("Division by zero is not possible: ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
