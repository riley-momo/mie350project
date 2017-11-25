package com.mie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.MenuDao;
import com.mie.dao.UserDao;
import com.mie.model.User;

public class OwnerController extends HttpServlet {
	/**
	 * This class handles all insert/edit/list menu items functions of the servlet.
	 * 
	 * These are variables that lead to the appropriate JSP pages. INSERT leads
	 * to the Add A Menu Item page. EDIT leads to the Edit A Menu Item page.
	 * LIST_MENU_ITEMS leads to the listing of a restaurant's menu items
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private static String LIST_OWNER_MENU_ITEMS = "ListMenuItemsOwner.jsp";

	private UserDao UserDao;
	private MenuDao MenuDao;
	/**
	 * Constructor for this class.
	 */
	public OwnerController() {
		super();
		UserDao = new UserDao();
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Retrieve the entered username and password from the login.jsp form.
		 */
		User owner = new User();
		String forward = "";
		String action = request.getParameter("action");
		
		//owner.setUserID(Integer.parseInt(request.getParameter("OwnerID")));

		if(action.equalsIgnoreCase("listOwnersItems")) {
			forward = LIST_OWNER_MENU_ITEMS;
			request.setAttribute("menus", MenuDao.getOwnerItems(owner.getUserID()));
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
}
