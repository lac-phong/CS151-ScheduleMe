package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.Goal;
import com.scheduleMe.User;

import java.io.IOException;

public class WritePhysicalGoal implements GoalsWriteBehavior {

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Physical Goal!");

    }

    @Override
    public void deleteFromCSV(Goal goal, User user) throws IOException {

    }
}
