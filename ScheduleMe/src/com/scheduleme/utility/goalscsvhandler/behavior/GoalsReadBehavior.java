package com.scheduleme.utility.goalscsvhandler.behavior;

import com.scheduleme.FinancialGoal;
import com.scheduleme.DefiniteGoal;
import com.scheduleme.Goal;
import com.scheduleme.IndefiniteGoal;
import com.scheduleme.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface GoalsReadBehavior{
     void ReadFromCSV(User user) throws IOException;
}

