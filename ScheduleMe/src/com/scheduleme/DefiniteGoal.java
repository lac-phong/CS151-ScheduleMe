package com.scheduleme;

import java.time.LocalDate;

//TODO we need to create something that tracks how many times this was done and maybe automnatically completes the goal if it reaches its total.
public class DefiniteGoal implements GoalInterval {

    private final String interval = "Definite";
    private LocalDate dueDate;
    private LocalDate completedDate;
    private boolean isComplete;
    private String name;

    public DefiniteGoal(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCompleteDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }

    public void sendNotification(String message) {
        NotificationWindow notification = new NotificationWindow("ATTENTION USER", message);
        notification.display();
    }

    @Override
    public void timeToComplete() {
        LocalDate today = LocalDate.now();
        LocalDate oneDayBeforeDueDate = dueDate.minusDays(1);
        if (!isComplete && today.equals(oneDayBeforeDueDate)) {
            sendNotification("YOUR GOAL " + name + " NEEDS TO BE COMPLETED IN 1 DAY");
        }
        if (!isComplete && today.equals(dueDate)) {
            sendNotification("YOUR GOAL " + name + " NEEDS TO BE COMPLETED TODAY");
        }
    }

}
