package com.scheduleme.utility.goalscsvhandler;

import com.scheduleme.utility.goalscsvhandler.behavior.ReadPersonalGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WritePersonalGoal;

public class PersonalGoalsCSVHandler extends GoalsCSVHandler{
    public PersonalGoalsCSVHandler(){
        goalsWriteBehavior = new WritePersonalGoal();
        goalsReadBehavior =new ReadPersonalGoal();
    }
}
