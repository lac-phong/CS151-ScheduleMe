/*
 * Goal.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package com.goaltracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Goal implements Serializable {
    private String description;
    private String notes;
    private PriorityLevel priority;
    private ArrayList<Goal> subGoals;
    private Boolean isAccomplished = false;
    private Boolean isAbandoned = false;
    private Boolean isSubGoal;
    private Date dateCreated;
    private Date dateAccomplished;

    public Goal(String aDescription, PriorityLevel aPriority, String aNotes) {
            description = aDescription;
            priority = aPriority;
            notes = aNotes;
            isSubGoal = false;
    }

    public Goal(String aDescription, PriorityLevel aPriority, String aNotes, Boolean aIsSubGoal) {
            description = aDescription;
            priority = aPriority;
            notes = aNotes;
            isSubGoal = aIsSubGoal;
    }

    public Boolean getIsSubGoal() {
        return isSubGoal;
    }

    public void setIsSubGoal(Boolean isSubGoal) {
        this.isSubGoal = isSubGoal;
    }

    
    public Boolean getIsAbandoned() {
        return isAbandoned;
    }

    public void setIsAbandoned(Boolean isAbandoned) {
        this.isAbandoned = isAbandoned;
    }
    
    
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ArrayList<Goal> getSubGoals() {
        return subGoals;
    }

    public void setSubGoals(ArrayList<Goal> subGoals) {
        this.subGoals = subGoals;
    }

    public Boolean getIsAccomplished() {
        return isAccomplished;
    }

    public void setIsAccomplished(Boolean isAccomplished) {
        this.isAccomplished = isAccomplished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public void setPriority(PriorityLevel aPriority) {
        priority = aPriority;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date aDateCreated) {
        dateCreated = aDateCreated;
    }

    public Date getDateAccomplished() {
        return dateAccomplished;
    }

    public void setDateAccomplished(Date aDateAccomplished) {
        dateAccomplished = aDateAccomplished;
    }
}
