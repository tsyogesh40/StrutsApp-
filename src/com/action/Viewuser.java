//$Id$
package com.action;

import java.sql.ResultSet;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.login.Signup;
import com.opensymphony.xwork2.ActionSupport;

public class Viewuser extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Signup obj=null;
	ResultSet rs=null;
	List<Signup> li=null;
	HttpServletResponse response;
	HttpServletRequest request;
	
	
	public String execute() throws Exception
	{
		System.out.println("function called");
	try{
		li = new ArrayList<Signup>();
		rs= Action.viewall();
		if(rs !=null)
			while(rs.next())
			{
				obj=new Signup();
				obj.setName(rs.getString("name"));
				obj.setEmail(rs.getString("email"));
				obj.setPassword(rs.getString("password"));
				obj.setDate(rs.getString("date"));
				li.add(obj);
			}
		
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
		return "added";
	}
	public List<Signup> getLi() {
		return li;
	}

	public void setLi(List<Signup> li) {
		this.li = li;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
		
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;		
	}
	
}
