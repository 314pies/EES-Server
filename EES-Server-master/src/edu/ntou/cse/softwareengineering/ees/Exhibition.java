package edu.ntou.cse.softwareengineering.ees;

import java.lang.String;
import java.util.*;

public class Exhibition {
	
	private int exhibitionID = Utilities.INVALID;
	private String exhibitionName;
	private Date startDate;
	private Date endDate;
	private String exhibitionLocation;
	private String exhibitionMoreInformation;
	private int exhibitionHostID = Utilities.INVALID;
	private ArrayList<Integer> exhibitionBoothes;
	
	public Exhibition(int _id, String _name, Date _sDate, 
			Date _eDate, String _exLocation, String _mInformation,
			int _hostNum, ArrayList<Integer> _boothes) {
		this.exhibitionID = _id;
		this.exhibitionName = _name;
		this.startDate = _sDate;
		this.endDate = _eDate;
		this.exhibitionLocation = _exLocation;
		this.exhibitionMoreInformation = _mInformation;
		this.exhibitionHostID = _hostNum;
		this.exhibitionBoothes = _boothes;
	}
	
	public int getExhibitionID() {
		return this.exhibitionID;
	}
	
	public String getExhibitionName() {
		return this.exhibitionName;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public String getExhibitionLocation() {
		return this.exhibitionLocation;
	}
	
	public String getExhibitionMoreInformation() {
		return this.exhibitionMoreInformation;
	}
	
	public int getExhibitionHostID() {
		return this.exhibitionHostID;
	}
	
	public ArrayList<Integer> getExhibitionBoothes(){
		return this.exhibitionBoothes;
	}
	
	public boolean setExhibition(int _id, String _name, Date _sDate, 
			Date _eDate, String _exLocation, String _mInformation,
			int _hostNum) {
		try {
			this.exhibitionID = _id;
			this.exhibitionName = _name;
			this.startDate = _sDate;
			this.endDate = _eDate;
			this.exhibitionLocation = _exLocation;
			this.exhibitionMoreInformation = _mInformation;
			this.exhibitionHostID = _hostNum;
			return true;
		}catch(Exception epp) {
			return false;
		}
	}
	
	public boolean setExhibitionID(int _ID) {
		this.exhibitionID = _ID;
		return true;
	}
	
	public boolean setExhibitionName(String _exhibitionName) {
		this.exhibitionName = _exhibitionName;
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
	
	public boolean setExhibitionLocation(String _exhibitionPlace) {
		this.exhibitionLocation = _exhibitionPlace;
		return true;
	}
	
	public boolean setExhibitionMoreInformation(String _exhibitionMoreInformation) {
		this.exhibitionMoreInformation = _exhibitionMoreInformation;
		return true;
	}
	
	public boolean setExhibitionHostID(int _hostID) {
	    this.exhibitionHostID = _hostID;
	    return true;
	}
	
	public void deleteExhibition() {
		this.exhibitionID = Utilities.INVALID;
		this.exhibitionName = "";
		this.exhibitionLocation = "";
		this.exhibitionMoreInformation = "";
		this.exhibitionHostID = Utilities.INVALID;
		this.exhibitionBoothes.clear();
	}
	
	public boolean createBooth(ArrayList<Integer> _boothes) {
		this.exhibitionBoothes = _boothes;
		return true;
	}
	//?
	public boolean setBooth(ArrayList<Integer> _boothes) {
		this.exhibitionBoothes.addAll(_boothes);
		return true;
	}
	
	public boolean isValid() {
		if(this.exhibitionID == Utilities.INVALID ||
		   this.exhibitionName == "" ||
		   this.exhibitionLocation == "" ||
		   this.exhibitionMoreInformation == "" ||
		   this.exhibitionHostID == Utilities.INVALID) {
			return false;
		}else return true;
	}
}
