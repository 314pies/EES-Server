package edu.ntou.cse.softwareengineering.ees;

import java.util.*;

public class Cart {
	
	private int cartId = Utilities.INVALID;
	private int userId = Utilities.INVALID;
	private ArrayList<Integer> productIdList;
	private ArrayList<Integer> ammountList;
	private ArrayList<Integer> priceList;
	private Date time;
	
	public Cart(int cartId, int userId) {
		if(cartId != Utilities.INVALID && userId == Utilities.INVALID)
		{
			this.cartId = cartId;
			this.userId = userId;
		}
		productIdList = new ArrayList<Integer>();
		ammountList = new ArrayList<Integer>();
		priceList = new ArrayList<Integer>();
		time = new Date();
	}
	
	public int getCartId() {
		return cartId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public ArrayList<Integer> getProductIdList() {
		return productIdList;
	}
	
	public ArrayList<Integer> getAmmountList() {
		return ammountList;
	}
	
	public ArrayList<Integer> getPriceList() {
		return priceList;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime() {
		time = new Date();
	}
	
	public boolean addProduct(Product product){
		if(product.isValid())
		{
			productIdList.add(product.getProductId());
			ammountList.add(1);
			priceList.add(product.getPrice());
			setTime();
			return true;
		}
		return false;
	}
	
	public boolean addProduct(Product product, int ammount){
		if(product.isValid())
		{
			productIdList.add(product.getProductId());
			ammountList.add(ammount);
			priceList.add(product.getPrice());
			setTime();
			return true;
		}
		return false;
	}
	
	public boolean removeProduct(int index){
		if(index >= 0 && index < productIdList.size() && !productIdList.isEmpty())
		{
			productIdList.remove(index);
			ammountList.remove(index);
			priceList.remove(index);
			setTime();
			return true;
		}
		return false;
	}
	
	public void clearCart() {
		productIdList.clear();
		ammountList.clear();
		priceList.clear();
		setTime();
	}
}
