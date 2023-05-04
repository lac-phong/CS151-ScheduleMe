package com.scheduleMe;

public class EducationalGoal implements GoalType {
    private final String category = "Educational";
    private String activity;
    private boolean isComplete;
    private boolean trackingDone = false;

    public EducationalGoal(String activity) {
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
        throw new UnsupportedOperationException("Unimplemented method 'trackActivity'");
    }
    
}