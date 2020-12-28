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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
    int count = 0;
    private JLabel calendarLabel;
    private JLabel timerLabel;
    private JLabel scheduleLabel;
    private JLabel notificationLabel;
    private JButton notificationButton;
    private JButton timerButton;
    private JButton calendarButton;
    private JButton scheduleButton;
    private JFrame frame;
    private JPanel panel;
    
    public GUI() {
      //Creating the Frame
      JFrame frame = new JFrame("Chat Frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300, 300);


      //Creating the MenuBar and adding components
      JMenuBar mb = new JMenuBar();
      JMenu m1 = new JMenu("File");
      JMenu m2 = new JMenu("Help");
      mb.add(m1);
      mb.add(m2);
      JMenuItem m11 = new JMenuItem("Open");
      JMenuItem m22 = new JMenuItem("Save as");
      JMenuItem m31 = new JMenuItem("HELP ME");
      JMenuItem m32 = new JMenuItem("Settings");
      m1.add(m11);
      m1.add(m22);
      m2.add(m31);
      m2.add(m32);
      
      //Creating the panel at bottom and adding components
      JPanel panel = new JPanel(); // the panel is not visible in output
      JButton timer = new JButton("Timer");
      JButton calendar = new JButton("Calendar");
      JButton schedule = new JButton("Schedule");
      panel.add(timer);
      panel.add(calendar);
      panel.add(schedule);

      // Text Area at the Center
      JTextArea ta = new JTextArea();

      //Adding Components to the frame.
      frame.getContentPane().add(BorderLayout.SOUTH, panel);
      frame.getContentPane().add(BorderLayout.NORTH, mb);
      frame.getContentPane().add(BorderLayout.CENTER, ta);
      frame.setVisible(true);

    }

	public static void main(String[] args) {
		new GUI();
	}

}
