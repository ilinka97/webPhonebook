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
public class EditContactServiceTest {

	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock private ContactDAO daoContact;
	private EditContactService editContService;
	private Contact contact; 
	
	@Before
	public void setUp() throws Exception {
		editContService=new EditContactService();
		contact=new Contact();
	}

	@Test
	public void ShouldReturnTrueIfContactIsEdited() {
		
		when(daoContact.editContact(contact)).thenReturn(true);
		
		assertTrue(editContService.editContact(contact, daoContact));
		verify(daoContact).editContact(contact);
		
	}

	@Test
	public void ShouldReturnFalseIfContactIsNotEdited() {
		
		when(daoContact.editContact(contact)).thenReturn(false);
		
		assertFalse(editContService.editContact(contact, daoContact));
		verify(daoContact).editContact(contact);
		
	}

	@Test
	public void ShouldReturnContactWhenGivenContId() {
		
		Contact testCont=new Contact();
		when(daoContact.getContactById(3)).thenReturn(testCont);
		 
		assertEquals(testCont, editContService.getContactById(3,daoContact));
		verify(daoContact).getContactById(3);
		
	}
	
}
