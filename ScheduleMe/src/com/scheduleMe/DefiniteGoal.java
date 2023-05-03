package com.scheduleMe;

import java.time.LocalDate;
//TODO we need to create something that tracks how many times this was done and maybe automnatically completes the goal if it reaches its total.
public class DefiniteGoal implements GoalInterval {
    private final String interval = "Definite";
    private LocalDate dueDate;
    private LocalDate completedDate;
    private boolean isComplete;

    public DefiniteGoal(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String getString() {
        return interval;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete){
        this.isComplete = isComplete;
    }

    public void setCompleteDate(LocalDate completeDate) {
        this.completedDate = completeDate;
    }

    @Override
    public void timeToComplete() {

    }
}
