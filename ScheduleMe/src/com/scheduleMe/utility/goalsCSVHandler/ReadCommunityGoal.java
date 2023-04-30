package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.User;

import java.io.IOException;

public class ReadCommunityGoal implements GoalsReadBehavior {
    @Override
    public void ReadFromCSV(User user) throws IOException {
        System.out.println("Read Community Goal!");
    }
}
