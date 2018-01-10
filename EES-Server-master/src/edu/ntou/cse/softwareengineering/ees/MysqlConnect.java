/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ntou.cse.softwareengineering.ees;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import javax.swing.text.Utilities;

/**
 *
 * @author Lien
 */
public class MysqlConnect {
    private String url = "jdbc:mysql://yochien.tk:3306/";
    private String dbName = "ees";
    private String driver = "com.mysql.jdbc.Driver";
    private String userName = "ees";
    private String password = "ees";
    private MonitorBundle monitorBundle;
    private ExhibitionBundle exhibitionBundle;
    private BoothBundle boothBundle;
    
    public MysqlConnect(){
        ArrayList<String> exhibitionName = new ArrayList<String>();
        ArrayList<String> exhibitionPopularity = new ArrayList<String>();
        ArrayList<String> exhibitionStartDate  = new ArrayList<String>();
        ArrayList<String> exhibitionEndDate = new ArrayList<String>();
        ArrayList<String> exhibitionLocation = new ArrayList<String>();
        ArrayList<String> exhibitionOrganizerId = new ArrayList<String>();
        ArrayList<String> exhibitionDescription  = new ArrayList<String>();
        ArrayList<String> exhibitionId = new ArrayList<String>();
        ArrayList<String> exhibitionURL = new ArrayList<String>();
        
        ArrayList<String> boothName = new ArrayList<String>();
        ArrayList<String> boothPopularity = new ArrayList<String>();
        ArrayList<String> boothId = new ArrayList<String>();
        ArrayList<String> boothPosition = new ArrayList<String>();
        ArrayList<String> boothHolderId = new ArrayList<String>();
        ArrayList<String> boothBelong2Exhibition = new ArrayList<String>();
        ArrayList<String> boothDescription = new ArrayList<String>();
        
        String[] exhibitionNameAry = null;
        String[] exhibitionPopularityAry = null;
        String[] exhibitionStartDateAry = null;
        String[] exhibitionEndDateAry = null;
        String[] exhibitionLocationAry = null;
        String[] exhibitionOrganizerIdAry = null;
        String[] exhibitionDescriptionAry = null;
        String[] exhibitionIdAry = null;
        String[] exhibitionURLAry = null;
        
        String[] boothNameAry = null;
        String[] boothPopularityAry = null;
        String[] boothIdAry = null;
        String[] boothPositionAry = null;
        String[] boothHolderIdAry = null;
        String[] boothBelong2ExhibitionAry = null;
        String[] boothDescriptionAry = null;
        
        try { 
            
            Class.forName(driver).newInstance(); 
            Connection conn = DriverManager.getConnection(url+dbName,userName,password); 
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  `exhibition`;");
            while (res.next()) {
                exhibitionId.add(res.getString("exhibitionId"));
                exhibitionName.add(res.getString("displayName"));
                exhibitionStartDate.add(res.getString("startDate"));
                exhibitionEndDate.add(res.getString("endDate"));
                exhibitionLocation.add(res.getString("location"));
                exhibitionOrganizerId.add(res.getString("organizer_Id"));
                exhibitionDescription.add(res.getString("description"));
                exhibitionPopularity.add(res.getString("popularity"));
                exhibitionURL.add(res.getString("URL"));
            }
            
            exhibitionIdAry = new String[exhibitionId.size()];
            exhibitionNameAry = new String[exhibitionName.size()];
            exhibitionStartDateAry = new String[exhibitionStartDate.size()];
            exhibitionEndDateAry = new String[exhibitionEndDate.size()];
            exhibitionLocationAry = new String[exhibitionLocation.size()];
            exhibitionOrganizerIdAry = new String[exhibitionOrganizerId.size()];
            exhibitionDescriptionAry = new String[exhibitionDescription.size()];
            exhibitionPopularityAry = new String[exhibitionPopularity.size()];
            exhibitionURLAry = new String[exhibitionURL.size()];
            
            res = st.executeQuery("SELECT *  FROM  `booth`");
            while (res.next()) {
                boothId.add(res.getString("boothId"));
                boothPosition.add(res.getString("boothPosition"));
                boothHolderId.add(res.getString("holderId"));
                boothBelong2Exhibition.add(res.getString("exhibitionId"));
                boothName.add(res.getString("displayName"));
                boothPopularity.add(res.getString("popularity"));
                boothDescription.add(res.getString("description"));
            }
            
            boothNameAry = new String[boothName.size()];
            boothPopularityAry = new String[boothPopularity.size()];
            boothIdAry = new String[boothId.size()];
            boothPositionAry = new String[boothPosition.size()];
            boothHolderIdAry = new String[boothHolderId.size()];
            boothBelong2ExhibitionAry = new String[boothBelong2Exhibition.size()];
            boothDescriptionAry = new String[boothDescription.size()];
            
            exhibitionIdAry = exhibitionId.toArray(exhibitionIdAry);
            exhibitionStartDateAry = exhibitionStartDate.toArray(exhibitionStartDateAry);
            exhibitionEndDateAry = exhibitionEndDate.toArray(exhibitionEndDateAry);
            exhibitionLocationAry = exhibitionLocation.toArray(exhibitionLocationAry);
            exhibitionOrganizerIdAry = exhibitionOrganizerId.toArray(exhibitionOrganizerIdAry);
            exhibitionDescriptionAry = exhibitionDescription.toArray(exhibitionDescriptionAry);
            exhibitionURLAry = exhibitionURL.toArray(exhibitionURLAry);
            exhibitionNameAry = exhibitionName.toArray(exhibitionNameAry);
            exhibitionPopularityAry = exhibitionPopularity.toArray(exhibitionPopularityAry);
            
            boothNameAry = boothName.toArray(boothNameAry);
            boothPopularityAry = boothPopularity.toArray(boothPopularityAry);
            boothIdAry = boothId.toArray(boothIdAry);
            boothPositionAry = boothPosition.toArray(boothPositionAry);
            boothHolderIdAry = boothHolderId.toArray(boothHolderIdAry);
            boothBelong2ExhibitionAry = boothBelong2Exhibition.toArray(boothBelong2ExhibitionAry);
            boothDescriptionAry = boothDescription.toArray(boothDescriptionAry);
            
            conn.close(); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        this.monitorBundle = new MonitorBundle(exhibitionNameAry, boothNameAry, exhibitionPopularityAry, boothPopularityAry);
        this.exhibitionBundle = new ExhibitionBundle(exhibitionIdAry, exhibitionNameAry, exhibitionStartDateAry, exhibitionEndDateAry,
                                                  exhibitionLocationAry, exhibitionOrganizerIdAry, exhibitionDescriptionAry, exhibitionPopularityAry,
                                                  exhibitionURLAry);
        this.boothBundle = new BoothBundle(boothIdAry, boothPositionAry, boothHolderIdAry, boothBelong2ExhibitionAry, boothNameAry,
                                                  boothPopularityAry, boothDescriptionAry);
    }
    
    public void updateMysqlData(){
        this.boothBundle = null;
        this.exhibitionBundle = null;
        this.monitorBundle = null;
        
        ArrayList<String> exhibitionName = new ArrayList<String>();
        ArrayList<String> exhibitionPopularity = new ArrayList<String>();
        ArrayList<String> exhibitionStartDate  = new ArrayList<String>();
        ArrayList<String> exhibitionEndDate = new ArrayList<String>();
        ArrayList<String> exhibitionLocation = new ArrayList<String>();
        ArrayList<String> exhibitionOrganizerId = new ArrayList<String>();
        ArrayList<String> exhibitionDescription  = new ArrayList<String>();
        ArrayList<String> exhibitionId = new ArrayList<String>();
        ArrayList<String> exhibitionURL = new ArrayList<String>();
        
        ArrayList<String> boothName = new ArrayList<String>();
        ArrayList<String> boothPopularity = new ArrayList<String>();
        ArrayList<String> boothId = new ArrayList<String>();
        ArrayList<String> boothPosition = new ArrayList<String>();
        ArrayList<String> boothHolderId = new ArrayList<String>();
        ArrayList<String> boothBelong2Exhibition = new ArrayList<String>();
        ArrayList<String> boothDescription = new ArrayList<String>();
        
        String[] exhibitionNameAry = null;
        String[] exhibitionPopularityAry = null;
        String[] exhibitionStartDateAry = null;
        String[] exhibitionEndDateAry = null;
        String[] exhibitionLocationAry = null;
        String[] exhibitionOrganizerIdAry = null;
        String[] exhibitionDescriptionAry = null;
        String[] exhibitionIdAry = null;
        String[] exhibitionURLAry = null;
        
        String[] boothNameAry = null;
        String[] boothPopularityAry = null;
        String[] boothIdAry = null;
        String[] boothPositionAry = null;
        String[] boothHolderIdAry = null;
        String[] boothBelong2ExhibitionAry = null;
        String[] boothDescriptionAry = null;
        
        try { 
            
            Class.forName(driver).newInstance(); 
            Connection conn = DriverManager.getConnection(url+dbName,userName,password); 
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  `exhibition`;");
            while (res.next()) {
                exhibitionId.add(res.getString("exhibitionId"));
                exhibitionName.add(res.getString("displayName"));
                exhibitionStartDate.add(res.getString("startDate"));
                exhibitionEndDate.add(res.getString("endDate"));
                exhibitionLocation.add(res.getString("location"));
                exhibitionOrganizerId.add(res.getString("organizer_Id"));
                exhibitionDescription.add(res.getString("description"));
                exhibitionPopularity.add(res.getString("popularity"));
                exhibitionURL.add(res.getString("URL"));
            }
            
            exhibitionIdAry = new String[exhibitionId.size()];
            exhibitionNameAry = new String[exhibitionName.size()];
            exhibitionStartDateAry = new String[exhibitionStartDate.size()];
            exhibitionEndDateAry = new String[exhibitionEndDate.size()];
            exhibitionLocationAry = new String[exhibitionLocation.size()];
            exhibitionOrganizerIdAry = new String[exhibitionOrganizerId.size()];
            exhibitionDescriptionAry = new String[exhibitionDescription.size()];
            exhibitionPopularityAry = new String[exhibitionPopularity.size()];
            exhibitionURLAry = new String[exhibitionURL.size()];
            
            res = st.executeQuery("SELECT *  FROM  `booth`");
            while (res.next()) {
                boothId.add(res.getString("boothId"));
                boothPosition.add(res.getString("boothPosition"));
                boothHolderId.add(res.getString("holderId"));
                boothBelong2Exhibition.add(res.getString("exhibitionId"));
                boothName.add(res.getString("displayName"));
                boothPopularity.add(res.getString("popularity"));
                boothDescription.add(res.getString("description"));
            }
            
            boothNameAry = new String[boothName.size()];
            boothPopularityAry = new String[boothPopularity.size()];
            boothIdAry = new String[boothId.size()];
            boothPositionAry = new String[boothPosition.size()];
            boothHolderIdAry = new String[boothHolderId.size()];
            boothBelong2ExhibitionAry = new String[boothBelong2Exhibition.size()];
            boothDescriptionAry = new String[boothDescription.size()];
            
            exhibitionIdAry = exhibitionId.toArray(exhibitionIdAry);
            exhibitionStartDateAry = exhibitionStartDate.toArray(exhibitionStartDateAry);
            exhibitionEndDateAry = exhibitionEndDate.toArray(exhibitionEndDateAry);
            exhibitionLocationAry = exhibitionLocation.toArray(exhibitionLocationAry);
            exhibitionOrganizerIdAry = exhibitionOrganizerId.toArray(exhibitionOrganizerIdAry);
            exhibitionDescriptionAry = exhibitionDescription.toArray(exhibitionDescriptionAry);
            exhibitionURLAry = exhibitionURL.toArray(exhibitionURLAry);
            exhibitionNameAry = exhibitionName.toArray(exhibitionNameAry);
            exhibitionPopularityAry = exhibitionPopularity.toArray(exhibitionPopularityAry);
            
            boothNameAry = boothName.toArray(boothNameAry);
            boothPopularityAry = boothPopularity.toArray(boothPopularityAry);
            boothIdAry = boothId.toArray(boothIdAry);
            boothPositionAry = boothPosition.toArray(boothPositionAry);
            boothHolderIdAry = boothHolderId.toArray(boothHolderIdAry);
            boothBelong2ExhibitionAry = boothBelong2Exhibition.toArray(boothBelong2ExhibitionAry);
            boothDescriptionAry = boothDescription.toArray(boothDescriptionAry);
            
            conn.close(); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        this.monitorBundle = new MonitorBundle(exhibitionNameAry, boothNameAry, exhibitionPopularityAry, boothPopularityAry);
        this.exhibitionBundle = new ExhibitionBundle(exhibitionIdAry, exhibitionNameAry, exhibitionStartDateAry, exhibitionEndDateAry,
                                                  exhibitionLocationAry, exhibitionOrganizerIdAry, exhibitionDescriptionAry, exhibitionPopularityAry,
                                                  exhibitionURLAry);
        this.boothBundle = new BoothBundle(boothIdAry, boothPositionAry, boothHolderIdAry, boothBelong2ExhibitionAry, boothNameAry,
                                                  boothPopularityAry, boothDescriptionAry);
    }
    
    public MonitorBundle getMonitor () throws IndexOutOfBoundsException{
        return this.monitorBundle;
    }
    
    public ExhibitionBundle getExhibition(){
        return this.exhibitionBundle;
    }
    
    public BoothBundle getBooth(){
        return this.boothBundle;
    }
    
    public boolean insertExhibition(String name, String startDate, String endDate, String location, String description, String exhibitionURL){
        int organizer_id = 1;
         try { 
            Class.forName(driver).newInstance(); 
            Connection conn = DriverManager.getConnection(url+dbName+"?useUnicode=true&characterEncoding=utf-8",userName,password); 
            Statement st = conn.createStatement();
            String sqlexecute = "INSERT INTO exhibition(`displayName`, `startDate`, `endDate`, `location`, `organizer_id`,"
                    + "`description`, `URL`) VALUES ('" + name + "', '" + startDate + "', '" + endDate + "', '" + location + "', '" + organizer_id + 
                    "', '" + description + "', '" + exhibitionURL + "');";
            System.out.println(sqlexecute);
            st.executeUpdate(sqlexecute);
            conn.close(); 
            this.updateMysqlData();
            return true;
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }
    
}