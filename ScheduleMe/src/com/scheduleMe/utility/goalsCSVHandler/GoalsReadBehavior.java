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

               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // create a formatter
               LocalDate dueDate = LocalDate.parse(dueDateString, formatter); // parse the string to a LocalDate object

//               LocalDate completedDate;
//               String isCompleteString = String.copyValueOf(fields[4].toCharArray());
//               boolean isComplete;
//               if (isCompleteString.matches("TRUE")){
//                    isComplete = true;
//               }

               Goal newGoal = new FinancialGoal(name, description, dueDate);
               newGoal.setCategory(category);
               user.goals.add(newGoal);
          }

          reader.close();

     }
}
class ReadCommunityGoal implements GoalsReadBehavior{
     @Override
     public void ReadFromCSV(User user) throws IOException {
          System.out.println("Read Community Goal!");
     }
}
class ReadEducationalGoal implements GoalsReadBehavior{
     @Override
     public void ReadFromCSV(User user) throws IOException {
          System.out.println("Read Educational Goal!");
     }
}
class ReadCareerGoal implements GoalsReadBehavior{
     @Override
     public void ReadFromCSV(User user) throws IOException {
          System.out.println("Read Career Goal!");
     }
}
class ReadPhysicalGoal implements GoalsReadBehavior{
     @Override
     public void ReadFromCSV(User user) throws IOException {
          System.out.println("Read Physical Goal!");
     }
}
class ReadPersonalGoal implements GoalsReadBehavior{
     @Override
     public void ReadFromCSV(User user) throws IOException {
          System.out.println("Read Personal Goal!");
     }
}
class ReadRelationshipGoal implements GoalsReadBehavior{
     @Override
     public void ReadFromCSV(User user) throws IOException {
          System.out.println("Read Relationship Goal!");
     }
}
