package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.Goal;
import com.scheduleMe.User;

import java.io.IOException;
import java.util.ArrayList;

public abstract class GoalsCSVHandler {

    public  GoalsWriteBehavior goalsWriteBehavior;
    public  GoalsReadBehavior goalsReadBehavior;

    public   void performWrite(Goal goal, User user) throws IOException {
        goalsWriteBehavior.writeToCSV(goal, user);
    }

    public   void performRead(User user) throws IOException {
        goalsReadBehavior.ReadFromCSV(user);
    }

    public GoalsWriteBehavior getGoalsWriteBehavior() {
        return goalsWriteBehavior;
    }

    public GoalsReadBehavior getGoalsReadBehavior() {
        return goalsReadBehavior;
    }
    public void setGoalsWriteBehavior(GoalsWriteBehavior goalsWriteBehavior){
        this.goalsWriteBehavior = goalsWriteBehavior;
    }
    public void setGoalsReadBehavior(GoalsReadBehavior goalsReadBehavior){
        this.goalsReadBehavior = goalsReadBehavior;
    }
}
