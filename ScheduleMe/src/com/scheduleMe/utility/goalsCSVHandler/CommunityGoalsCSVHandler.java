package com.scheduleMe.utility.goalsCSVHandler;

public class CommunityGoalsCSVHandler extends GoalsCSVHandler{
    public CommunityGoalsCSVHandler(){
        goalsWriteBehavior = new WriteCommunityGoal();
        goalsReadBehavior = new ReadCommunityGoal();
    }
}
