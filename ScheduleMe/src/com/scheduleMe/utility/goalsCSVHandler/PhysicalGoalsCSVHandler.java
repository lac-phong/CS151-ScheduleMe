package com.scheduleMe.utility.goalsCSVHandler;

public class PhysicalGoalsCSVHandler extends GoalsCSVHandler{
    public PhysicalGoalsCSVHandler(){
        goalsWriteBehavior = new WritePhysicalGoal();
        goalsReadBehavior = new ReadPhysicalGoal();
    }
}
