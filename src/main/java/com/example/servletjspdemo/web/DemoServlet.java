package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//String param = request.getParameter("name");
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession();
		ServletContext ctx = request.getServletContext();
	
		if (ctx.getAttribute("counter") == null)
			ctx.setAttribute("counter", new Integer(0));
		
		Integer counter = (Integer) ctx.getAttribute("counter");
		ctx.setAttribute("counter", new Integer(counter + 1));;
		
		
		out.println("<h1>Liczba odwiedzin: " + (Integer) ctx.getAttribute("counter") + "</h1>");
	}

}
