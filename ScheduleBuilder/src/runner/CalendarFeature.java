package runner;

import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * The type ScheduleFeature
 */
public class CalendarFeature {

  /**
   * holds DefaultTableModel object
   */
  private DefaultTableModel model;

  /**
   * Sets the current date
   *
   * @param JLabel dateLabel
   */
  public void getDate(JLabel dateLabel) {
    Calendar cal = Calendar.getInstance();
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int year = cal.get(Calendar.YEAR);

    String longMonth = null;

    if (month == 0)
      longMonth = "Jan.";
    else if (month == 1)
      longMonth = "Feb.";
    else if (month == 2)
      longMonth = "Mar.";
    else if (month == 3)
      longMonth = "Apr.";
    else if (month == 4)
      longMonth = "May";
    else if (month == 5)
      longMonth = "Jun";
    else if (month == 6)
      longMonth = "Jul.";
    else if (month == 7)
      longMonth = "Aug.";
    else if (month == 8)
      longMonth = "Sep.";
    else if (month == 9)
      longMonth = "Oct.";
    else if (month == 10)
      longMonth = "Nov.";
    else if (month == 11)
      longMonth = "Dec.";

    dateLabel.setText("Date: " + (longMonth) + " " + day + ", " + year);
  }

  /**
   * Sets the current time
   *
   * @param JLabel timeLabel
   */
  public void getTime(JLabel timeLabel) {
    Thread clock = new Thread() {
      public void run() {
        try {
          while (true) {
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR);
            int min = cal.get(Calendar.MINUTE);
            int sec = cal.get(Calendar.SECOND);
            int meridian = cal.get(Calendar.AM_PM);

            String hh = null;
            String mm = null;
            String ss = null;
            String ampm = null;

            if (hour == 0)
              hh = "12";
            else if (hour < 10)
              hh = "0" + String.valueOf(hour);
            else
              hh = String.valueOf(hour);

            if (min < 10)
              mm = "0" + String.valueOf(min);
            else
              mm = String.valueOf(min);

            if (sec < 10)
              ss = "0" + String.valueOf(sec);
            else
              ss = String.valueOf(sec);

            if (meridian == 0)
              ampm = "AM";
            else
              ampm = "PM";

            timeLabel.setText("Time: " + hh + ":" + mm + ":" + ss + " " + ampm);
            sleep(1000);
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    clock.start();
  }

  /**
   * Formats the table for Calendar
   *
   * @return JTable table
   */
  public JTable getTableModel() {
    // THE TABLE
    final JTable table = new JTable();

    // THE MODEL OF OUR TABLE
    model = new DefaultTableModel() {
      private static final long serialVersionUID = 1L;

      public Class<?> getColumnClass(int column) {
        switch (column) {
          case 0:
            return String.class;
          case 1:
            return String.class;
          default:
            return String.class;
        }
      }

      @Override
      public boolean isCellEditable(int row, int column) {

        if (column == 0) {
          return false;
        }
        return true;
      }
    };

    // ASSIGN THE MODEL TO TABLE
    table.setModel(model);

    model.addColumn("DAY");
    model.addColumn("EVENTS");

    // THE ROW
    int day = 1;
    for (int i = 0; i < 31; i++) {
      model.addRow(new Object[0]);

      model.setValueAt("" + day, i, 0);
      day++;
    }

    table.getColumnModel().getColumn(1).setPreferredWidth(500);
    table.setSelectionMode(0);
    table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    return table;
  }
}
