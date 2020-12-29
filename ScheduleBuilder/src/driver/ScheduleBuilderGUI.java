package driver;

import runner.CalendarFeature;
import runner.ScheduleFeature;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;

public class ScheduleBuilderGUI {

	public static void GUI() {
		
		// Create and set up the window.
		final JFrame frame2 = new JFrame("Schedule Builder");

		frame2.setSize(617, 571);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// Panel 0: Home Page
		JPanel p0 = new JPanel();
		homepage(p0);
		
		// Panel 1: Calendar
		JPanel p1 = new JPanel();
		calendar(p1);
		
		// Panel 2: Schedule
		JPanel p2 = new JPanel();
		schedule(p2);

		// Panel 3: Timer & Stopwatch
		JPanel p3 = new JPanel();
		timer(p3);
		
		// Panel 4: Settings
		JPanel p4 = new JPanel();
		settings(p4);
		
		// Add all panels to the tabbedPane & to frame
		tabbedPane.addTab("Home Page", p0);
		tabbedPane.addTab("Calendar", p1);
		tabbedPane.addTab("Schedule", p2);
		
		tabbedPane.addTab("Timer & Stopwatch", p3);
		tabbedPane.addTab("Settings", p4);

		frame2.getContentPane().add(tabbedPane);
		frame2.setVisible(true);
	}
	
	
	// Home Page
	public static void homepage(JPanel p0) {
		p0.setLayout(new GridLayout(2,1));
		
		JLabel logo = new JLabel(new ImageIcon("src/images/logo.png"));
		p0.add(logo);
		logo.setHorizontalAlignment(JLabel.CENTER);
		logo.setVerticalAlignment(JLabel.BOTTOM);
		
		JLabel copyright = new JLabel("Copyright © 2020 Sakshi Shah & Sharar Noor");
		p0.add(copyright);
		copyright.setHorizontalAlignment(JLabel.CENTER);
		copyright.setVerticalAlignment(JLabel.BOTTOM);
	}
	
	
	// Calendar
	public static void calendar(JPanel p1) {
		p1.setLayout(new GridLayout(3, 1));
		
		JLabel dateLabel = new JLabel("Date: ");
		p1.add(dateLabel);
		dateLabel.setHorizontalAlignment(JLabel.LEFT);
		dateLabel.setVerticalAlignment(JLabel.CENTER);
		
		JLabel timeLabel = new JLabel("Time: ");
		p1.add(timeLabel);
		timeLabel.setHorizontalAlignment(JLabel.LEFT);
		timeLabel.setVerticalAlignment(JLabel.CENTER);
		
		CalendarFeature calendarRun = new CalendarFeature();
		calendarRun.getDate(dateLabel);
		calendarRun.getTime(timeLabel);
		calendarRun.runProgram();
	}
	
	
	// Schedule
	public static void schedule(JPanel p2) {
	  ScheduleFeature scheduleF = new ScheduleFeature();
     
      //create method in scheduleFeature to get table datas
      String[][] dataTimes = {
          {"5-6"},
          {"6-7"},
          {"7-8"},
          {"8-9"},
          {"9-10"},
          {"10-11"},
          {"11-12"},
          {"12-1"},
          {"1-2"},
          {"2-3"},
          {"3-4"},
          {"4-5"},
          {"5-6"},
          {"6-7"},
          {"7-8"},
          {"8-9"},
          {"9-10"},
          {"10-11"},
          {"11-12"},
          };
      
      String[][] dataTasks = {
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
          {new String()},
      };
      
       String[] columnTime = {"Time"};
       String[] columnTasks = {"Tasks"};

       JTable tableTimes = new JTable(dataTimes, columnTime);
       tableTimes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       tableTimes.setRowSelectionAllowed(false);
       tableTimes.setEnabled(false);
       
       p2.setLayout(new BorderLayout());
       p2.add(tableTimes.getTableHeader(), BorderLayout.PAGE_START);
       p2.add(tableTimes, BorderLayout.WEST);
        
       JTable tableInput = new JTable(dataTasks, columnTasks);
       tableInput.setRowSelectionAllowed(false);
       tableInput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
       p2.add(tableInput.getTableHeader(), BorderLayout.PAGE_START);
       p2.add(tableInput, BorderLayout.CENTER);
	}
	
	
	// Timer
	public static void timer(JPanel p3) {
		p3.add(new JLabel("Timer & Stopwatch"));
		p3.setLayout(new GridLayout(1, 1));
	}
	
	
	// Settings
	public static void settings(JPanel p4) {
		p4.add(new JLabel("Settings"));
		p4.setLayout(new GridLayout(1, 1));
	}
	
	
	
	
	public static void main(String[] args) {
		GUI();
	}

}
