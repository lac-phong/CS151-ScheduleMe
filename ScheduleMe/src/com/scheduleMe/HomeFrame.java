package com.scheduleMe;

import com.scheduleMe.utility.goalsCSVHandler.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class HomeFrame extends JFrame implements ActionListener {
    private JButton addGoalButton;
    private JButton viewGoalsButton;
    private JButton logoutButton;
    private JLabel greetingLabel;
    private JLabel nameLabel;

    private JButton viewAchievementsButton;

    private User currentUser;
    private Goal goalToDisplay;

    public HomeFrame(User user) throws IOException {
        currentUser = user;
        populateGoals();
        Achievement.validateAchievements(currentUser);
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

        // If there is a goal to display, show it on homescreen to serve as reminder.
        if (goalToDisplay != null){

            JLabel goalLabel = new JLabel("How is your " + goalToDisplay.getType().getCategory() + " goal going? It is " +
                    "marked as due on: " + ((DefiniteGoal) goalToDisplay.getInterval()).getDueDate());
            goalLabel.setFont(new Font("Arial", Font.BOLD, 18));
            goalLabel.setHorizontalAlignment(JLabel.CENTER);

            JTextArea descriptionArea = new JTextArea("Description: " + goalToDisplay.getDescription());
            descriptionArea.setEditable(false);
            descriptionArea.setLineWrap(true);
            descriptionArea.setWrapStyleWord(true);
            JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

            JPanel goalDisplayPanel = new JPanel(new BorderLayout(10, 10));
            goalDisplayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            goalDisplayPanel.add(goalLabel, BorderLayout.NORTH);
            goalDisplayPanel.add(descriptionScrollPane, BorderLayout.CENTER);

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

            viewAchievementsButton = new JButton(("View Achievements"));
            viewAchievementsButton.addActionListener(this);

            JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            buttonPanel.add(addGoalButton);
            buttonPanel.add(viewGoalsButton);
            buttonPanel.add(viewAchievementsButton);
            buttonPanel.add(logoutButton);

            JPanel contentPane = new JPanel(new BorderLayout(10, 10));
            contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            contentPane.add(topPanel, BorderLayout.NORTH);
            contentPane.add(goalDisplayPanel, BorderLayout.CENTER);
            contentPane.add(buttonPanel, BorderLayout.SOUTH);

            setContentPane(contentPane);
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }
        else {
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

            viewAchievementsButton = new JButton(("View Achievements"));
            viewAchievementsButton.addActionListener(this);

            JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            buttonPanel.add(addGoalButton);
            buttonPanel.add(viewGoalsButton);
            buttonPanel.add(viewAchievementsButton);

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
        } else if (e.getSource() == viewAchievementsButton) {
            dispose();
            new ViewAchievementsFrame(currentUser);
        }
    }

    private void populateGoals() throws IOException {
        GoalsCSVHandler goalsCSVHandler = new FinancialGoalsCSVHandler();
        if (currentUser.goals.isEmpty()) {
            goalsCSVHandler.performRead(currentUser);
            goalsCSVHandler.setGoalsReadBehavior(new ReadRelationshipGoal());
            goalsCSVHandler.performRead(currentUser);
            goalsCSVHandler.setGoalsReadBehavior(new ReadPhysicalGoal());
            goalsCSVHandler.performRead(currentUser);
            goalsCSVHandler.setGoalsReadBehavior(new ReadEducationalGoal());
            goalsCSVHandler.performRead(currentUser);

        }
        if (currentUser.completedGoals.isEmpty()){
            goalsCSVHandler.setGoalsReadBehavior(new ReadCompletedGoal());
            goalsCSVHandler.performRead(currentUser);
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