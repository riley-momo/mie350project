package com.mie.model;

import java.util.Date;

public class Menu {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Student object.
	 */

	private String name;
	private int restaurantID;
	private double price;
	private int calories;
	private String category;
	private String dietary;
	private int promoKey;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
	//TODO
		return "";
	}
}