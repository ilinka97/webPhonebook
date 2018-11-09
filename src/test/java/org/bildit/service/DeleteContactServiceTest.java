package org.bildit.service;

import static org.junit.Assert.*;
import org.bildit.dao.ContactDAO;
import org.bildit.model.Contact;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeleteContactServiceTest {
	
	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock private ContactDAO daoContact;
	private DeleteContactService deleteContService;
	private Contact contact; 
	
	@Before
	public void setUp() throws Exception {
		deleteContService=new DeleteContactService();
		contact=new Contact();
	}

	@Test
	public void ShouldReturnTrueIfContactIsDeleted() {
		
		when(daoContact.deleteContact(contact)).thenReturn(true);
		
		assertTrue(deleteContService.deleteContact(contact, daoContact));
		verify(daoContact).deleteContact(contact);
		
	}
	
	@Test
	public void ShouldReturnFalseIfContactIsNotDeleted() {
		
		when(daoContact.deleteContact(contact)).thenReturn(false);
		
		assertFalse(deleteContService.deleteContact(contact, daoContact));
		verify(daoContact).deleteContact(contact);
		
	}
}
