package com.advjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	        response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        String name = request.getParameter("uname");
	        String password = request.getParameter("upass");
	        if(name.equals("kavya") && (password.equals("sree")))
	        {
	           pw.println("Valid");
	           //response.sendRedirect("https://www.youtube.com/");
	        	
	        }
	        else
	        {
	            pw.println("<h1 style=color:red>Invalid user</h1>");
	        	//response.sendError(808,"failed");
	        }
	 

	}
}

	