package org.bildit.service;

import java.util.List;
import org.bildit.dao.ContactDAO;
import org.bildit.model.Contact;
import org.bildit.model.User;

public class ShowContactsService {

	public List<Contact> getContactsByUser(User user, ContactDAO daoContact){
			
		List<Contact> contacts=daoContact.getAllContactsByUser(user);
		
		return contacts;
			
	}
	
}
