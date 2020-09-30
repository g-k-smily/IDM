package com.apps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 Connection conn = null;
    public ProductServlet() {
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
         String name=request.getParameter("pname");
         String photo=request.getParameter("photo");
         try {
        	 File f=new File(photo);
        	 int size=(int)f.length();
        	 FileInputStream fos=new FileInputStream(f);
        	 PreparedStatement ps1=conn.prepareStatement("insert into products(pname,img)values(?,?)");
        	 ps1.setString(1, name);
        	 ps1.setBinaryStream(2,fos,size);
        	 int x2=ps1.executeUpdate();
        	 if(x2>0) {
        		 System.out.println("Inserted Successfully");
        	 }else {
        		 System.out.println("Try Again");

        		 
        	 }
        	 
        	 
         }catch (Exception e) {
             System.out.println(e);
         }
     
	}

}
