package com.pauseandshop.ecommerce.generic.databaseutility;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
public void getDbconnection(String url,String username,String password) throws SQLException {
	
try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
  con = DriverManager.getConnection(url, username, password);
}
catch(Exception e) {
}
}
public void getDbconnection() throws SQLException {
	
try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
  con = DriverManager.getConnection("jsbc:mysql://localhost:3306/projects", "roots", "roots");
}
catch(Exception e) {
}
}
public void closeDbConnection() {
	try {
		con.close();
	}
	catch(Exception e) {
}
}
public ResultSet executeconSelectQuery(String query) {
	ResultSet result=null;
	try {
		Statement stat = con.createStatement();
		 result=stat.executeQuery(query);
	}
	catch(Exception e) {
}
return result;
}
public int executeNonselectQuery(String query) {
	int result=0;
	try {
		 Statement stat = con.createStatement();
		 result =stat.executeUpdate(query);
	}
	catch(Exception e) {
	}
		return result;
	}
}
