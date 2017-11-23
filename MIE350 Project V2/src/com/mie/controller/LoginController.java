package com.mie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.model.*;
import com.mie.dao.*;

/**
 * Servlet implementation for LoginController.
 * 
 * This class handles the login servlet and assigns session attributes for users
 * who succesfully log into the system.
 */
public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered username and password from the login.jsp form.
		 */
		User user = new User();
		user.setEmail(request.getParameter("em"));
		user.setPassword(request.getParameter("pw"));

		try {
			/**
			 * Try to see if the user can log in.
			 */
			user = UserDao.login(user);

			/**
			 *User will either be a student, an owner, or invalid. We direct them to the appropriate page based on these conditions
			 */
			if (user.isStudent()) {
//				StudentUser su = (StudentUser) user;	//cast to student so we may access student methods
				User su = user;
				
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", su);
				session.setAttribute("email", user.getEmail());
				session.setAttribute("userName", user.getNameOfUser());
				//session.setAttribute("dietRestrictions", );
				/**
				 * Redirect to the members-only home page.
				 */
				response.sendRedirect("StudentLogged.jsp");

				/**
				 * Set a timeout variable of 900 seconds (15 minutes) for this
				 * member who has logged into the system.
				 */
				session.setMaxInactiveInterval(900);
				
			}

			else if (user.isRestaurantOwner()){
				//Redirect User to Restaurant Owner Page
//				Owner ou = (Owner) user;
				User ou = user;
				
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", ou);
				session.setAttribute("email", user.getEmail());
				session.setAttribute("userName", user.getNameOfUser());
				
				response.sendRedirect("OwnerLogged.jsp");
				session.setMaxInactiveInterval(900);
			}
			else {
				/**
				 * Otherwise, redirect the user to the invalid login page and
				 * ask them to log in again with the proper credentials.
				 */
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
