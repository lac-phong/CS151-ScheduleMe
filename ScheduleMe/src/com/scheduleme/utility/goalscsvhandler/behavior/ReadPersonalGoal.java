package com.scheduleme.utility.goalscsvhandler.behavior;

import com.scheduleme.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadPersonalGoal implements GoalsReadBehavior {
    @Override
    public void ReadFromCSV(User user) throws IOException {
        System.out.println("Read Personal Goal!");
        String fileName = user.getUsername() + "_Personal_goals.csv";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();  // skip the header row

        while ((line = reader.readLine()) != null) {

            String[] fields = line.split(",");
            String name = String.copyValueOf(fields[2].toCharArray());
            String description = String.copyValueOf(fields[3].toCharArray());
            String interval = String.copyValueOf(fields[5].toCharArray());

            Goal newGoal = new Goal(name, description);

            if (interval.equals("Indefinite")) {
                String recurrence = String.copyValueOf(fields[6].toCharArray());
                int freq = Integer.parseInt(String.copyValueOf(fields[7].toCharArray()));
                newGoal.setInterval(new IndefiniteGoal(recurrence, freq));
            } else {
                String dueDateString = String.copyValueOf(fields[6].toCharArray());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dueDate = LocalDate.parse(dueDateString, formatter);
                newGoal.setInterval(new DefiniteGoal(dueDate));
            }
            newGoal.setType(new GeneralGoal());
            user.getGoals().add(newGoal);
        }
        System.out.println("Passed");
        reader.close();
    }
}
