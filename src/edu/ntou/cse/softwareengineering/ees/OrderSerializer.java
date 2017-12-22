package edu.ntou.cse.softwareengineering.ees;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class OrderSerializer implements JsonSerializer<Order>
{
	@Override
	//This method gets involved whenever the parser encounters the KeelungSights
	public JsonElement serialize(Order src, Type T, JsonSerializationContext context)
	{
		JsonObject object = new JsonObject();

		/*
		private int orderId = Utilities.INVALID;
		private int userId = Utilities.INVALID;
		private int productId = Utilities.INVALID;
		private int ammount = Utilities.INVALID;
		private int price = Utilities.INVALID;
		private Date time;
		 */
		
		int orderId = src.getOrderId();
		int userId = src.getUserId();
		int productId = src.getProductId();
		int ammount = src.getAmmount();
		int price = src.getPrice();
		String time = src.getTime();
		
		object.addProperty("orderId", orderId);
		object.addProperty("userId", userId);
		object.addProperty("productId", productId);
		object.addProperty("ammount", ammount);
		object.addProperty("price", price);
		object.addProperty("time", time);
		
		//create the json object for the Order and return back to the Gson serializer
		
		return object;
	}
}
