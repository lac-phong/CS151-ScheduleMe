package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.DefiniteGoal;
import com.scheduleMe.Goal;
import com.scheduleMe.IndefiniteGoal;
import com.scheduleMe.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WritePhysicalGoal implements GoalsWriteBehavior {

    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Physical Goal!");
        String csvFilePath = user.getUsername() + "_Physical_goals.csv";
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
        } else {
            file.createNewFile();
            FileWriter writer = new FileWriter(csvFilePath);
            writer.close();
        }

        FileWriter writer = new FileWriter(csvFilePath, true); // Append to the CSV file

        if (!rowExists) {
            // Write the header row if the file is empty
            if (file.length() == 0) {
                writer.write("Username,Category,Name,Description,Activity,Recurrence,Due_Date,Frequency\n");
            }

            String username = user.getUsername();
            String category = goal.getType().getCategory();
            String name = goal.getName();
            String description = goal.getDescription();
            String activity = goal.getType().getActivity();
            String interval = goal.getInterval().getString();
            if (goal.getInterval().getString().equals("Definite")) {
                String dueDate = ((DefiniteGoal) goal.getInterval()).getDueDate().toString();
                writer.write(username + "," + category + "," + name + "," + description + "," + activity + "," + interval + "," + dueDate + "," + "\n");
            } else {
                String recurrence = ((IndefiniteGoal) goal.getInterval()).getRecurrence();
                int frequency = ((IndefiniteGoal) goal.getInterval()).getFreq();

                writer.write(username + "," + category + "," + name + "," + description + "," + activity + "," + interval + "," + recurrence + ","
                        + frequency + "," + "\n");
            }
        }
        writer.close();
    }

    @Override
    public void deleteFromCSV(Goal goal, User user) throws IOException {
        System.out.println("Deleted Physical Goal!");
        String csvFilePath = user.getUsername() + "_Physical_goals.csv";
        File file = new File(csvFilePath);

        if (file.exists()) {
            //store these
            List<String> rows = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(user.getUsername() + "," + goal.getType().getCategory() + "," + goal.getName())) {
                    rows.add(line);
                }
            }
            reader.close();

            // reimplment the rows so that there is no blank space
            FileWriter writer = new FileWriter(csvFilePath);
            for (String row : rows) {
                writer.write(row + "\n");
            }
            writer.close();
        }
    }

    @Override
    public void modifyGoalInCSV(Goal goal, User user) throws IOException {

    }
}
