
    
package com.apps;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.model.Student1;


/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().append("Served at: ").append(request.getContextPath());
         response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            StudentDao sDao = new StudentDao();
            List<Student1> list = sDao.listStudents();
            pw.println("<form action =DeleteStudent method =Post>");
            pw.println("<h1 >select the student name <h1>");
            pw.println("<select name =sname><br><br>");
            for(Student1 l:list){
                pw.println("<option>"+l.getSname()+"</option>");
                
                }
            pw.println("<br><br><input type = submit value=delete ></select>");
            pw.println("</form>");
        }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        doGet(request, response);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String sname = request.getParameter("sname");
        StudentDao sDao = new StudentDao();
        if(sDao.deleteStudent(sname)){
            pw.println("deleted successfully");
        }
        else{
            pw.println(" not deleted");
        }
                
    }



}
 









