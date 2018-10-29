package org.bildit.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bildit.model.Contact;
import org.bildit.service.SearchContactsService;

@WebServlet("/searchContacts")
public class SearchContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchedName=request.getParameter("searchField");
		
		HttpSession session= request.getSession();
		@SuppressWarnings("unchecked")
		List<Contact> contacts=(List<Contact>) session.getAttribute("contacts");
			
		SearchContactsService searchContService=new SearchContactsService();
		List<Contact> searchResults=searchContService.searcContacsByName(contacts, searchedName);
		
		request.setAttribute("searchedContacts", searchResults);
		request.getRequestDispatcher("view/searchContacts.jsp").forward(request, response);
	}

	
	

}
