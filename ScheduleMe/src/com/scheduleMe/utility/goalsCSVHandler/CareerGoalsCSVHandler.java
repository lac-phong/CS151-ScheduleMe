package com.scheduleMe.utility.goalsCSVHandler;

public class CareerGoalsCSVHandler extends GoalsCSVHandler{
    public CareerGoalsCSVHandler(){
        goalsWriteBehavior = new WriteCareerGoal();
        goalsReadBehavior = new ReadCareerGoal();
    }
}
