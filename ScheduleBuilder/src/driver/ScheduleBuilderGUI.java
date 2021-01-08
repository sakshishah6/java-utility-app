package driver;

import runner.CalendarFeature;
import runner.ScheduleFeature;
import runner.StopwatchFeature;
import runner.TimerFeature;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Insets;

public class ScheduleBuilderGUI {

	public static void GUI() {
		
		// Create and set up the window.
		final JFrame frame = new JFrame("Schedule Builder");

		frame.setSize(620, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 1));
		frame.setResizable(false);
        
		/*
		ImageIcon frameImgIcon = new ImageIcon("src/media/logo.png","newImg");
		Image frameImg = frameImgIcon.getImage();
		Image newFrameImg = frameImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        frame.setIconImage(newFrameImg);
        */
		
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
		
		tabbedPane.addTab("Calendar", p1);
		tabbedPane.addTab("Calendar", resizedTab1Icon, p1);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		
		tabbedPane.addTab("Schedule", p2);
		tabbedPane.addTab("Schedule", resizedTab2Icon, p2);
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		
		tabbedPane.addTab("Timer", p3);
		tabbedPane.addTab("Timer", resizedTab3Icon, p3);
		tabbedPane.setBackgroundAt(3, new Color(255, 255, 255));
		
		tabbedPane.addTab("Stopwatch", p4);
		tabbedPane.addTab("Stopwatch", resizedTab4Icon, p4);
		tabbedPane.setBackgroundAt(4, new Color(255, 255, 255));
		
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
		p0.setBackground(new Color(255, 228, 225));
		p0.setOpaque(true);
        p0.setLayout(new BorderLayout(0, 0));
	
        JPanel btnPanel = new JPanel();
		BoxLayout layout = new BoxLayout(btnPanel, BoxLayout.Y_AXIS);
		btnPanel.setLayout(layout);
		btnPanel.setBorder(new EmptyBorder(50,10,50,10));
		btnPanel.setBackground(new Color(255, 228, 225));
		btnPanel.setMaximumSize(new Dimension(175, 90));
		p0.add(btnPanel, BorderLayout.CENTER);
        
		JButton saveBtn = new JButton("Save Session");
		saveBtn.setMargin(new Insets(2, 2, 2, 2));
		saveBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		saveBtn.setMaximumSize(new Dimension(125, 50));
		btnPanel.setBorder(new EmptyBorder(100,10,10,10));
		saveBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		saveBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPanel.add(saveBtn);
        
        JLabel logo = new JLabel(new ImageIcon("src/media/logo.png"));
		logo.setHorizontalAlignment(JLabel.CENTER);
		logo.setVerticalAlignment(JLabel.CENTER);
		logo.setBorder(new EmptyBorder(50,10,10,10));
		p0.add(logo, BorderLayout.NORTH);
		
		JPanel infoPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(infoPanel, BoxLayout.Y_AXIS);
		infoPanel.setLayout(boxlayout);
		infoPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		infoPanel.setBackground(new Color(255, 228, 225));
		infoPanel.setMaximumSize(new Dimension(600, 180));
		p0.add(infoPanel, BorderLayout.SOUTH);
		
