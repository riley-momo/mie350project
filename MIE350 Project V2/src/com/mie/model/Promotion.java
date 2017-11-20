package com.mie.model;

import java.sql.Date;

public class Promotion {

	private int promoKey;
	private Date startDate;
	private Date endDate;
	private double promoPrice;
	
	public int getPromoKey() {
		return promoKey;
	}

	public void setPromoKey(int newPromoKey) {
		this.promoKey = newPromoKey;
	}
	
	public Date getStartDate(){
		return startDate;
	}
	
	public Date getEndDate(){
		return endDate;
	}
	
	public void setStartDate(Date newStartDate){
		startDate = newStartDate;
	}
	
	public void setEndDate(Date newEndDate){
		endDate = newEndDate;
	}
	
	public double getPromoPrice(){
		return promoPrice;
	}
	
	public void setPromoPrice(double newPromoPrice){
		promoPrice = newPromoPrice;
	}
}
