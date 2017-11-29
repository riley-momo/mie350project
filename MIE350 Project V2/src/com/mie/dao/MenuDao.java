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
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO Menu"
					+ "(ItemName,RestaurantID,Price,Calories,Category,DietaryRestrictions)"
					+ " VALUES (?, ?, ?, ?, ?, ? )");
			
			preparedStatement.setString(1, menu.getItemName());
			preparedStatement.setInt(2, menu.getRestaurantID());
			preparedStatement.setDouble(3, menu.getPrice());
			preparedStatement.setInt(4,menu.getCalories());
			preparedStatement.setString(5, menu.getCategory());
			preparedStatement.setString(6, menu.getDietary());
		
			
			preparedStatement.executeUpdate();
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
			String name = menu.getItemName();
			
			String query = "DELETE FROM Menu WHERE ItemName = '" + name + "' AND RestaurantID = " + resID + ";";
			
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
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE Menu SET Price=?, Calories=?, Category=?, DietaryRestrictions=?"
							+ " WHERE ItemName=? AND RestaurantID=?");
			
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery(
//					"SELECT * FROM Menu WHERE ItemName="+ menu.getItemName()+ " AND RestaurantID=" + menu.getRestaurantID()) ;
//			if (!rs.next()){
//				System.out.println("fuck");
//			}
//			
			preparedStatement.setDouble(1, menu.getPrice());
			preparedStatement.setInt(2,menu.getCalories());
			preparedStatement.setString(3, menu.getCategory());
			preparedStatement.setString(4, menu.getDietary());
			preparedStatement.setString(5, menu.getItemName());
			preparedStatement.setInt(6, menu.getRestaurantID());
			
			preparedStatement.executeUpdate();
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
			ResultSet rs = statement.executeQuery("SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Menu.RestaurantID = Restaurant.RestaurantID");
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setItemName(rs.getString("ItemName"));
				menu.setRestaurantName(rs.getString("Name_of_Restaurant"));
				menu.setRestaurantID(rs.getInt("RestaurantID"));
				menu.setPrice(rs.getDouble("Price"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setCategory(rs.getString("Category"));
				menu.setDietary(rs.getString("DietaryRestrictions"));
				menu.setRestaurantRating(rs.getDouble("Rating"));
				menus.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menus;
	}

	
	public List<Menu> getFilteredItems(String price, String calories, String category, String diet){
		System.out.println(price+ " " +calories +" " + category+" " +  diet);
		/**
		 * This method returns the list of menu items 
		 */
		String query = null;
		
		//filter everything
		if(!calories.equals("*") && !category.equals("*") && !diet.equals("*") && !price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Price <= " + price + " AND Calories <= " + calories
					+ " AND DietaryRestrictions = '" + diet + "' AND Category = '" + category + "';";
		}
		
		//filter calories, category, diet
		else if(!calories.equals("*") && !category.equals("*") && !diet.equals("*") && price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Calories <= " + calories
					+ " AND DietaryRestrictions = '" + diet + "' AND Category = '" + category + "';";
		}
		
		//filter calories, category, price
		else if(!calories.equals("*") && !category.equals("*") && diet.equals("*") && !price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Price <= " + price + " AND Calories <= " + calories
					+ "' AND Category = '" + category + "';";
		}
		
		//filter category, diet, price
		else if(calories.equals("*") && !category.equals("*") && !diet.equals("*") && !price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Price <= " + price
					+ " AND DietaryRestrictions = '" + diet + "' AND Category = '" + category + "';";
		}
		
		//filter calories, diet, price
		else if(!calories.equals("*") && category.equals("*") && !diet.equals("*") && !price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Price <= " + price + " AND Calories <= " + calories
					+ " AND DietaryRestrictions = '" + diet + "';";
		}
		
		//filter calories, category
		else if(!calories.equals("*") && !category.equals("*") && diet.equals("*") && price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Calories <= " + calories + "' AND Category = '" + category + "';";
		}

		//filter calories, price
		if(!calories.equals("*") && category.equals("*") && diet.equals("*") && !price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Price <= " + price + " AND Calories <= " + calories + ";";
		}
		
		//filter calories, diet
		if(!calories.equals("*") && category.equals("*") && !diet.equals("*") && price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Calories <= " + calories
					+ " AND DietaryRestrictions = '" + diet + "';";
		}
		
		//filter diet, price
		if(calories.equals("*") && category.equals("*") && !diet.equals("*") && !price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Price <= " + price 
					+ " AND DietaryRestrictions = '" + diet + "';";
		}
		
		//filter category, price
		if(calories.equals("*") && !category.equals("*") && diet.equals("*") && !price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Price <= " + price + " AND Category = '" + category + "';";
		}
		
		//filter category, diet
		if(calories.equals("*") && !category.equals("*") && !diet.equals("*") && price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE DietaryRestrictions = '" + diet + "' AND Category = '" + category + "';";
		}
		
		//filter calories only
		else if(!calories.equals("*") && category.equals("*") && diet.equals("*") && price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Calories <= " + calories + ";";
		}
		
		//filter category only
		else if(calories.equals("*") && !category.equals("*") && diet.equals("*") && price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Category = '" + category + "';";
		}
		
		//filter price only
		else if(calories.equals("*") && category.equals("*") && diet.equals("*") && !price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Price <= " + price + ";";
		}
		
		//filter diet only
		else if(calories.equals("*") && category.equals("*") && !diet.equals("*") && price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE DietaryRestrictions = '" + diet + "';";
		}
	
		//filter nothing
		else if(calories.equals("*") && category.equals("*") && diet.equals("*") && price.equals("*")){
			query = "SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID;" ;
		}
		
		List<Menu> menus = new ArrayList<Menu>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setItemName(rs.getString("ItemName"));
				menu.setRestaurantName(rs.getString("Name_of_Restaurant"));
				menu.setPrice(rs.getDouble("Price"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setCategory(rs.getString("Category"));
				menu.setDietary(rs.getString("DietaryRestrictions"));
				menu.setRestaurantRating(rs.getDouble("Rating"));
				menus.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menus;
	}

	public List<Menu> getOwnerItems(String ownerEmail) {
		/**
		 * This method returns the list of all menu items that a restaurant owner owns
		 * in the form of a List object.
		 */
		List<Menu> menus = new ArrayList<Menu>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE Restaurant.RestaurantID = Menu.RestaurantID AND Restaurant.Owner_Email = '"
					+ ownerEmail + "';");
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setItemName(rs.getString("ItemName"));
				menu.setRestaurantID(rs.getInt("RestaurantID"));
				menu.setRestaurantName(rs.getString("Name_of_Restaurant"));
				menu.setPrice(rs.getDouble("Price"));
				menu.setCalories(rs.getInt("Calories"));
				menu.setCategory(rs.getString("Category"));
				menu.setDietary(rs.getString("DietaryRestrictions"));
				menu.setPromoKey(rs.getInt("PromoKey"));
				menu.setRestaurantRating(rs.getDouble("Rating"));
				menus.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}

	public Menu getMenuItemByRestaurantIDAndItemName(int restaurantID,
			String itemName) {
		Menu menu = new Menu();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM Menu JOIN Restaurant ON Menu.RestaurantID = Restaurant.RestaurantID WHERE RestaurantID = ? AND ItemName = ?");
			preparedStatement.setInt(1, restaurantID);
			preparedStatement.setString(2, itemName);
			
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				menu.setRestaurantID(rs.getInt("RestaurantID"));
				menu.setItemName(rs.getString("ItemName"));
				menu.setRestaurantName(rs.getString("Name_of_Restaurant"));
				if (rs.getInt("Calories") > 0 ){
					menu.setCalories(rs.getInt("Calories"));
				}
				menu.setPrice(rs.getDouble("Price"));
				menu.setCategory(rs.getString("Category"));
				menu.setDietary(rs.getString("DietaryRestrictions"));
				menu.setRestaurantRating(rs.getDouble("Rating"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menu;
	}

	public void deleteMenuItemByRestaurantIDAndItemName(int restaurantID,
			String itemName) {
		/**
		 * This method deletes a menu item from the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE from MENU where RestaurantID=? AND ItemName =?");
			
			preparedStatement.setInt(1, restaurantID);
			preparedStatement.setString(2, itemName);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
	

}