package edu.ntou.cse.softwareengineering.ees;

import java.lang.String;
import java.util.*;

public class Product {

	private int productId = Utilities.INVALID;
	private int holderId = Utilities.INVALID;
	private String productName;
	private String description;
	private int price = Utilities.INVALID;
	private ArrayList<String> tags;
	
	public Product(int productId, int holderId, String productName, String description,
			int price, ArrayList<String> tags) 
	{
		if(productId != Utilities.INVALID && holderId != Utilities.INVALID)
		{
			this.productId = productId;
			this.holderId = holderId;
			this.productName = productName;
			this.description = description;
			this.price = price;
			this.tags = tags;
		}
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getHolderId() {
		return holderId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public ArrayList<String> getTags(){
		return tags;
	}
	
	public boolean setProductName(String productName) {
		if(productName != null && productName != "")
		{
			this.productName = productName;
			return true;
		}
		return false;
	}
	
	public boolean setDescription(String description) {
		if(description != null && description != "")
		{
			this.description = description;
			return true;
		}
		return false;
	}
	
	public boolean setPrice(int price) {
		if(price >= 0)
		{
			this.price = price;
			return true;
		}
		return false;
	}
	
	public boolean setTags(ArrayList<String> tags) {
		if(tags != null)
		{
			this.tags = tags;
			return true;
		}
		return false;
	}
	
	public boolean isValid() {
		if(productId == Utilities.INVALID || holderId == Utilities.INVALID || productName == "")
			return false;
		return true;
	}
}
