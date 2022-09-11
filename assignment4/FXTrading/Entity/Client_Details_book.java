package com.finzly.assignment4.FXTrading.Entity;


public class Client_Details_book {
	
	private String bookingConfirmation;
	private String name;
	private String currencypair;
	private double amount;
	private String getrate;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getBookingConfirmation() {
		return bookingConfirmation;
	}
	public void setBookingConfirmation(String bookingConfirmation) {
		this.bookingConfirmation = bookingConfirmation;
	}
	public String getCurrencypair() {
		return currencypair;
	}
	public void setCurrencypair(String currencypair) {
		this.currencypair = currencypair;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	public String getGetrate() {
		return getrate;
	}
	public void setGetrate(String getrate) {
		this.getrate = getrate;
	}
	
	
	
	
	
	
	

}
