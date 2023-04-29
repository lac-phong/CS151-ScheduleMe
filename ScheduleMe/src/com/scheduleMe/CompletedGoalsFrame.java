package com.scheduleMe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CompletedGoalsFrame extends JFrame implements ActionListener {
    private final User currentUser;
    private final ArrayList<Goal> goals;
    private final ArrayList<Goal> incompleteGoals;
    

    public CompletedGoalsFrame(User currentUser) {
        this.currentUser = currentUser;
        goals = currentUser.completedGoals;
        incompleteGoals = currentUser.goals;

        setTitle("View Completed Goals");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String goalsDisplay;

        if (goals.isEmpty()){
            goalsDisplay = "You have no completed goals right now, ";
        }
        else {
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
            JLabel categoryLabel = new JLabel("Category: " + goal.getCategory());
            JLabel descriptionLabel = new JLabel("Description: " + goal.getDescription());
            JLabel dueDateLabel = new JLabel("Completed Date: " + goal.getCompleteDate().toString());
            JButton incompleteButton, deleteButton;
            

            JPanel goalContainer = new JPanel();
            goalContainer.setLayout(new GridLayout(1, 2, 5, 0));

            JPanel goalPanel = new JPanel();
            goalPanel.setBorder(new EmptyBorder(10, 20, 10, 10));
            goalPanel.setLayout(new BoxLayout(goalPanel, BoxLayout.Y_AXIS));
            goalPanel.add(nameLabel2);
            goalPanel.add(categoryLabel);
            goalPanel.add(descriptionLabel);
            goalPanel.add(dueDateLabel);
            goalContainer.add(goalPanel);

            JPanel optionsContainer = new JPanel();
            optionsContainer.setLayout(new BorderLayout());
            JPanel optionsPanel = new JPanel();
            optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
            optionsPanel.setBorder(new EmptyBorder(5, 0, 10, 0));
            incompleteButton = new JButton("Incomplete");
            incompleteButton.addActionListener(this);
            deleteButton = new JButton("Delete");
            deleteButton.addActionListener(this);
            optionsPanel.add(incompleteButton);
            optionsPanel.add(deleteButton);
            optionsContainer.add(optionsPanel, BorderLayout.CENTER);
            incompleteButton.setActionCommand("incomplete_" + Integer.toString(goals.indexOf(goal)));  
            deleteButton.setActionCommand("delete_" + Integer.toString(goals.indexOf(goal)));  
            goalContainer.add(optionsContainer);

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
            goals.remove(index);
            dispose();
            new CompletedGoalsFrame(currentUser);
        } else if (e.getActionCommand().startsWith("incomplete_")){
            int index = Integer.parseInt(e.getActionCommand().substring(11));
            Goal goal = goals.get(index);
            goals.remove(index);
            incompleteGoals.add(goal);
            dispose();
            new CompletedGoalsFrame(currentUser);
        }
    }
}