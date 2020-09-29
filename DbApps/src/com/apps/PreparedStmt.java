
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
 * Servlet implementation class PreparedStmt
 */
@WebServlet("/PreparedStmt")
public class PreparedStmt extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    Connection conn = null;
    public PreparedStmt() {
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
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int eno = Integer.parseInt(request.getParameter("eno"));
        String ename = request.getParameter("ename");
        String edate = request.getParameter("edate");
        float esalary = Float.parseFloat(request.getParameter("esalary"));
        System.out.println(eno + "" + ename + "" + edate + "" + esalary);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date strd = format.parse(edate);
            long st =strd.getTime();
            java.sql.Date d = new java.sql.Date(st);
            PreparedStatement pst = conn.prepareStatement("insert into emp values(?,?,?,?)");;
            pst.setInt(1, eno);
            pst.setString(2,ename);
            pst.setDate(3, d);
            pst.setFloat(4,esalary);
            int res = pst.executeUpdate();
            
            if (res > 0) {
                pw.println("<h1>inserted succesfuly</h1>");
                pw.println("<br><br><h1><a href=Deleteemployee1.html>Delete the employee</a></h1>");
            } else {
                pw.println("</h2>failed to insert</h2>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}








