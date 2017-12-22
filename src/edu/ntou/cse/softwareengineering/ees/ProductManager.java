package edu.ntou.cse.softwareengineering.ees;

import java.util.*;

public class ProductManager {
	
	private ArrayList<Order> historyOrderList;
	private Order myOrder;
	
	public void searchOrder() {
		//get the list from server
		historyOrderList = new ArrayList<Order>();
	}
	
	public Order selectOrder(int index) {
		if(historyOrderList.isEmpty())
			return null;
		else
			if(index >= 0 && index < historyOrderList.size())
				return historyOrderList.get(index);
			else
				return null;
	}
	
	public void createNewOrder() {
		//call server and get the newest orderId
		//int orderId =  
		//Order myOrder(-1, UserAccount.getAccountId());
		myOrder = new Order(Utilities.INVALID, Utilities.INVALID);
	}
	
	public void setOrder(Product product) {
		myOrder.setProduct(product);
	}
	
	public void setOrder(Product product, int ammount) {
		myOrder.setProduct(product, ammount);
	}
	
	public void submitOrder() {
		if(myOrder.isValid())
		{
			//invoke server submit order
			killOrder();
		}
	}
	
	//Clear the product, won't clear the orderId and userId
	public void clearCart() {
		myOrder.clear();
	}
	
	//Kill order object
	public void killOrder() {
		myOrder = null;
	}
	
	/*
	public void insertProductToCart(Product product) {
		if(product.isValid())
			myCart.addProduct(product);
	}
	
	public void insertProductToCart(Product product, int ammount) {
		if(product.isValid())
			myCart.addProduct(product, ammount);
	}
	
	public void checkoutCart() {
		myCart.setTime();
		//invoke the server function of the submit cart
		myCart = null;
	}
	
	//Clear the cart, but user cartId won't clear
	public void clearCart() {
		myCart.clearCart();;
	}
	
	//Kill the cart object
	public void cancelCart() {
		myCart = null;
	}*/
}
