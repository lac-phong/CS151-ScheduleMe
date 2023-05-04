package com.scheduleme;

public class PhysicalGoal implements GoalType {
    private final String category = "Physical";
    private String activity;
    private boolean isComplete;
    private boolean trackingDone = false;

    public PhysicalGoal(String activity) {
        this.activity = activity;
    }

    @Override
    public boolean getTrackingDone() {
        // TODO Auto-generated method stub
        return trackingDone;
    }

    @Override
    public boolean getIsComplete() {
        return isComplete;
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
    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

}