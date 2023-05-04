package com.scheduleme.utility.goalscsvhandler;

/*since we have a variety of different goal types each with different parameters
and variables and what not, it would be easy to implement a different read
and write behavior via the strategy design pattern.
*/

import com.scheduleme.utility.goalscsvhandler.behavior.ReadFinancialGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteFinancialGoal;

public class FinancialGoalsCSVHandler extends GoalsCSVHandler {
    public FinancialGoalsCSVHandler(){
        goalsWriteBehavior = new WriteFinancialGoal();
        goalsReadBehavior = new ReadFinancialGoal();
    }
}
