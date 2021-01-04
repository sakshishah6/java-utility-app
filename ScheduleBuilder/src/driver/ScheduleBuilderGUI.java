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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;

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
        tab4Icon = new ImageIcon("src/media/settings icon.png","iconImg4");
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
		p3.setLayout(new GridLayout(0, 4));
		p3.setBackground(Color.WHITE);
		p3.setOpaque(true);
		
		//code for selecting between timer & stopwatch
		JLabel options = new JLabel("Select an option:");
		p3.add(options);
		options.setHorizontalAlignment(JLabel.LEFT);
		options.setVerticalAlignment(JLabel.CENTER);
		
		JRadioButton timerRadioBtn = new JRadioButton("Timer");
		p3.add(timerRadioBtn);
		timerRadioBtn.setHorizontalAlignment(JRadioButton.LEFT);
		timerRadioBtn.setVerticalAlignment(JRadioButton.CENTER);
		timerRadioBtn.setBackground(Color.WHITE);
		
		JRadioButton stopwatchRadioBtn = new JRadioButton("Stopwatch");
		p3.add(stopwatchRadioBtn);
		stopwatchRadioBtn.setHorizontalAlignment(JRadioButton.LEFT);
		stopwatchRadioBtn.setVerticalAlignment(JRadioButton.CENTER);
		stopwatchRadioBtn.setBackground(Color.WHITE);
		
		ButtonGroup G = new ButtonGroup();
		G.add(timerRadioBtn);
		G.add(stopwatchRadioBtn);
		
		JButton selectBtn = new JButton("Select");
		p3.add(selectBtn);
		selectBtn.setHorizontalAlignment(JButton.CENTER);
		selectBtn.setVerticalAlignment(JButton.CENTER);
		
		/*
		//leave a line of space
		p3.add(new JLabel(""));
		p3.add(new JLabel(""));
		p3.add(new JLabel(""));
		p3.add(new JLabel(""));
		*/
		
		//JLabel emptyLabel = new JLabel("");
		
		//timer related objects
		JLabel timerLabel = new JLabel("TIMER");
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setVerticalAlignment(JLabel.CENTER);
		
    	JLabel enterTimerInfo = new JLabel("Enter the following & then press START");
		enterTimerInfo.setHorizontalAlignment(JLabel.LEFT);
		enterTimerInfo.setVerticalAlignment(JLabel.CENTER);
		
    	JTextField enterHour = new JTextField("HH");
    	enterHour.setHorizontalAlignment(JLabel.CENTER);
    	
    	JTextField enterMin = new JTextField("MM");
    	enterMin.setHorizontalAlignment(JLabel.CENTER);
    	
    	JTextField enterSec = new JTextField("SS");
    	enterSec.setHorizontalAlignment(JLabel.CENTER);
    	
    	JLabel timer = new JLabel("00:00:00");
    	timer.setHorizontalAlignment(JLabel.LEFT);
    	timer.setVerticalAlignment(JLabel.CENTER);
		
    	//stopwatch related objects
		JLabel stopwatchLabel = new JLabel("STOPWATCH");
		stopwatchLabel.setHorizontalAlignment(JLabel.CENTER);
		stopwatchLabel.setVerticalAlignment(JLabel.CENTER);
    	
		//start, stop and reset buttons
		JButton startBtn = new JButton("START");
		startBtn.setHorizontalAlignment(JButton.CENTER);
		startBtn.setVerticalAlignment(JButton.CENTER);
		JButton stopBtn = new JButton("STOP");
		stopBtn.setHorizontalAlignment(JButton.CENTER);
		stopBtn.setVerticalAlignment(JButton.CENTER);
		JButton resetBtn = new JButton("RESET");
		resetBtn.setHorizontalAlignment(JButton.CENTER);
		resetBtn.setVerticalAlignment(JButton.CENTER);
		
		//when select button is clicked
	    selectBtn.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	p3.remove(timerLabel);
	        	p3.remove(enterTimerInfo);
	        	p3.remove(enterHour);
	        	p3.remove(enterMin);
	        	p3.remove(enterSec);
	        	p3.remove(timer);
	        	p3.remove(stopwatchLabel);
	        	p3.revalidate();
	        	
	        	if (timerRadioBtn.isSelected()) {
		    		
	        		p3.add(timerLabel);
		    		p3.add(enterTimerInfo);
		        	p3.add(enterHour);
		        	p3.add(enterMin);
		        	p3.add(enterSec);
		        	p3.add(timer);
		        	
		        	timerF.setTextFieldFocus(enterHour, "HH");
		        	timerF.setTextFieldFocus(enterMin, "MM");
		        	timerF.setTextFieldFocus(enterSec, "SS");

		    	    //When start button is clicked
		    	    startBtn.addActionListener(new ActionListener(){
		    	        @Override
		    	        public void actionPerformed(ActionEvent e) {
		    	        	if (timerF.validateFields(enterHour, enterMin, enterSec)==false) {
		    	        		JOptionPane.showMessageDialog(p3, "Please enter a valid time (hour<=12, min<=59, sec<=59).");
		    	        	}
		    	        	
		    	        	else timerF.runTimer(timer, enterHour.getText(), enterMin.getText(), enterSec.getText());
		    	        };
		    	    });
		    	    
		    	    /*
		    	    //When pause button is clicked
		    	    startBtn.addActionListener(new ActionListener(){
		    	        @Override
		    	        public void actionPerformed(ActionEvent select) {
		    	        	if (timerF.validateFields(enterHour, enterMin, enterSec)==false) {
		    	        		JOptionPane.showMessageDialog(enterHour, "Please enter a valid time (hour<13, min<60, sec<60).");
		    	        	};
		    	        	
		        			timerF.runTimer();
		    	        };
		    	    });
		    	    */
		    	    
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
	        	
	    		else if (stopwatchRadioBtn.isSelected()) {
		    		//stopwatch label
		    		p3.add(stopwatchLabel);
	    			
		        	//reset stopwatch stuff
	    			timerF.runStopwatch();
	    		}
	        	
	        	p3.add(startBtn);
	        	p3.add(stopBtn);
	        	p3.add(resetBtn);
	        }
	    });
	    
	    

	    
	}
	
	// Stopwatch
	public static void stopwatch(JPanel p4) {
		p4.add(new JLabel("Stopwatch"));
		p4.setLayout(new GridLayout(1, 1));
		p4.setBackground(Color.WHITE);
		p4.setOpaque(true);
	}
	
	public static void main(String[] args) {
		GUI();
	}

}
