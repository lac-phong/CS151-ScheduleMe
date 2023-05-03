package com.scheduleMe;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ViewAchievementsFrame extends JFrame {

    private JLabel titleLabel;
    private JPanel mainPanel;

    public ViewAchievementsFrame(User user) {
        Achievement.validateAchievements(user);

        // Set up the window
        setTitle("Achievements");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // Create a label for the title
        titleLabel = new JLabel("Achievements", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Create a panel to hold the achievements
        mainPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        // Generate the achievements and add them to the panel
        HashMap<String, Achievement> achievements = Achievement.generateAchievements();
        for (String key : achievements.keySet()) {
            Achievement achievement = achievements.get(key);
            JLabel label = new JLabel(achievement.getTitle(), SwingConstants.LEFT);
            if (achievement.isUnlocked()) {
                label.setForeground(Color.GREEN);
                label.setText(label.getText() + " - Unlocked!");
            } else {
                label.setForeground(Color.RED);
                label.setText(label.getText() + " - Locked");
            }
            mainPanel.add(label);
        }

        // Validate the user's achievements
    }
}