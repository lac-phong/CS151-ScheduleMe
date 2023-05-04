package com.scheduleme;

import com.scheduleme.utility.UserCSVHandler;
import com.scheduleme.utility.goalscsvhandler.FinancialGoalsCSVHandler;
import com.scheduleme.utility.goalscsvhandler.*;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteCompletedGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteEducationalGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WritePhysicalGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteRelationshipGoal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

public class ViewGoalsFrame extends JFrame implements ActionListener {
    private final User currentUser;
    private final ArrayList<Goal> goals;
    private final ArrayList<Goal> completedGoals;
    private int startIndex = 0;
    private int endIndex;
    private JLabel rangeLabel;

    //TODO bug where trying to complete last or second to last goal in a category gives out of bounds exception


    public ViewGoalsFrame(User currentUser) {
        this.currentUser = currentUser;
        goals = currentUser.getGoals();
        endIndex = Math.min(4, goals.size() - 1);
        completedGoals = currentUser.getCompletedGoals();

        setTitle("View Goals");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String goalsDisplay;

        if (goals.isEmpty()){
            goalsDisplay = "You have no goals right now, ";
        }
        else {
            goalsDisplay = "Here are your goals, ";
        }

        // Create components
        JLabel goalsLabel = new JLabel(goalsDisplay + currentUser.getFirstName() + ":");
        goalsLabel.setFont(new Font(goalsLabel.getFont().getName(), Font.PLAIN, 20));
        goalsLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);
        JButton completedGoalsButton = new JButton("Completed Goals");
        completedGoalsButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.add(backButton);
        buttonPanel.add(completedGoalsButton);

        // Create goals list panel
        JPanel goalsPanel = new JPanel();
        goalsPanel.setLayout(new BoxLayout(goalsPanel, BoxLayout.Y_AXIS));

//        rangeLabel = new JLabel("Showing goals " + (startIndex + 1) + "-" + (endIndex + 1) + " of " + goals.size());
//        rangeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
//        goalsPanel.add(rangeLabel);


        for (Goal goal : goals) {
            JLabel nameLabel2 = new JLabel(goal.getName());
            nameLabel2.setFont(new Font(nameLabel2.getFont().getName(), Font.BOLD, 14));
            JLabel categoryLabel = new JLabel("Category: " + goal.getType().getCategory());
            JLabel descriptionLabel = new JLabel("Description: " + goal.getDescription());
            JLabel activityLabel = new JLabel("Activity: " + goal.getType().getActivity());

            JPanel goalPanel = new JPanel();
            goalPanel.setBorder(new EmptyBorder(10, 20, 10, 10));
            goalPanel.setLayout(new BoxLayout(goalPanel, BoxLayout.Y_AXIS));
            goalPanel.add(nameLabel2);
            goalPanel.add(categoryLabel);
            if (!goal.getType().getCategory().equals("General")) {
                goalPanel.add(activityLabel);
                if (goal.getType().getCategory().equals("Financial")) {
                    JLabel amountLabel = new JLabel("Amount: " + String.valueOf(((FinancialGoal) goal.getType()).getAmount()));
                    goalPanel.add(amountLabel);
                }
            }
            goalPanel.add(descriptionLabel);

            if (goal.getInterval().getString().equals("Indefinite")) {
                JLabel recurrenceLabel = new JLabel("Recurrence: " + ((IndefiniteGoal) goal.getInterval()).getRecurrence());
                JLabel frequencyLabel = new JLabel("Frequency: " + ((IndefiniteGoal) goal.getInterval()).getFreq());
                goalPanel.add(recurrenceLabel);
                goalPanel.add(frequencyLabel);
            } else if (goal.getInterval().getString().equals("Definite")) {
                JLabel dueDateLabel = new JLabel("Due Date: " + ((DefiniteGoal) goal.getInterval()).getDueDate());
                goalPanel.add(dueDateLabel);
            }

            JButton editButton, completeButton, deleteButton;

            JPanel goalContainer = new JPanel();
            goalContainer.setLayout(new GridLayout(1, 2, 5, 0));
            goalContainer.add(goalPanel);

            JPanel optionsPanel = new JPanel();
            optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
            optionsPanel.setBorder(new EmptyBorder(5, 0, 10, 0));
            editButton = new JButton("Edit");
            editButton.addActionListener(this);
            optionsPanel.add(editButton);
            completeButton = new JButton("Complete Task");
            completeButton.addActionListener(this);
            optionsPanel.add(completeButton);
            deleteButton = new JButton("Delete");
            deleteButton.addActionListener(this);
            optionsPanel.add(deleteButton);
            completeButton.setActionCommand("complete_" + Integer.toString(goals.indexOf(goal)));
            editButton.setActionCommand("edit_" + Integer.toString(goals.indexOf(goal)));
            deleteButton.setActionCommand("delete_" + Integer.toString(goals.indexOf(goal)));
            goalContainer.add(optionsPanel);

            goalsPanel.add(goalContainer);
            goalsPanel.add(Box.createVerticalStrut(10));
        }

