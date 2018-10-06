package org.bildit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.bildit.model.Contact;
import org.bildit.model.User;


public class ContactDAOImpl implements ContactDAO{
	
	Connection connection=ConnectionManager.getInstance().getConnection();
	
	@Override
	public boolean addContact(Contact contact) {
		
		String query="INSERT INTO contact(contact_name,phone_number, user_id) VALUES (?,?,?)";
		PreparedStatement statement=null;
		
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, contact.getContactName());
			statement.setString(2, contact.getPhoneNumber());
			statement.setInt(3, contact.getUserId());
			
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
	public boolean editContact(Contact contact) {
		
		String query="UPDATE contact SET contact_name=?, phone_number=? WHERE contact_id=? ";
		PreparedStatement statement=null;
		
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, contact.getContactName());
			statement.setString(2, contact.getPhoneNumber());
			statement.setInt(3, contact.getContactId());
			
			if (statement.executeUpdate()==1) {
				return true;
			}/*else{
			System.out.println("shit happend.");
			}
			*/
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}

	@Override
	public boolean deleteContact(Contact contact) {
		
		String query="DELETE FROM contact WHERE contact_id=?";
		PreparedStatement statement=null;
		 
		try {
			statement=connection.prepareStatement(query);
			statement.setInt(1, contact.getContactId());
			
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
	public ArrayList<Contact> getAllContactsByUser(User user) {
		
		String query="SELECT * FROM contact WHERE user_id=?";
		PreparedStatement statement=null;
		ArrayList<Contact> contacts=new ArrayList<Contact>();
		ResultSet rs=null;
		
		try {
			statement=connection.prepareStatement(query);
			statement.setInt(1, user.getUserId());
			rs=statement.executeQuery();
			
			while(rs.next()) {
				Contact contact=new Contact();
				contact.setContactId(rs.getInt("contact_id"));
				contact.setContactName(rs.getString("contact_name"));
				contact.setPhoneNumber(rs.getString("phone_number"));
				contact.setUserId(rs.getInt("user_id"));
				contacts.add(contact);
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return contacts;
	}

	@Override
	public Contact getContactByName(String contactName) {
		
		String query="SELECT * FROM contact WHERE contact_name=?";
		PreparedStatement statement=null;
		Contact contact=new Contact();
		ResultSet rs=null;
		
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1, contactName);
			rs=statement.executeQuery();
			
			if(rs.next()){
				contact.setContactId(rs.getInt("contact_id"));
				contact.setContactName(rs.getString("contact_name"));
				contact.setPhoneNumber(rs.getString("phone_number"));
				contact.setUserId(rs.getInt("user_id"));
				
				rs.close();
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return contact;
	}	

}
