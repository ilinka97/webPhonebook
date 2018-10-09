package org.bildit.service;

import org.bildit.dao.UserDAO;
import org.bildit.dao.UserDAOImpl;
import org.bildit.model.User;

public class RegistrationService {

	public boolean registerUser(User user) {
		
		UserDAO userDao=new UserDAOImpl();
		
		if (userDao.addUser(user)) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
