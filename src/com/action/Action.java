//$Id$
package com.action;
import com.login.dbconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Action extends dbconnect{

public static Connection myconnection() throws Exception
{
	try{
		Class.forName(dbconnect.JDBC_DRIVER);
		System.out.print("DB connected");
		return DriverManager.getConnection(dbconnect.DB_URL, dbconnect.PASS,dbconnect.USER);
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
}

public String adduser(String name,String email,String pass) throws Exception
{
	try {
		String sql = "INSERT INTO login(name,email,password) VALUES(?,?,?)";
		PreparedStatement ps = myconnection().prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, pass);
		ps.executeUpdate();
	      System.out.println("Inserting records into the table...");

		return "User added Successful";
	} catch (Exception e) {
		e.printStackTrace();
		return e.getMessage();
	} finally {
		if (myconnection() != null) {
			myconnection().close();
		}
	}
	
}

public static ResultSet viewall() throws Exception
{
	try{
		String sql = "SELECT * FROM login";
		PreparedStatement ps = myconnection().prepareStatement(sql);
		ResultSet rs=ps.executeQuery(sql);
		
//		   while(rs.next())
//		      {
//		        String nm= rs.getString("name");
//		         String em = rs.getString("email");
//		         String pwd = rs.getString("password");
//		         String dt=rs.getString("date");
//		         
//		         //Display values
//		         System.out.print("Name: " + nm +"\t");
//		         System.out.print(" Email: " + em +"\t");
//		         System.out.print(" Password: " + pwd +"\t");
//		         System.out.println("Date:"+ dt+"\t");
//		      }
		return rs;
	}catch (Exception e) {
		e.printStackTrace();
		return null;
	} finally {
		if (myconnection() != null) {
			myconnection().close();
		}
	}
}

}
