package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.User;

import java.io.IOException;

public class ReadPersonalGoal implements GoalsReadBehavior {
    @Override
    public void ReadFromCSV(User user) throws IOException {
        System.out.println("Read Personal Goal!");
    }
}