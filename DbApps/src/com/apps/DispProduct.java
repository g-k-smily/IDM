package com.apps;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispProduct
 */
@WebServlet("/DispProduct")
public class DispProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 Connection conn = null;
    public DispProduct() {
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
        try {
        PreparedStatement st=conn.prepareStatement("select * from products where pid = ?"); 
        st.setInt(1,Integer.parseInt(request.getParameter("pid")));
        ResultSet rs=st.executeQuery();
        String name=null;
        if(rs.next()) {
        	name=rs.getString("pname");
        	System.out.println(name);
        	InputStream in=rs.getBinaryStream("img");
        	FileOutputStream fos=new FileOutputStream("G:\\telakona\\kavya.jpg");
        	byte size[]=new byte[4732];
        	int bytes=0;
        	while((bytes=in.read(size))!=-1) {
        		fos.write(size,0,bytes);
        	}
        	pw.println("<body bgcolor='lightgreen'><div align ='center'>Name="+name+
        			"<IMG SRC='G:\\telakona\\kavya.jpg' width='175' height ='200'></div></body>");
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
        
	}

}
