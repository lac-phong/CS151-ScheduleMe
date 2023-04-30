package com.scheduleMe.utility.goalsCSVHandler;

public class PersonalGoalsCSVHandler extends GoalsCSVHandler{
    public PersonalGoalsCSVHandler(){
        goalsWriteBehavior = new WritePersonalGoal();
        goalsReadBehavior =new ReadPersonalGoal();
    }
}
