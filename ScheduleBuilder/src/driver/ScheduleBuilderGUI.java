package driver;

import runner.CalendarFeature;
import runner.ScheduleFeature;
import runner.TimerFeature;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;

public class ScheduleBuilderGUI {

	
	public static void GUI() {
		
		// Create and set up the window.
		final JFrame frame = new JFrame("Schedule Builder");

		frame.setSize(620, 580);
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
		p3.setLayout(new GridLayout(2, 1));
		p3.setBackground(Color.WHITE);
		p3.setOpaque(true);
		
		//panel for timer info
		JPanel timerInfoPanel = new JPanel();
		BoxLayout boxlayout1 = new BoxLayout(timerInfoPanel, BoxLayout.X_AXIS);
		timerInfoPanel.setLayout(boxlayout1);
		timerInfoPanel.setBorder(new EmptyBorder(20, 10, 10, 5));
		timerInfoPanel.setBackground(Color.WHITE);
		p3.add(timerInfoPanel);
		
		//additional labelPanel within timerInfoPanel
		JPanel labelPanel = new JPanel();
		BoxLayout boxlayout2 = new BoxLayout(labelPanel, BoxLayout.Y_AXIS);
		labelPanel.setLayout(boxlayout2);
		labelPanel.setPreferredSize((new Dimension(300, 100)));
		labelPanel.setBorder(new EmptyBorder(20, 200, 20, 5));
		labelPanel.setBackground(Color.WHITE);
		timerInfoPanel.add(labelPanel);
		
    	JLabel hourLabel = new JLabel("Hour:");
    	hourLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	hourLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    	hourLabel.setBorder(new EmptyBorder(15, 10, 10, 10));
    	hourLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
    	
    	JLabel minuteLabel = new JLabel("Minute:");
    	minuteLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	minuteLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    	minuteLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
    	minuteLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
    	
    	JLabel secondLabel = new JLabel("Second:");
    	secondLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	secondLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    	secondLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
    	secondLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
    	labelPanel.add(hourLabel);
    	labelPanel.add(minuteLabel);
    	labelPanel.add(secondLabel);
    	
    	//additional textFieldPanel within timerInfoPanel
		JPanel textFieldPanel = new JPanel();
		BoxLayout boxlayout3 = new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS);
		textFieldPanel.setLayout(boxlayout3);
		textFieldPanel.setBorder(new EmptyBorder(20, 5, 20, 20));
		textFieldPanel.setBackground(Color.WHITE);
		textFieldPanel.setPreferredSize((new Dimension(300, 100)));
		timerInfoPanel.add(textFieldPanel);
    	
    	JTextField enterHour = new JTextField("HH");
    	enterHour.setAlignmentX(Component.LEFT_ALIGNMENT);
    	enterHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterHour.setHorizontalAlignment(SwingConstants.LEFT);
    	enterHour.setMaximumSize((new Dimension(50,30)));
    	
    	JTextField enterMin = new JTextField("MM");
    	enterMin.setAlignmentX(Component.LEFT_ALIGNMENT);
    	enterMin.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterMin.setHorizontalAlignment(SwingConstants.LEFT);
    	enterMin.setMaximumSize((new Dimension(50,35)));
    	
    	JTextField enterSec = new JTextField("SS");
    	enterSec.setAlignmentX(Component.LEFT_ALIGNMENT);
    	enterSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterSec.setHorizontalAlignment(SwingConstants.LEFT);
    	enterSec.setMaximumSize((new Dimension(50,35)));
    	
    	textFieldPanel.add(enterHour);
    	textFieldPanel.add(enterMin);
    	textFieldPanel.add(enterSec);
    	
    	//panel for timer & buttons itself
		JPanel generalTimerPanel = new JPanel();
		BoxLayout boxlayout4 = new BoxLayout(generalTimerPanel, BoxLayout.Y_AXIS);
		generalTimerPanel.setLayout(boxlayout4);
		generalTimerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		generalTimerPanel.setBackground(Color.WHITE);
		p3.add(generalTimerPanel);
		
		//additional timerPanel within the generalTimerPanel
		JPanel timerPanel = new JPanel();
		BoxLayout boxlayout5 = new BoxLayout(timerPanel, BoxLayout.X_AXIS);
		timerPanel.setLayout(boxlayout5);
		timerPanel.setBorder(new EmptyBorder(10, 30, 30, 30));
		timerPanel.setBackground(Color.WHITE);
		generalTimerPanel.add(timerPanel);
		
    	JLabel timer = new JLabel("00:00:00");
    	timer.setFont(new Font("Tahoma", Font.BOLD, 30));
    	timer.setHorizontalAlignment(JLabel.CENTER);
    	timer.setVerticalAlignment(JLabel.CENTER);
    	timerPanel.add(timer);
    	
		//additional buttonPanel within the generalTimerPanel
		JPanel buttonPanel = new JPanel();
		BoxLayout boxlayout6 = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(boxlayout6);
		buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setMaximumSize(new Dimension(300, 100));
		generalTimerPanel.add(buttonPanel);
    	
