//$Id$
package com.login;
import java.sql.*;

import javax.servlet.http.HttpServletResponse;
import com.action.Action;

public class Signup extends Action {
	private String name;
	private String email;
	private String password;
	private String date;
	//@SuppressWarnings("unused")
	private String msg;
	
    HttpServletResponse response;

	public String execute() throws Exception
	{

		Action obj=new Action();
		try{
		setMsg(obj.adduser(getName(), getEmail(), getPassword()));
		ResultSet rs = Action.viewall();
	      System.out.println("Updated List...");
	      
		      while(rs.next())
		      {
		        String nm= rs.getString("name");
		         String em = rs.getString("email");
		         String pwd = rs.getString("password");
		         
		         //Display values
		         System.out.print("Name: " + nm +"\t");
		         System.out.print(" Email: " + em +"\t");
		         System.out.println(" Password: " + pwd +"\t");
		      }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "added";	 
	        
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	
}
