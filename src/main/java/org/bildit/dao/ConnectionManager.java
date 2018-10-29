package org.bildit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String USERNAME="root";
	private static final String PASSWORD="password";
	private static final String CONN_STRING="jdbc:mysql://localhost/web_phonebook?useSSL=false&serverTimezone=UTC";
	
	private static ConnectionManager instance=null;
	private Connection conn=null;
	
	private ConnectionManager(){
		
	}
	
	public static ConnectionManager getInstance(){
		if(instance==null){
			instance=new ConnectionManager();
		}
		return instance;
	}
	private boolean openConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Connection getConnection(){
		if(conn==null){
			if(openConnection()){
				return conn;
			}else{
				return null;
			}
		}
		return conn;
		
	}
	
	public void close(){
		try {
			conn.close();
			conn=null;
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}
