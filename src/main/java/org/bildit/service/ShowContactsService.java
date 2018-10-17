package org.bildit.service;

import java.util.ArrayList;
import org.bildit.dao.ContactDAO;
import org.bildit.dao.ContactDAOImpl;
import org.bildit.model.Contact;
import org.bildit.model.User;

public class ShowContactsService {

	public ArrayList<Contact> getContactsByUser(User user){
			
		ContactDAO daoContacts=new ContactDAOImpl();
		ArrayList<Contact> contacts=daoContacts.getAllContactsByUser(user);
		
		return contacts;
			
	}
	
}
