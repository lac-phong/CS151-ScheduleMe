package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.Goal;
import com.scheduleMe.User;

import java.io.IOException;

public class WriteEducationalGoal implements GoalsWriteBehavior {
    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Educational Goal!");

    }

    @Override
    public void deleteFromCSV(Goal goal, User user) throws IOException {

    }
}
