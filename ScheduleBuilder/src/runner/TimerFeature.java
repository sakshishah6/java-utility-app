package runner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TimerFeature extends Programs {

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
	        System.out.print("Please enter a valid time\n");
	        return false;
	    }
	    	    
	    if (!(isNumH && isNumM && isNumS)) {
	        System.out.print("Please enter a valid time\n");
	        return false;
	    }
	    
	    int hh = Integer.parseInt(hour);
	    int mm = Integer.parseInt(min);
	    int ss = Integer.parseInt(sec);
	    
	    if ( (hh>12) || (mm>59) || (ss>59)) {
    		System.out.print("Please enter a valid time\n");
    		return false;
	    }
	    
	    if (hh<10) enterHour.setText("0"+hh);
	    if (mm<10) enterMin.setText("0"+mm);
	    if (ss<10) enterSec.setText("0"+ss);
	    
	    return true;
	};
	
	public void runTimer(JLabel timerLbl, String hour, String minute, String second) {
		int hr = Integer.parseInt(hour);
		int min = Integer.parseInt(minute);
		int sec = Integer.parseInt(second);
		

		timerLbl.setText(hour+":"+minute+":"+second);

	}
	
	public void runStopwatch() {

	}
	
	@Override
	public void runProgram() {
		  
	}
	
}
