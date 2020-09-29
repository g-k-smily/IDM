package com.model;
import java.io.Serializable;

public class Student1 implements Serializable {

	
	private int sno;
	private String sname;
	private String spass;
	private String mobileno;
	private String cname;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Student1() {
		
	}
	public Student1(int sno, String sname, String spass, String mobileno, String cname) {
		this();
		this.sno = sno;
		this.sname = sname;
		this.spass = spass;
		this.mobileno = mobileno;
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Student1 [sno=" + sno + ", sname=" + sname + ", spass=" + spass + ", mobileno=" + mobileno + ", Cname="
				+ cname + "]";
	}
	
	
}