package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bildit.model.Contact;
import org.bildit.service.EditContactService;

@WebServlet("/editContactRedirect")
public class EditContactRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr=request.getParameter("editButton");
		int id=Integer.parseInt(idStr);
		
		EditContactService editConService=new EditContactService();
		Contact contact=editConService.getContactById(id);
		contact.setContactId(id);
		
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/editContact").forward(request, response);
		
	}

}
