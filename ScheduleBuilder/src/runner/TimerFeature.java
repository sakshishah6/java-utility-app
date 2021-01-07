package runner;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TimerFeature extends Programs {

	int start;
	int secOnlyNew = 0;
	
	public void setTextFieldFocus(JTextField enterField, String t) {

		enterField.addFocusListener(new FocusListener() {
		    public void focusLost(FocusEvent e) {
		        if(enterField.getText().trim().equals(""))
		        	enterField.setText(t);
		         else; //do nothing
		    }
	
		    public void focusGained(FocusEvent e) {
		        if(enterField.getText().trim().equals(t))
		        	enterField.setText("");
		         else; //do nothing
		    }
		});
	};
	
	public boolean validateFields(JTextField enterHour, JTextField enterMin, JTextField enterSec) {
	    
	    String hour = enterHour.getText();
	    String min = enterMin.getText();
	    String sec = enterSec.getText();
	    
		if (hour=="HH") enterHour.setText("00");
		if (hour=="MM") enterMin.setText("00");
		if (hour=="SS") enterSec.setText("00");
	    
	    boolean isNumH = hour.chars().allMatch( Character::isDigit );
	    boolean isNumM = min.chars().allMatch( Character::isDigit );
	    boolean isNumS = sec.chars().allMatch( Character::isDigit );
	    
		if (enterHour==null || enterMin==null || enterSec==null ) {
	        return false;
	    }
	    	    
	    if (!(isNumH && isNumM && isNumS)) {
	        return false;
	    }
	    
	    int hh = Integer.parseInt(hour);
	    int mm = Integer.parseInt(min);
	    int ss = Integer.parseInt(sec);
	    
	    if ( (hh>12) || (mm>59) || (ss>59)) {
    		return false;
	    }
	    
	    if (hh<10) enterHour.setText("0"+hh);
	    if (mm<10) enterMin.setText("0"+mm);
	    if (ss<10) enterSec.setText("0"+ss);
	    
	    return true;
	};
	
	public int convertToSeconds(int hr, int min, int sec) {
		return hr*60*60 + min*60 + sec;
	}
	
	public int[] convertFromSeconds(int sec) {
        int p1 = sec % 60;
        int p2 = sec / 60;
        int p3 = p2 % 60;
        p2 = p2 / 60;
        
        //return p2 + ":" + p3 + ":" + p1;
        
		int[] result = new int[3];
		result[0] = p2;
		result[1] = p3;
		result[2] = p1;
		
		return result;
	}
	
	public String formatTime(int hour, int minute, int second) {
		String formattedHour = null;
		String formattedMinute = null;
		String formattedSecond = null;
	    
		if (hour<10) formattedHour = "0"+hour;
	    else formattedHour = ""+hour;
	    
		if (minute<10) formattedMinute = "0"+minute;
		else formattedMinute = ""+minute;
		
		if (second<10) formattedSecond = "0"+second;
		else formattedSecond = ""+second;
		
		return formattedHour+":"+formattedMinute+":"+formattedSecond;
	}
	
	public int setInterval(int seconds, Timer t) {
	    start = 0;
		if (seconds == 1) {
			t.cancel();
			playMusic("src/media/timer sound.mp3");
		}
	    return seconds-1;
	}
	
	public void playMusic(String filepath) {
	      try {
	    	  File f = new File("./" + filepath);
	    	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
	          Clip clip = AudioSystem.getClip();
	          clip.open(audioIn);
	          clip.start();
	       } catch (UnsupportedAudioFileException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       } catch (LineUnavailableException e) {
	          e.printStackTrace();
	       }
	}
	
	public void runTimer(JLabel timerLbl, String hour, String minute, String second, int option) {
		int hr = Integer.parseInt(hour);
		int min = Integer.parseInt(minute);
		int sec = Integer.parseInt(second);
		
		int secOnly = convertToSeconds(hr, min, sec);
		
	    int delay = 1000;
	    int period = 1000;
	    
	    start = 1;
    	
	    int[] result = convertFromSeconds(secOnly);
    	
	    String finalTime = formatTime(result[0], result[1], result[2]);
    	
	    timerLbl.setText(finalTime);
    	
    	Timer t = new Timer();
    	TimerTask task;
    	
    	task = new TimerTask() {
	        public void run() {
	        	if (start==1) {
	        		secOnlyNew = setInterval(secOnly, t);
	        		start = 0;
	        	}
	        	else {
		        	secOnlyNew = setInterval(secOnlyNew, t);
		        	System.out.println(secOnlyNew);
	        	}
	        	int[] result = convertFromSeconds(secOnlyNew);
	        	String finalTime = formatTime(result[0], result[1], result[2]);
	        	timerLbl.setText(finalTime);
	        }
    	};
	    	
    	//option 1 - start
    	if (option==1) {
		    t.scheduleAtFixedRate(task, delay, period);
    	}
    	
    	//option 2 - pause
    	else if (option==2) {
    		
    	}
    	
    	//option 3 - reset
    	else if (option==3) {
    		task.cancel();
    	}
	}
	
	public void pauseTimer() {

	}
	
	public void resetTimer() {
		//t.cancel();
		//task.cancel();
	}
	
	@Override
	public void runProgram() {
		  
	}
	
}
