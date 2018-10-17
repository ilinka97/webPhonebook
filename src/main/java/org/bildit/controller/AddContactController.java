package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.model.Contact;
import org.bildit.model.User;
import org.bildit.service.AddContactService;

@WebServlet("/addContact")
public class AddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/addContact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contactName;
		String phoneNumber;
		
		contactName=request.getParameter("contactName");
		phoneNumber=request.getParameter("phoneNumber");
		
		Contact contact=new Contact();
		contact.setContactName(contactName);
		contact.setPhoneNumber(phoneNumber);
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		contact.setUserId(user.getUserId());
		
		AddContactService addContService=new AddContactService();
		
		if (addContService.addContact(contact)) {
			response.sendRedirect("/home");
		}else {
			request.getRequestDispatcher("view/addContact.jsp").forward(request, response);
		}
			
	}

}
