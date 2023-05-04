
package com.goaltracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class MultiAtomicGoal extends Goal implements Serializable {
    private Date targetDeadline;
    private Boolean countdown;
    public ArrayList<Goal> subgoals;
    private String taskDescriptor;
    
    public MultiAtomicGoal(String aDescription, PriorityLevel aPriority, Date aTargetDeadline, Boolean aCountdown, String aTaskDescriptor, String aTasks, String aNotes) {
        super(aDescription, aPriority, aNotes);
        targetDeadline = aTargetDeadline;
        taskDescriptor = aTaskDescriptor;
        subgoals = new ArrayList<>();
        
        String[] tasks = aTasks.split("\\n");
        for (String t: tasks) {
            AtomicGoal a = new AtomicGoal(t, aPriority, aTargetDeadline, aCountdown, "", true);
            subgoals.add(a);
            GoalTracker.addGoal(a);
        }   
        
    }

    public ArrayList<Goal> getSubgoals() {
        return subgoals;
    }

    public void setSubgoals(ArrayList<Goal> subgoals) {
        this.subgoals = subgoals;
    }

    public String getTaskDescriptor() {
        return taskDescriptor;
    }

    public void setTaskDescriptor(String taskDescriptor) {
        this.taskDescriptor = taskDescriptor;
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
