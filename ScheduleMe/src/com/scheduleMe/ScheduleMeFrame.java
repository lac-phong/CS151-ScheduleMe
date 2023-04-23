package com.scheduleMe;

import com.scheduleMe.utility.CSVHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;


public class ScheduleMeFrame extends JFrame implements ActionListener {
    private JButton signUpButton;
    private JButton loginButton;

    private HashMap<String, User> users;



    public ScheduleMeFrame() throws IOException {

        // on start up populate the users hashmap with values from csv
        users = (HashMap<String, User>) CSVHandler.CSVToHashMap("output.csv");


        setTitle("ScheduleMe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel greetingLabel = new JLabel("Welcome to ScheduleMe!");
        greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        greetingLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this);

        buttonPanel.add(signUpButton);

        loginButton = new JButton("Log In");
        loginButton.addActionListener(this);
        buttonPanel.add(loginButton);

        JPanel contentPane = new JPanel(new BorderLayout(0, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.add(greetingLabel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(500,500);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            dispose();
            SignUpFrame signUpFrame = new SignUpFrame(users);
            signUpFrame.setVisible(true);
            System.out.println("Sign Up button clicked");
        } else if (e.getSource() == loginButton) {
            dispose();
            LoginFrame loginFrame = new LoginFrame(users);
            loginFrame.setVisible(true);
            System.out.println("Log In button clicked");
        }
    }
}