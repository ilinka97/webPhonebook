package org.bildit.service;

import org.bildit.dao.UserDAO;
import org.bildit.model.User;

public class RegistrationService {

	public boolean registerUser(User user, UserDAO daoUser) {
		
		if (daoUser.addUser(user)) {
			return true;
		}else {
			return false;
		}
		
	}
	
} 
