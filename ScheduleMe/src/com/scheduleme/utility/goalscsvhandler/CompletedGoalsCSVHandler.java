package com.scheduleme.utility.goalscsvhandler;


import com.scheduleme.utility.goalscsvhandler.behavior.ReadCompletedGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteCompletedGoal;

public class CompletedGoalsCSVHandler extends  GoalsCSVHandler{
    public CompletedGoalsCSVHandler(){
        goalsWriteBehavior = new WriteCompletedGoal();
        goalsReadBehavior = new ReadCompletedGoal();
    }
}
