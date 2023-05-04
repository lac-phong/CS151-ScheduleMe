package com.scheduleme.utility.goalscsvhandler.behavior;

import com.scheduleme.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadFinancialGoal implements GoalsReadBehavior {
    private int amount;

    @Override
    public void ReadFromCSV(User user) throws IOException {
        System.out.println("Read goals!");
        String fileName = user.getUsername() + "_Financial_goals.csv";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();  // skip the header row

        while ((line = reader.readLine()) != null) {

            String[] fields = line.split(",");
            String name = String.copyValueOf(fields[2].toCharArray());
            String description = String.copyValueOf(fields[3].toCharArray());
            String activity = String.copyValueOf(fields[4].toCharArray());
            String interval = String.copyValueOf(fields[5].toCharArray());

            Goal newGoal = new Goal(name, description);

            if (interval.equals("Indefinite")) {
                String recurrence = String.copyValueOf(fields[6].toCharArray());
                int freq = Integer.parseInt(String.copyValueOf(fields[7].toCharArray()));
                newGoal.setInterval(new IndefiniteGoal(recurrence, freq));
                amount = Integer.parseInt(String.copyValueOf(fields[8].toCharArray()));
            } else {
                String dueDateString = String.copyValueOf(fields[6].toCharArray());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dueDate = LocalDate.parse(dueDateString, formatter);
                amount = Integer.parseInt(String.copyValueOf(fields[7].toCharArray()));
                newGoal.setInterval(new DefiniteGoal(dueDate));
            }
            //TODO change this code so that is sets to relevant behavior of the class, we don't need this if statement
            newGoal.setType(new FinancialGoal(activity, amount));
            user.getGoals().add(newGoal);
        }

        reader.close();

    }
    //TODO write code to edit and delete from csv
}
