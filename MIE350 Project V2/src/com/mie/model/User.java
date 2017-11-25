package com.mie.model;

public class User {

	private String nameOfUser;
	private String email;
	private String password;
	private boolean isStudent;
	private boolean isRestaurantOwner;
	
	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String name) {
		this.nameOfUser = name;
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String newEmail){
		email = newEmail;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String newPassword){
		password = newPassword;
	}
	
	public boolean isStudent(){
		return isStudent;
	}
	
	public void setIsStudent(boolean answer){
		isStudent = answer;
	}
	
	public boolean isRestaurantOwner(){
		return isRestaurantOwner;
	}
	
	public void setIsRestaurantOwner(boolean answer){
		isRestaurantOwner = answer;
	}
	
	//allows the user information to be printed to the screen
	@Override
	public String toString() {
		
		if(isRestaurantOwner){
			return "Owner [ Name of User = " + nameOfUser + ", Email = " + email +
					", Password = " + password + "]";
		}
		else if (isStudent){
			return "Student [Name of User = " + nameOfUser + ", Email = " + email +
					", Password = " + password + "]";
		}
		else return "Not sure if this user is a student or an owner";
	}
}

