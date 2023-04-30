package com.scheduleMe.utility.goalsCSVHandler;



public class CompletedGoalsCSVHandler extends  GoalsCSVHandler{
    public CompletedGoalsCSVHandler(){
        goalsWriteBehavior = new WriteCompletedGoal();
        goalsReadBehavior = new ReadCompletedGoal();
    }
}
