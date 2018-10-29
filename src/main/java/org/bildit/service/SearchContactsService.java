package org.bildit.service;


import java.util.ArrayList;
import java.util.List;

import org.bildit.model.Contact;

public class SearchContactsService {

	public List<Contact> searcContacsByName(List<Contact> contacts, String searchName){
		
		List<Contact> searchResults= new ArrayList<>();
		
		for (Contact contact : contacts) {
			if(contact.getContactName().contains(searchName)) {
            	searchResults.add(contact);
            }
        }
		
		return searchResults;
		
	}
	
}
