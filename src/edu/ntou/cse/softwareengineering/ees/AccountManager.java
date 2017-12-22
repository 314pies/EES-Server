package edu.ntou.cse.softwareengineering.ees;

import java.lang.String;
import java.util.*;

public class AccountManager {
	
	//access account by AccountManager.Singleton.account
	public static AccountManager Singleton;
	public static Account account;
	public AccountManager() {
		Singleton = this;
	}
	
	public boolean CreateAccount(String email, String password, String repeatedPassword, 
			String displayName, Date birthday, boolean isMale) {
		if(email.isEmpty() || password.isEmpty() || birthday.after(new Date()))
			return false;
		if(password.equals(repeatedPassword))
		{
			//invoke server create account
			//if true get accountId from server
			int accountId = -1;
			account = new Account(email, password, displayName, birthday, isMale);
			account.setAccountId(accountId);
			return true;
		}
		return false;
	}
	
	public boolean login(String email, String password) {
		if(!email.isEmpty() && !password.isEmpty())
		{
			//invoke server login
			//get data from server
			//account = new Account(email, password, displayName, birthday, isMale);
			//account.setAccountId(accountId);
			setAdmin();
			return true;
		}
		return false;
	}
	
	public void logout() {
		account = null;
	}
	
	public boolean setPassword(String password, String repeatedPassword)
	{
		return account.setPassword(password, repeatedPassword);
	}
	
	public boolean setDisplayName(String displayName) {
		return account.setDisplayName(displayName);
	}
	
	public boolean setBirthday(Date birthday) {
		return account.setBirthday(birthday);
	}
	
	public void setGender(boolean isMale) {
		account.setGender(isMale);
	}
	
	private void setAdmin() {
		//invoke server to check admin of the exhibition or booth
		//server return exhibition list
		//ArrayList<Integer> exhibitionList = new ArrayList<Integer>();
		//for(int exhibitionId : exhibitionList) {
		//	account.setExhibitionHolder(exhibitionId);
		//}
		
		//server return booth list
		//ArrayList<Integer> boothList = new ArrayList<Integer>();
		//for(int boothId: boothList) {
		//account.setBoothHolder(boothId);
	}
}
