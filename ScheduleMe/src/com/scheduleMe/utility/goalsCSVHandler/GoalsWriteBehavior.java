package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.Goal;
import com.scheduleMe.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface GoalsWriteBehavior{
     void writeToCSV(Goal goal, User user) throws IOException;
}

class WriteFinancialGoal implements GoalsWriteBehavior{
    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Financial Goal!");
        String csvFilePath = user.getUsername() + "_Financial_goals.csv";
        FileWriter writer = new FileWriter(csvFilePath);
        writer.write("Username,Category,Name,Description,Due_Date,Completed_Date, Is_Completed\n"); // writes the header row

        String username = user.getUsername();
        String category = goal.getCategory();
        String name = goal.getName();
        String description = goal.getDescription();
        String dueDate = goal.getDueDate().toString();
        String completedDate;
        String isComplete = String.valueOf(goal.getIsComplete());

        writer.write(username +"," + category + "," + name + "," + description + "," + dueDate + ","
        +  "," + isComplete);

        writer.close();
    }
}
class WriteCommunityGoal implements GoalsWriteBehavior{

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote community Goal!");
    }
}
class WriteEducationalGoal implements GoalsWriteBehavior{

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Educational Goal!");

    }
}
class WriteCareerGoal implements GoalsWriteBehavior{

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Career Goal!");

    }
}
class WritePhysicalGoal implements GoalsWriteBehavior{

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Physical Goal!");

    }
}
class WritePersonalGoal implements GoalsWriteBehavior{

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Personal Goal!");

    }
}
class WriteRelationshipGoal implements GoalsWriteBehavior{

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Relationship Goal!");

    }
}

