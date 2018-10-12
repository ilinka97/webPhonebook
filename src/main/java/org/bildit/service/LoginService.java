package org.bildit.service;

import org.bildit.dao.UserDAO;
import org.bildit.dao.UserDAOImpl;
import org.bildit.model.User;

public class LoginService {

	public boolean login(User user) {
		
		UserDAO userDao=new UserDAOImpl();
	
		User userByName=userDao.getUserByFirstName(user.getFirstName());
		
		if (userByName.getFirstName() != null && userByName.getPassword() != null) {
			if(userByName.getPassword().equals(user.getPassword())) {
				user.setLastName(userByName.getLastName());
				return true;
			}	
		}
		
		return false;
		
	}
	
}
