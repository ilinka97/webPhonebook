package org.bildit.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.dao.ContactDAOImpl;
import org.bildit.model.Contact;
import org.bildit.model.User;
import org.bildit.service.ShowContactsService;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		ShowContactsService getContactsService=new ShowContactsService();
		User user=(User) session.getAttribute("user");
		List<Contact> contacts=getContactsService.getContactsByUser(user, new ContactDAOImpl());
		session.setAttribute("contacts", contacts);
		request.getRequestDispatcher("view/home.jsp").forward(request, response);
		
	}

}
