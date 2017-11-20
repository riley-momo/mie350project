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
	private static String SEARCH_MENU = "/searchMenuResult.jsp";
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
		String query = request.getParameter("query");

		RequestDispatcher view = request.getRequestDispatcher(SEARCH_MENU);
		request.setAttribute("query", query);
		request.setAttribute("menuItems", dao.getFilteredItems(query));
		/**
		 * Redirect to the search results page after the list of students
		 * matching the keywords has been retrieved.
		 */

		view.forward(request, response);
	}
}