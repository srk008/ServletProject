package org.ty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sub")
public class Sub extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String num3=request.getParameter("fri");
		String num4=request.getParameter("sec");
		int re=Integer.parseInt(num3)-Integer.parseInt(num4);
		out.println("Substraction is "+re);
//		out.println("Well-come to Substraction world:");
		out.println("<a href=\"Main.html\"><input type=\"button\" value=\"Home\"></a>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
