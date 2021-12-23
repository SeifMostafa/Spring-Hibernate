package com.musala.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/?user=hbstudent?useSSL=false";
			String user="hbstudent";
			String password="hbstudent";
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("successfull connection!");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
