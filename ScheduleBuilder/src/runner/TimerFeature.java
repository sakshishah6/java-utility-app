package runner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The type TimerFeature
 */
public class TimerFeature {

  private int delay = 1000;
  private long period = 1000;
  private int start = 0;
  private int secOnlyNew = 0;
  private int pauseHr = 0;
  private int pauseMin = 0;
  private int pauseSec = 0;
  private TimerTask task = null;
  private Timer t = new Timer();


  /**
   * Sets the focus on or away from the input textfield
   * 
   * @param enterField (JTextField enterHr, enterMin or enterSec)
   * @param t (String SS, MM or HH)
   */
  public void setTextFieldFocus(JTextField enterField, String t) {

    enterField.addFocusListener(new FocusListener() {
      public void focusLost(FocusEvent e) {
        if (enterField.getText().trim().equals(""))
          enterField.setText(t);
        else
          ; // do nothing
      }

      public void focusGained(FocusEvent e) {
        if (enterField.getText().trim().equals(t))
          enterField.setText("");
        else
          ; // do nothing
      }
    });
  };


  /**
   * Determines whether inputs are valid or not
   * 
   * @param JTextField enterHour
   * @param JTextField enterMin
   * @param JTextField enterSec
   * @return boolean value
   */
  public boolean validateFields(JTextField enterHour, JTextField enterMin, JTextField enterSec) {

    String hour = enterHour.getText();
    String min = enterMin.getText();
    String sec = enterSec.getText();

    if (hour == "HH")
      enterHour.setText("00");
    if (hour == "MM")
      enterMin.setText("00");
    if (hour == "SS")
      enterSec.setText("00");

    boolean isNumH = hour.chars().allMatch(Character::isDigit);
    boolean isNumM = min.chars().allMatch(Character::isDigit);
    boolean isNumS = sec.chars().allMatch(Character::isDigit);

    if (enterHour == null || enterMin == null || enterSec == null) {
      return false;
    }

    if (!(isNumH && isNumM && isNumS)) {
      return false;
    }

    int hh = Integer.parseInt(hour);
    int mm = Integer.parseInt(min);
    int ss = Integer.parseInt(sec);

    if ((hh > 12) || (mm > 59) || (ss > 59)) {
      return false;
    }

    if (hh < 10)
      enterHour.setText("0" + hh);
    if (mm < 10)
      enterMin.setText("0" + mm);
    if (ss < 10)
      enterSec.setText("0" + ss);

    return true;
  };


  /**
   * Converts time in hours, minutes & seconds shown on label to time in seconds
   * only
   * 
   * @param int hr
   * @param int min
   * @param int sec
   * @return int seconds
   */
  private int convertToSeconds(int hr, int min, int sec) {
    return hr * 60 * 60 + min * 60 + sec;
  }


  /**
   * Converts time from seconds to an array with the hours, minutes and seconds
   * 
   * @param int sec
   * @return int array containing hours, minutes, seconds
   */
  private int[] convertFromSeconds(int sec) {
    int p1 = sec % 60;
    int p2 = sec / 60;
    int p3 = p2 % 60;
    p2 = p2 / 60;

    int[] result = new int[3];
    result[0] = p2;
    result[1] = p3;
    result[2] = p1;

    return result;
  }


  /**
   * Takes the hours, minutes & seconds and puts them into a string format
   * 
   * @param int hour
   * @param int minute
   * @param int second
   * @return String formatted time
   */
  private String formatTime(int hour, int minute, int second) {
    String formattedHour = null;
    String formattedMinute = null;
    String formattedSecond = null;

    if (hour < 10)
      formattedHour = "0" + hour;
    else
      formattedHour = "" + hour;

    if (minute < 10)
      formattedMinute = "0" + minute;
    else
      formattedMinute = "" + minute;

    if (second < 10)
      formattedSecond = "0" + second;
    else
      formattedSecond = "" + second;

    return formattedHour + ":" + formattedMinute + ":" + formattedSecond;
  }


  /**
   * Counts down the seconds for the timer and plays music at the end
   * 
   * @param int seconds
   * @param JButton timerResetBtn
   * @return int seconds
   */
  private int countDown(int seconds, JButton timerResetBtn) {
    if (seconds == 1) {
      task.cancel();
      playMusic("src/media/timer sound.mp3");
      timerResetBtn.doClick();
    }
    return seconds - 1;
  }


