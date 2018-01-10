package edu.ntou.cse.softwareengineering.ees;

import java.util.*;

public class Order implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int orderId = Utilities.INVALID;
	private int userId = Utilities.INVALID;
	private int productId = Utilities.INVALID;
	private int ammount = Utilities.INVALID;
	private int price = Utilities.INVALID;
	private String time;
	
	public Order(int orderId, int userId) {
		if(orderId != Utilities.INVALID && userId != Utilities.INVALID)
		{
			this.orderId = orderId;
			this.userId = userId;
		}
		time = new Date().toString();
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getAmmount() {
		return ammount;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime() {
		time = new Date().toString();
	}
	
	public boolean setProduct(Product product){
		if(product.isValid())
		{
			this.productId = product.getProductId();
			this.ammount = 1;
			this.price = product.getPrice();
			setTime();
			return true;
		}
		return false;
	}
	
	public boolean setProduct(Product product, int ammount){
		if(product.isValid())
		{
			this.productId = product.getProductId();
			this.ammount = ammount;
			this.price = product.getPrice();
			setTime();
			return true;
		}
		return false;
	}
	
	public void clear(){
		this.productId = Utilities.INVALID;
		this.ammount = Utilities.INVALID;
		this.price = Utilities.INVALID;
		setTime();
	}
	
	public boolean isValid() {
		if(orderId == Utilities.INVALID || 
			userId == Utilities.INVALID ||
			productId == Utilities.INVALID ||
			ammount <= 0 ||
			price <= 0)
			return false;
		return true;
	}
}
