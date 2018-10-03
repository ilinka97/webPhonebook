package org.bildit.dao;

import org.bildit.model.User;

public interface UserDAO {
	
	boolean addUser(User user);
	User getUserById(int id);
	User getUserByFirstName(String firstName);
	 
}
