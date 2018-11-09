package org.bildit.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bildit.dao.ContactDAOImpl;
import org.bildit.model.Contact;
import org.bildit.service.DeleteContactService;

@WebServlet("/deleteContact")
public class DeleteContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeleteContactService delContactService= new DeleteContactService();
		
		Contact contact=new Contact();
		String idStr=request.getParameter("deleteButton");
		int id=Integer.parseInt(idStr);
		contact.setContactId(id);
		
		if(delContactService.deleteContact(contact, new ContactDAOImpl())) {
			request.getRequestDispatcher("/home").forward(request, response);
		}else {
			request.getRequestDispatcher("view/home.jsp").forward(request, response);
		}
		
	}


}
