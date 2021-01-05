package driver;

import runner.CalendarFeature;
import runner.ScheduleFeature;
import runner.TimerFeature;
import runner.StopwatchFeature;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

public class ScheduleBuilderGUI {

	
	public static void GUI() {
		
		// Create and set up the window.
		final JFrame frame = new JFrame("Schedule Builder");

		frame.setSize(617, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// Panel 0: Home Page
		JPanel p0 = new JPanel();
        ImageIcon tab0Icon, resizedTab0Icon;
        tab0Icon = new ImageIcon("src/media/home icon.png","iconImg0");
        resizedTab0Icon = resizeIcons(tab0Icon);
		homepage(p0);
		
		// Panel 1: Calendar      
		JPanel p1 = new JPanel();
        ImageIcon tab1Icon, resizedTab1Icon;
        tab1Icon = new ImageIcon("src/media/calendar icon.png","iconImg1");
        resizedTab1Icon = resizeIcons(tab1Icon);
		calendar(p1);
		
		// Panel 2: Schedule
		JPanel p2 = new JPanel();
        ImageIcon tab2Icon, resizedTab2Icon;
        tab2Icon = new ImageIcon("src/media/schedule icon.png","iconImg2");
        resizedTab2Icon = resizeIcons(tab2Icon);
		schedule(p2);

		// Panel 3: Timer
		JPanel p3 = new JPanel();
        ImageIcon tab3Icon, resizedTab3Icon;
        tab3Icon = new ImageIcon("src/media/timer icon.png","iconImg3");
        resizedTab3Icon = resizeIcons(tab3Icon);
		timer(p3);
		
		// Panel 4: Stopwatch
		JPanel p4 = new JPanel();
        ImageIcon tab4Icon, resizedTab4Icon;
        tab4Icon = new ImageIcon("src/media/stopwatch icon.png","iconImg4");
        resizedTab4Icon = resizeIcons(tab4Icon);
		stopwatch(p4);
		
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
		
		tabbedPane.addTab("Timer", p3);
		tabbedPane.addTab("Timer", resizedTab3Icon, p3);
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		
		tabbedPane.addTab("Stopwatch", p4);
		tabbedPane.addTab("Stopwatch", resizedTab4Icon, p4);
		tabbedPane.setBackgroundAt(4, Color.WHITE);
		
		frame.getContentPane().add(tabbedPane);
		frame.setVisible(true);
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
	
        JLabel logo = new JLabel(new ImageIcon("src/media/logo.png"));
		logo.setHorizontalAlignment(JLabel.CENTER);
		logo.setVerticalAlignment(JLabel.CENTER);
		
		p0.add(logo);
		
		JPanel infoPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(infoPanel, BoxLayout.Y_AXIS);
		infoPanel.setLayout(boxlayout);
		infoPanel.setBorder(new EmptyBorder(125, 20, 10, 20));
		infoPanel.setBackground(Color.WHITE);
		p0.add(infoPanel);
		
		JLabel version = new JLabel("Version 1.1");
		version.setAlignmentX(Component.CENTER_ALIGNMENT);
		version.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel copyright = new JLabel("Copyright © 2020. Schedule Builder.");
		copyright.setAlignmentX(Component.CENTER_ALIGNMENT);
		copyright.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel creators = new JLabel("Sakshi Shah & Sharar Noor. All rights reserved.");
		creators.setHorizontalAlignment(SwingConstants.CENTER);
		creators.setAlignmentX(Component.CENTER_ALIGNMENT);
		creators.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		infoPanel.add(version);
		infoPanel.add(copyright);
		infoPanel.add(creators);
	}
	
	
	// Calendar
	public static void calendar(JPanel p1) {
      CalendarFeature calendarF = new CalendarFeature();
      
      p1.setLayout(new BorderLayout());
      JTable newTable = calendarF.getTableModel();
      p1.add(new JScrollPane(newTable), BorderLayout.CENTER);

//      p1.setLayout(new GridLayout(3, 1));
//      p1.setBackground(Color.WHITE);
//      p1.setOpaque(true);
//      JLabel dateLabel = new JLabel("Date: ");
//      p1.add(dateLabel);
//      dateLabel.setHorizontalAlignment(JLabel.LEFT);
//      dateLabel.setVerticalAlignment(JLabel.CENTER);
//
//      JLabel timeLabel = new JLabel("Time: ");
//      p1.add(timeLabel);
//      timeLabel.setHorizontalAlignment(JLabel.LEFT);
//      timeLabel.setVerticalAlignment(JLabel.CENTER);
//
//      calendarF.getDate(dateLabel);
//      calendarF.getTime(timeLabel);
//      calendarF.runProgram();
	}
	
	
	// Schedule
	public static void schedule(JPanel p2) {
	  ScheduleFeature scheduleF = new ScheduleFeature();
   
      p2.setLayout(new BorderLayout());
      JTable newTable = scheduleF.getTableModel();
      p2.add(new JScrollPane(newTable), BorderLayout.CENTER);
  
      p2.setBackground(Color.WHITE);
      p2.setOpaque(true);
      
      p2.add(new TextField(), BorderLayout.SOUTH);
      
      JButton clearField = new JButton("Clear Field");
      
      clearField.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
          //GET SELECTED ROW
          newTable.removeEditor();
          newTable.removeColumnSelectionInterval(0, newTable.getColumnCount() - 1);
          newTable.removeRowSelectionInterval(0, newTable.getRowCount() - 1);
          for(int i=0;i<newTable.getRowCount();i++)
          {
            newTable.setValueAt(new String(),i, 1);
            newTable.setValueAt(false, i, 2);
          }
        }
      });
      
      p2.add(clearField, BorderLayout.SOUTH);    
    }
    
	
	// Timer
	public static void timer(JPanel p3) {
		
		TimerFeature timerF = new TimerFeature();
		timerF.runProgram();
		
		//set up p3
		p3.setLayout(new GridLayout(4, 3));
		p3.setBackground(Color.WHITE);
		p3.setOpaque(true);
		
    	JLabel hourLabel = new JLabel("Hour:");
    	hourLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    	hourLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	hourLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	
    	JLabel minuteLabel = new JLabel("Minute:");
    	minuteLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    	minuteLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	minuteLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	
    	JLabel secondLabel = new JLabel("Second:");
    	secondLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    	secondLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	secondLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
    	JTextField enterHour = new JTextField("HH");
    	enterHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterHour.setHorizontalAlignment(JLabel.CENTER);
    	
    	JTextField enterMin = new JTextField("MM");
    	enterMin.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterMin.setHorizontalAlignment(JLabel.CENTER);
    	
    	JTextField enterSec = new JTextField("SS");
    	enterSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterSec.setHorizontalAlignment(JLabel.CENTER);
    	
    	JLabel timer = new JLabel("00:00:00");
    	timer.setFont(new Font("Tahoma", Font.BOLD, 30));
    	timer.setHorizontalAlignment(JLabel.CENTER);
    	timer.setVerticalAlignment(JLabel.CENTER);
    	
		//start, stop and reset buttons
		JButton timerStartBtn = new JButton("START");
		timerStartBtn.setForeground(new Color(50, 205, 50));
		timerStartBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerStartBtn.setHorizontalAlignment(JButton.CENTER);
		timerStartBtn.setVerticalAlignment(JButton.CENTER);
		timerStartBtn.setSize(100,100);
		
		JButton timerPauseBtn = new JButton("PAUSE");
		timerPauseBtn.setForeground(new Color(255, 0, 0));
		timerPauseBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerPauseBtn.setHorizontalAlignment(JButton.CENTER);
		timerPauseBtn.setVerticalAlignment(JButton.CENTER);
		timerPauseBtn.setSize(100,100);
		
		JButton timerResetBtn = new JButton("RESET");
		timerResetBtn.setForeground(new Color(32, 178, 170));
		timerResetBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerResetBtn.setHorizontalAlignment(JButton.CENTER);
		timerResetBtn.setVerticalAlignment(JButton.CENTER);
		timerResetBtn.setSize(100,100);
		
		p3.add(hourLabel);
		p3.add(minuteLabel);
		p3.add(secondLabel);
    	p3.add(enterHour);
    	p3.add(enterMin);
    	p3.add(enterSec);
    	p3.add(new JLabel(""));
    	p3.add(timer);
    	p3.add(new JLabel(""));
    	p3.add(timerStartBtn);
    	p3.add(timerPauseBtn);
    	p3.add(timerResetBtn);
    	
    	timerF.setTextFieldFocus(enterHour, "HH");
    	timerF.setTextFieldFocus(enterMin, "MM");
    	timerF.setTextFieldFocus(enterSec, "SS");
		
	    //When start button is clicked
	    timerStartBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if (timerF.validateFields(enterHour, enterMin, enterSec)==false) {
	        		JOptionPane.showMessageDialog(p3, "Please enter a valid time. (HR <= 12, MIN <= 59, SEC <= 59).");
	        	}
	        	
	        	else timerF.runTimer(timer, enterHour.getText(), enterMin.getText(), enterSec.getText());
	        };
	    });

	    //When stop button is clicked
	    timerPauseBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent select) {
	        	
	        };
	    });
		    	    
	    //When reset button is clicked
	    timerResetBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	enterHour.setText("HH");
	        	enterMin.setText("MM");
	        	enterSec.setText("SS");
	        	timer.setText("00:00:00");
	        };
	    });

	}
	
	
	// Stopwatch
	public static void stopwatch(JPanel p4) {
		p4.setLayout(new GridLayout(2, 3));
		p4.setBackground(Color.WHITE);
		p4.setOpaque(true);
		
    	JLabel stopwatch = new JLabel("00:00:00");
    	stopwatch.setFont(new Font("Tahoma", Font.BOLD, 30));
    	stopwatch.setHorizontalAlignment(JLabel.CENTER);
    	stopwatch.setVerticalAlignment(JLabel.CENTER);
		
		//start, stop and reset buttons
		JButton stopwatchStartBtn = new JButton("START");
		stopwatchStartBtn.setForeground(new Color(50, 205, 50));
		stopwatchStartBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		stopwatchStartBtn.setHorizontalAlignment(JButton.CENTER);
		stopwatchStartBtn.setVerticalAlignment(JButton.CENTER);
		stopwatchStartBtn.setSize(100,100);
		
		JButton stopwatchStopBtn = new JButton("STOP");
		stopwatchStopBtn.setForeground(new Color(255, 0, 0));
		stopwatchStopBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		stopwatchStopBtn.setHorizontalAlignment(JButton.CENTER);
		stopwatchStopBtn.setVerticalAlignment(JButton.CENTER);
		stopwatchStopBtn.setSize(100,100);
		
		JButton stopwatchResetBtn = new JButton("RESET");
		stopwatchResetBtn.setForeground(new Color(32, 178, 170));
		stopwatchResetBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		stopwatchResetBtn.setHorizontalAlignment(JButton.CENTER);
		stopwatchResetBtn.setVerticalAlignment(JButton.CENTER);
		stopwatchResetBtn.setSize(100,100);
		
		p4.add(new JLabel(""));
		p4.add(stopwatch);
    	p4.add(new JLabel(""));
    	p4.add(stopwatchStartBtn);
    	p4.add(stopwatchStopBtn);
    	p4.add(stopwatchResetBtn);
		
	    //When start button is clicked
    	stopwatchStartBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        };
	    });

	    //When stop button is clicked
    	stopwatchStopBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent select) {
	        	
	        };
	    });
		    	    
	    //When reset button is clicked
    	stopwatchResetBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	stopwatch.setText("00:00:00");
	        };
	    });
		
	}
	
	
	// Main
	public static void main(String[] args) {
		GUI();
	}

}
