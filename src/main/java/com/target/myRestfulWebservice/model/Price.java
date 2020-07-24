package com.target.myRestfulWebservice.model;


public class Price {

	private int priceValue;
	private String currency;
	
	public Price() {
		
	}
	
	public Price(int priceValue, String currency) {
		super();
		this.priceValue = priceValue;
		this.currency = currency;
	}
	
	public int getPriceValue() {
		return priceValue;
	}
	public void setPriceValue(int priceValue) {
		this.priceValue = priceValue;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
