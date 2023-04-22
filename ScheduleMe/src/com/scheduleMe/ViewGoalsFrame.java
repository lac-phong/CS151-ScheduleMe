package com.scheduleMe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewGoalsFrame extends JFrame implements ActionListener {
    private final User currentUser;
    private final ArrayList<Goal> goals;

    public ViewGoalsFrame(User currentUser) {
        this.currentUser = currentUser;
        goals = currentUser.goals;

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

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.add(backButton);

        // Create goals list panel
        JPanel goalsPanel = new JPanel();
        goalsPanel.setLayout(new BoxLayout(goalsPanel, BoxLayout.Y_AXIS));

        for (Goal goal : goals) {
            JLabel nameLabel2 = new JLabel(goal.getName());
            nameLabel2.setFont(new Font(nameLabel2.getFont().getName(), Font.BOLD, 14));
            JLabel categoryLabel = new JLabel("Category: " + goal.getCategory());
            JLabel descriptionLabel = new JLabel("Description: " + goal.getDescription());
            JLabel dueDateLabel = new JLabel("Due Date: " + goal.getDueDate().toString());

            JPanel goalPanel = new JPanel();
            goalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            goalPanel.setLayout(new BoxLayout(goalPanel, BoxLayout.Y_AXIS));
            goalPanel.add(nameLabel2);
            goalPanel.add(categoryLabel);
            goalPanel.add(descriptionLabel);
            goalPanel.add(dueDateLabel);
            goalPanel.add(Box.createVerticalStrut(10));

            goalsPanel.add(goalPanel);
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
            new HomeFrame(currentUser);
        }
    }
}