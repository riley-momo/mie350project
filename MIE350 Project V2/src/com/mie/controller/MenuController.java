package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.MenuDao;
import com.mie.model.Menu;
import com.mie.model.User;

public class MenuController extends HttpServlet {
	/**
	 * This class handles all insert/edit/list functions of the servlet.
	 * 
	 * These are variables that lead to the appropriate JSP pages. INSERT leads
	 * to the Add A Student page. EDIT leads to the Edit A Student page.
	 * LIST_STUDENT_PUBLIC leads to the public listing of students.
	 * LIST_STUDENT_ADMIN leads to the admin-only listing of students (for them
	 * to modify student information).
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addMenuItem.jsp";
	private static String EDIT = "/editMenuItem.jsp";
	private static String LIST_MENU_ITEMS = "/listMenuItems.jsp";
	private static String LIST_OWNER_MENU_ITEMS = "/listMenuItemsOwner.jsp";
	private static String SEARCH_MENU_ITEMS = "/listMenuItemsStudent.jsp";
	

	private MenuDao dao;

	/**
	 * Constructor for this class.
	 */
	public MenuController() {
		super();
		dao = new MenuDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This class retrieves the appropriate 'action' found on the JSP pages:
		*/
		User owner = new User();
		String forward = "";
		String action = request.getParameter("action"); 
		if(action.equalsIgnoreCase("listOwnersItems")) {
			forward = LIST_OWNER_MENU_ITEMS;
			List<Menu> menus = dao.getOwnerItems((String)request.getSession().getAttribute("Email"));
			request.setAttribute("menus", menus);
			request.setAttribute("restaurantID", menus.get(0).getRestaurantID());
			request.setAttribute("restaurantName", menus.get(0).getRestaurantName());
		} 
		else if (action.equalsIgnoreCase("searchMenuItems")){
			forward = SEARCH_MENU_ITEMS;
			request.setAttribute("menus", dao.getAllItems());
			//set attribute names to "price", "calories", "category", and "diet"
			
			//request.setAttribute("menus", dao.getFilteredItems(price, calories, category, diet));
		}

	else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
			int restaurantID = Integer.parseInt(request.getParameter("restaurantId"));
			String restaurantName = request.getParameter("restaurantName");
			Menu menu = new Menu();
			menu.setRestaurantID(restaurantID);
			menu.setRestaurantName(restaurantName);
			request.setAttribute("menu", menu);
			request.setAttribute("edit",false);
	}
	else if (action.equalsIgnoreCase("edit")) {
			forward = EDIT;
			//System.out.print("test");
			int restaurantID = Integer.parseInt(request.getParameter("restaurantId"));
			String itemName = request.getParameter("itemName");
			Menu menu = dao.getMenuItemByRestaurantIDAndItemName(restaurantID, itemName);
			request.setAttribute("menu", menu);
			request.setAttribute("edit",false);
		} 
		else if (action.equalsIgnoreCase("listRestaurant")) {
			forward = LIST_MENU_ITEMS;
			request.setAttribute("menus", dao.getAllItems());
		
		}
		else if (action.equalsIgnoreCase("delete")){
			int restaurantID = Integer.parseInt(request.getParameter("restaurantId"));
			String itemName = request.getParameter("itemName");
			dao.deleteMenuItemByRestaurantIDAndItemName(restaurantID, itemName);
			
			forward = LIST_OWNER_MENU_ITEMS;
			List<Menu> menus = dao.getOwnerItems((String)request.getSession().getAttribute("Email"));
			request.setAttribute("menus", menus);
			request.setAttribute("restaurantID", menus.get(0).getRestaurantID());
			request.setAttribute("restaurantName", menus.get(0).getRestaurantName());
			
		}
		else {
			forward = INSERT;
		}

		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves all of the information entered in the form on
		 * the addMenuItem.jsp or the editMenuItem.jsp pages.
		 */
		//System.out.print("test");
		Menu menu = new Menu();
		menu.setRestaurantID(Integer.parseInt(request.getParameter("restaurantId")));
		menu.setRestaurantName(request.getParameter("restaurantName"));
		menu.setItemName(request.getParameter("itemName"));
		menu.setPrice(Double.parseDouble(request.getParameter("price")));
		menu.setCalories(Integer.parseInt(request.getParameter("calories")));
		menu.setCategory(request.getParameter("category"));
		menu.setDietary(request.getParameter("dietary"));
		boolean edit = Boolean.getBoolean(request.getParameter("edit"));
		
		 //System.out.println(request.getParameter("edit"));
		 
		/**
		 * If the edit attribute has been set to false, 
		 * we are adding a new menu item
		 */
		if (!edit) {
			dao.addMenuItem(menu);
			//System.out.println("oops");
		} else {
			/**
			 * Otherwise, the user is editing an existing menu item
			 */
			dao.updateMenuItem(menu);
		}
		/**
		 * Once the Menu Item has been added or updated, the page will redirect to
		 * the listing of Menu Items.
		 */
		RequestDispatcher view = request.getRequestDispatcher(LIST_OWNER_MENU_ITEMS);
		
		List<Menu> menus = dao.getOwnerItems((String)request.getSession().getAttribute("Email"));
		request.setAttribute("menus", menus);
		request.setAttribute("restaurantID", menus.get(0).getRestaurantID());
		request.setAttribute("restaurantName", menus.get(0).getRestaurantName());
		
		view.forward(request, response);
	}
}