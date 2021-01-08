package runner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StopwatchFeature {

	private static Timer s;
	private TimerTask task;
	private int delay = 1000;
	private int period = 1000;
	private int event = 0;
	private int totalSec = 0;
	
	/* Name: convertToSeconds
	 * Purpose: Converts time shown on label to time in seconds only
	 * Input: JLabel stopwatchLabel
	 * Output: int seconds
	 */
	private int convertToSeconds(JLabel stopwatchLabel) {
		
		String hr = "" + (stopwatchLabel.getText()).charAt(0) + (stopwatchLabel.getText()).charAt(1);
		String min = "" + (stopwatchLabel.getText()).charAt(3) + (stopwatchLabel.getText()).charAt(4);
		String sec = "" + (stopwatchLabel.getText()).charAt(6) + (stopwatchLabel.getText()).charAt(7);
		
		int h = Integer.parseInt(hr);
		int m = Integer.parseInt(min);
		int s = Integer.parseInt(sec);
		
		return h*60*60 + m*60 + s;
	}
	
	/* Name: convertFromSeconds
	 * Purpose: Converts time in seconds to a string format used on the label
	 * Input: int seconds
	 * Output: String formattedTime
	 */
	private String convertFromSeconds(int sec) {
        int p1 = sec % 60;
        int p2 = sec / 60;
        int p3 = p2 % 60;
        p2 = p2 / 60;
        
		int[] result = new int[3];
		result[0] = p2;
		result[1] = p3;
		result[2] = p1;
		
		String formatedTime = formatTime(result);
		
		return formatedTime;
	}
	
	/* Name: formatTime
	 * Purpose: formats the time in order to show it on the label
	 * Input: integer array containing hour, minute and second at each index
	 * Output: String formatted time
	 */
	private String formatTime(int[] arr) {
		int hour = arr[0];
		int minute = arr[1];
		int second = arr[2];
		
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
	
	private int countUp(int seconds) {
	    return seconds+1;
	}
	
	public TimerTask startStopwatch(TimerTask task, JLabel stopwatchLabel) {

    	task = new TimerTask() {
	        public void run() {
	        	totalSec = convertToSeconds(stopwatchLabel);
	        	totalSec = countUp(totalSec);
	        	String newTime = convertFromSeconds(totalSec);
	        	stopwatchLabel.setText(newTime);
	        }
    	};
    	
    	s.scheduleAtFixedRate(task, delay, period);
    	
    	String newTime = convertFromSeconds(totalSec);
    	stopwatchLabel.setText(newTime);
	    
	    return task;
	}
	
	public TimerTask stopStopwatch(TimerTask task, JLabel stopwatchLabel) {
		task.cancel();
		totalSec = convertToSeconds(stopwatchLabel);
		event=1;
		return task;
	}
	
	public Timer resetStopwatch(TimerTask task) {
		task.cancel();
    	s.cancel();
    	s.purge();
    	s=null;
    	task=null;
    	event=2;
		totalSec = 0;
    	return s;
	}
	
	public void runStopwatch(JLabel stopwatchLabel, JButton stopwatchStartBtn, JButton stopwatchStopBtn, JButton stopwatchResetBtn) {

	    stopwatchStartBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    		//new event
	        	if (event==0 && stopwatchLabel.getText()=="00:00:00") {
	        		s = new Timer();
	        		task = startStopwatch(task, stopwatchLabel);
	        	}
	        	//after pause
	        	if (event==1) {
	        		task = startStopwatch(task, stopwatchLabel);
	        	}
	    		//after restart
	        	else if (event==2 && stopwatchLabel.getText()=="00:00:00") {
	        		s = new Timer();
	        		task = startStopwatch(task, stopwatchLabel);
	    		}
	        	
        		stopwatchStartBtn.setEnabled(false);
        		stopwatchStopBtn.setEnabled(true);
        		stopwatchResetBtn.setEnabled(true);
	        };
	    });

	    stopwatchStopBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent select) {
	        	task = stopStopwatch(task, stopwatchLabel);
	        	stopwatchStartBtn.setEnabled(true);
	        	stopwatchStopBtn.setEnabled(false);
	        	stopwatchResetBtn.setEnabled(true);
	        };
	    });
		    	    
	    stopwatchResetBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	resetStopwatch(task);
	        	stopwatchLabel.setText("00:00:00");
	        	stopwatchStartBtn.setEnabled(true);
	        	stopwatchStopBtn.setEnabled(false);
	        	stopwatchResetBtn.setEnabled(false);
	        };
	    });
	}
}
