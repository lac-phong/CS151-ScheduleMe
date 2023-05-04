package com.scheduleMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class LoginFrame extends JFrame implements ActionListener {
    private JButton loginButton;
    private JButton backButton;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private HashMap<String, User> users;

    public LoginFrame() throws IOException {
        users = UserList.getInstance();


        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titleLabel = new JLabel("Login!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        inputPanel.add(usernameLabel);

        usernameField = new JTextField();
        inputPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        inputPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new BorderLayout());

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        buttonPanel.add(backButton, BorderLayout.WEST);

        loginButton = new JButton("Log In");
        loginButton.addActionListener(this);
        buttonPanel.add(loginButton, BorderLayout.EAST);

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
        if (e.getSource() == loginButton) {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                if (Objects.equals(users.get(username).getPassword(), password)) {
                    dispose();
                    new HomeFrame(users.get(username));
                } else {
                    JOptionPane.showMessageDialog(this, "Password does not match username!");
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "No such username!");
                dispose();
                try {
                    new ScheduleMeFrame();
                } catch (IOException exc) {
                    throw new RuntimeException(exc);
                }
            } catch (IOException ex) {
  
                throw new RuntimeException(ex);
            }


            // check if username and password are valid
            // if valid, log in the user and open the main application window
            // if invalid, show an error message to the user
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