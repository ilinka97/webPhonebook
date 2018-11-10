package org.bildit.service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.bildit.model.Contact;
import org.junit.Before;
import org.junit.Test;

public class SearchContactsServiceTest {
	
	private Contact c1, c2, c3;
	private List<Contact> contacts;
	private SearchContactsService searchContService;

	@Before
	public void setUp() throws Exception { 
		
		c1=new Contact();
		c1.setContactName("c1");
		
		c2=new Contact();
		c2.setContactName("c2");
		
		c3=new Contact();
		c3.setContactName("c3");
		
		contacts=new ArrayList<>();
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		
		searchContService=new SearchContactsService();
	}

	@Test
	public void ShouldReturnListOfContactsIfContactNameIsFoundInList() {
		
		List<Contact> searchResults=new ArrayList<>();
		searchResults.add(c1);
		searchResults.add(c2);
		searchResults.add(c3);
		
		assertEquals(searchResults, searchContService.searcContacsByName(contacts, "c"));
		
	}
	
	@Test
	public void ShouldReturnNullIfContactNameIsNotFoundInList() {
		
	    List<Contact> searchResults=new ArrayList<>(); 
	    
	    assertEquals(searchResults, searchContService.searcContacsByName(contacts, "v"));
	
	}
}
