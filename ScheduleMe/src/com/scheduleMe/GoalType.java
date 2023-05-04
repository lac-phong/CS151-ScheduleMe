package com.scheduleMe;

public interface GoalType {
    String getCategory();
    String getActivity();
    boolean getIsComplete();
    boolean getTrackingDone();
    void setActivity(String activity);
    void trackActivity();
}
