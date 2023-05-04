package com.scheduleme.utility.goalscsvhandler;

import com.scheduleme.utility.goalscsvhandler.behavior.ReadEducationalGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteEducationalGoal;

public class EducationalGoalsCSVHandler extends GoalsCSVHandler{
    public EducationalGoalsCSVHandler(){
        goalsWriteBehavior = new WriteEducationalGoal();
        goalsReadBehavior = new ReadEducationalGoal();
    }
}
