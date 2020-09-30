package com.apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.model.Student1;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
	        Student1 stud= new Student1();
	        stud.setSname(request.getParameter("sname"));
	        stud.setSpass(request.getParameter("spass"));
	        stud.setMobileno(request.getParameter("mobileno"));
	        stud.setCname(request.getParameter("Cname"));
	        StudentDao studDao =new StudentDao();
	        if(studDao.addStudent1(stud)) {
	        	pw.println("<h1>Registration Successfull</h1>");
	        }else {
	        	pw.println("<h1>TryAgain</h1>");
	        }
		
	}

		
}
