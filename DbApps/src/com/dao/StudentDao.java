package com.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

import com.model.Student1;

public class StudentDao {

	public Connection createConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			System.out.println(con + " COnnected Successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}

	public boolean addStudent1(Student1 stud) {
		boolean b = false;
		Connection con = createConnection();
		try {
			PreparedStatement pst = con
					.prepareStatement("insert into Student1(sname,spass,mobileno,cname) values(?,?,?,?)");
			pst.setString(1, stud.getSname());
			pst.setString(2, stud.getSpass());
			pst.setString(3, stud.getMobileno());
			pst.setString(4, stud.getCname());
			int res = pst.executeUpdate();
			if (res > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		
		return b;

	}
    public boolean deleteStudent(String sname) {
        boolean b=false;
        Connection con = createConnection();
        try{
            PreparedStatement pst = con.prepareStatement("delete from student1 where sname = ?");
            pst.setString(1,sname);
            int res = pst.executeUpdate();
            if(res>0){
                b= true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
      
        return b;
    }
    public boolean validateUser(String user,String password) {
    	boolean b=false;
    	Connection con=createConnection();
    	try {
    		 PreparedStatement pst = con.prepareStatement("select * from student1 where sname = ? and spass= ? ");
    		 pst.setString(1,user);
    		 pst.setString(2,password);
             ResultSet res = pst.executeQuery();
             if(res.next()){
                 b= true;
             }
             }catch (Exception e) {
			System.out.println(e);

		}
    	
		return b;
    	
    }

	public List<Student1> listStudents() {
	        List<Student1> list = new ArrayList<Student1>();
	        Connection conn = createConnection();
	        try {
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery("select *from student1");
	            while (rs.next()) {
	                Student1 s = new Student1(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
	                        rs.getString(5));
	                list.add(s);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return list;
	    }
	 
}
