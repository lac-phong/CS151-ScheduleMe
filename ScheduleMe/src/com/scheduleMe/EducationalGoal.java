package com.scheduleMe;

public class EducationalGoal implements GoalType {
    private final String category = "Educational";
    private String activity;

    public EducationalGoal(String activity) {
        this.activity = activity;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getActivity() {
        return activity;
    }

    @Override
    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public void trackActivity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trackActivity'");
    }
    
}