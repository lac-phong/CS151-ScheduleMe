/*
 * ScheduleItem.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.Date;

public class ScheduleItem {
    private Date date;
    private Goal goal;

    public ScheduleItem(Date aDate, Goal aGoal) {
        date = aDate;
        goal = aGoal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date aDate) {
        date = aDate;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal aGoal) {
        goal = aGoal;
    }
}
