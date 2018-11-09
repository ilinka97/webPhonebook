package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bildit.dao.ContactDAOImpl;
import org.bildit.model.Contact;
import org.bildit.service.EditContactService;

@WebServlet("/editContact")
public class EditContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Contact contact=new Contact();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contact reqContact=(Contact) request.getAttribute("contact");
		contact.setContactId(reqContact.getContactId());
		request.getRequestDispatcher("view/editContact.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contactName=request.getParameter("contactName");
		String phoneNumber=request.getParameter("phoneNumber");
		
		contact.setContactName(contactName);
		contact.setPhoneNumber(phoneNumber);
		
		EditContactService editContService=new EditContactService();
		
		if (editContService.editContact(contact, new ContactDAOImpl())) {
			response.sendRedirect("/home");
		}else {
			request.getRequestDispatcher("view/addContact.jsp").forward(request, response);
		}
		
	}

}
