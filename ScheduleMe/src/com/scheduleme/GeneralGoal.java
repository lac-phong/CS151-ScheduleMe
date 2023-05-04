package com.scheduleme;

public class GeneralGoal implements GoalType {
    private final String category = "General";
    private boolean isComplete;
    private boolean trackingDone = false;

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
        return "";
    }

    @Override
    public void setActivity(String activity) {

    }

    @Override
    public void trackActivity() {

    }

}
