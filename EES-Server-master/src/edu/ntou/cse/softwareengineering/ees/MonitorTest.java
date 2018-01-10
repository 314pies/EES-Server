/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ntou.cse.softwareengineering.ees;

import javax.swing.JFrame;


/**
 *
 * @author Lien
 */
public class MonitorTest {
    public static void main(String[] args){
        MonitorUI application = new MonitorUI();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        application.setSize(400, 1000);
        application.setVisible(true);
    }
}
