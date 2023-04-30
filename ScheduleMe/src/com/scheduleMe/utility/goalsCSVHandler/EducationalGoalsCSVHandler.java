package com.scheduleMe.utility.goalsCSVHandler;

public class EducationalGoalsCSVHandler extends GoalsCSVHandler{
    public EducationalGoalsCSVHandler(){
        goalsWriteBehavior = new WriteEducationalGoal();
        goalsReadBehavior = new ReadEducationalGoal();
    }
}
