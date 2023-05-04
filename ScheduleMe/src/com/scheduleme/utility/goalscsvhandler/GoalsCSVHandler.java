package com.scheduleme.utility.goalscsvhandler;

import com.scheduleme.Goal;
import com.scheduleme.User;
import com.scheduleme.utility.goalscsvhandler.behavior.GoalsReadBehavior;
import com.scheduleme.utility.goalscsvhandler.behavior.GoalsWriteBehavior;

import java.io.IOException;

public abstract class GoalsCSVHandler {

    public GoalsWriteBehavior goalsWriteBehavior;
    public GoalsReadBehavior goalsReadBehavior;

    public void performWrite(Goal goal, User user) throws IOException {
        goalsWriteBehavior.writeToCSV(goal, user);
    }

    public void performDelete(Goal goal, User user) throws IOException {
        goalsWriteBehavior.deleteFromCSV(goal, user);
    }


    public void performRead(User user) throws IOException {
        goalsReadBehavior.ReadFromCSV(user);
    }


    public GoalsWriteBehavior getGoalsWriteBehavior() {
        return goalsWriteBehavior;
    }

    public GoalsReadBehavior getGoalsReadBehavior() {
        return goalsReadBehavior;
    }

    public void setGoalsWriteBehavior(GoalsWriteBehavior goalsWriteBehavior) {
        this.goalsWriteBehavior = goalsWriteBehavior;
    }

    public void setGoalsReadBehavior(GoalsReadBehavior goalsReadBehavior) {
        this.goalsReadBehavior = goalsReadBehavior;
    }
}
