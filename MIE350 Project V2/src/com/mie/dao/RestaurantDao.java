package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.util.DbUtil;
import com.mie.model.Menu;
import com.mie.model.Restaurant;

public class RestaurantDao {
	/**
	 * This class handles all of the user-related methods
	 * (add/update/delete/get).
	 */

	private Connection connection;

	public RestaurantDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	
	//should only be accessed by the owner. 
	public void changeAddress(Restaurant res){
		/**
		 * This method updates the address of a restaurant
		 */
		try {
			
			int resID = res.getResID(); 
			String address = res.getAddress();
			String query = "UPDATE Restaurant SET Address = '" + address + "' WHERE RestaurantID = " + resID + ";";
			
			Statement stmt = connection.createStatement();
			stmt.execute(query);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	//should only be accessed by the owner. 
	public void changeRestaurantName(Restaurant res){
		/**
		 * This method updates the name of a restaurant
		 */
		try {
			int resID = res.getResID();
			String name = res.getName();
			String query = "UPDATE Restaurant SET Name_of_Restaurant = '" + name + "' WHERE RestaurantID = " + resID + ";";
			
			Statement stmt = connection.createStatement();
			stmt.execute(query);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//should only be accessed by the owner. 
	public void changePaymentMethod(Restaurant res){
		/**
		 * This method updates the payment methods available in a restaurant
		 */
		try{
			int resID = res.getResID();
			String[] methods = res.getPaymentMethod();
			StringBuilder sb = new StringBuilder();
			for(int i =0; i < methods.length; i++){
				sb.append(methods[i]).append(",");
			}
			sb.setLength(sb.length() - 1);
			String newMethods = sb.toString();
			String query = "UPDATE Restaurant SET Payment_Method = '" + newMethods + "' WHERE RestaurantID = " + resID + ";";
			
			Statement stmt = connection.createStatement();
			stmt.execute(query);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//should only be accessed by the owner. 
	public void changeCuisineType(Restaurant res){
		/**
		 * This method updates the cuisine type of the restaurant
		 */
		try {
			int resID = res.getResID();
			String type = res.getCuisineType();
			String query = "UPDATE Restaurant SET CuisineType = '" + type + "' WHERE RestaurantID = " + resID + ";";
			
			Statement stmt = connection.createStatement();
			stmt.execute(query);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//should only be accessed by the owner. 
	public void changeDietaryRestriction(Restaurant res){
		/**
		 * This method updates the dietary restrictions available for the restaurant
		 */
		try {
			int resID = res.getResID();
			String diet = res.getDietary();
			String query = "UPDATE Restaurant SET Dietary_Restrictions = '" + diet + "' WHERE RestaurantID = " + resID + ";";
			
			Statement stmt = connection.createStatement();
			stmt.execute(query);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// should only be accessed by the owner.
		public void changeDineInOption(Restaurant res){
			/**
			 * This method updates the dietary restrictions available for the restaurant
			 */
			try {
				int resID = res.getResID();
				boolean dineIn = res.getDineIn();
				String query = "UPDATE Restaurant SET Dine_In = '" + dineIn + "' WHERE RestaurantID = " + resID + ";";
				
				Statement stmt = connection.createStatement();
				stmt.execute(query);
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	// should only be accessed by the administrator.
//	public void changeOwner(Restaurant res){
//		/**
//		 * This method updates the dietary restrictions available for the restaurant
//		 */
//		try {
//			int resID = res.getResID();
//			int OwnerID = res.getOwnerID();
//			String query = "UPDATE Restaurant SET Owner_ID = " + OwnerID + "WHERE RestaurantID = " + resID + ";";
//			
//			Statement stmt = connection.createStatement();
//			stmt.execute(query);
//	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