		JButton timerStartBtn = new JButton("START");
		timerStartBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		timerStartBtn.setForeground(new Color(50, 205, 50));
		timerStartBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerStartBtn.setHorizontalAlignment(JButton.CENTER);
		timerStartBtn.setVerticalAlignment(JButton.CENTER);
		timerStartBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		timerStartBtn.setMaximumSize((new Dimension(100,50)));
		buttonPanel.add(timerStartBtn);
		
		JButton timerPauseBtn = new JButton("PAUSE");
		timerPauseBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		timerPauseBtn.setForeground(new Color(255, 0, 0));
		timerPauseBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerPauseBtn.setHorizontalAlignment(JButton.CENTER);
		timerPauseBtn.setVerticalAlignment(JButton.CENTER);
		timerPauseBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		timerPauseBtn.setMaximumSize((new Dimension(100,50)));
		buttonPanel.add(timerPauseBtn);
		
		JButton timerResetBtn = new JButton("RESET");
		timerResetBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		timerResetBtn.setForeground(new Color(32, 178, 170));
		timerResetBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerResetBtn.setHorizontalAlignment(JButton.CENTER);
		timerResetBtn.setVerticalAlignment(JButton.CENTER);
		timerResetBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		timerResetBtn.setMaximumSize((new Dimension(100,50)));
		buttonPanel.add(timerResetBtn);
		
    	timerF.setTextFieldFocus(enterHour, "HH");
    	timerF.setTextFieldFocus(enterMin, "MM");
    	timerF.setTextFieldFocus(enterSec, "SS");
		
	    //When start button is clicked
	    timerStartBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if (timerF.validateFields(enterHour, enterMin, enterSec)==false) {
	        		JOptionPane.showMessageDialog(p3, "Please enter a valid time.\nHOUR < 13\nMINUTE < 60\nSECOND < 60");
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
	        	timerF.resetTimer();
	        	enterHour.setText("HH");
	        	enterMin.setText("MM");
	        	enterSec.setText("SS");
	        	timer.setText("00:00:00");
	        };
	    });

	}
	
	
	// Stopwatch
	public static void stopwatch(JPanel p4) {
		p4.setLayout(new GridLayout(2, 1));
		p4.setBackground(Color.WHITE);
		p4.setOpaque(true);
		
		//panel for showing stopwatch
		JPanel watchPanel = new JPanel();
		watchPanel.setLayout(new GridLayout(1,1));
		watchPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		watchPanel.setBackground(Color.WHITE);
		watchPanel.setMaximumSize(new Dimension(310, 290));
		p4.add(watchPanel);
		
    	JLabel stopwatch = new JLabel("00:00:00");
    	stopwatch.setFont(new Font("Tahoma", Font.BOLD, 30));
    	stopwatch.setHorizontalAlignment(JLabel.CENTER);
    	stopwatch.setVerticalAlignment(JLabel.CENTER);
    	watchPanel.add(stopwatch);
		
		//panel for buttons
		JPanel buttonPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(boxlayout);
		buttonPanel.setBorder(new EmptyBorder(10, 150, 10, 100));
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setMaximumSize(new Dimension(310, 290));
		p4.add(buttonPanel);
		
		JButton stopwatchStartBtn = new JButton("START");
		stopwatchStartBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopwatchStartBtn.setAlignmentY(Component.TOP_ALIGNMENT);
		stopwatchStartBtn.setForeground(new Color(50, 205, 50));
		stopwatchStartBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		stopwatchStartBtn.setHorizontalAlignment(JButton.CENTER);
		stopwatchStartBtn.setVerticalAlignment(JButton.CENTER);
		stopwatchStartBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		stopwatchStartBtn.setMaximumSize((new Dimension(100,50)));
		
		JButton stopwatchStopBtn = new JButton("STOP");
		stopwatchStopBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopwatchStopBtn.setAlignmentY(Component.TOP_ALIGNMENT);
		stopwatchStopBtn.setForeground(new Color(255, 0, 0));
		stopwatchStopBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		stopwatchStopBtn.setHorizontalAlignment(JButton.CENTER);
		stopwatchStopBtn.setVerticalAlignment(JButton.CENTER);
		stopwatchStopBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		stopwatchStopBtn.setMaximumSize((new Dimension(100,50)));
		
		JButton stopwatchResetBtn = new JButton("RESET");
		stopwatchResetBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopwatchResetBtn.setAlignmentY(Component.TOP_ALIGNMENT);
		stopwatchResetBtn.setForeground(new Color(32, 178, 170));
		stopwatchResetBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		stopwatchResetBtn.setHorizontalAlignment(JButton.CENTER);
		stopwatchResetBtn.setVerticalAlignment(JButton.CENTER);
		stopwatchResetBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		stopwatchResetBtn.setMaximumSize((new Dimension(100,50)));
		
		buttonPanel.add(stopwatchStartBtn);
		buttonPanel.add(stopwatchStopBtn);
		buttonPanel.add(stopwatchResetBtn);
		
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
