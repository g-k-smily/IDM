
package com.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmploy
 */
@WebServlet("/UpdateEmploy")
public class UpdateEmploy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Connection conn = null;

	public UpdateEmploy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int eno1 = Integer.parseInt(request.getParameter("eno"));
		String ename = request.getParameter("ename");
		String hire = request.getParameter("hiredate");
		float esal = Float.parseFloat(request.getParameter("esalary"));
		System.out.println(eno1 + "" + ename + "" + hire + "" + esal);
		pw.println("<!DOCTYPE html><html><head><meta charset=ISO-8859-1><title>Insert title here</title></head>");
		pw.println("<body>");
		pw.println("<form action=UpdateEmploy method=POST>");
		pw.println("<h1 style=background-color:skyblue;color:white;padding:20px;text-align:center;></h1>");
		pw.println("<table align=center>");
		pw.println("<tr><td>Enter EmployeeNum: </td><td><input type=text name=eno value=" + eno1 + "></td></tr>");
		pw.println("<tr><td>Enter EmployeeName: </td><td><input type=text name=ename value= " + ename + "></td></tr>");
		pw.println(" <tr><td>Enter date: </td><td><input type=date name=hiredate value=" + hire + "></td></tr>");
		pw.println(" <tr><td>Enter salary: </td><td><input type=text name=salary value =" + esal + "></td></tr>");
		pw.println("<tr><td colspan=2 align=center><input type=submit value=update employee></td></tr>");
		pw.println("</table>");
		pw.println("</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int eno = Integer.parseInt(request.getParameter("eno"));
		String ename = request.getParameter("ename");
		String edate = request.getParameter("edate");
		float esal = Float.parseFloat(request.getParameter("esalary"));
		System.out.println(eno + "" + ename + "" + edate + "" + esal);
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			java.util.Date strd = format.parse(edate);
			long st = strd.getTime();
			java.sql.Date d = new java.sql.Date(st);
			PreparedStatement pst = conn.prepareStatement("update emp set ename=?,edate=?,esalary=? where eno=?");
			pst.setString(1, ename);

			pst.setDate(2, d);
			pst.setFloat(3, esal);
			pst.setInt(4, eno);
			int res = pst.executeUpdate();

			if (res > 0) {
				pw.println("<h1>updated succesfuly</h1>");
				pw.println("<br><br><h1><a href=DeleteEmp.html>Delete the employee</a></h1>");
			} else {
				pw.println("</h2>failed to </h2>");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
