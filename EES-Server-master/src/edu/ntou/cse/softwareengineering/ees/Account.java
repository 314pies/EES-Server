package edu.ntou.cse.softwareengineering.ees;

import java.lang.String;
import java.util.*;

public class Account {
	
	private int accountId = Utilities.INVALID;
	private String email;
	private String password;
	private String displayName;
	private Date birthday;
	private boolean isMale;
	private boolean initialized = false;
	private ArrayList<Integer> exhibitionHolder;
	private ArrayList<Integer> boothHolder;
	
	public Account(String email, String password, String displayName, Date birthday, boolean isMale)
	{
		if(email != null && email != "" && password != null && password != "")
		{
			this.email = email;
			this.password = password;
			this.displayName = displayName;
			this.birthday = birthday;
			this.isMale = isMale;
		}
	}
	
	public void setAccountId(int accountId) {
		if(!initialized)
		{
			this.accountId = accountId;
			initialized = true;
		}

	}
	
	public boolean setPassword(String password, String repeatedPassword)
	{
		if(password.equals(repeatedPassword))
		{
			this.password = password;
			return true;
		}
		return false;
	}
	
	public boolean setDisplayName(String displayName)
	{
		if(!displayName.isEmpty())
		{
			this.displayName = displayName;
			return true;
		}
		return false;
	}
	
	public boolean setBirthday(Date birthday)
	{
		if(birthday.before(new Date()))
		{
			this.birthday = birthday;
			return true;
		}
		return false;
	}
	
	public void setGender(boolean isMale)
	{
		this.isMale = isMale;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public boolean getGender() {
		return isMale;
	}
	
	public void setExhibitionHolder(int exhibitionId) {
		exhibitionHolder.add(exhibitionId);
	}
	
	public void setBoothHolder(int boothId) {
		boothHolder.add(boothId);
	}
}
