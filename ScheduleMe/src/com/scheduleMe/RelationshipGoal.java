package com.scheduleMe;

public class RelationshipGoal implements GoalType {
    private final String category = "Relationship";
    private String activity;

    public RelationshipGoal(String activity) {
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
