package com.mie.model;

public class User {

	private int ID;
	private String nameOfUser;
	private String email;
	private String password;
	
	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String name) {
		this.nameOfUser = name;
	}

	public int getUserID() {
		return ID;
	}

	public void setUserID(int newUserID) {
		this.ID = newUserID;
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
}
