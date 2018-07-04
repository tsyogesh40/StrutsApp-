//$Id$
package com.login;
import com.opensymphony.xwork2.ActionSupport;

import java.util.*;
import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import java.io.IOException;
import java.sql.*;

@SuppressWarnings("unused")

public class LoginApp extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	
	private static final long serialVersionUID = 1L;
	private int x;
	private String username;
	private String password;
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	/*public void validate()
	{
		if(username.length()<1)
		{
			addFieldError("username","Username cannot be empty");
		}
		if(StringUtils.isEmpty(getPassword()))
		{
			addFieldError("password","Password not valid");
		}
	}*/
	

	public String execute() throws IOException
	{
		Connection conn = null;
		   Statement stmt = null;
		   int flag = 0;
		   String name="",pwd = "";
		System.out.println("Login on process.....please wait");
		System.out.println( "Submitted Value :"+ username +" "+password +" " );
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
	      HttpServletResponse response = ServletActionContext.getResponse();
	      
		try{
			 Class.forName(dbconnect.JDBC_DRIVER);
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(dbconnect.DB_URL,dbconnect.USER,dbconnect.PASS);
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      PreparedStatement ps = conn.prepareStatement("select * from login where name=? and password=?");
		      ps.setString(1,getUsername());
		      ps.setString(2,getPassword());
		      ResultSet rs=ps.executeQuery();  
		     while(rs.next())
		     {
		    	 name=rs.getString("name");
		    	 pwd=rs.getString("password");
		     }

			
		}catch(Exception e)
		{
			System.out.println("Exception Caught"  +e);
		}
		
		if(name.equals(getUsername())&&pwd.equals(getPassword()))
	     {
	    	 System.out.println("login success");
	    	return "success";
	     }
		return "failure";

	     
	}
	
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
		
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
		
	}

	
	
}
