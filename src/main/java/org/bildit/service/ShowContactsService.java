package org.bildit.service;


import java.util.List;
import org.bildit.dao.ContactDAO;
import org.bildit.dao.ContactDAOImpl;
import org.bildit.model.Contact;
import org.bildit.model.User;

public class ShowContactsService {

	public List<Contact> getContactsByUser(User user){
			
		ContactDAO daoContacts=new ContactDAOImpl();
		List<Contact> contacts=daoContacts.getAllContactsByUser(user);
		
		return contacts;
			
	}
	
}
