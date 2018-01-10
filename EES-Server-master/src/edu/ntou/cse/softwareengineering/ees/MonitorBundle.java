/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ntou.cse.softwareengineering.ees;

import java.util.Arrays;

/**
 *
 * @author Lien
 */
public class MonitorBundle {
    public String[] exhibitionDisplayName;         //顯示展覽名稱
    public String[] boothDisplayName;                  //顯示攤位名稱
    public String[] exhibitionPopularity;                  //顯示展覽觀看人數
    public String[] boothPopularity;                      //顯示攤位觀看人數
    
    //
    public MonitorBundle(String[] _exhibitionDisplayName, String[] _boothDisplayName, String[] _exhibitionPopularity, String[] _boothPopularity){
        this.exhibitionDisplayName = _exhibitionDisplayName;
        this.exhibitionPopularity = _exhibitionPopularity;
        this.boothDisplayName = _boothDisplayName;
        this.boothPopularity = _boothPopularity;
    }
    
    public String[] getExhibitionName(){
        return this.exhibitionDisplayName;
    }
    
    public String[] getExhibitionPopularity(){
        return this.exhibitionPopularity;
    }
    
    public String[] getBoothName(){
        return this.boothDisplayName;
    }
    
    public String[] getBoothPopularity(){
        return this.boothPopularity;
    }
    
    @Override
    public String toString(){
        return "MonitorBundle [exhibitionDisplayName=" + Arrays.toString(exhibitionDisplayName) +
                ", exhibitionPopularity=" + Arrays.toString(exhibitionPopularity) + ", boothDisplayName=" + 
                Arrays.toString(boothDisplayName) + ", boothPopularity=" + Arrays.toString(boothPopularity) + 
                "]";
    }
}
