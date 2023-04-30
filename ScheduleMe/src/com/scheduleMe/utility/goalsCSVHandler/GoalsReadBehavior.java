package com.scheduleMe.utility.goalsCSVHandler;

import com.scheduleMe.FinancialGoal;
import com.scheduleMe.Goal;
import com.scheduleMe.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public interface GoalsReadBehavior{
     void ReadFromCSV(User user) throws IOException;
}
class ReadFinancialGoal implements GoalsReadBehavior{
     @Override
     public void ReadFromCSV(User user) throws IOException {
          System.out.println("Read goals!");
          String fileName = user.getUsername() + "_Financial_goals.csv";
          BufferedReader reader = new BufferedReader(new FileReader(fileName));
          String line = reader.readLine();  // skip the header row

          while ((line = reader.readLine()) != null) {

               String[] fields = line.split(",");
               String category = String.copyValueOf(fields[1].toCharArray());
               String name = String.copyValueOf(fields[2].toCharArray());
               String description = String.copyValueOf(fields[3].toCharArray());

               String dueDateString = String.copyValueOf(fields[4].toCharArray());

               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
               LocalDate dueDate = LocalDate.parse(dueDateString, formatter);

               Goal newGoal = new FinancialGoal(name, description, dueDate);
               newGoal.setCategory(category);
               user.goals.add(newGoal);
          }

          reader.close();

     }
}

