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

public class RatingController extends HttpServlet {
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
	private RatingDao dao;
	private static final long serialVersionUID = 1L;
	private static String RATE = "/leaveRating.jsp";
	private static String INVALID_RATE = "/invalidRating.jsp";
	private static String SEARCH_MENU_ITEMS = "/listMenuItemsStudent.jsp";
	private static String LOGIN = "/login.jsp";

	/**
	 * Constructor for this class.
	 */
	public RatingController() {
		super();
		dao = new RatingDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles directing the user to the restaurant rating page
		 */
		HttpSession session = request.getSession(true);
		RequestDispatcher view;
		
		if ((String)request.getSession().getAttribute("email") == null 
				|| ((String)request.getSession().getAttribute("email")).isEmpty()){
			view= request.getRequestDispatcher(LOGIN);
		}
		else {
			User user = (User) session.getAttribute("currentSessionUser");
			user.setEmail((String)session.getAttribute("email"));
			String action = request.getParameter("action"); 
			
			if(action.equalsIgnoreCase("rate")) {		
				int restaurantID =  Integer.parseInt(request.getParameter("restaurantId"));		
				boolean isValid = dao.isValid(user, restaurantID);
				
			
				if (isValid){
					String restaurantName = request.getParameter("restaurantName");
					Menu menu = new Menu();
					menu.setRestaurantID(restaurantID);
					menu.setRestaurantName(restaurantName);
					request.setAttribute("menu", menu); 
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
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles rating restaurants
		 */
		HttpSession session = request.getSession(true);
		RequestDispatcher view;
		
		if ((String)request.getSession().getAttribute("email") == null 
				|| ((String)request.getSession().getAttribute("email")).isEmpty()){
			view= request.getRequestDispatcher(LOGIN);
		}
		else {
			User user = (User) session.getAttribute("currentSessionUser");
			int restaurantID =  Integer.parseInt(request.getParameter("restaurantToRate"));
			int rating = Integer.parseInt(request.getParameter("rating"));
			
			if (rating > 5 || rating < 0) {
				view = request.getRequestDispatcher(INVALID_RATE);
			}
			else {
				view= request.getRequestDispatcher(SEARCH_MENU_ITEMS);
				dao.addRating(user, restaurantID, rating);
				MenuDao menuDao = new MenuDao();
				request.setAttribute("menus", menuDao.getAllItems());
			}
		}
		
		view.forward(request, response);
	}



}	

	