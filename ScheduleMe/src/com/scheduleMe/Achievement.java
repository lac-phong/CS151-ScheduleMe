package com.scheduleMe;

import java.time.LocalDate;

public class Achievement {
    String title;
    String description;
    boolean isUnlocked;
    int progressCounter;
    int conditionCount;

    LocalDate dateUnlocked;

    public Achievement(String title, String description, boolean isUnlocked, int progressCounter, int conditionCount){
        this.title = title;
        this.description = description;
        this.isUnlocked = isUnlocked;
        this.progressCounter = progressCounter;
        this.conditionCount = conditionCount;
    }

}
