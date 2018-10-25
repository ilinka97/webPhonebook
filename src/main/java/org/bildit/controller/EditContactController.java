package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.model.Contact;
import org.bildit.service.EditContactService;

@WebServlet("/editContact")
public class EditContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/editContact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contactName=request.getParameter("contactName");
		String phoneNumber=request.getParameter("phoneNumber");
		
		Contact contact=new Contact();
		contact.setContactName(contactName);
		contact.setPhoneNumber(phoneNumber);
		
		EditContactService editContService=new EditContactService();
		HttpSession session=request.getSession();
		Contact sessionContact=(Contact) session.getAttribute("contact");
		contact.setContactId(sessionContact.getContactId());
		
		if (editContService.editContact(contact)) {
			response.sendRedirect("/home");
		}else {
			request.getRequestDispatcher("view/addContact.jsp").forward(request, response);
		}
		
		
	}

}
