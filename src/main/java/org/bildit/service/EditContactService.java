package org.bildit.service;

import org.bildit.dao.ContactDAO;
import org.bildit.model.Contact;

public class EditContactService {

	public boolean editContact(Contact contact, ContactDAO daoContact) {
		
		if (daoContact.editContact(contact)) {
			return true;
		}
		return false; 
	}
	
	public Contact getContactById(int id, ContactDAO daoContact) {
		
		Contact contact=daoContact.getContactById(id);
		return contact; 
		
	}
}
