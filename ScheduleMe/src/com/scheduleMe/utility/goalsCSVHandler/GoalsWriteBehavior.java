package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.Goal;
import com.scheduleMe.User;
import java.io.*;

public interface GoalsWriteBehavior {
     void writeToCSV(Goal goal, User user) throws IOException;

     void deleteFromCSV(Goal goal, User user) throws IOException;

     void modifyGoalInCSV(Goal goal, User user) throws IOException;
}

