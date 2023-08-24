package com.fita.jdbcconnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Curdjdbc {
	
	void retrive() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection reffernceConnection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Kaviya02");
		Statement smt = reffernceConnection.createStatement();
		ResultSet res = smt.executeQuery("select * from Companies");
		
		while(res.next()) {
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
		}
		
	}
	void insert() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection reffernceConnection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Kaviya02");
	    PreparedStatement stmt=reffernceConnection.prepareStatement("insert into Companies values(?,?,?,?,?)");  
        stmt.setInt(1,18);
        stmt.setString(2, "reee");
        stmt.setString(3,"Banglore");
        stmt.setString(4, "ree@gmail.com");
        stmt.setInt(5,48328);
        int i=stmt.executeUpdate();  
        System.out.println(i+" records inserted");  	
	}
	void update() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection reffernceConnection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Kaviya02");
		PreparedStatement stmt=reffernceConnection.prepareStatement("update Companies set name=?where id=?");  
		stmt.setString(1,"keerthi");
		stmt.setInt(2,17); 
		int i=stmt.executeUpdate();  
		System.out.println(i+" records updated");  
	}
	void delete() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection reffernceConnection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Kaviya02");
		PreparedStatement stmt=reffernceConnection.prepareStatement("delete from Companies where id=?");  
		stmt.setInt(1,17);  
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records deleted");  

	}
	void select() throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection reffernceConnection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Kaviya02");
	PreparedStatement stmt=reffernceConnection.prepareStatement("select * from Companies");  
	ResultSet rs=stmt.executeQuery();  
	while(rs.next()){  
	System.out.println(rs.getInt(1)+" "+rs.getString(2));  
	}  
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Curdjdbc getData = new Curdjdbc();
		getData.retrive();
		//getData.insert();
		//getData.update();
		//getData.delete();
		getData.select();
	}

}
