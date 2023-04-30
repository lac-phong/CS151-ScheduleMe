package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.Goal;
import com.scheduleMe.User;

import java.io.*;
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
        File file = new File(csvFilePath);
        boolean rowExists = false;

        if (file.exists()) {
            // Read the CSV file to check if the row already exists
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(user.getUsername() + "," + goal.getCategory() + "," + goal.getName())) {
                    rowExists = true;
                    break;
                }
            }
            reader.close();
        }

        FileWriter writer = new FileWriter(csvFilePath, true); // Append to the CSV file

        if (!rowExists) {
            // Write the header row if the file is empty
            if (file.length() == 0) {
                writer.write("Username,Category,Name,Description,Due_Date,Completed_Date,Is_Completed\n");
            }

            String username = user.getUsername();
            String category = goal.getCategory();
            String name = goal.getName();
            String description = goal.getDescription();
            String dueDate = goal.getDueDate().toString();
            String completedDate = "";
            String isComplete = String.valueOf(goal.getIsComplete());

            writer.write(username + "," + category + "," + name + "," + description + "," + dueDate + ","
                    + completedDate + "," + isComplete + "\n");
            System.out.println("Goal added to the CSV file.");
        } else {
            System.out.println("Goal already exists in the CSV file.");
        }

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

