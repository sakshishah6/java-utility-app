package runner;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class ScheduleFeature extends Programs {

      public String[][] getTableTimes() {
        
        
        String[][] dataTimes = {
            {"TIMES"},
            {"5-6"},
            {"6-7"},
            {"7-8"},
            {"8-9"},
            {"9-10"},
            {"10-11"},
            {"11-12"},
            {"12-1"},
            {"1-2"},
            {"2-3"},
            {"3-4"},
            {"4-5"},
            {"5-6"},
            {"6-7"},
            {"7-8"},
            {"8-9"},
            {"9-10"},
            {"10-11"},
            {"11-12"},
            };
        
        return dataTimes;
      }
      
      public String[][] getTableTasks(){
        String[][] dataTasks = {
            {"TASKS"},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
            {new String()},
        };
        
        return dataTasks;
      }
      
      
	  @Override
	  public void runProgram() {
	    // TODO Auto-generated method stub
	  }

}
