package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private String email;
	private String name;
	private String password;
	private int rollNo;
	
	/*
	    {
		    "email" : "sankha@gmail.com",
		    "name" : "Sankha",
		    "password" : "Sankha@123",
		    "rollNo" : 73
		}
	 */
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public Student(String email, String name, String password, int rollNo) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.rollNo = rollNo;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Student [email=" + email + ", name=" + name + ", password=" + password + ", rollNo=" + rollNo + "]";
	}
	
	
	
}
