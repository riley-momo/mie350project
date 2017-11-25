package com.mie.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.MenuDao;
import com.mie.dao.UserDao;
import com.mie.model.User;

public class AccountCreationController  extends HttpServlet {

	private UserDao dao;

	/**
	 * Constructor for this class.
	 */
	public AccountCreationController() {
		super();
		dao = new UserDao();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
	
		/**
		 * Retrieve the entered username, email and password from the createAccount.jsp form.
		 */
		User user = new User();
		user.setEmail(request.getParameter("em"));
		user.setPassword(request.getParameter("pw"));
		user.setNameOfUser(request.getParameter("nm"));
		
		try {
			boolean success = dao.addStudentUser(user);
			if(success){
				response.sendRedirect("login.jsp");
			}
			else{
				response.sendRedirect("invalidLogin.jsp");
			}
		}
		catch (Throwable theException) {
			/**
			 * Print out any errors.
			 */
			System.out.println(theException);
		}
	}

}
