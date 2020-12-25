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
    //private JButton button;
    
    public GUI() {
      frame = new JFrame(); //this is the window
      
      //button = new JButton("Click Me!!");
      
      panel = new JPanel();
      
      calendarLabel = new JLabel();
      timerLabel = new JLabel();
      scheduleLabel = new JLabel();
      notificationLabel = new JLabel();
      
      calendarLabel.setText("Calendar");
      timerLabel.setText("Timer");
      scheduleLabel.setText("Schedule");
      notificationLabel.setText("Notifications");
      
      calendarLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
      timerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
      //calendarLabel.setLocation(110, 20);
      //calendarLabel.setBounds(20, 50, 100, 50);
      //timerLabel.setBounds(40, 100, 100, 50);
      scheduleLabel.setBounds(100, 50, 100, 50);
      notificationLabel.setBounds(100, 100, 100, 50);
      
      
      panel.setSize(300, 300);
      //panel.setBorder(BorderFactory.createEmptyBorder(300,  300,  300,  300));
      //panel.setLayout(new GridLayout(0, 1));
      //panel.add(button);
      //panel.add(label);
      panel.add(calendarLabel, BorderLayout.WEST);
      panel.add(timerLabel, BorderLayout.WEST);
      panel.add(scheduleLabel, BorderLayout.EAST);
      panel.add(notificationLabel, BorderLayout.EAST);
      
      //button.addActionListener(this);
      
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

	/*
  @Override
  public void actionPerformed(ActionEvent e) {
    count ++;
    //label.setText("Number of clicks: " + count);
  }
*/
}
