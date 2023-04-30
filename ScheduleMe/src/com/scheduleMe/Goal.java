package com.scheduleMe;

public class Goal {
    private String name;
    private String description;
    private GoalType category;
    private GoalInterval interval;

    public Goal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public GoalType getType() {
        return category;
    }

    public void setType(GoalType category) {
        this.category = category;
    }

    public GoalInterval getInterval() {
        return interval;
    }

    public void setInterval(GoalInterval interval) {
        this.interval = interval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}





