package com.target.myRestfulWebservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {
	
	@Id
	private String productId;
	private String  productName;
	
	private Price currentPrice;
	
	public Product() {
		
	}
	
	public Product(String productId, String productName,Price currentPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.currentPrice=currentPrice;
	}
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Price getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Price currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", currentPrice=" + currentPrice
				+ "]";
	}



}
