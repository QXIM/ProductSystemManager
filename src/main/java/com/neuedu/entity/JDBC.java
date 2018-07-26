package com.neuedu.entity;

import java.io.IOException;
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
	static Properties ps=new Properties();

	static {
		
		try {
			ps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
			Class.forName(ps.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection conn() throws SQLException {
		
		String url=ps.getProperty("url");
		String username=ps.getProperty("username");
		String userpassword=ps.getProperty("userpassword");
		return DriverManager.getConnection(url, username, userpassword);
		
	}
	public static void close(Connection con ,Statement st) throws SQLException {
		
		if(con!=null) {
			con.close();
		}
		if(st!=null) {
			st.close();
		}
	}
public static void close(Connection con ,Statement st,ResultSet re) throws SQLException {
		
		if(con!=null) {
			con.close();
		}
		if(st!=null) {
			st.close();
		}
		if(re!=null) {
			re.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
