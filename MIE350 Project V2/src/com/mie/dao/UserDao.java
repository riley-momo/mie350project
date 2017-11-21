package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.util.DbUtil;
import com.mie.model.*;
import com.mie.controller.*;

import com.mie.util.*;

public class UserDao {

	/**
	 * This class handles the Student and Owner User objects and the login component of the web
	 * app.
	 */
	static Connection currentCon = null;
	static ResultSet rs = null;

	public UserDao() {
		/**
		 * Get the database connection.
		 */
		currentCon = DbUtil.getConnection();
	}
	
	/**
	 * This method attempts to find the student user that is trying to log in by
	 * first retrieving the username and password entered by the user.
	 */
	public static User login(User user) {
		
		Statement stmt = null;

		String email = user.getEmail();
		String password = user.getPassword();

		/**
		 * Prepare a query that searches the Users table in the database
		 * with the given username and password.
		 */
		String searchStudentUserQuery = "SELECT * FROM Student WHERE Email = '"
				+ email + "' AND Password = '" + password + "';";

		String searchOwnerQuery = "SELECT * FROM Owner WHERE Email = '"
				+ email + "' AND Password = '" + password + "';";
		
		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			
			//first check if this user is a student
			rs = stmt.executeQuery(searchStudentUserQuery);
			boolean more = rs.next();

			/**
			 * If there are no results from the query, set the member to false.
			 * The person attempting to log in will be redirected to the home
			 * page when isValid is false.
			 */
			
			//user is not a student
			if (!more) {
				user.setIsStudent(false);
				
				Statement stmt2 = currentCon.createStatement();
				
				// if this user is not a student, check if the user is an owner
				rs = stmt2.executeQuery(searchOwnerQuery);
				boolean more2 = rs.next();
				
				//not an owner or a student
				if(!more2){
					user.setIsRestaurantOwner(false);
				}
				
				//user is a restaurant owner
				else if(more2){
					String nameOfOwner = rs.getString("NameOfOwner");
					user.setNameOfUser(nameOfOwner);
					user.setIsRestaurantOwner(true);
				}
				
			}

			/**
			 * If the query results in an database entry that matches the
			 * username and password, assign the appropriate information to
			 * the Member object.
			 */
			else if (more) {
				String nameOfStudent = rs.getString("NameOfStudent");
				user.setNameOfUser(nameOfStudent);
				user.setIsStudent(true);
				user.setIsRestaurantOwner(false);
				
				
			}
		}
		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		/**
		 * Return the user object.
		 */
		return user;
	}
	
}
