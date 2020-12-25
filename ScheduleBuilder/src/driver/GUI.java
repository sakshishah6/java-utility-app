package driver;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
    int count = 0;
    private JLabel calendarLabel;
    private JLabel timerLabel;
    private JLabel scheduleLabel;
    private JLabel notificationLabel;
    private JFrame frame;
    private JPanel panel;
    
    public GUI() {
      frame = new JFrame(); //this is the window
      
      panel = new JPanel(new BorderLayout());
      
      calendarLabel = new JLabel();
      timerLabel = new JLabel();
      scheduleLabel = new JLabel();
      notificationLabel = new JLabel();
      
      calendarLabel.setText("Calendar");
      timerLabel.setText("Timer");
      scheduleLabel.setText("Schedule");
      notificationLabel.setText("Notifications");
         
      panel.setSize(300, 300);
      panel.setLayout(new GridLayout(2, 2));
      panel.add(calendarLabel);
      panel.add(timerLabel);
      panel.add(scheduleLabel);
      panel.add(notificationLabel);
      
      
      frame.add(panel, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Schedule Builder");
      frame.pack();
      frame.setVisible(true);
      frame.setSize(300, 300);
      
    }

	public static void main(String[] args) {
		new GUI();
	}

}
