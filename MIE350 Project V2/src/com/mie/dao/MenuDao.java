package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mie.model.Menu;
import com.mie.util.DbUtil;

public class MenuDao {
	/**
	 * This class handles all of the user-related methods
	 * (add/update/delete/get).
	 */

	private Connection connection;

	public MenuDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	//need to make sure only owners can access this method
	public void addMenuItem(Menu menu) {
		/**
		 * This method adds a new menu item to the database.
		 */
		try {
			int resID = menu.getRestaurantID();
			String name = menu.getName();
			int calories = menu.getCalories();
			String category = menu.getCategory();
			String diet = menu.getDietary();
			double price = menu.getPrice();
			int promoKey = menu.getPromoKey();

			String query = "INSERT INTO MENU VALUES (" + name + ", " + resID + ", " + price + ", " +
							calories + ", " + category + ", " + diet + ", " + promoKey + ");" ;
			
			//if the menu item already exists, an error will be raised and this action will fail
			
			Statement stmt = connection.createStatement();
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}	

	//only owner can access
	public void deleteMenuItem(Menu menu){
		/**
		 * This method deletes a menu item (based on its restaurant ID and name of item)
		 * from the database.
		 */
		try{
			int resID = menu.getRestaurantID();
			String name = menu.getName();
			
			String query = "DELETE FROM Menu WHERE Name = '" + name + "' AND RestaurantID = " + resID + ";";
			
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//only owner can access
	public void updateMenuItem(Menu menu) {
		/**
		 * This method updates a menu item (based on its restaurant ID and name of item)
		 * into the database.
		 */
		try{
			int resID = menu.getRestaurantID();
			String name = menu.getName();
			
			int calories = menu.getCalories();
			String category = menu.getCategory();
			String diet = menu.getDietary();
			double price = menu.getPrice();
			int promoKey = menu.getPromoKey();
			
			
			String query = "UPDATE Menu SET Price = "+ price + 
					", Category = '" + category + "', Calories = " + calories + ", DietaryRestrictions = '" + 
					diet + "', promoKey = "+ promoKey + " WHERE RestaurantID = " + resID + " AND ItemName = '"
					+ name +"';";
			
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Menu> getAllItems() {
		/**
		 * This method returns the list of all menu items in the form of a List
		 * object.
		 */
		List<Menu> menus = new ArrayList<Menu>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Menu");
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setName(rs.getString("ItemName"));
				menu.setRestaurantID(rs.getInt("RestaurantID"));
				menu.setPrice(rs.getDouble("Price"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setCategory(rs.getString("Category"));
				menu.setDietary(rs.getString("DietaryRestrictions"));
				
				menus.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menus;
	}

	
	public List<Menu> getFilteredItems(String query){
	
		/**
		 * This method returns the list of menu items according to the supplied query
		 */
		List<Menu> menus = new ArrayList<Menu>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setName(rs.getString("ItemName"));
				menu.setRestaurantID(rs.getInt("RestaurantID"));
				menu.setPrice(rs.getDouble("Price"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setCategory(rs.getString("Category"));
				menu.setDietary(rs.getString("DietaryRestrictions"));
				
				menus.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menus;
	}

	

}