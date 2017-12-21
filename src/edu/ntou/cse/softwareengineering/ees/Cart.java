package edu.ntou.cse.softwareengineering.ees;

import java.lang.String;
import java.util.*;

public class Cart {
	
	private final int INVALID = -1;
	private int cartId = INVALID;
	private int userId = INVALID;
	private ArrayList<Integer> productIdList;
	private ArrayList<Integer> ammountList;
	private ArrayList<Integer> priceList;
	private Date time;
	
	public Cart(int cartId, int userId) {
		if(cartId != INVALID && userId == INVALID)
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
	
	public boolean setAmmountList(ArrayList<Integer> ammountList){
		if(ammountList != null) {
			this.ammountList = ammountList;
			return true;
		}
		return false;
	}
	
	public boolean setPriceList(ArrayList<Integer> priceList){
		if(priceList != null) {
			this.priceList = priceList;
			return true;
		}
		return false;
	}
	
	public boolean setProductIdList(ArrayList<Integer> productIdList){
		if(productIdList != null) {
			this.productIdList = productIdList;
			return true;
		}
		return false;
	}
}
