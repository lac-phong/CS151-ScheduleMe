package com.scheduleMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CreateGoalFrame extends JFrame implements ActionListener {
    private JTextField nameField;
    private JComboBox<String> categoryComboBox;
    private JTextArea descriptionArea;
    private JSpinner dueDateSpinner;

    private User currentUser;

    public CreateGoalFrame(User currentUser) {
        this.currentUser =currentUser;
        setTitle("Create New Goal");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {"Financial", "Physical", "Relationship", "Educational", "Career", "Personal Growth", "Community Involvement"};
        categoryComboBox = new JComboBox<>(categories);
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea(5, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dueDateSpinner, "yyyy-MM-dd");
        dueDateSpinner.setEditor(dateEditor);


        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);
        JButton createButton = new JButton("Create Goal");
        createButton.addActionListener(this);

        // Create content pane
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to content pane
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(categoryLabel);
        formPanel.add(categoryComboBox);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionScrollPane);
        formPanel.add(dueDateLabel);
        formPanel.add(dueDateSpinner);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(backButton);
        buttonPanel.add(createButton);

        // Style components
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dueDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add components to content pane
        contentPane.add(formPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public CreateGoalFrame(User currentUser, Goal goal, int index){
        this.currentUser =currentUser;
        setTitle("Create New Goal");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        nameField.setText(goal.getName());
        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {"Financial", "Physical", "Relationship", "Educational", "Career", "Personal Growth", "Community Involvement"};
        categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.setSelectedItem(goal.getCategory());
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setText(goal.getDescription());
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateSpinner = new JSpinner(new SpinnerDateModel());
        Date date = Date.from(goal.getDueDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        dueDateSpinner.setValue(date);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dueDateSpinner, "yyyy-MM-dd");
        dueDateSpinner.setEditor(dateEditor);


        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);
        JButton createButton = new JButton("Finish Edit");
        createButton.addActionListener(this);
        createButton.setActionCommand("finaledit_"+Integer.toString(index));

        // Create content pane
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to content pane
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(categoryLabel);
        formPanel.add(categoryComboBox);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionScrollPane);
        formPanel.add(dueDateLabel);
        formPanel.add(dueDateSpinner);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(backButton);
        buttonPanel.add(createButton);

        // Style components
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dueDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add components to content pane
        contentPane.add(formPanel, BorderLayout.CENTER);
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
        } else if (e.getActionCommand().equals("Create Goal")) {
            String name = nameField.getText();
            String category = (String) categoryComboBox.getSelectedItem();
            String description = descriptionArea.getText();
            LocalDate dueDate = LocalDate.of(2023, 12,15); // hard coded so we need to change this.



            Goal newGoal = new Goal(name, category, description, dueDate);

            JOptionPane.showMessageDialog(this, name + " created!");

            currentUser.goals.add(newGoal); // maybe pass in anonymous declaration?
            dispose();
            new HomeFrame(currentUser);
        } else if (e.getActionCommand().startsWith("finaledit_")) {
            String name = nameField.getText();
            String category = (String) categoryComboBox.getSelectedItem();
            String description = descriptionArea.getText();
            LocalDate dueDate = LocalDate.of(2023, 12,15); // hard coded so we need to change this.



            Goal editedGoal = new Goal(name, category, description, dueDate);

            currentUser.goals.add(Integer.parseInt(e.getActionCommand().substring(10)),editedGoal); // maybe pass in anonymous declaration?
            dispose();
            new ViewGoalsFrame(currentUser);
        }
    }
}