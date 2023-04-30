package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.DefiniteGoal;
import com.scheduleMe.Goal;
import com.scheduleMe.IndefiniteGoal;
import com.scheduleMe.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface GoalsWriteBehavior{
     void writeToCSV(Goal goal, User user) throws IOException;
     void deleteFromCSV(Goal goal, User user) throws IOException;
}

