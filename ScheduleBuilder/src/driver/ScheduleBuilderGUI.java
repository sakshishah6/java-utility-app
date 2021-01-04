package driver;

import runner.CalendarFeature;
import runner.ScheduleFeature;
import runner.TimerFeature;
import runner.StopwatchFeature;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		JButton startBtn = new JButton("START");
		startBtn.setForeground(new Color(50, 205, 50));
		startBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		startBtn.setHorizontalAlignment(JButton.CENTER);
		startBtn.setVerticalAlignment(JButton.CENTER);
		startBtn.setSize(100,100);
		
		JButton pauseBtn = new JButton("PAUSE");
		pauseBtn.setForeground(new Color(255, 0, 0));
		pauseBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		pauseBtn.setHorizontalAlignment(JButton.CENTER);
		pauseBtn.setVerticalAlignment(JButton.CENTER);
		pauseBtn.setSize(100,100);
		
		JButton resetBtn = new JButton("RESET");
		resetBtn.setForeground(new Color(32, 178, 170));
		resetBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		resetBtn.setHorizontalAlignment(JButton.CENTER);
		resetBtn.setVerticalAlignment(JButton.CENTER);
		resetBtn.setSize(100,100);
		
		p3.add(hourLabel);
		p3.add(minuteLabel);
		p3.add(secondLabel);
    	p3.add(enterHour);
    	p3.add(enterMin);
    	p3.add(enterSec);
    	p3.add(new JLabel(""));
    	p3.add(timer);
    	p3.add(new JLabel(""));
    	p3.add(startBtn);
    	p3.add(pauseBtn);
    	p3.add(resetBtn);
    	
    	timerF.setTextFieldFocus(enterHour, "HH");
    	timerF.setTextFieldFocus(enterMin, "MM");
    	timerF.setTextFieldFocus(enterSec, "SS");
		
	    //When start button is clicked
	    startBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if (timerF.validateFields(enterHour, enterMin, enterSec)==false) {
	        		JOptionPane.showMessageDialog(p3, "Please enter a valid time. (HR <= 12, MIN <= 59, SEC <= 59).");
	        	}
	        	
	        	else timerF.runTimer(timer, enterHour.getText(), enterMin.getText(), enterSec.getText());
	        };
	    });

	    //When stop button is clicked
	    pauseBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent select) {
	        	
	        };
	    });
		    	    
	    //When reset button is clicked
	    resetBtn.addActionListener(new ActionListener(){
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
		p4.add(new JLabel("Stopwatch"));
		p4.setLayout(new GridLayout(1, 1));
		p4.setBackground(Color.WHITE);
		p4.setOpaque(true);
		
    	//stopwatch related objects
		JLabel stopwatchLabel = new JLabel("STOPWATCH");
		stopwatchLabel.setHorizontalAlignment(JLabel.CENTER);
		stopwatchLabel.setVerticalAlignment(JLabel.CENTER);
	}
	
	
	// Main
	public static void main(String[] args) {
		GUI();
	}

}
