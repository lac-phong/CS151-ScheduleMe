package com.goaltracker;

import java.io.Serializable;
import java.util.Date;

public class CountGoal extends Goal implements Serializable {
    private Date targetDeadline;
    private Boolean countdown;
    private Integer startCount;
    private Integer currentCount;
    private Integer targetCount;
    
    public CountGoal(String aDescription, PriorityLevel aPriority, Date aTargetDeadline, Integer aCurrentCount, Integer aTargetCount, String aNotes) {
        super(aDescription, aPriority, aNotes);
        targetDeadline = aTargetDeadline;
        currentCount = aCurrentCount;
        targetCount = aTargetCount;
        startCount = currentCount;
    }

    public int addToCount(int v) {
        currentCount += v;
        if (currentCount >= targetCount) {
            this.setIsAccomplished(true);
        }
        GoalTracker.save();
        return currentCount.intValue();
    }
    
    public Integer getStartCount() {
        return startCount;
    }
    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer aCurrentCount) {
        currentCount = aCurrentCount;
    }

    public Integer getTargetCount() {
        return targetCount;
    }

    public void setTargetCount(Integer aTargetCount) {
        this.targetCount = aTargetCount;
    }

    public Date getTargetDeadline() {
        return targetDeadline;
    }

    public void setTargetDeadline(Date aTargetDeadline) {
        targetDeadline = aTargetDeadline;
    }

    public Boolean getCountdown() {
        return countdown;
    }

    public void setCountdown(Boolean aCountdown) {
        countdown = aCountdown;
    }
}
