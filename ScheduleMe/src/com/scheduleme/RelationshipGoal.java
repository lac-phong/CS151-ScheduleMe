package com.scheduleme;

public class RelationshipGoal implements GoalType {
    private final String category = "Relationship";
    private String activity;
    private boolean isComplete;
    private boolean trackingDone = false;

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

    @Override
    public boolean getIsComplete() {
        // TODO Auto-generated method stub
        return isComplete;
    }

    @Override
    public boolean getTrackingDone() {
        // TODO Auto-generated method stub
        return trackingDone;
    }

}
