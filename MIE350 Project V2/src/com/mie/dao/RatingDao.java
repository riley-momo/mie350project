package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mie.model.Menu;
import com.mie.model.Restaurant;
import com.mie.model.StudentUser;
import com.mie.model.User;
import com.mie.util.DbUtil;

public class RatingDao {
	/**
	 * This class handles all of rating-related methods
	 */

	private Connection connection;

	public RatingDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public boolean isValid(User user, int restaurantID) {
		boolean result = false;
		try {
			String email = user.getEmail();
			//check if the rating exists
			String query = "SELECT * FROM Rating WHERE email = " + email + " AND RestaurantID = " + restaurantID;
			Statement stmt;
			stmt = connection.createStatement();
			stmt.execute(query);
			ResultSet rs = stmt.executeQuery(query);
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void addRating(StudentUser student, Restaurant res, int rating) {
		/**
		 * This method adds a new rating to the database
		 */
		try {
			int studentID = student.getUserID();
			int resID = res.getResID();
	
//			//check if the rating exists
//			String query = "SELECT * FROM Rating WHERE UserID = " + studentID + " AND RestaurantID = " + resID;
//			Statement stmt = connection.createStatement();
//			stmt.execute(query);

			//if the rating for one restaurant has already been added by an user, an error will be raised and this action will fail
			String query = "INSERT INTO Rating VALUES (" + studentID + ", " + resID
					+ ", " + rating + ");";
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public int getRating(StudentUser student, Restaurant res, int rating){
		/**
		 * This method retrieves existing rating a user did on a restaurant
		 */
		int existingRating = (Integer) null;
		try {
			int studentID = student.getUserID();
			int resID = res.getResID();
			
			String query = "SELECT Rating From Rating WHERE UserID = " + studentID +" AND RestaurantID = " + resID;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				existingRating = rs.getInt("Rating");
			}
		
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return existingRating;
	}
	
	public void deleteRating(StudentUser student, Restaurant res, int rating){
		/**
		 * This method deletes existing rating a user did on a restaurant
		 */
		try {
			int studentID = student.getUserID();
			int resID = res.getResID();
			
			String query = "DELECT FROM Rating WHERE UserID = " + studentID +" AND RestaurantID = " + resID;
			Statement stmt = connection.createStatement();
			stmt.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}


}
