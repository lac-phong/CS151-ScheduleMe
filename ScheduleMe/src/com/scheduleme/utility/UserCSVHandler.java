package com.scheduleme.utility;

import com.scheduleme.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class UserCSVHandler {
    //Writes the users hashmap into a comma separated values file
    public static void WriteToCSV(HashMap<String, User> users) throws IOException {
        String csvFilePath = "output.csv";
        FileWriter writer = new FileWriter(csvFilePath);
        writer.write("Username,Password,First_Name,Last_Name,Email,NumOfFinancialGoals,NumOfEducationalGoals,NumOfPhysicalGoals," +
                "NumOfRelationshipGoals,numOfTotalGoals\n"); // writes the header row

        for (Map.Entry<String, User> entry : users.entrySet()) {
            String username = entry.getKey();
            String firstName = entry.getValue().getFirstName();
            String lastName = entry.getValue().getLastName();
            String email = entry.getValue().getEmail();
            String password = entry.getValue().getPassword();

            writer.write(username + "," + password + "," + firstName + "," + lastName + "," + email + "," +
                    entry.getValue().numOfFinancialGoalsCompleted + "," + entry.getValue().numOfEducationalGoalsCompleted +
                    "," + entry.getValue().numOfPhysicalGoalsCompleted + "," + entry.getValue().numOfRelationshipGoalsCompleted + "," +
                    entry.getValue().numOfTotalGoalsComplete + "\n"); // need to change this to include goals
        }

        writer.close();
    }

    public static Map<String, User> CSVToHashMap() throws IOException {
        String csvFilePath = "output.csv";
        HashMap<String, User> users = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line = reader.readLine();  // skip the header row

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            String username = String.copyValueOf(fields[0].toCharArray());
            String password = String.copyValueOf(fields[1].toCharArray());
            String firstName = String.copyValueOf(fields[2].toCharArray());
            String lastName = String.copyValueOf(fields[3].toCharArray());
            String email = String.copyValueOf(fields[4].toCharArray());
            int numOfFinancialGoalsCompleted = Integer.parseInt(String.copyValueOf(fields[5].toCharArray()));
            int numOfEducationalGoalsCompleted = Integer.parseInt(String.copyValueOf(fields[6].toCharArray()));
            int numOfPhysicalGoalsCompleted = Integer.parseInt(String.copyValueOf(fields[7].toCharArray()));
            int numOfRelationshipGoalsCompleted = Integer.parseInt(String.copyValueOf(fields[8].toCharArray()));
            int numOfTotalGoalsCompleted = Integer.parseInt(String.copyValueOf(fields[9].toCharArray()));


            users.put(username, new User(username, password, email, firstName, lastName));
            users.get(username).numOfTotalGoalsComplete = numOfTotalGoalsCompleted;
            users.get(username).numOfFinancialGoalsCompleted = numOfFinancialGoalsCompleted;
            users.get(username).numOfEducationalGoalsCompleted = numOfEducationalGoalsCompleted;
            users.get(username).numOfPhysicalGoalsCompleted = numOfPhysicalGoalsCompleted;
            users.get(username).numOfRelationshipGoalsCompleted = numOfRelationshipGoalsCompleted;


            //create csv files

            csvFilePath = username + "_Financial_goals.csv";
            File file = new File(csvFilePath);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter writer = new FileWriter(csvFilePath);
                writer.close();
            }
            csvFilePath = username + "_Relationship_goals.csv";
            file = new File(csvFilePath);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter writer = new FileWriter(csvFilePath);
                writer.close();
            }
            csvFilePath = username + "_Physical_goals.csv";
            file = new File(csvFilePath);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter writer = new FileWriter(csvFilePath);
                writer.close();
            }
            csvFilePath = username + "_Educational_goals.csv";
            file = new File(csvFilePath);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter writer = new FileWriter(csvFilePath);
                writer.close();
            }
            csvFilePath = username + "_Personal_goals.csv";
            file = new File(csvFilePath);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter writer = new FileWriter(csvFilePath);
                writer.close();
            }
            csvFilePath = username + "_Completed_goals.csv";
            file = new File(csvFilePath);
            if (!file.exists()) {
                file.createNewFile();
                FileWriter writer = new FileWriter(csvFilePath);
                writer.close();
            }
        }

        reader.close();


        return users;


    }

    public static void generateCSV(User user) throws IOException {
        String username = user.getUsername();

        String csvFilePath = username + "_Financial_goals.csv";
        File file = new File(csvFilePath);
        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(csvFilePath);
            writer.close();
        }
        csvFilePath = username + "_Relationship_goals.csv";
        file = new File(csvFilePath);
        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(csvFilePath);
            writer.close();
        }
        csvFilePath = username + "_Physical_goals.csv";
        file = new File(csvFilePath);
        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(csvFilePath);
            writer.close();
        }
        csvFilePath = username + "_Educational_goals.csv";
        file = new File(csvFilePath);
        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(csvFilePath);
            writer.close();
        }
        csvFilePath = username + "_Personal_goals.csv";
        file = new File(csvFilePath);
        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(csvFilePath);
            writer.close();
        }
        csvFilePath = username + "_Completed_goals.csv";
        file = new File(csvFilePath);
        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(csvFilePath);
            writer.close();
        }
    }

    public static void createUserCSV() {
        try {
            File outputFile = new File("output.csv");
            if (outputFile.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
        }
    }
}
