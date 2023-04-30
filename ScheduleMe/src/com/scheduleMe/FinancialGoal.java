package com.scheduleMe;

public class FinancialGoal implements GoalType {
    private final String category = "Financial";
    private String activity;

    public FinancialGoal(String activity) {
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
        
    }
    
}