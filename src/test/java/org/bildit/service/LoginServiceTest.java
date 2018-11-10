package org.bildit.service;

import static org.junit.Assert.*;

import org.bildit.dao.UserDAO;
import org.bildit.model.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock private UserDAO daoUser;
	private LoginService loginService;
	private User user;
	
	@Before
	public void setUp() throws Exception {
		loginService=new LoginService();
		user=new User();
	}

	@Ignore
	@Test
	public void ShouldReturnFalseIfFirstNameIsNull() {
		
		when(daoUser.getUserByFirstName("someName")).thenReturn(user);
		user.setFirstName(null); 
		assertFalse(loginService.login(user, daoUser));
		verify(daoUser).getUserByFirstName("someName");
		
	}
	
	@Ignore
	@Test
	public void ShouldReturnTrueIfUserIsLogged() {
		
	   	when(daoUser.getUserByFirstName("someName")).thenReturn(user);
		user.setPassword("pw"); 
	
		User testUser=new User();
		testUser.setPassword("pw"); 
		
		assertTrue(loginService.login(testUser, daoUser));
		verify(daoUser).getUserByFirstName("someName");
	}
	
	@Ignore
	@Test
	public void ShouldReturnFalseIfUserIsNotLogged() {
		
	    when(daoUser.getUserByFirstName("someName")).thenReturn(user);;
		user.setPassword("pw"); 
	
		User testUser=new User();
		testUser.setPassword("pww"); 
		
		assertFalse(loginService.login(testUser, daoUser));
		verify(daoUser).getUserByFirstName("someName");
	}
}
