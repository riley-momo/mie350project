package com.mie.model;

import java.util.Date;

public class Menu {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Menu object.
	 */

	private String itemName;
	private int restaurantID;
	private String restaurantName;
	private double price;
	private int calories;
	private String category;
	private String dietary;
	private int promoKey;
	private int restaurantRating;
	
//	**
	private String ownerEmail;
	
//**
	public String getOwnerEmail(){
	return ownerEmail;
	}
	
	

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String name) {
		this.itemName = name;
	}

	public String getRestaurantName(){
		return restaurantName;
	}
	
	public void setRestaurantName(String name){
		this.restaurantName = name;
	}
	
	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int resID) {
		this.restaurantID = resID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price= price;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int c) {
		this.calories = c;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDietary(){
		return dietary;
	}
	
	public void setDietary(String dietary){
		this.dietary = dietary;
	}
	public int getPromoKey(){
		return promoKey;
	}
	public void setPromoKey(int promoKey){
		this.promoKey = promoKey;
	}
	
	public int getRestaurantRating() {
		return restaurantRating;
	}
	
	public void setRestaurantRating(int restaurantRating) {
		this.restaurantRating = restaurantRating;
	}
}