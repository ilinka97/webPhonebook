package org.bildit.service;

import org.bildit.dao.UserDAO;
import org.bildit.model.User;

public class LoginService {

	public boolean login(User user, UserDAO daoUser) {
	
		User userByName=daoUser.getUserByFirstName(user.getFirstName());
		
		if (userByName.getFirstName() != null && userByName.getPassword() != null) {
			if(userByName.getPassword().equals(user.getPassword())) {
				user.setUserId(userByName.getUserId());
				user.setLastName(userByName.getLastName());
				return true;    
			}	   
		} 
		 
		return false;
		
	}
	
}
