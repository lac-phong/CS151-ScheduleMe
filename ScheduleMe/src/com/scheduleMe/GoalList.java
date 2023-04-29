package com.scheduleMe;

import java.io.IOException;
import java.util.ArrayList;

public class GoalList {

    private static ArrayList<Goal> goalList;

    public static ArrayList getInstance(User user) throws IOException {
        if (goalList == null) {
            user.goals = new ArrayList<>();
        }
        return goalList;
    }

}
