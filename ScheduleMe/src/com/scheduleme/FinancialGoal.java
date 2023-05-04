package com.scheduleme;

public class FinancialGoal implements GoalType, GoalCompletionListener {
    private final String category = "Financial";
    private String activity;
    private int initialAmount;
    private int amount;
    private boolean isComplete;
    private boolean trackingDone;


    public FinancialGoal(String activity) {
        this.activity = activity;
    }

    public FinancialGoal(String activity, int amount) {
        this.activity = activity;
        this.amount = amount;
    }

    public int getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(int initialAmount) {
        this.initialAmount = initialAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTrackingDone(boolean trackingDone) {
        this.trackingDone = trackingDone;
    }

    @Override
    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public boolean getIsComplete() {
        return isComplete;
    }

    @Override
    public boolean getTrackingDone() {
        return trackingDone;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getActivity() {
        return activity;
    }

    @Override
    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public void trackActivity() {
        CompleteGoalFrame completeGoalFrame = new CompleteGoalFrame(this, this);
        completeGoalFrame.display();
    }

    @Override
    public void onGoalCompleted(boolean completed) {
        isComplete = completed;
        trackingDone = true;
    }
}