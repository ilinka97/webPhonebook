package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.model.User;
import org.bildit.service.RegistrationService;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName;
		String lastName;
		String password;
		
		firstName=request.getParameter("firstName");
		lastName=request.getParameter("lastName");
		password=request.getParameter("password");
		
		User user=new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		
		RegistrationService registrationService=new RegistrationService();
		String registrationMessage=null;
		
		if(registrationService.registerUser(user)) {
			registrationMessage="You have been successfully registered!";
			request.setAttribute("registrationMessage", registrationMessage);
			request.getRequestDispatcher("view/index.jsp").forward(request, response);	
		}else {
			registrationMessage="Something went wrong. Please try again!";
			request.setAttribute("registrationMessage", registrationMessage);
			request.getRequestDispatcher("view/index.jsp").forward(request, response);
		}
		
	}

}
