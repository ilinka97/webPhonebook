package org.bildit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.bildit.model.User;

public class UserDAOImpl implements UserDAO {
	
	Connection connection=ConnectionManager.getInstance().getConnection();
	
	@Override
	public boolean addUser(User user) {
		String query="INSERT INTO user(first_name,last_name,password) VALUES (?,?,?)";
		PreparedStatement statement=null;
		
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getPassword());
			
			if (statement.executeUpdate()==1) {
				return true;
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public User getUserById(int id) {
		
		String query="SELECT * FROM user WHERE user_id=?";
		PreparedStatement statement=null;
		User user=new User();
		ResultSet rs=null; 
		
		try {
			statement=connection.prepareStatement(query);
			statement.setInt(1, id);
			rs=statement.executeQuery();
			
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				
				rs.close();
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	
	@Override
	public User getUserByFirstName(String firstName) {
		
		String qurey="SELECT * FROM user WHERE first_name=?";
		PreparedStatement statement=null;
		User user=new User();
		ResultSet rs=null;
		
		try {
			statement=connection.prepareStatement(qurey);
			statement.setString(1, firstName);
			rs=statement.executeQuery();
			
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				
				rs.close();
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}
	
}
