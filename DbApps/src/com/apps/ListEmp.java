package com.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListEmp
 */
@WebServlet("/ListEmp")
public class ListEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Connection conn = null;

	public ListEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			System.out.println(conn + " COnnected Successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
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
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("select * from emp");
			pw.println("<table align=center cellpadding=20px border=1 bgcolor=pink>");
			while (res.next()) {
				int empno = res.getInt(1);
				String ename = res.getString(2);
				Date edate = res.getDate(3);
				Float esalary = res.getFloat(4);
				pw.println("<tr><td>" + empno + "</td><td>" + ename + "</td><td>" + edate + "</td><td>" + esalary
						+ "</td><td><a href=DeleteEmp?eno=" + empno + ">Delete</a></td>" + "<td><a href=UpdateEmploy?eno="
						+ empno + "&ename=" + ename + "&edate=" + edate + "&esalary=" + esalary
						+ ">Update</a></td></tr>");

			}
			pw.println("</table>");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
