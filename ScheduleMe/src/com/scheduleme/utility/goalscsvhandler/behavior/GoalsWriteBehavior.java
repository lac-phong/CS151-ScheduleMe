package com.scheduleme.utility.goalscsvhandler.behavior;

import com.scheduleme.Goal;
import com.scheduleme.User;
import java.io.*;

public interface GoalsWriteBehavior {
     void writeToCSV(Goal goal, User user) throws IOException;

     void deleteFromCSV(Goal goal, User user) throws IOException;

}

