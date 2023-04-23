package com.scheduleMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.*;

public class HomeFrame extends JFrame implements ActionListener {
    private JButton addGoalButton;
    private JButton viewGoalsButton;
    private JButton logoutButton;
    private JLabel greetingLabel;
    private JLabel nameLabel;

    private User currentUser;

    public HomeFrame(User user) {
        currentUser = user;
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

}