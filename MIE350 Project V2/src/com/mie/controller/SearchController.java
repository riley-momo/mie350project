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

import com.mie.dao.MenuDao;
import com.mie.model.Menu;

public class SearchController extends HttpServlet {
	/**
	 * This class only handles the SEARCH feature of the web app.
	 * 
	 * These are variables that lead to the appropriate JSP pages.
	 * 
	 * SEARCH_USER leads to the search results page.
	 * 
	 */
	//test
	private static final long serialVersionUID = 1L;
	private static String SEARCH_MENU = "/recommendations.jsp";
	private MenuDao dao;

	/**
	 * Constructor for this class.
	 */
	public SearchController() {
		super();
		dao = new MenuDao();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method handles retrieval of SQL query based on users filter
		 */
		
		/* handle price */
		String priceoption = request.getParameter("priceoption");
		String p1price = request.getParameter("p1price");
		String p2price = request.getParameter("p1price");
		String price = "*";
		if(priceoption.equals("p1")){
			if(p1price.equals("") == false){
				price = p1price;
			}
		}
		/* handle calories */
		String caloriesoption = request.getParameter("calories");
		String c1val = request.getParameter("c1val");
		String calories = "*";
		if(caloriesoption.equals("c1")){
			if(c1val.equals("") == false){
				calories = c1val;
			}
		}
		/*handle diet*/
		String dietoption = request.getParameter("diet");
		String diet = "*";
		if(dietoption.equals("d1")){
			diet = "Vegetarian";
		}
		
		/* handle category */
		String categoryoption = request.getParameter("category");
		String category = "*";
		if(categoryoption.equals("all") == false){
			category = categoryoption;
		}
		/* */
		
		//if the input is anything, set parameter to "*"
		//String calories = request.getParameter("calories");
		//String category = request.getParameter("category");
		//String diet = request.getParameter("dietaryRestriction");
		//String price = request.getParameter("price");
		
		RequestDispatcher view = request.getRequestDispatcher(SEARCH_MENU);
		request.setAttribute("menus", dao.getFilteredItems(price, calories, category, diet));
		/**
		 * Redirect to the search results page after the list of menus
		 * matching the keywords has been retrieved.
		 */

		view.forward(request, response);
	}
}