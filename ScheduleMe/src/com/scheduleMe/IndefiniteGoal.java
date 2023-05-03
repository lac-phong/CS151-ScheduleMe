package com.scheduleMe;
//TODO add in a counter to track the user's number of times accomplishing per unit of time
public class IndefiniteGoal implements GoalInterval {
    private final String interval = "Indefinite";
    private String recurrence;
    private int frequency;
    private boolean isComplete;

    public IndefiniteGoal(String recurrence, int frequency) {
        this.recurrence = recurrence;
        this.frequency = frequency;
    }

    @Override
    public String getString() {
        return interval;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public int getFreq() {
        return frequency;
    }

    public void setFreq(int frequency) {
        this.frequency = frequency;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete){
        this.isComplete = isComplete;
    }

    @Override
    public void timeToComplete() {

    }
}
