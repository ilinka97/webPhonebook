package org.bildit.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.bildit.dao.UserDAO;
import org.bildit.model.User;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock private UserDAO daoUser;
	private RegistrationService registrationService;
	private User user;
	
	@Before
	public void setUp() throws Exception {
		registrationService= new RegistrationService();
		user=new User();
	}

	@Test
	public void ShouldReturnTrueIfUserIsRegistrated() {
		
		when(daoUser.addUser(user)).thenReturn(true);
		
		assertTrue(registrationService.registerUser(user, daoUser));
		verify(daoUser).addUser(user);
		
	}

	@Test
	public void ShouldReturnFalseIfUserIsNotRegistrated() {
		
		when(daoUser.addUser(user)).thenReturn(false);
		
		assertFalse(registrationService.registerUser(user, daoUser));
		verify(daoUser).addUser(user);
		
	}
}
