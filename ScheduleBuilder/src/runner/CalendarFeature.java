package runner;

import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CalendarFeature extends Programs {

	public void getDate(JLabel dateLabel) {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		dateLabel.setText("Date: "+(month+1)+"/"+day+"/"+year);
	}
	
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
						
						if (hour == 0) hh = "12";
						else if (hour < 10) hh = "0"+String.valueOf(hour);
						else hh = String.valueOf(hour);
						
						if (min < 10) mm = "0"+String.valueOf(min);
						else mm = String.valueOf(min);
						
						if (sec < 10) ss = "0"+String.valueOf(sec);
						else ss = String.valueOf(sec);
						
						if (meridian == 0) ampm = "AM";
						else ampm = "PM";
						
						timeLabel.setText("Time: "+hh+":"+mm+":"+ss+" "+ampm);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
	
	public JTable getTableModel() {
      //THE TABLE
      final JTable table=new JTable();

      //THE MODEL OF OUR TABLE
      DefaultTableModel model=new DefaultTableModel()
      {
		private static final long serialVersionUID = 1L;

		public Class<?> getColumnClass(int column)
        {
          switch(column)
          {
          case 0:
            return String.class;
          case 1:
            return String.class;
          default:
            return String.class;
          }
        }
        
        @Override 
        public boolean isCellEditable(int row, int column)
        {
          
          if (column == 0) {
            return false;
          }
          return true;  
        }     
      };

      //ASSIGN THE MODEL TO TABLE
      table.setModel(model);

      model.addColumn("DAY");
      model.addColumn("EVENTS");
  //
//      //THE ROW
     int day = 1;
     for(int i=0;i<31;i++)
     {
       model.addRow(new Object[0]);
             
       model.setValueAt("" + day,i,0);
       day++;
      }

     table.getColumnModel().getColumn(1).setPreferredWidth(500);
     table.setSelectionMode(0);
     return table;
    }
	
	@Override
	public void runProgram() {

	}

}
