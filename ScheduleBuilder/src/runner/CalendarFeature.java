package runner;

import java.util.Calendar;

import javax.swing.JLabel;

public class CalendarFeature extends Programs {

	public void getDate(JLabel dateLabel) {
		Calendar cal = Calendar.getInstance();

		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		dateLabel.setText("Date: "+month+"/"+day+"/"+year);
	}
	
	public void getTime(JLabel timeLabel) {
		Calendar cal = Calendar.getInstance();

		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int meridian = cal.get(Calendar.AM_PM);
		
		String hh = null;
		String mm = null;
		String ampm = null;
		
		if (hour == 0) hh = "12";
		else if (hour < 10) hh = "0"+String.valueOf(hour);
		else hh = String.valueOf(hour);
		
		if (min < 10) mm = "0"+String.valueOf(min);
		else mm = String.valueOf(min);

		if (meridian == 0) ampm = "AM";
		else ampm = "PM";
		
		timeLabel.setText("Time: "+hh+":"+mm+" "+ampm);
		
		//to change time dynamically, try running a recursive timer
		//every time the timer is at 0 sec, start it again and update the timeLabel (i.e. line 40)
	}
	
	public void runProgram() {

	
	}

}
