package org.bildit.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.bildit.dao.ContactDAO;
import org.bildit.model.Contact;

@RunWith(MockitoJUnitRunner.class)
public class AddContactServiceTest {
	
	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock private ContactDAO daoContact;
	private AddContactService addContService;
	private Contact contact; 
	
	@Before
	public void setUp() throws Exception {
		addContService=new AddContactService();
		contact=new Contact();
	}
	
	@Test
	public void ShouldReturnTrueIfContactIsAdded() {
		
		when(daoContact.addContact(contact)).thenReturn(true); 
		
		assertTrue(addContService.addContact(contact,daoContact));
		verify(daoContact).addContact(contact); 
		
	} 
	    
	@Test
	public void ShouldReturnFalseIfContactIsNotAdded() {
		
		when(daoContact.addContact(contact)).thenReturn(false);
		
		assertFalse(addContService.addContact(contact,daoContact));
		verify(daoContact).addContact(contact);
		
	}
}
