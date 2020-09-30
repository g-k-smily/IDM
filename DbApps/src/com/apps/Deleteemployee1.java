
    
package com.apps;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Deleteemployee
 */
@WebServlet("/Deleteemployee1")
public class Deleteemployee1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    Connection conn = null;
    public Deleteemployee1() {
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
        int eno1 = Integer.parseInt(request.getParameter("enum9"));
        try {
        Statement st =conn.createStatement();
        int res = st.executeUpdate("delete from emp where eno="+eno1);
        if (res > 0) {
            pw.println("<h1>deleted  succesfuly</h1>");
        } else {
            pw.println("</h2>failed to delete</h2>");
        }
        }catch (Exception e) {
        System.out.println(e);
    }
    }
}
 









