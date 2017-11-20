package com.mie.model;

public class StudentUser extends User{

	private String dietary;
	
	public String getDietaryRestriction(){
		return dietary;
	}
	
	public void setDietaryRestriction(String dietRes){
		dietary = dietRes;
	}
}
