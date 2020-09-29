
package com.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementatio
 */
@WebServlet("/StmtInsert")
public class StmtInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Connection conn = null;

	public StmtInsert() {
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
		int eno1 = Integer.parseInt(request.getParameter("eno"));
		String enamee = request.getParameter("ename");
		String hire = request.getParameter("hiredate");
		float esal = Float.parseFloat(request.getParameter("salary"));

		System.out.println(eno1 + "" + enamee + "" + hire + "" + esal);
		try {
			Statement st = conn.createStatement();
			int res = st.executeUpdate(
					"insert into emp values(" + eno1 + ",' " + enamee + "' ," + "' " + hire + "' ," + esal + ")");
			if (res > 0) {
				pw.println("<h1>inserted succesfuly</h1>");
				pw.println("<br><br><h1><a href=deleteemployee.html>Delete the employee</a></h1>");

			} else {
				pw.println("</h2>failed to insert</h2>");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
