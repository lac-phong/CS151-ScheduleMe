package com.scheduleme.utility.goalscsvhandler;

import com.scheduleme.utility.goalscsvhandler.behavior.ReadRelationshipGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteRelationshipGoal;

public class RelationshipGoalsCSVHandler extends GoalsCSVHandler{
    public RelationshipGoalsCSVHandler(){
        goalsWriteBehavior = new WriteRelationshipGoal();
        goalsReadBehavior = new ReadRelationshipGoal();
    }
}
