package org.bildit.service;

import org.bildit.dao.ContactDAO;
import org.bildit.dao.ContactDAOImpl;
import org.bildit.model.Contact;

public class DeleteContactService {
	
	public boolean deleteContact(Contact contact){
		
		ContactDAO daoContact=new ContactDAOImpl();
		
		if(daoContact.deleteContact(contact)) {
			return true;
		}else {
			return false;
		}
		
	}

}
