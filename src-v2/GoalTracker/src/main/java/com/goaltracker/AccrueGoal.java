package com.goaltracker;

import java.io.Serializable;
import java.util.Date;

public class AccrueGoal extends Goal implements Serializable {
    private Date targetDeadline;
    private Boolean countdown;
    private Double startAmount;
    private Double currentAmount;
    private Double targetAmount;
    
    public AccrueGoal(String aDescription, PriorityLevel aPriority, Date aTargetDeadline, Double aCurrentAmount, Double aTargetAmount, String aNotes) {
        super(aDescription, aPriority, aNotes);
        targetDeadline = aTargetDeadline;
        currentAmount = aCurrentAmount;
        startAmount = currentAmount;
        targetAmount = aTargetAmount;
    }

    public Double addToAmount(double v) {
        currentAmount += v;
        if (currentAmount >= targetAmount) {
            this.setIsAccomplished(true);
        }
        GoalTracker.save();
        return currentAmount.doubleValue();        
    }
    public Double getStartAmount() {
        return startAmount;
    }
    
    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
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
