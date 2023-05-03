package com.scheduleMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class ViewAchievementsFrame extends JFrame implements ActionListener {

    private JLabel titleLabel;
    private JPanel achievementPanel;

    private JButton backButton;
    private User currentUser;

    public ViewAchievementsFrame(User user) {
        this.currentUser = user;
        Achievement.validateAchievements(currentUser);

        // Set up the window
        setTitle("Achievements");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // Create a label for the title
        titleLabel = new JLabel("Achievements", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        backButton = new JButton("Back");
        backButton.addActionListener(this);

        // Create a panel to hold the achievements
        achievementPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        add(achievementPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        // Generate the achievements and add them to the panel
        HashMap<String, Achievement> achievements = currentUser.achievements;
        for (String key : achievements.keySet()) {
            Achievement achievement = achievements.get(key);
            JLabel titleLabel = new JLabel(achievement.getTitle(), SwingConstants.LEFT);
            JLabel descriptionLabel = new JLabel("Description: " + achievement.getDescription(), SwingConstants.LEFT);
            if (achievement.isUnlocked()) {
                titleLabel.setForeground(new Color(34, 139, 34));
                titleLabel.setText(titleLabel.getText() + " - Unlocked!");
            } else {
                titleLabel.setForeground(Color.RED);
                titleLabel.setText(titleLabel.getText() + " - Locked");
            }
            achievementPanel.add(titleLabel);
            achievementPanel.add(descriptionLabel);
            if (achievement.getTitle().equals("Juggernaut")) {
                int numCompleted = currentUser.numOfPhysicalGoalsCompleted;
                int requiredNum = 5;
                JLabel progressLabel = new JLabel("Progress: " + "(" + numCompleted + "/" + requiredNum + ")");
                achievementPanel.add(progressLabel);
            } else if (achievement.getTitle().equals("Scholar")) {
                int numCompleted = currentUser.numOfEducationalGoalsCompleted;
                int requiredNum = 5;
                JLabel progressLabel = new JLabel("Progress: " + "(" + numCompleted + "/" + requiredNum + ")" + " Educational goals completed");
                achievementPanel.add(progressLabel);
            } else if (achievement.getTitle().equals("Debt Collector")) {
                int numCompleted = currentUser.numOfFinancialGoalsCompleted;
                int requiredNum = 5;
                JLabel progressLabel = new JLabel("Progress: " + "(" + numCompleted + "/" + requiredNum + ")");
                achievementPanel.add(progressLabel);
            } else if (achievement.getTitle().equals("Suave")) {
                int numCompleted = currentUser.numOfRelationshipGoalsCompleted;
                int requiredNum = 5;
                JLabel progressLabel = new JLabel("Progress: " + "(" + numCompleted + "/" + requiredNum + ")");
                achievementPanel.add(progressLabel);
            } else if (achievement.getTitle().equals("Variety")) {
                int requiredNum = 3;
                JLabel progressLabel = new JLabel("Progress: " + "(" + user.numOfPhysicalGoalsCompleted + "/" +
                        requiredNum + ")" + "(" + user.numOfRelationshipGoalsCompleted + "/" +
                        requiredNum + ")" + "(" + user.numOfFinancialGoalsCompleted + "/" +
                        requiredNum + ")" + "(" + user.numOfEducationalGoalsCompleted + "/" +
                        requiredNum + ")");
                achievementPanel.add(progressLabel);
            }
            else if (achievement.getTitle().equals("Dedicated")) {
                int numCompleted = currentUser.numOfTotalGoalsComplete;
                int requiredNum = 25;
                JLabel progressLabel = new JLabel("Progress: " + "(" + numCompleted + "/" + requiredNum + ")");
                achievementPanel.add(progressLabel);
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            dispose();
            try {
                new HomeFrame(currentUser);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
