package com.scheduleMe;

public interface GoalInterval {
    String getString();
    boolean getIsComplete();
    void setIsComplete(boolean isComplete);
    void timeToComplete();
}
