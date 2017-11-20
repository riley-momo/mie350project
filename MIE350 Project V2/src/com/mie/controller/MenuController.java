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
	private static String INSERT = "/addStudent.jsp";
	private static String EDIT = "/editMenuItems.jsp";
	private static String LIST_MENU_ITEMS = "/listMenuItems.jsp";
	private static String DELETE = "/deleteMenu.jsp";

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
		 * 
		 * - delete will direct the servlet to let the user delete a student in
		 * the database. - insert will direct the servlet to let the user add a
		 * new student to the database. - edit will direct the servlet to let
		 * the user edit student information in the database. - listStudent will
		 * direct the servlet to the public listing of all students in the
		 * database. - listStudentAdmin will direct the servlet to the admin
		 * listing of all students in the database.
		 */
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			forward = DELETE; //change in JSP
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
		} else if (action.equalsIgnoreCase("edit")) {
			forward = EDIT;
		} else if (action.equalsIgnoreCase("listRestaurant")) {
			forward = LIST_MENU_ITEMS;
			request.setAttribute("menus", dao.getAllItems());
		}
		else {
			forward = INSERT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}


}