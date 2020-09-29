package com.apps;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.model.Student1;

/**
 * Servlet implementation class ListStudents
 */
@WebServlet("/ListStudents")
public class ListStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListStudents() {
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		StudentDao stuDao = new StudentDao();
		List<Student1> list = stuDao.listStudents();
		pw.println("<table align=center cellpadding=20px border=1");
		for (Student1 s : list)
			pw.println("<tr><td>" + s.getSno() + "</td><td>" + s.getSname() + "</td><td>" + s.getSpass() + "</td><td>"
					+ s.getMobileno() + "</td><td>" + s.getCname() + "</td></tr>");

	}

}
