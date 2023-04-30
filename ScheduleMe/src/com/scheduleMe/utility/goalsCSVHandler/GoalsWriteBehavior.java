package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.DefiniteGoal;
import com.scheduleMe.Goal;
import com.scheduleMe.IndefiniteGoal;
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
                if (line.startsWith(user.getUsername() + "," + goal.getType().getCategory() + "," + goal.getName())) {
                    rowExists = true;
                    break;
                }

            }

            reader.close();
        }
        else {
            file.createNewFile();
            FileWriter writer = new FileWriter(csvFilePath);
            writer.close();
        }

        FileWriter writer = new FileWriter(csvFilePath, true); // Append to the CSV file

        if (!rowExists) {
            // Write the header row if the file is empty
            if (file.length() == 0) {
                writer.write("Username,Category,Name,Description,Due_Date,Completed_Date,Is_Completed\n");
            }

            String username = user.getUsername();
            String category = goal.getType().getCategory();
            String name = goal.getName();
            String description = goal.getDescription();
            String activity = goal.getType().getActivity();
            String interval = goal.getInterval().getString();
            if (goal.getInterval().getString().equals("Definite")){
                String dueDate = ((DefiniteGoal) goal.getInterval()).getDueDate().toString();
                writer.write(username + "," + category + "," + name + "," + description + "," + activity + "," + interval + "," + dueDate + "," + "\n");
            } else {
            String recurrence = ((IndefiniteGoal) goal.getInterval()).getRecurrence();
            int frequency = ((IndefiniteGoal) goal.getInterval()).getFreq();

            writer.write(username + "," + category + "," + name + "," + description + "," + activity + "," + interval + "," + recurrence + ","
                    + frequency + "," + "\n");
            System.out.println("Goal added to the CSV file.");
            }
        } else {
            System.out.println("Goal already exists in the CSV file.");
        }

        writer.close();
    }
}

class WriteEducationalGoal implements GoalsWriteBehavior{

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Educational Goal!");

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

