package edu.ntou.cse.softwareengineering.ees;

import java.lang.String;
import java.util.*;

public class Exhibitation {
	
	private int exhibitationID = Utilities.INVALID;
	private String exhibitationName;
	private Date startDate;
	private Date endDate;
	private String exhibitationLocation;
	private String exhibitationMoreInformation;
	private int exhibitationHostID = Utilities.INVALID;
	private ArrayList<Integer> exhibitationBoothes;
	
	public Exhibitation(int _id, String _name, Date _sDate, 
			Date _eDate, String _exLocation, String _mInformation,
			int _hostNum, ArrayList<Integer> _boothes) {
		this.exhibitationID = _id;
		this.exhibitationName = _name;
		this.startDate = _sDate;
		this.endDate = _eDate;
		this.exhibitationLocation = _exLocation;
		this.exhibitationMoreInformation = _mInformation;
		this.exhibitationHostID = _hostNum;
		this.exhibitationBoothes = _boothes;
	}
	
	public int getExhibitationID() {
		return this.exhibitationID;
	}
	
	public String getExhibitatioName() {
		return this.exhibitationName;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public String getExhibitationLocation() {
		return this.exhibitationLocation;
	}
	
	public String getExhibitationMoreInformation() {
		return this.exhibitationMoreInformation;
	}
	
	public int getExhibitationHostID() {
		return this.exhibitationHostID;
	}
	
	public ArrayList<Integer> getExhibitationBoothes(){
		return this.exhibitationBoothes;
	}
	
	public boolean setExhibitation(int _id, String _name, Date _sDate, 
			Date _eDate, String _exLocation, String _mInformation,
			int _hostNum) {
		try {
			this.exhibitationID = _id;
			this.exhibitationName = _name;
			this.startDate = _sDate;
			this.endDate = _eDate;
			this.exhibitationLocation = _exLocation;
			this.exhibitationMoreInformation = _mInformation;
			this.exhibitationHostID = _hostNum;
			return true;
		}catch(Exception epp) {
			return false;
		}
	}
	
	public boolean setExhibitationID(int _ID) {
		this.exhibitationID = _ID;
		return true;
	}
	
	public boolean setExhibitationName(String _exhibitationName) {
		this.exhibitationName = _exhibitationName;
		return true;
	}
	
	public boolean setStartDate(Date _startDate) {
		this.startDate = _startDate;
		return true;
	}
	
	public boolean setEndDate(Date _endDate) {
		this.endDate = _endDate;
		return true;
	}
	
	public boolean setExhibitationLocation(String _exhibitationPlace) {
		this.exhibitationLocation = _exhibitationPlace;
		return true;
	}
	
	public boolean setExhibitationMoreInformation(String _exhibitationMoreInformation) {
		this.exhibitationMoreInformation = _exhibitationMoreInformation;
		return true;
	}
	
	public boolean setExhibitationHostID(int _hostID) {
	    this.exhibitationHostID = _hostID;
	    return true;
	}
	
	public void deleteExhibitation() {
		this.exhibitationID = Utilities.INVALID;
		this.exhibitationName = "";
		this.exhibitationLocation = "";
		this.exhibitationMoreInformation = "";
		this.exhibitationHostID = Utilities.INVALID;
		this.exhibitationBoothes.clear();
	}
	
	public boolean createBooth(ArrayList<Integer> _boothes) {
		this.exhibitationBoothes = _boothes;
		return true;
	}
	//?
	public boolean setBooth(ArrayList<Integer> _boothes) {
		this.exhibitationBoothes.addAll(_boothes);
		return true;
	}
	
	public boolean isValid() {
		if(this.exhibitationID == Utilities.INVALID ||
		   this.exhibitationName == "" ||
		   this.exhibitationLocation == "" ||
		   this.exhibitationMoreInformation == "" ||
		   this.exhibitationHostID == Utilities.INVALID) {
			return false;
		}else return true;
	}
}
