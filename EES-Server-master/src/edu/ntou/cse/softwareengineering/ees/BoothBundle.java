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
public class BoothBundle {
    private String[] boothId;
    private String[] boothPosition;
    private String[] boothHolderId;
    private String[] boothBelong2Exhibition;
    private String[] boothDisplayName;
    private String[] boothPopularity;
    private String[] boothDescription;
    
    public BoothBundle(String[] _boothId,String[] _boothPosition,String[] _boothHolderId,String[] _boothBelong2Exhibition,
            String[] _boothDisplayName,String[] _boothPopularity, String[] _boothDescription){
        this.boothId = _boothId;
        this.boothPosition = _boothPosition;
        this.boothHolderId = _boothHolderId;
        this.boothBelong2Exhibition = _boothBelong2Exhibition;
        this.boothDisplayName = _boothDisplayName;
        this.boothPopularity = _boothPopularity;
        this.boothDescription = _boothDescription;
    }
    
    public String[] getBoothId(){
        return this.boothId;
    }
    
    public String[] getPosition(){
        return this.boothPosition;
    }
    
    public String[] getHolderId(){
        return this.boothHolderId;
    }
    
    public String[] getExhibitionId(){
        return this.boothBelong2Exhibition;
    }
    
    public String[] getName(){
        return this.boothDisplayName;
    }
    
    public String[] getPopularity(){
        return this.boothPopularity;
    }
    
    public String[] getDescription(){
        return this.boothDescription;
    }
    
    @Override
        public String toString(){
            return "BoothBundle [boothId=" + Arrays.toString(boothId) + ", boothPosition=" + Arrays.toString(boothPosition) +
                    ", boothHolderId=" + Arrays.toString(boothHolderId) + ", boothExhibitionId=" + Arrays.toString(boothBelong2Exhibition) +
                    ", boothDisplayName=" + Arrays.toString(boothDisplayName) + ", boothPopularity=" + Arrays.toString(boothPopularity) + 
                    ", boothDescription=" + Arrays.toString(boothDescription) + "]";
        }
    
}
