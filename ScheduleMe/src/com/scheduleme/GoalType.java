package com.scheduleme;

public interface GoalType {
    String getCategory();
    String getActivity();
    boolean getIsComplete();
    boolean getTrackingDone();
    void setIsComplete(boolean isComplete);
    void setActivity(String activity);
    void trackActivity();
}
