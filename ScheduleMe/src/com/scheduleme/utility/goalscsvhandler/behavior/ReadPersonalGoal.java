package com.scheduleme.utility.goalscsvhandler.behavior;

import com.scheduleme.User;

import java.io.IOException;

public class ReadPersonalGoal implements GoalsReadBehavior {
    @Override
    public void ReadFromCSV(User user) throws IOException {
        System.out.println("Read Personal Goal!");
    }
}
