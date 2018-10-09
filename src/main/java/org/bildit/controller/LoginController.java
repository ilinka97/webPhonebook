package org.bildit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bildit.model.User;
import org.bildit.service.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName;
		String password;
		
		firstName=request.getParameter("firstName");
		password=request.getParameter("password");
		
		User user=new User();
		user.setFirstName(firstName);
		user.setPassword(password);
		
		LoginService loginService=new LoginService();
		
		if(loginService.login(user)) {
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("view/home.jsp");
		}else {
			response.sendRedirect("view/index.jsp");
		}
		
	}

}
