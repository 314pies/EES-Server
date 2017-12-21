package edu.ntou.cse.softwareengineering.ees;

import java.util.*;

public class ProductManager {
	
	private ArrayList<Cart> historyCartList;
	private Cart myCart;
	
	public void searchCart() {
		//get the list from server
		historyCartList = new ArrayList<Cart>();
	}
	
	public Cart selectCart(int index) {
		if(historyCartList.isEmpty())
			return null;
		else
			if(index >= 0 && index < historyCartList.size())
				return historyCartList.get(index);
			else
				return null;
	}
	
	public void createNewCart() {
		//call server and get the newest cartId
		//int cartId =  
		//Cart myCart(-1, UserAccount.getAccountId());
		myCart = new Cart(Utilities.INVALID, Utilities.INVALID);
	}
	
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
	}
}
