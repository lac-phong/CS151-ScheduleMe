/*
 * Schedule.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.ArrayList;
import java.util.Date;

public class Schedule {
    private ArrayList<ScheduleItem> items;

    public ArrayList<ScheduleItem> getScheduleItems() {
        return items;
    }

    public void addScheduleItem(Date aDate, Goal aGoal) {
        items.add(new ScheduleItem(aDate, aGoal));
    }

    public String exportSchedule() {
        return "**TO DO**";
    }
}
