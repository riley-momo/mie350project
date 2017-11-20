package com.mie.model;

public class Restaurant {

	private String name;
	private int restaurantID;
	private String address;
	private String[] paymentMethod;
	private String cuisineType;
	private double rating;
	private String dietary;
	private boolean dineIn;
	private int ownerID;
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public int getResID(){
		return restaurantID;
	}
	
	public void setRestaurantID(int resID) {
		this.restaurantID = resID;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String newAddress){
		address = newAddress;
	}
	
	public String[] getPaymentMethod(){
		return paymentMethod;
	}
	
	public void setPaymentMethod(String[] newPaymentMethod){
		paymentMethod = newPaymentMethod;
	}
	
	public String getCuisineType(){
		return cuisineType;
	}
	
	public void setCuisineType(String newCuisineType){
		cuisineType = newCuisineType;
	}
	
	public double getRating(){
		return rating;
	}
	
	public void setRating(double newRating){
		rating = newRating;
	}
	
	public String getDietary(){
		return dietary;
	}
	
	public void setDietary(String newDietary){
		this.dietary = newDietary;
	}
	
	public void setDineIn(boolean newDineIn){
		dineIn = newDineIn;
	}
	
	public boolean getDineIn(){
		return dineIn;
	}
	
	public void setOwnerID(int newOwnerID){
		ownerID = newOwnerID;
	}
	
	public int getOwnerID(){
		return ownerID;
	}
}
