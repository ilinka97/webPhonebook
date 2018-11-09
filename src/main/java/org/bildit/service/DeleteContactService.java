package org.bildit.service;

import org.bildit.dao.ContactDAO;
import org.bildit.model.Contact;

public class DeleteContactService {
	
	public boolean deleteContact(Contact contact, ContactDAO daoContact){
		
		if(daoContact.deleteContact(contact)) {
			return true;
		}else {
			return false;
		}
		
	}

}
