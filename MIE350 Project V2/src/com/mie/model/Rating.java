package com.mie.model;

public class Rating {
 
	
	// not sure if a rating object is the best approach, may change later!!
	 
	
	
	//one student user may only rate a restaurant once
	private StudentUser student;
	private int rating;
	private Restaurant restaurant;
	
	public void setRating(int newRating){
		rating = newRating;
	}
	
	public int getRating(){
		return rating;
	}
	
	
}
