package com.scheduleMe;

import com.scheduleMe.utility.goalsCSVHandler.FinancialGoalsCSVHandler;
import com.scheduleMe.utility.goalsCSVHandler.*;

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
    

    public ViewGoalsFrame(User currentUser) {
        this.currentUser = currentUser;
        goals = currentUser.goals;
        completedGoals = currentUser.completedGoals;

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
            goal.getInterval().setIsComplete(true);
            if (goal.getInterval().getString().equals("Definite")) {
                ((DefiniteGoal) goal.getInterval()).setCompleteDate(LocalDate.now());
            }
            goals.remove(index);
            completedGoals.add(goal);
            dispose();
            new ViewGoalsFrame(currentUser);
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