  /**
   * Play music to signal end of timer
   * 
   * @param String filepath
   */
  private void playMusic(String filepath) {
    try {
      File f = new File("./" + filepath);
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
      Clip clip = AudioSystem.getClip();
      clip.open(audioIn);
      clip.start();
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }
  }


  /**
   * Performs a series of tasks to start the timer
   * 
   * @param int h
   * @param int m
   * @param int s
   * @param JLabel timerLabel
   * @param JLabel timerResetBtn
   * @return TimerTask task
   */
  public TimerTask startTimer(int h, int m, int s, JLabel timerLabel, JButton timerResetBtn) {
    int secOnly = convertToSeconds(h, m, s);

    task = new TimerTask() {
      public void run() {
        if (start == 0) {
          secOnlyNew = countDown(secOnly, timerResetBtn);
          start = 1;
        } else if (start == 1) {
          secOnlyNew = countDown(secOnlyNew, timerResetBtn);
        }
        int[] result = convertFromSeconds(secOnlyNew);
        String finalTime = formatTime(result[0], result[1], result[2]);
        timerLabel.setText(finalTime);
      }
    };

    t.scheduleAtFixedRate(task, delay, period);

    int[] result = convertFromSeconds(secOnly);
    String finalTime = formatTime(result[0], result[1], result[2]);
    timerLabel.setText(finalTime);

    return task;
  }


  /**
   * Drives the events for running the timer
   * 
   * @param JTextField enterHour
   * @param JTextField enterMin
   * @param JTextField enterSec
   * @param JLabel timerLabel
   * @param JButton enterBtn
   * @param JButton timerStartBtn
   * @param JButton timerPauseBtn
   * @param JButton timerResetBtn
   */
  public void runTimer(JTextField enterHour, JTextField enterMin, JTextField enterSec,
      JLabel timerLabel, JButton enterBtn, JButton timerStartBtn, JButton timerPauseBtn,
      JButton timerResetBtn) {

    timerStartBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        // new start
        if (start == 0 && timerLabel.getText() == "00:00:00") {
          int hr = Integer.parseInt(enterHour.getText());
          int min = Integer.parseInt(enterMin.getText());
          int sec = Integer.parseInt(enterSec.getText());
          task = startTimer(hr, min, sec, timerLabel, timerResetBtn);
        }

        // after pause
        else if (start == 1) {
          task.cancel();
          task = startTimer(pauseHr, pauseMin, pauseSec, timerLabel, timerResetBtn);
        }

        // after restart
        else if (start == 2 && timerLabel.getText() == "00:00:00") {
          int hr = Integer.parseInt(enterHour.getText());
          int min = Integer.parseInt(enterMin.getText());
          int sec = Integer.parseInt(enterSec.getText());
          task = startTimer(hr, min, sec, timerLabel, timerResetBtn);
        }

        timerStartBtn.setEnabled(false);
        timerPauseBtn.setEnabled(true);
        timerResetBtn.setEnabled(true);
      };
    });

    timerPauseBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent select) {

        task.cancel();

        String hour = "" + (timerLabel.getText()).charAt(0) + (timerLabel.getText()).charAt(1);
        String minute = "" + (timerLabel.getText()).charAt(3) + (timerLabel.getText()).charAt(4);
        String second = "" + (timerLabel.getText()).charAt(6) + (timerLabel.getText()).charAt(7);

        pauseHr = Integer.parseInt(hour);
        pauseMin = Integer.parseInt(minute);
        pauseSec = Integer.parseInt(second);

        timerStartBtn.setEnabled(true);
        timerPauseBtn.setEnabled(false);
        timerResetBtn.setEnabled(true);

        start = 1;
      };
    });

    timerResetBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        task.cancel();

        enterHour.setText("HH");
        enterMin.setText("MM");
        enterSec.setText("SS");
        timerLabel.setText("00:00:00");
        pauseHr = 0;
        pauseMin = 0;
        pauseSec = 0;
        enterBtn.setEnabled(true);
        timerStartBtn.setEnabled(false);
        timerPauseBtn.setEnabled(false);
        timerResetBtn.setEnabled(false);
        start = 0;
      };
    });
  }

}
