package runner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * The type ScheduleFeature
 */
public class ScheduleFeature {

  /**
   * holds DefaultTableModel object
   */
  private DefaultTableModel model;
  
  /**
   * Formats the table for Schedule
   *
   * @return JTable table
   */
  public JTable getTableModel() {
    // THE TABLE
    final JTable table = new JTable();

    // THE MODEL OF OUR TABLE
    DefaultTableModel model = new DefaultTableModel() {
      private static final long serialVersionUID = 1L;

      public Class<?> getColumnClass(int column) {
        switch (column) {
          case 0:
            return String.class;
          case 1:
            return String.class;
          case 2:
            return Boolean.class;
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

    model.addColumn("TIMES");
    model.addColumn("TASKS");
    model.addColumn("COMPLETED");

    // THE ROW

    int time1 = 5;
    int time2 = 6;

    for (int i = 0; i <= 19; i++) {
      model.addRow(new Object[0]);

      if (time1 == 13) {
        time1 = 1;
      }
      if (time2 == 13) {
        time2 = 1;
      }

      model.setValueAt((time1) + ":00 - " + (time2) + ":00 ", i, 0);

      time1++;
      time2++;
    }
    table.getColumnModel().getColumn(1).setPreferredWidth(300);
    table.setSelectionMode(0);
    table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

    return table;
  }
}
