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
public class ExhibitionBundle {
        private String[] exhibitionName = null;
        private String[] exhibitionPopularity = null;
        private String[] exhibitionStartDate = null;
        private String[] exhibitionEndDate = null;
        private String[] exhibitionLocation = null;
        private String[] exhibitionOrganizerId = null;
        private String[] exhibitionDescription = null;
        private String[] exhibitionId = null;
        private String[] exhibitionURL = null;
        
        public ExhibitionBundle(String[] _exhibitionId, String[] _exhibitionName, String[] _exhibitionStartDate, String[] _exhibitionEndDate, 
                String[] _exhibitionLocation, String[] _exhibitionOrganizerId, String[] _exhibitionDescription, String[] _exhibitionPopularity, 
                String[] _exhibitionURL){
            this.exhibitionId = _exhibitionId;
            this.exhibitionName = _exhibitionName;
            this.exhibitionStartDate = _exhibitionStartDate;
            this.exhibitionEndDate = _exhibitionEndDate;
            this.exhibitionLocation = _exhibitionLocation;
            this.exhibitionOrganizerId = _exhibitionOrganizerId;
            this.exhibitionDescription = _exhibitionDescription;
            this.exhibitionPopularity = _exhibitionPopularity;
            this.exhibitionURL = _exhibitionURL;
        }
        
        public String[] getExhibitionId(){
            return this.exhibitionId;
        }
        
        public String[] getName(){
            return this.exhibitionName;
        }
         
        public String[] getStartDate(){
            return this.exhibitionStartDate;
        }
        
        public String[] getEndDate(){
            return this.exhibitionEndDate;
        }
        
        public String[] getLocation(){
            return this.exhibitionLocation;
        }
        
        public String[] getOrganizerId(){
            return this.exhibitionOrganizerId;
        }
        
        public String[] getDescription(){
            return this.exhibitionDescription;
        }
        
        public String[] getPopularity(){
            return this.exhibitionPopularity;
        }
        
        public String[] getURL(){
            return this.exhibitionURL;
        }
        
        @Override
        public String toString(){
            return "ExhibitionBundle [exhibitionId=" + Arrays.toString(exhibitionId) + ", exhibitionDisplayName=" + Arrays.toString(exhibitionName) +
                    ", exhibitionStartDate=" + Arrays.toString(exhibitionStartDate) + ", exhibitionEndDate=" + Arrays.toString(exhibitionEndDate) +
                    ", exhibitionLocation=" + Arrays.toString(exhibitionLocation) + ", exhibitionOrganizerId=" + Arrays.toString(exhibitionOrganizerId) + 
                    ", exhibitionDescription=" + Arrays.toString(exhibitionDescription) + ", exhibitionPopularity=" + Arrays.toString(exhibitionPopularity) + 
                    ", exhibitionURL=" + Arrays.toString(exhibitionURL) + "]";
        }
        
}
