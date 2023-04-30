package com.scheduleMe.utility.goalsCSVHandler;

public class RelationshipGoalsCSVHandler extends GoalsCSVHandler{
    public RelationshipGoalsCSVHandler(){
        goalsWriteBehavior = new WriteRelationshipGoal();
        goalsReadBehavior = new ReadRelationshipGoal();
    }
}
