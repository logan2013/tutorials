package com.imtzp.servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 5685565570206382603L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<p>Hello World!</p>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
