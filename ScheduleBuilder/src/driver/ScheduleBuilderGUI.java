package driver;

import runner.CalendarFeature;
import runner.ScheduleFeature;
import runner.TimerFeature;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
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
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Font;

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
        ImageIcon tab0Icon, resizedTab0Icon;
        tab0Icon = new ImageIcon("src/images/home icon.png","iconImg0");
        resizedTab0Icon = resizeIcons(tab0Icon);
		homepage(p0);
		
		// Panel 1: Calendar      
		JPanel p1 = new JPanel();
        ImageIcon tab1Icon, resizedTab1Icon;
        tab1Icon = new ImageIcon("src/images/calendar icon.png","iconImg1");
        resizedTab1Icon = resizeIcons(tab1Icon);
		calendar(p1);
		
		// Panel 2: Schedule
		JPanel p2 = new JPanel();
        ImageIcon tab2Icon, resizedTab2Icon;
        tab2Icon = new ImageIcon("src/images/schedule icon.png","iconImg2");
        resizedTab2Icon = resizeIcons(tab2Icon);
		schedule(p2);

		// Panel 3: Timer & Stopwatch
		JPanel p3 = new JPanel();
        ImageIcon tab3Icon, resizedTab3Icon;
        tab3Icon = new ImageIcon("src/images/timer icon.png","iconImg3");
        resizedTab3Icon = resizeIcons(tab3Icon);
		timer(p3);
		
		// Panel 4: Settings
		JPanel p4 = new JPanel();
        ImageIcon tab4Icon, resizedTab4Icon;
        tab4Icon = new ImageIcon("src/images/settings icon.png","iconImg4");
        resizedTab4Icon = resizeIcons(tab4Icon);
		settings(p4);
		
		// Add all panels to the tabbedPane & to frame
		tabbedPane.addTab("Home Page", p0);
		tabbedPane.addTab("Home Page", resizedTab0Icon, p0);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		
		tabbedPane.addTab("Calendar", p1);
		tabbedPane.addTab("Calendar", resizedTab1Icon, p1);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		
		tabbedPane.addTab("Schedule", p2);
		tabbedPane.addTab("Schedule", resizedTab2Icon, p2);

		tabbedPane.setBackgroundAt(2, Color.WHITE);
		
		tabbedPane.addTab("Timer & Stopwatch", p3);
		tabbedPane.addTab("Timer & Stopwatch", resizedTab3Icon, p3);
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		
		tabbedPane.addTab("Settings", p4);
		tabbedPane.addTab("Settings", resizedTab4Icon, p4);
		tabbedPane.setBackgroundAt(4, Color.WHITE);
		
		frame2.getContentPane().add(tabbedPane);
		frame2.setVisible(true);
	}
	
	//Resize images
	public static ImageIcon resizeIcons(ImageIcon icon) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);
        return newIcon;
	}
	
	
	// Home Page
	public static void homepage(JPanel p0) {
		p0.setLayout(new GridLayout(2,1));
		p0.setBackground(Color.WHITE);
		p0.setOpaque(true);
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
		p1.setBackground(Color.WHITE);
		p1.setOpaque(true);
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
      
      String[] columnTime = {"Time"};
      String[] columnTasks = {"Tasks"};
     
      JTable tableTimes = new JTable(scheduleF.getTableTimes(), columnTime);
      tableTimes.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
      tableTimes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      tableTimes.setRowSelectionAllowed(false);
      tableTimes.setEnabled(false);
      
      p2.setLayout(new BorderLayout());
      //p2.add(tableTimes.getTableHeader(), BorderLayout.PAGE_START);
      p2.add(tableTimes, BorderLayout.WEST);
       
      JTable tableInput = new JTable(scheduleF.getTableTasks(), columnTasks);
      tableInput.setRowSelectionAllowed(false);
      tableInput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      p2.setBackground(Color.WHITE);
      p2.setOpaque(true);
      p2.add(tableInput, BorderLayout.CENTER);
      
      JButton clearField = new JButton("Clear Field");
      
      clearField.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
          //GET SELECTED ROW
          tableInput.removeEditor();
          for(int i=1;i<tableInput.getRowCount();i++)
          {
            tableInput.setValueAt(new String(),i, 0);
          }
        }
      });
      
      p2.add(clearField, BorderLayout.SOUTH);
    }
    
	// Timer
	public static void timer(JPanel p3) {
		p3.setLayout(new GridLayout(8, 2));
		p3.setBackground(Color.WHITE);
		p3.setOpaque(true);
		
		JLabel options = new JLabel("Select an option:");
		p3.add(options);
		options.setHorizontalAlignment(JLabel.LEFT);
		options.setVerticalAlignment(JLabel.CENTER);
		
		JRadioButton timerRadioBtn = new JRadioButton("Timer");
		p3.add(timerRadioBtn);
		timerRadioBtn.setHorizontalAlignment(JRadioButton.LEFT);
		timerRadioBtn.setVerticalAlignment(JRadioButton.CENTER);
		
		JRadioButton stopwatchRadioBtn = new JRadioButton("Stopwatch");
		p3.add(stopwatchRadioBtn);
		stopwatchRadioBtn.setHorizontalAlignment(JRadioButton.LEFT);
		stopwatchRadioBtn.setVerticalAlignment(JRadioButton.CENTER);
		
		JButton selectButton = new JButton("Select");
		p3.add(selectButton);
		selectButton.setHorizontalAlignment(JButton.LEFT);
		selectButton.setVerticalAlignment(JButton.CENTER);
		
		TimerFeature timerF = new TimerFeature();
		timerF.runProgram();
	}
	
	// Settings
	public static void settings(JPanel p4) {
		p4.add(new JLabel("Settings"));
		p4.setLayout(new GridLayout(1, 1));
		p4.setBackground(Color.WHITE);
		p4.setOpaque(true);
	}
	
	public static void main(String[] args) {
		GUI();
	}

}
