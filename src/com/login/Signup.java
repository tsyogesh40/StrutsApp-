//$Id$
package com.login;
import java.sql.*;


public class Signup{
	private String name;
	private String email;
	private String password;
	
	/* static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:8889/myserver";

	  //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";*/
	
	   
	   
	public String execute()
	{
		Connection conn = null;
		   Statement stmt = null;
		   int flag = 0;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(dbconnect.JDBC_DRIVER);
		      
			  System.out.println( "Submitted Value :"+ name +" "+email +" "+password );

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(dbconnect.DB_URL,dbconnect.USER,dbconnect.PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      System.out.println("Inserting records into the table...");
		      
		      PreparedStatement ps = conn.prepareStatement("INSERT INTO login(name,email,password) VALUES(?,?,?)");
		      	ps.setString(1,getName());
				ps.setString(2,getEmail());
				ps.setString(3, getPassword());
				flag = ps.executeUpdate();
				System.out.println(flag);
				if(flag>0)
					System.out.println("Inserted Successfully");
						      
		      sql = "SELECT * FROM login";
		      ResultSet rs = stmt.executeQuery(sql);
		  
		      
		      System.out.println("Updated List...");
		   //STEP 5: Extract data from result set
		      while(rs.next()){
		        String name= rs.getString("name");
		         String email = rs.getString("email");
		         String password = rs.getString("password");
		         

		         //Display values
		         System.out.print("Name: " + name +"\t");
		         System.out.print(" Email: " + email +"\t");
		         System.out.println(" Password: " + password +"\t");
		      }
		      
		   }
		  catch(Exception e)
		   {
			System.out.print("caught exception"+ e);  
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
}
