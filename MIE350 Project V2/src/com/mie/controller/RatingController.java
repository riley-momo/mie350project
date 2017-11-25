package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.MenuDao;
import com.mie.dao.RatingDao;
import com.mie.model.Menu;
import com.mie.model.User;

public class RatingController {
	/**
	 * This class only handles the restaurant RATING feature of the web app.
	 *
	 * These are variables that lead to the appropriate JSP pages.
	 * 
	 * RATE leads to leaving a rating page
	 * 
	 * INVALID_RATE leads to error:already rated this restaurant page
	 * 
	 */
	//test
	private static final long serialVersionUID = 1L;
	private static String RATE = "/leaveRating.jsp";
	private static String INVALID_RATE = "/invalidRating.jsp";
	private RatingDao dao;
	

	/**
	 * Constructor for this class.
	 */
	public RatingController() {
		super();
		dao = new RatingDao();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles rating restaurants
		 */
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("currentSessionUser");
		int restaurantID =  Integer.parseInt(request.getParameter("restaurantToRate"));
		
		boolean isValid = dao.isValid(user, restaurantID);
		RequestDispatcher view;
		
		if (isValid){
			 view = request.getRequestDispatcher(RATE);
		}
		else {
			view = request.getRequestDispatcher(INVALID_RATE);
		}
		
		
		/**
		Redirect to appropriate page based on valid/invalid result
		 */

		view.forward(request, response);
	}
}	

	