package com.scheduleMe;

import com.scheduleMe.utility.goalsCSVHandler.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class HomeFrame extends JFrame implements ActionListener {
    private JButton addGoalButton;
    private JButton viewGoalsButton;
    private JButton logoutButton;
    private JLabel greetingLabel;
    private JLabel nameLabel;

    private User currentUser;
    private Goal goalToDisplay;

    public HomeFrame(User user) throws IOException {
        currentUser = user;
        populateGoals();
        if (!currentUser.goals.isEmpty()){
            goalToDisplay = findNextGoal();
        }
        else {
            goalToDisplay = null;
        }
        setTitle("ScheduleMe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create greeting label
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        String timeOfDay;
        if (hour < 12) {
            timeOfDay = "Morning";
        } else if (hour < 17) {
            timeOfDay = "Afternoon";
        } else {
            timeOfDay = "Evening";
        }

        if (goalToDisplay != null){

        }
        greetingLabel = new JLabel("Good " + timeOfDay + ", ");
        greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        greetingLabel.setHorizontalAlignment(JLabel.LEFT);


        nameLabel = new JLabel(user.getFirstName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setHorizontalAlignment(JLabel.LEFT);

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(greetingLabel);
        topPanel.add(nameLabel);

        // create buttons
        addGoalButton = new JButton("Add Goal");
        addGoalButton.addActionListener(this);

        viewGoalsButton = new JButton("View Current Goals");
        viewGoalsButton.addActionListener(this);

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.add(addGoalButton);
        buttonPanel.add(viewGoalsButton);

        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        contentPane.add(logoutButton, BorderLayout.SOUTH);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addGoalButton) {

            dispose();
            new CreateGoalFrame(currentUser);
            // handle add goal button click
            System.out.println("Add Goal button clicked");

        } else if (e.getSource() == viewGoalsButton) {
            // handle view goals button click
            dispose();
            new ViewGoalsFrame(currentUser);

            System.out.println("View Current Goals button clicked");
        } else if (e.getSource() == logoutButton) {

            // handle logout button click
            System.out.println("Logout button clicked");
            this.dispose(); // close the current frame
            try {
                new ScheduleMeFrame(); // show the login/signup screen
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void populateGoals() throws IOException {
        if (currentUser.goals.isEmpty()) {
            GoalsCSVHandler goalsCSVHandler = new FinancialGoalsCSVHandler();
            goalsCSVHandler.performRead(currentUser);;
        }
    }

    private Goal findNextGoal() throws IOException {
        LocalDate closestDate = null;
        long closestDiff = Long.MAX_VALUE;
        Goal homeScreenDisplayGoal = null;

        for (Goal goal : UserList.getGoalList(currentUser)) {
            if (goal.getInterval().getString().equals("Definite")){
                LocalDate today = LocalDate.now();
                long diff = Math.abs(ChronoUnit.DAYS.between(((DefiniteGoal) goal.getInterval()).getDueDate(), today));
                if (diff < closestDiff) {
                    closestDiff = diff;
                    closestDate = ((DefiniteGoal) goal.getInterval()).getDueDate();
                    homeScreenDisplayGoal = goal;
                }
            }
        }
        return homeScreenDisplayGoal;
    }
}