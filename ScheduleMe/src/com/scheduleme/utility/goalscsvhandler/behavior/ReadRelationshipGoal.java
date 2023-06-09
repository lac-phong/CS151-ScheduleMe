package com.scheduleme.utility.goalscsvhandler.behavior;

import com.scheduleme.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadRelationshipGoal implements GoalsReadBehavior {
    @Override
    public void ReadFromCSV(User user) throws IOException {
        System.out.println("Read Relationship goals!");
        String fileName = user.getUsername() + "_Relationship_goals.csv";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();  // skip the header row

        while ((line = reader.readLine()) != null) {

            String[] fields = line.split(",");
            String category = String.copyValueOf(fields[1].toCharArray());
            String name = String.copyValueOf(fields[2].toCharArray());
            String description = String.copyValueOf(fields[3].toCharArray());
            String activity = String.copyValueOf(fields[4].toCharArray());
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
            //TODO change this code so that is sets to relevant behavior of the class, we don't need this if statement
            newGoal.setType(new RelationshipGoal(activity));
//                } else if (category.equals("Educational")) {
//                    newGoal.setType(new EducationalGoal(activity));
//                } else if (category.equals("Relationship")) {
//                    newGoal.setType(new RelationshipGoal(activity));
//                } else if (category.equals("Physical")) {
//                    newGoal.setType(new PhysicalGoal(activity));
//                } else if (category.equals("General")) {
//                    newGoal.setType(new GeneralGoal());
//                }
            user.getGoals().add(newGoal);
        }

        reader.close();

    }
}
