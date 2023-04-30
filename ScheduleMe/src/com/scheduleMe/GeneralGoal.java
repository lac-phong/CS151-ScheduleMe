package com.scheduleMe;

public class GeneralGoal implements GoalType {
    private final String category = "General";

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getActivity() {
        return "";
    }

    @Override
    public void setActivity(String activity) {
        
    }

    @Override
    public void trackActivity() {
        
    }
    
}