		JLabel version = new JLabel("Version 1.1.");
		version.setAlignmentX(Component.CENTER_ALIGNMENT);
		version.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel copyright = new JLabel("Copyright © 2020. Schedule Builder.");
		copyright.setAlignmentX(Component.CENTER_ALIGNMENT);
		copyright.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel creators = new JLabel("Sakshi Shah & Sharar Noor. All rights reserved.");
		creators.setHorizontalAlignment(SwingConstants.CENTER);
		creators.setAlignmentX(Component.CENTER_ALIGNMENT);
		creators.setFont(new Font("Tahoma", Font.PLAIN, 13));
		infoPanel.add(version);
		infoPanel.add(copyright);
		infoPanel.add(creators);
	}
	
	
    // Calendar
    public static void calendar(JPanel p1) {
      CalendarFeature calendarF = new CalendarFeature();
      
      p1.setLayout(new BorderLayout());
      JTable newTable = calendarF.getTableModel();
      
      JPanel centerPanel = new JPanel(new GridLayout(1, 1));
      centerPanel.setBackground(new Color(255, 228, 225));
      centerPanel.add(new JScrollPane(newTable));
      
      centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
      
      p1.add(centerPanel, BorderLayout.CENTER);

      p1.setBackground(Color.WHITE);
      p1.setOpaque(true);
      
      JPanel northPanel = new JPanel(new BorderLayout());
      northPanel.setBackground(new Color(255, 228, 225));
      
      northPanel.setBorder(new EmptyBorder(20, 20, 0, 20));
      
      JLabel dateLabel = new JLabel("Date: ");
      dateLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
      northPanel.add(dateLabel, BorderLayout.WEST);
      dateLabel.setHorizontalAlignment(JLabel.LEFT);
      dateLabel.setVerticalAlignment(JLabel.CENTER);

      JLabel timeLabel = new JLabel("Time: ");
      timeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
      northPanel.add(timeLabel, BorderLayout.EAST);
      timeLabel.setHorizontalAlignment(JLabel.LEFT);
      timeLabel.setVerticalAlignment(JLabel.CENTER);

      calendarF.getDate(dateLabel);
      calendarF.getTime(timeLabel);
      
      p1.add(northPanel, BorderLayout.NORTH);
      
      JPanel southPanel = new JPanel();
      southPanel.setBackground(new Color(255, 228, 225));
      
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
          }
        }
      });
      
      southPanel.add(clearField);
      
      p1.add(southPanel, BorderLayout.SOUTH);
    }
    
    
    // Schedule
    public static void schedule(JPanel p2) {
      ScheduleFeature scheduleF = new ScheduleFeature();
        
      p2.setLayout(new BorderLayout());
      
      JPanel centerPanel = new JPanel(new GridLayout(1, 1));
      centerPanel.setBackground(new Color(255, 228, 225));
      
      JTable newTable = scheduleF.getTableModel();
      centerPanel.add(new JScrollPane(newTable));
      
      p2.add(centerPanel, BorderLayout.CENTER);
  
      p2.setBackground(Color.WHITE);
      p2.setOpaque(true);
      
      JPanel southPanel = new JPanel();
      southPanel.setBackground(new Color(255, 228, 225));
      BoxLayout southLayout = new BoxLayout(southPanel, BoxLayout.Y_AXIS);
      southPanel.setLayout(southLayout);
      
      centerPanel.setMaximumSize(new Dimension(620, 200));
      centerPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
      southPanel.setMaximumSize(new Dimension(620, 380));
      southPanel.setBorder(new EmptyBorder(10, 20, 20, 20));
      
      JLabel notesLabel = new JLabel("NOTES");
      notesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      notesLabel.setHorizontalAlignment(SwingConstants.LEFT);
      notesLabel.setVerticalAlignment(SwingConstants.TOP);
      southPanel.add(notesLabel);
      
      JTextArea notes = new JTextArea();
      notesLabel.setLabelFor(notes);
      notes.setRows(8);
      notes.setMaximumSize(new Dimension(50, 50));
      
      southPanel.add(new JScrollPane(notes));
     
      
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
          
          notes.setText(new String());
          
        }
      });
      clearField.setSize(20, 20);
      
      clearField.setAlignmentX(Component.CENTER_ALIGNMENT);
      //clearField.setBorder(new EmptyBorder(20, 5, 20, 20));
      
      southPanel.add(clearField);
      
      
      p2.add(southPanel, BorderLayout.SOUTH);
    }
    
	
	// Timer
	public static void timer(JPanel p3) {
		
		TimerFeature timerF = new TimerFeature();
		
		//set up p3
		p3.setLayout(new GridLayout(1, 1));
		p3.setBackground(Color.WHITE);
		p3.setOpaque(true);
		
		//panel for timer info
		JPanel timerInfoPanel = new JPanel();
		timerInfoPanel.setBackground(new Color(255, 228, 225));
		p3.add(timerInfoPanel);
    	
    	JLabel emptyLabel1 = new JLabel("");
    	emptyLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);
    	emptyLabel1.setHorizontalAlignment(SwingConstants.LEFT);
    	emptyLabel1.setBorder(new EmptyBorder(10, 10, 10, 10));
    	emptyLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	
    	JLabel emptyLabel2 = new JLabel("");
    	emptyLabel2.setAlignmentX(Component.LEFT_ALIGNMENT);
    	emptyLabel2.setHorizontalAlignment(SwingConstants.LEFT);
    	emptyLabel2.setBorder(new EmptyBorder(10, 10, 10, 10));
    	emptyLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	timerInfoPanel.setLayout(null);
    	
    	JLabel hourLabel = new JLabel("Hour:");
    	hourLabel.setBounds(167, 61, 56, 44);
    	timerInfoPanel.add(hourLabel);
    	hourLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	hourLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    	hourLabel.setBorder(new EmptyBorder(15, 10, 10, 10));
    	hourLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	
    	JButton enterBtn = new JButton("Enter");
    	enterBtn.setBounds(363, 114, 81, 35);
    	timerInfoPanel.add(enterBtn);
    	enterBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterBtn.setMaximumSize(new Dimension(75, 35));
    	
    	JTextField enterMin = new JTextField("MM");
    	enterMin.setBounds(233, 114, 100, 35);
    	timerInfoPanel.add(enterMin);
    	enterMin.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterMin.setHorizontalAlignment(SwingConstants.CENTER);
    	enterMin.setMaximumSize(new Dimension(100, 35));
    	timerF.setTextFieldFocus(enterMin, "MM");
    	
    	JTextField enterSec = new JTextField("SS");
    	enterSec.setBounds(233, 160, 100, 35);
    	timerInfoPanel.add(enterSec);
    	enterSec.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterSec.setHorizontalAlignment(SwingConstants.CENTER);
    	enterSec.setMaximumSize(new Dimension(100, 35));
    	timerF.setTextFieldFocus(enterSec, "SS");
    	
    	JTextField enterHour = new JTextField("HH");
    	enterHour.setBounds(233, 68, 100, 35);
    	timerInfoPanel.add(enterHour);
    	enterHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	enterHour.setHorizontalAlignment(JTextField.CENTER);
    	enterHour.setMaximumSize(new Dimension(100, 35));
    	
    	timerF.setTextFieldFocus(enterHour, "HH");
    	
    	JLabel secondLabel = new JLabel("Second:");
    	secondLabel.setBounds(151, 158, 72, 39);
    	timerInfoPanel.add(secondLabel);
    	secondLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	secondLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    	secondLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
    	secondLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	
    	JLabel minuteLabel = new JLabel("Minute:");
    	minuteLabel.setBounds(155, 112, 68, 39);
    	timerInfoPanel.add(minuteLabel);
    	minuteLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	minuteLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    	minuteLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
    	minuteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		//additional timerPanel within the generalTimerPanel
		JPanel timerPanel = new JPanel();
		timerPanel.setBounds(190, 249, 200, 75);
		timerInfoPanel.add(timerPanel);
		timerPanel.setLayout(new GridLayout(1,1));
		timerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), Color.GRAY, Color.GRAY));
		timerPanel.setMaximumSize(new Dimension(200, 75));
		timerPanel.setBackground(new Color(255, 255, 255));
		
		JLabel timer = new JLabel("00:00:00");
		timerPanel.add(timer);
		timer.setFont(new Font("Tahoma", Font.BOLD, 30));
		timer.setHorizontalAlignment(JLabel.CENTER);
		timer.setVerticalAlignment(JLabel.CENTER);
		
		JButton timerStartBtn = new JButton("START");
		timerStartBtn.setBounds(92, 361, 116, 57);
		timerInfoPanel.add(timerStartBtn);
		timerStartBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		timerStartBtn.setForeground(new Color(50, 205, 50));
		timerStartBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerStartBtn.setHorizontalAlignment(JButton.CENTER);
		timerStartBtn.setVerticalAlignment(JButton.CENTER);
		timerStartBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		timerStartBtn.setMaximumSize(new Dimension(100,50));
		timerStartBtn.setEnabled(false);
		
		JButton timerPauseBtn = new JButton("PAUSE");
		timerPauseBtn.setBounds(232, 361, 116, 57);
		timerInfoPanel.add(timerPauseBtn);
		timerPauseBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		timerPauseBtn.setForeground(new Color(255, 0, 0));
		timerPauseBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerPauseBtn.setHorizontalAlignment(JButton.CENTER);
		timerPauseBtn.setVerticalAlignment(JButton.CENTER);
		timerPauseBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		timerPauseBtn.setMaximumSize(new Dimension(100,50));
		timerPauseBtn.setEnabled(false);
		
		JButton timerResetBtn = new JButton("RESET");
		timerResetBtn.setBounds(371, 361, 116, 57);
		timerInfoPanel.add(timerResetBtn);
		timerResetBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		timerResetBtn.setForeground(new Color(32, 178, 170));
		timerResetBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		timerResetBtn.setHorizontalAlignment(JButton.CENTER);
		timerResetBtn.setVerticalAlignment(JButton.CENTER);
		timerResetBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		timerResetBtn.setMaximumSize(new Dimension(100,50));
		timerResetBtn.setEnabled(false);
	 	enterHour.addKeyListener(new KeyAdapter() {
	 		@Override
	 		public void keyPressed(KeyEvent e) {
	 			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	 				enterBtn.doClick();
	 			}
	 		}
	 	});
	 	
    	enterMin.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
    				enterBtn.doClick();
    			}
    		}
    	});
    	
    	enterSec.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
    				enterBtn.doClick();
    			}
    		}
    	});
    	
    	enterBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if (timerF.validateFields(enterHour, enterMin, enterSec)==false) {
	        		JOptionPane.showMessageDialog(p3, "Please enter a valid time.\nHOUR < 13\nMINUTE < 60\nSECOND < 60");
	        		enterBtn.setEnabled(true);
            		timerStartBtn.setEnabled(false);
            		timerPauseBtn.setEnabled(false);
            		timerResetBtn.setEnabled(false);
	        	}
	        	else {
	        		timerF.runTimer(enterHour, enterMin, enterSec, timer, enterBtn, timerStartBtn, timerPauseBtn, timerResetBtn);
	        		enterBtn.setEnabled(false);
            		timerStartBtn.setEnabled(true);
            		timerPauseBtn.setEnabled(false);
            		timerResetBtn.setEnabled(true);
	        	}
	        }
	    });
	}

	
	// Stopwatch
	public static void stopwatch(JPanel p4) {
		
		StopwatchFeature stopwatchF = new StopwatchFeature();
		
		p4.setLayout(new GridLayout(1, 1));
		p4.setBackground(Color.WHITE);
		p4.setOpaque(true);
		
		//panel for showing stopwatch
		JPanel watchPanel = new JPanel();
		watchPanel.setBorder(new EmptyBorder(90, 200, 90, 200));
		watchPanel.setBackground(new Color(255, 228, 225));
		watchPanel.setMaximumSize(new Dimension(310, 290));
		p4.add(watchPanel);
    	watchPanel.setLayout(null);
    	
    	JPanel stopwatchPanel = new JPanel();
    	stopwatchPanel.setBounds(197, 114, 209, 81);
    	stopwatchPanel.setLayout(new GridLayout(1, 1));
    	stopwatchPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), Color.LIGHT_GRAY, Color.GRAY, new Color(128, 128, 128)));
    	stopwatchPanel.setMaximumSize(new Dimension(200, 100));
    	stopwatchPanel.setBackground(new Color(255, 255, 255));
    	watchPanel.add(stopwatchPanel);
    	
    	JLabel stopwatch = new JLabel("00:00:00");
    	stopwatchPanel.add(stopwatch);
    	stopwatch.setFont(new Font("Tahoma", Font.BOLD, 30));
    	stopwatch.setHorizontalAlignment(JLabel.CENTER);
    	stopwatch.setVerticalAlignment(JLabel.CENTER);
    	stopwatch.setMaximumSize(new Dimension(200, 100));
    	
    	JButton stopwatchStartBtn = new JButton("START");
    	stopwatchStartBtn.setBounds(105, 244, 114, 61);
    	watchPanel.add(stopwatchStartBtn);
    	stopwatchStartBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    	stopwatchStartBtn.setAlignmentY(Component.TOP_ALIGNMENT);
    	stopwatchStartBtn.setForeground(new Color(50, 205, 50));
    	stopwatchStartBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
    	stopwatchStartBtn.setHorizontalAlignment(JButton.CENTER);
    	stopwatchStartBtn.setVerticalAlignment(JButton.CENTER);
    	stopwatchStartBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    	stopwatchStartBtn.setMaximumSize(new Dimension(100,50));
    	
    	JButton stopwatchResetBtn = new JButton("RESET");
    	stopwatchResetBtn.setBounds(384, 244, 114, 61);
    	watchPanel.add(stopwatchResetBtn);
    	stopwatchResetBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    	stopwatchResetBtn.setAlignmentY(Component.TOP_ALIGNMENT);
    	stopwatchResetBtn.setForeground(new Color(32, 178, 170));
    	stopwatchResetBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
    	stopwatchResetBtn.setHorizontalAlignment(JButton.CENTER);
    	stopwatchResetBtn.setVerticalAlignment(JButton.CENTER);
    	stopwatchResetBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    	stopwatchResetBtn.setMaximumSize(new Dimension(100,50));
    	stopwatchResetBtn.setEnabled(false);
    	
    	JButton stopwatchStopBtn = new JButton("STOP");
    	stopwatchStopBtn.setBounds(246, 244, 114, 61);
    	watchPanel.add(stopwatchStopBtn);
    	stopwatchStopBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    	stopwatchStopBtn.setAlignmentY(Component.TOP_ALIGNMENT);
    	stopwatchStopBtn.setForeground(new Color(255, 0, 0));
    	stopwatchStopBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
    	stopwatchStopBtn.setHorizontalAlignment(JButton.CENTER);
    	stopwatchStopBtn.setVerticalAlignment(JButton.CENTER);
    	stopwatchStopBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    	stopwatchStopBtn.setMaximumSize(new Dimension(100,50));
    	stopwatchStopBtn.setEnabled(false);
    	
    	stopwatchF.runStopwatch(stopwatch, stopwatchStartBtn, stopwatchStopBtn, stopwatchResetBtn);
	}	

	
	// Main
	public static void main(String[] args) {
		GUI();
	}

}
