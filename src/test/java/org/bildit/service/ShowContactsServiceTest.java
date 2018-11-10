package org.bildit.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.bildit.dao.ContactDAO;
import org.bildit.model.Contact;
import org.bildit.model.User;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShowContactsServiceTest {

	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock private ContactDAO daoContact;
	private ShowContactsService showContService;
	private User user;
	
	@Before
	public void setUp() throws Exception {
		showContService= new ShowContactsService();
		user=new User();
	}

	@Test
	public void ShouldReturnListOfContactsByUser() {
		
		List<Contact> contacts=new ArrayList<>();
		when(daoContact.getAllContactsByUser(user)).thenReturn(contacts);
		
		assertEquals(contacts, showContService.getContactsByUser(user, daoContact));
		verify(daoContact).getAllContactsByUser(user);  
		
	}

}
