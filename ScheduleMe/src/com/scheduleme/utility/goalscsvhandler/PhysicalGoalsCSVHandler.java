package com.scheduleme.utility.goalscsvhandler;

import com.scheduleme.utility.goalscsvhandler.behavior.ReadPhysicalGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WritePhysicalGoal;

public class PhysicalGoalsCSVHandler extends GoalsCSVHandler{
    public PhysicalGoalsCSVHandler(){
        goalsWriteBehavior = new WritePhysicalGoal();
        goalsReadBehavior = new ReadPhysicalGoal();
    }
}
