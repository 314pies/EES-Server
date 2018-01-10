package edu.ntou.cse.softwareengineering.ees;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.*;
import javax.swing.JFrame;

public class EESMonitorTest
{
	public static void main (String args[])
	{
		EESMonitor monitor = new EESMonitor();
		monitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		monitor.setSize(800, 800);
		monitor.setVisible(true);
		
		String soundURL = "maplestory.wav";
        try{
            //open an audio input stream
            //URL url = monitor.getClass().getClassLoader().getResource(soundURL);
        	URL url = new File("./src/"+ soundURL).toURI().toURL();
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            //Get sound clip
            Clip clip = AudioSystem.getClip();
            //open audio clip amd load samples from the audio input stream
            clip.open(audioIn);
            //clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);   //repeat forever
        }catch(UnsupportedAudioFileException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(LineUnavailableException e){
            e.printStackTrace();
        }
	}
}