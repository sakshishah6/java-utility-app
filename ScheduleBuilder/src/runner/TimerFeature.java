package runner;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class TimerFeature extends Programs {

	public void selectOption(JRadioButton timerRadioBtn, JRadioButton stopwatchRadioBtn, JLabel timerLabel, JLabel stopwatchLabel) {
		if (timerRadioBtn.isSelected()) runTimer(timerLabel);
		else if (stopwatchRadioBtn.isSelected()) runStopwatch(stopwatchLabel);
	}
	
	public void runTimer(JLabel timerLabel) {
		timerLabel.setVisible(true);
	}
	
	public void runStopwatch(JLabel stopwatchLabel) {
		stopwatchLabel.setVisible(true);
	}
	
	@Override
	public void runProgram() {
		  
	}
	
}
