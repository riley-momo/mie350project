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
	
	public void addRating(User student, int restaurantID, int rating) {
		/**
		 * This method adds a new rating to the database
		 */
		try {
			//Insert the user's rating in to the rating table
			String email = student.getEmail();
			String query = "INSERT INTO Rating VALUES (" + email + ", " + restaurantID
					+ ", " + rating + ");";
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			
			//Get the average rating from the rating table
			query = "SELECT AVG(Rating) AS avgRating FROM Rating WHERE RestaurantID = " + restaurantID + ";";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			rating = rs.getInt("avgRating");	
			
			//Update the restaurant table with the new rating
			query = "UPDATE Restaurant SET Rating = " + rating + " WHERE RestaurantID = " + restaurantID + ";";
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
