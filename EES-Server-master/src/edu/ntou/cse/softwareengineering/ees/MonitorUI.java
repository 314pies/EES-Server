/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ntou.cse.softwareengineering.ees;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.SQLException;

/**
 *
 * @author Lien
 */
public class MonitorUI extends JFrame{
    private final JTextField textField1;
    private final JTextField textField2;
    private final JTextField textField3;
    
    public MonitorUI() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        MonitorBundle monitorBundle = mysqlConnect.getMonitor();
        
        textField1 = new JTextField(monitorBundle.toString());
        this.add(this.textField1, BorderLayout.NORTH);
        
         textField2 = new JTextField(mysqlConnect.getExhibition().toString());
        this.add(this.textField2, BorderLayout.CENTER);
        
         textField3 = new JTextField(mysqlConnect.getBooth().toString());
        this.add(this.textField3, BorderLayout.SOUTH);
    }
}
