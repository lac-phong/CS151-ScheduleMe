package com.scheduleme.utility.goalscsvhandler.behavior;

import com.scheduleme.DefiniteGoal;
import com.scheduleme.Goal;
import com.scheduleme.IndefiniteGoal;
import com.scheduleme.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteCompletedGoal implements GoalsWriteBehavior {
    @Override
    public void writeToCSV(Goal goal, User user) throws IOException {
        System.out.println("Wrote Completed Goal!");
        String csvFilePath = user.getUsername() + "_Completed_goals.csv";
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
            if (file.length() == 0) {
                writer.write("Username,Name,Category,Description,Activity,Recurrence,Due_Date\n");
            }

            String username = user.getUsername();
            String category = goal.getType().getCategory();
            String name = goal.getName();
            String description = goal.getDescription();
            String activity = goal.getType().getActivity();
            String interval = goal.getInterval().getString();
            if (goal.getInterval().getString().equals("Definite")) {
                String dueDate = ((DefiniteGoal) goal.getInterval()).getDueDate().toString();
                writer.write(username + "," + name + "," + category + "," + description + "," + activity + "," + interval + "," + dueDate + "," + "\n");
            } else {
                String recurrence = ((IndefiniteGoal) goal.getInterval()).getRecurrence();
                int frequency = ((IndefiniteGoal) goal.getInterval()).getFreq();

                writer.write(username + "," + name + "," + category + "," + description + "," + activity + "," + interval + "," + recurrence + ","
                        + frequency + "," + "\n");
            }
        }
        writer.close();
    }

    @Override
    public void deleteFromCSV(Goal goal, User user) throws IOException {
        System.out.println("Deleted Completed Goal!");
        String csvFilePath = user.getUsername() + "_Completed_goals.csv";
        File file = new File(csvFilePath);
        System.out.println(user.getUsername());
        System.out.println(goal.getType().getCategory());
        System.out.println(goal.getName());
        if (file.exists()) {
            //store these
            List<String> rows = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            while ((line = reader.readLine()) != null) { //not rewriting goal type after modifying properly
                if (!line.startsWith(user.getUsername() + "," + goal.getName())) {
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
}