        JScrollPane scrollPane = new JScrollPane(goalsPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Create content pane
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to content pane
        contentPane.add(goalsLabel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            dispose();
            try {
                new HomeFrame(currentUser);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand().equals("Completed Goals")) {
            dispose();
            new CompletedGoalsFrame(currentUser);
        }
        if (e.getActionCommand().startsWith("edit_")) {
            int index = Integer.parseInt(e.getActionCommand().substring(5));
            Goal goal = goals.get(index);
            dispose();
            new EditGoalFrame(currentUser, goal, index);

        }
        if (e.getActionCommand().startsWith("complete_")) {
            int index = Integer.parseInt(e.getActionCommand().substring(9));
            Goal goal = goals.get(index);
            GoalsCSVHandler goalsCSVHandler = new FinancialGoalsCSVHandler();
            if (goal.getInterval().getString().equals("Definite")) {
                ((DefiniteGoal) goal.getInterval()).setCompleteDate(LocalDate.now());
            }
            if (goals.get(index).getType().getCategory().equals("Relationship")){
                try {
                    goal.getInterval().setIsComplete(true);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteRelationshipGoal());
                    UserList.getGoalList(currentUser).remove(index);
                    completedGoals.add(goal);
                    dispose();
                    new ViewGoalsFrame(currentUser);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteCompletedGoal());
                    goalsCSVHandler.performWrite(goals.get(index),currentUser);
                    currentUser.numOfRelationshipGoalsCompleted++;

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (goals.get(index).getType().getCategory().equals("Physical")) {
                try {
                    goal.getInterval().setIsComplete(true);
                    goalsCSVHandler.setGoalsWriteBehavior(new WritePhysicalGoal());
                    UserList.getGoalList(currentUser).remove(index);
                    completedGoals.add(goal);
                    dispose();
                    new ViewGoalsFrame(currentUser);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteCompletedGoal());
                    goalsCSVHandler.performWrite(goals.get(index),currentUser);
                    currentUser.numOfPhysicalGoalsCompleted++;

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (goals.get(index).getType().getCategory().equals("Educational")) {
                try {
                    goal.getInterval().setIsComplete(true);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteEducationalGoal());
                    UserList.getGoalList(currentUser).remove(index);
                    completedGoals.add(goal);
                    dispose();
                    new ViewGoalsFrame(currentUser);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteCompletedGoal());
                    goalsCSVHandler.performWrite(goals.get(index),currentUser);
                    currentUser.numOfEducationalGoalsCompleted++;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (goal.getType().getCategory().equals("Financial")) {
                currentUser.numOfFinancialGoalsCompleted++;
                goal.getType().trackActivity();
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        while (!goal.getType().getTrackingDone()) {
                            Thread.sleep(100); // wait for 100 milliseconds before checking again
                        }
                        return null;
                    }
                    @Override
                    protected void done() {
                        try {
                            if (goal.getType().getIsComplete()) {
                                goalsCSVHandler.performDelete(goals.get(index), currentUser);
                                goalsCSVHandler.setGoalsWriteBehavior(new WriteCompletedGoal());
                                goalsCSVHandler.performWrite(goals.get(index),currentUser);
                                goal.getInterval().setIsComplete(true);
                                UserList.getGoalList(currentUser).remove(index);
                                completedGoals.add(goal);
                                dispose();
                                new ViewGoalsFrame(currentUser).setVisible(true); // Reinitialize the frame\
                            } else {
                                GoalsCSVHandler goalsCSVHandler = new FinancialGoalsCSVHandler();
                                goalsCSVHandler.performDelete(goal,currentUser);
                                goalsCSVHandler.performWrite(goal, currentUser);
                                dispose();
                                new ViewGoalsFrame(currentUser).setVisible(true); // Reinitialize the frame
                            }
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                };
                worker.execute();
            } else {
                try {
                    UserList.getGoalList(currentUser).remove(index);
                    completedGoals.add(goal);
                    dispose();
                    new ViewGoalsFrame(currentUser);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteCompletedGoal());
                    goalsCSVHandler.performWrite(goals.get(index),currentUser);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            try {
                UserCSVHandler.WriteToCSV(UserList.getInstance());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //TODO write these to be stored!!!
            if (currentUser.numOfPhysicalGoalsCompleted == 5 && currentUser.achievements.get("Juggernaut").achievementFlashed == false){
                JOptionPane.showMessageDialog(this,"Way to go! You have unlocked the Juggernaut Achievement!");
                currentUser.achievements.get("Juggernaut").achievementFlashed = true;
                currentUser.achievements.get("Juggernaut").setDateUnlocked(LocalDate.now());
            }
            if (currentUser.numOfEducationalGoalsCompleted == 5 && currentUser.achievements.get("Scholar").achievementFlashed == false){
                JOptionPane.showMessageDialog(this,"Way to go! You have unlocked the Scholar Achievement!");
                currentUser.achievements.get("Scholar").achievementFlashed = true;
                currentUser.achievements.get("Scholar").setDateUnlocked(LocalDate.now());

            }
            if (currentUser.numOfFinancialGoalsCompleted == 5 && currentUser.achievements.get("Debt Collector").achievementFlashed == false){
                JOptionPane.showMessageDialog(this,"Way to go! You have unlocked the Debt Collector Achievement!");
                currentUser.achievements.get("Debt Collector").achievementFlashed = true;
                currentUser.achievements.get("Debt Collector").setDateUnlocked(LocalDate.now());

            }
            if (currentUser.numOfRelationshipGoalsCompleted == 5 && currentUser.achievements.get("Suave").achievementFlashed == false){
                JOptionPane.showMessageDialog(this,"Way to go! You have unlocked the Suave Achievement!");
                currentUser.achievements.get("Suave").achievementFlashed = true;
                currentUser.achievements.get("Suave").setDateUnlocked(LocalDate.now());

            }
            if (currentUser.numOfTotalGoalsComplete == 25 && currentUser.achievements.get("Dedicated").achievementFlashed == false){
                JOptionPane.showMessageDialog(this,"Way to go! You have unlocked the Dedicated Achievement!");
                currentUser.achievements.get("Dedicated").achievementFlashed = true;
                currentUser.achievements.get("Dedicated").setDateUnlocked(LocalDate.now());
            }
            if (currentUser.numOfPhysicalGoalsCompleted == 3 && currentUser.numOfEducationalGoalsCompleted == 3
                    && currentUser.numOfFinancialGoalsCompleted >= 3 && currentUser.numOfRelationshipGoalsCompleted >= 3
                    && currentUser.achievements.get("Variety").achievementFlashed == false){
                JOptionPane.showMessageDialog(this,"Way to go! You have unlocked the Variety Achievement!");
                currentUser.achievements.get("Variety").achievementFlashed = true;
                currentUser.achievements.get("Variety").setDateUnlocked(LocalDate.now());

            }
            currentUser.numOfTotalGoalsComplete++;

        }
        if (e.getActionCommand().startsWith("delete_")) {
            GoalsCSVHandler goalsCSVHandler = new FinancialGoalsCSVHandler();
            int index = Integer.parseInt(e.getActionCommand().substring(7));
            if (goals.get(index).getType().getCategory().equals("Relationship")){
                goalsCSVHandler.setGoalsWriteBehavior(new WriteRelationshipGoal());
            } else if (goals.get(index).getType().getCategory().equals("Physical")) {
                goalsCSVHandler.setGoalsWriteBehavior(new WritePhysicalGoal());
            }
            else if (goals.get(index).getType().getCategory().equals("Educational")) {
                goalsCSVHandler.setGoalsWriteBehavior(new WriteEducationalGoal());
            }
            try {
                goalsCSVHandler.performDelete(goals.get(index), currentUser);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            goals.remove(index);
            dispose();
            new ViewGoalsFrame(currentUser);
        }
    }
}