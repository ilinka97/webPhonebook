package org.bildit.service;

import org.bildit.dao.ContactDAO;
import org.bildit.model.Contact;

public class AddContactService {

	public boolean addContact(Contact contact, ContactDAO daoContact) {
		
		if (daoContact.addContact(contact)) {   
			return true;
		}else {
			return false;
		}

	}
	
}
