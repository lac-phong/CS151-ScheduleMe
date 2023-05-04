package com.goaltracker;

import java.io.Serializable;
import java.util.Date;

public class AtomicGoal extends Goal implements Serializable {
    private Date targetDeadline;
    private Boolean countdown;
    
    public AtomicGoal(String aDescription, PriorityLevel aPriority, Date aTargetDeadline, Boolean aCountdown, String aNotes) {
        super(aDescription, aPriority, aNotes, false);
        targetDeadline = aTargetDeadline;
        countdown = aCountdown;
    }

    public AtomicGoal(String aDescription, PriorityLevel aPriority, Date aTargetDeadline, Boolean aCountdown, String aNotes, Boolean aIsSubGoal) {
        super(aDescription, aPriority, aNotes, aIsSubGoal);
        targetDeadline = aTargetDeadline;
        countdown = aCountdown;
    }
    
    public Date getTargetDeadline() {
        return targetDeadline;
    }

    public void setTargetDeadline(Date targetDeadline) {
        this.targetDeadline = targetDeadline;
    }

    public Boolean getCountdown() {
        return countdown;
    }

    public void setCountdown(Boolean countdown) {
        this.countdown = countdown;
    }
}
