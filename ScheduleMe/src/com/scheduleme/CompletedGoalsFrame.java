package com.scheduleme;

import com.scheduleme.utility.UserCSVHandler;
import com.scheduleme.utility.goalscsvhandler.FinancialGoalsCSVHandler;
import com.scheduleme.utility.goalscsvhandler.*;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteFinancialGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteCompletedGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteEducationalGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WritePhysicalGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WriteRelationshipGoal;
import com.scheduleme.utility.goalscsvhandler.behavior.WritePersonalGoal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CompletedGoalsFrame extends JFrame implements ActionListener {
    private final User currentUser;
    private final ArrayList<Goal> goals;
    private final ArrayList<Goal> incompleteGoals;


    public CompletedGoalsFrame(User currentUser) {
        this.currentUser = currentUser;
        goals = currentUser.getCompletedGoals();
        incompleteGoals = currentUser.getGoals();

        setTitle("View Completed Goals");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String goalsDisplay;

        if (goals.isEmpty()) {
            goalsDisplay = "You have no completed goals right now, ";
        } else {
            goalsDisplay = "Here are your completed goals, ";
        }

        // Create components
        JLabel goalsLabel = new JLabel(goalsDisplay + currentUser.getFirstName() + ":");
        goalsLabel.setFont(new Font(goalsLabel.getFont().getName(), Font.PLAIN, 20));
        goalsLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.add(backButton);

        // Create goals list panel
        JPanel goalsPanel = new JPanel();
        goalsPanel.setLayout(new BoxLayout(goalsPanel, BoxLayout.Y_AXIS));

        //we should create a button on the side of each goal that changes the boolean isComplete
        // add in check for loop to ignore goals that have the isComplete = true value
        // maybe add in button that allows user to see past completed goals
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
                    JLabel amountLabel = new JLabel("Amount: " + ((FinancialGoal) goal.getType()).getAmount());
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
                JLabel dueDateLabel = new JLabel("Complete Date: " + ((DefiniteGoal) goal.getInterval()).getCompleteDate());
                goalPanel.add(dueDateLabel);
            }

            JButton incompleteButton, deleteButton;

            JPanel goalContainer = new JPanel();
            goalContainer.setLayout(new GridLayout(1, 2, 5, 0));
            goalContainer.add(goalPanel);

            JPanel optionsPanel = new JPanel();
            optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
            optionsPanel.setBorder(new EmptyBorder(5, 0, 10, 0));
            incompleteButton = new JButton("Incomplete Task");
            incompleteButton.addActionListener(this);
            optionsPanel.add(incompleteButton);
            deleteButton = new JButton("Delete");
            deleteButton.addActionListener(this);
            optionsPanel.add(deleteButton);
            incompleteButton.setActionCommand("incomplete_" + Integer.toString(goals.indexOf(goal)));
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
            new ViewGoalsFrame(currentUser);
        }
        if (e.getActionCommand().startsWith("delete_")) {
            int index = Integer.parseInt(e.getActionCommand().substring(7));
            GoalsCSVHandler goalsCSVHandler = new CompletedGoalsCSVHandler();
            try {
                goalsCSVHandler.performDelete(goals.get(index), currentUser);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            goals.remove(index);
            dispose();
            new CompletedGoalsFrame(currentUser);
        } else if (e.getActionCommand().startsWith("incomplete_")) {
            currentUser.numOfTotalGoalsComplete--;
            int index = Integer.parseInt(e.getActionCommand().substring(11));
            Goal goal = goals.get(index);
            GoalsCSVHandler goalsCSVHandler = new CompletedGoalsCSVHandler();
            if (goals.get(index).getType().getCategory().equals("Relationship")) {
                try{
                    goal.getInterval().setIsComplete(false);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteRelationshipGoal());
                    goalsCSVHandler.performWrite(goals.get(index), currentUser);
                    UserList.getCompletedGoalList(currentUser).remove(index);
                    incompleteGoals.add(goal);
                    currentUser.numOfRelationshipGoalsCompleted--;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }   
            } else if (goals.get(index).getType().getCategory().equals("Financial")) {
                try{
                    goal.getInterval().setIsComplete(false);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteFinancialGoal());
                    goalsCSVHandler.performWrite(goals.get(index), currentUser);
                    UserList.getCompletedGoalList(currentUser).remove(index);
                    incompleteGoals.add(goal);
                    currentUser.numOfFinancialGoalsCompleted--;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (goals.get(index).getType().getCategory().equals("Physical")) {
                try{
                    goal.getInterval().setIsComplete(false);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WritePhysicalGoal());
                    goalsCSVHandler.performWrite(goals.get(index), currentUser);
                    UserList.getCompletedGoalList(currentUser).remove(index);
                    incompleteGoals.add(goal);
                    currentUser.numOfPhysicalGoalsCompleted--;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }   
            } else if (goals.get(index).getType().getCategory().equals("Educational")) {
                try{
                    goal.getInterval().setIsComplete(false);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WriteEducationalGoal());
                    goalsCSVHandler.performWrite(goals.get(index), currentUser);
                    UserList.getCompletedGoalList(currentUser).remove(index);
                    incompleteGoals.add(goal);
                    currentUser.numOfEducationalGoalsCompleted--;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }   
            } else {
                try{
                    goal.getInterval().setIsComplete(false);
                    goalsCSVHandler.performDelete(goals.get(index), currentUser);
                    goalsCSVHandler.setGoalsWriteBehavior(new WritePersonalGoal());
                    goalsCSVHandler.performWrite(goals.get(index), currentUser);
                    UserList.getCompletedGoalList(currentUser).remove(index);
                    incompleteGoals.add(goal);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }   
            }
            try {
                UserCSVHandler.WriteToCSV(UserList.getInstance());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
            new CompletedGoalsFrame(currentUser);
        }
    }
}
