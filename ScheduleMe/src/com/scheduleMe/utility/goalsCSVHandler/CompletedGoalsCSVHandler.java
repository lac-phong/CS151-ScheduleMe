package com.scheduleMe.utility.goalsCSVHandler;



public class CompletedGoalsCSVHandler extends  GoalsCSVHandler{
    CompletedGoalsCSVHandler(){
        goalsWriteBehavior = new WriteCompletedGoal();
        goalsReadBehavior = new ReadCompletedGoal();
    }
}
