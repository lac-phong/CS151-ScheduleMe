package com.scheduleMe;

public interface GoalType {
    String getCategory();
    String getActivity();
    void setActivity(String activity);
    void trackActivity();
}
