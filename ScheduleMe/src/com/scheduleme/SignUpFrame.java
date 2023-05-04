package com.scheduleme;

import com.scheduleme.utility.UserCSVHandler;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;

public class SignUpFrame extends JFrame implements ActionListener {
    private JButton signupButton;
    private JButton backButton;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField passwordField;

    private HashMap<String, User> users;

    public SignUpFrame() throws IOException {
        users = UserList.getInstance();
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 1200);

        JLabel titleLabel = new JLabel("Sign Up!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        inputPanel.add(usernameLabel);

        usernameField = new JTextField();
        inputPanel.add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        inputPanel.add(emailLabel);

        emailField = new JTextField();
        inputPanel.add(emailField);

        JLabel firstNameLabel = new JLabel("First Name:");
        inputPanel.add(firstNameLabel);

        firstNameField = new JTextField();
        inputPanel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        inputPanel.add(lastNameLabel);

        lastNameField = new JTextField();
        inputPanel.add(lastNameField);

        JLabel passwordLabel = new JLabel("Password:");
        inputPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new BorderLayout());

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        buttonPanel.add(backButton, BorderLayout.WEST);

        signupButton = new JButton("Sign Up");
        signupButton.addActionListener(this);
        buttonPanel.add(signupButton, BorderLayout.EAST);

        JPanel contentPane = new JPanel(new BorderLayout(0, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.add(titleLabel, BorderLayout.NORTH);
        contentPane.add(inputPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();


            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username is empty!");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password is empty!");
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Email is empty!");
            } else if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "First name is empty!");

            } else if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Last name is empty!");
            } else if (users.containsKey(username)) {
                JOptionPane.showMessageDialog(this, "Username already taken!");
            } else {
                User user = new User(username, password, email, firstName, lastName);
                System.out.println(user.getFirstName());
                users.put(user.getUsername(), user);
                try {
                    UserCSVHandler.WriteToCSV(users);
                    System.out.println("wrote!");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this, "Account created Successfully");
                try {
                    UserCSVHandler.generateCSV(user);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                try {
                    HomeFrame homeFrame = new HomeFrame(user);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }


        } else if (e.getSource() == backButton) {
            try {
                new ScheduleMeFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        }
    }
}
