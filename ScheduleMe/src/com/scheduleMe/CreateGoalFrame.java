package com.scheduleMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateGoalFrame extends JFrame implements ActionListener {
    private JTextField nameField;
    private JComboBox<String> categoryComboBox;
    private JComboBox<String> timeComboBox;
    private JTextArea descriptionArea;
    private JSpinner dueDateSpinner;
    private User currentUser;
    private Map<String, List<Component>> categoryComponents = new HashMap<>();
    private String[] financialOptions = {"Save", "Pay Debt", "Budget", "Invest", "Other"};
    private String[] physicalOptions = {"Gym", "Lifting", "Sports", "Cardio", "Other"};
    private String[] relationshipOptions = {"Dating", "Socializing", "Friendship", "Other"};
    private String[] educationalOptions = {"Studying", "Learning", "School", "Reading", "Other"};
    private JComboBox<String> financialComboBox = new JComboBox<>(financialOptions);
    private JComboBox<String> physicalComboBox = new JComboBox<>(physicalOptions);
    private JComboBox<String> relationshipComboBox = new JComboBox<>(relationshipOptions);
    private JComboBox<String> educationalComboBox = new JComboBox<>(educationalOptions);
    private Map<String, List<Component>> timeComponents = new HashMap<>();
    private String[] timeFrames = {"Daily", "Weekly", "Monthly", "Yearly"};
    private JComboBox<String> timeFrameComboBox = new JComboBox<>(timeFrames);
    private JSpinner timeFreqSpinner;
            

    public CreateGoalFrame(User currentUser) {
        this.currentUser =currentUser;
        JLabel actionLabel = new JLabel("Type of Activity");
        actionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        financialComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        physicalComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        relationshipComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        educationalComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        
        categoryComponents.put("Financial", Arrays.asList(actionLabel, financialComboBox));
        categoryComponents.put("Physical", Arrays.asList(actionLabel, physicalComboBox));
        categoryComponents.put("Relationship", Arrays.asList(actionLabel, relationshipComboBox));
        categoryComponents.put("Educational", Arrays.asList(actionLabel, educationalComboBox));

        JLabel timeFrameLabel = new JLabel("Time Frame: ");
        timeFrameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel timeFreqLabel = new JLabel("Frequency: ");
        timeFreqLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        SpinnerModel timeFreqModel = new SpinnerNumberModel(1, 1, 100, 1);
        timeFreqSpinner = new JSpinner(timeFreqModel);
        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dueDateSpinner, "yyyy-MM-dd");
        dueDateSpinner.setEditor(dateEditor);
        dueDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timeComponents.put("Indefinite", Arrays.asList(timeFrameLabel, timeFrameComboBox, timeFreqLabel, timeFreqSpinner));
        timeComponents.put("Definite", Arrays.asList(dueDateLabel, dueDateSpinner));

        setTitle("Create New Goal");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {"Choose type", "General", "Financial", "Physical", "Relationship", "Educational"};
        categoryComboBox = new JComboBox<>(categories);
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea(5, 20);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        JLabel timeLabel = new JLabel("Time interval: ");
        String[] timeTypes = {"Choose type", "Indefinite", "Definite"};
        timeComboBox = new JComboBox<>(timeTypes);


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
        formPanel.add(timeLabel);
        formPanel.add(timeComboBox);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(backButton);
        buttonPanel.add(createButton);

        // Style components
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add components to content pane
        contentPane.add(formPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        timeComboBox.addActionListener(e -> {
            String selectedTime = (String) timeComboBox.getSelectedItem();
            if (selectedTime.equals("Indefinite")) {
                List<Component> components = timeComponents.get(selectedTime);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();
                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(dueDateLabel)){
                    formPanel.remove(dueDateLabel);
                    formPanel.remove(dueDateSpinner);
                    rows -= 1;
                    rows += components.size()/2;
                    formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
                } else if (formComponents.contains(timeFrameLabel)) {
                    formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
                } else {
                    rows += components.size()/2;
                    formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
                }

                for (Component component : components) {
                    formPanel.add(component);
                }
            } else if (selectedTime.equals("Definite")){
                List<Component> components = timeComponents.get(selectedTime);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();
                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(timeFrameLabel)){
                    formPanel.remove(timeFrameLabel);
                    formPanel.remove(timeFrameComboBox);
                    formPanel.remove(timeFreqLabel);
                    formPanel.remove(timeFreqSpinner);
                    rows -= 2;
                    rows += components.size()/2;
                } else if (!formComponents.contains(dueDateLabel)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
            }
            else {
                int rows = ((GridLayout)formPanel.getLayout()).getRows();
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
            }
            formPanel.revalidate();
            formPanel.repaint();
        });

        categoryComboBox.addActionListener(e -> {
            String selectedCategory = (String) categoryComboBox.getSelectedItem();
            if (selectedCategory.equals("Financial")){
                List<Component> components = categoryComponents.get(selectedCategory);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();

                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(relationshipComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(relationshipComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(physicalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(physicalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(educationalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(educationalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (!formComponents.contains(financialComboBox)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
            } else if (selectedCategory.equals("Physical")) {
                List<Component> components = categoryComponents.get(selectedCategory);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();

                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(financialComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(financialComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(relationshipComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(relationshipComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(educationalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(educationalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (!formComponents.contains(physicalComboBox)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
            } else if (selectedCategory.equals("Relationship")) {
                List<Component> components = categoryComponents.get(selectedCategory);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();

                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(financialComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(financialComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(physicalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(physicalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(educationalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(educationalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (!formComponents.contains(relationshipComboBox)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
            } else if (selectedCategory.equals("Educational")) {
                List<Component> components = categoryComponents.get(selectedCategory);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();

                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(financialComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(financialComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(physicalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(physicalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(relationshipComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(relationshipComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (!formComponents.contains(educationalComboBox)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
            }
            else {
                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                int rows = ((GridLayout)formPanel.getLayout()).getRows();
                if (formComponents.contains(financialComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(financialComboBox);
                    rows -= 1;
                } else if (formComponents.contains(physicalComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(physicalComboBox);
                    rows -= 1;
                } else if (formComponents.contains(educationalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(educationalComboBox);
                    rows -= 1;
                } else if (formComponents.contains(relationshipComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(relationshipComboBox);
                    rows -= 1;
                } 
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
            }
            formPanel.revalidate();
            formPanel.repaint();
        });

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public CreateGoalFrame(User currentUser, Goal goal, int index){
        this.currentUser =currentUser;
        JLabel actionLabel = new JLabel("Type of Activity");
        actionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        financialComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        physicalComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        relationshipComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        educationalComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        
        categoryComponents.put("Financial", Arrays.asList(actionLabel, financialComboBox));
        categoryComponents.put("Physical", Arrays.asList(actionLabel, physicalComboBox));
        categoryComponents.put("Relationship", Arrays.asList(actionLabel, relationshipComboBox));
        categoryComponents.put("Educational", Arrays.asList(actionLabel, educationalComboBox));

        JLabel timeFrameLabel = new JLabel("Time Frame: ");
        timeFrameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel timeFreqLabel = new JLabel("Frequency: ");
        timeFreqLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        SpinnerModel timeFreqModel = new SpinnerNumberModel(1, 1, 100, 1);
        timeFreqSpinner = new JSpinner(timeFreqModel);
        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dueDateSpinner, "yyyy-MM-dd");
        dueDateSpinner.setEditor(dateEditor);
        dueDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        timeComponents.put("Indefinite", Arrays.asList(timeFrameLabel, timeFrameComboBox, timeFreqLabel, timeFreqSpinner));
        timeComponents.put("Definite", Arrays.asList(dueDateLabel, dueDateSpinner));

        setTitle("Edit Goal");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        nameField.setText(goal.getName());
        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {"Choose type", "General", "Financial", "Physical", "Relationship", "Educational"};
        categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.setSelectedItem(goal.getType().getCategory());
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setText(goal.getDescription());
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        JLabel timeLabel = new JLabel("Time interval: ");
        String[] timeTypes = {"Choose type", "Indefinite", "Definite"};
        timeComboBox = new JComboBox<>(timeTypes);
        timeComboBox.setSelectedItem(goal.getInterval().getString());


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
        formPanel.add(timeLabel);
        formPanel.add(timeComboBox);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(backButton);
        buttonPanel.add(createButton);

        // Style components
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timeComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        categoryComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add components to content pane
        contentPane.add(formPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        timeComboBox.addActionListener(e -> {
            String selectedTime = (String) timeComboBox.getSelectedItem();
            if (selectedTime.equals("Indefinite")) {
                List<Component> components = timeComponents.get(selectedTime);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();
                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(dueDateLabel)){
                    formPanel.remove(dueDateLabel);
                    formPanel.remove(dueDateSpinner);
                    rows -= 1;
                    rows += components.size()/2;
                    formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
                } else if (formComponents.contains(timeFrameLabel)) {
                    formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
                } else {
                    rows += components.size()/2;
                    formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
                }

                for (Component component : components) {
                    formPanel.add(component);
                }
                timeFrameComboBox.setSelectedItem(((IndefiniteGoal) goal.getInterval()).getRecurrence());
                timeFreqSpinner.setValue(((IndefiniteGoal) goal.getInterval()).getFreq());
            } else if (selectedTime.equals("Definite")){
                List<Component> components = timeComponents.get(selectedTime);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();
                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(timeFrameLabel)){
                    formPanel.remove(timeFrameLabel);
                    formPanel.remove(timeFrameComboBox);
                    formPanel.remove(timeFreqLabel);
                    formPanel.remove(timeFreqSpinner);
                    rows -= 2;
                    rows += components.size()/2;
                } else if (!formComponents.contains(dueDateLabel)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
                dueDateSpinner.setValue(((DefiniteGoal) goal.getInterval()).getDueDate());
            }
            else {
                int rows = ((GridLayout)formPanel.getLayout()).getRows();
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
            }
            formPanel.revalidate();
            formPanel.repaint();
        });

        categoryComboBox.addActionListener(e -> {
            String selectedCategory = (String) categoryComboBox.getSelectedItem();
            if (selectedCategory.equals("Financial")){
                List<Component> components = categoryComponents.get(selectedCategory);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();

                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(relationshipComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(relationshipComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(physicalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(physicalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(educationalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(educationalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (!formComponents.contains(financialComboBox)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
                financialComboBox.setSelectedItem(((FinancialGoal) goal.getType()).getActivity());
            } else if (selectedCategory.equals("Physical")) {
                List<Component> components = categoryComponents.get(selectedCategory);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();

                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(financialComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(financialComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(relationshipComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(relationshipComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(educationalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(educationalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (!formComponents.contains(physicalComboBox)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
                physicalComboBox.setSelectedItem(((PhysicalGoal) goal.getType()).getActivity());
            } else if (selectedCategory.equals("Relationship")) {
                List<Component> components = categoryComponents.get(selectedCategory);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();

                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(financialComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(financialComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(physicalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(physicalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(educationalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(educationalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (!formComponents.contains(relationshipComboBox)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
                relationshipComboBox.setSelectedItem(((RelationshipGoal) goal.getType()).getActivity());
            } else if (selectedCategory.equals("Educational")) {
                List<Component> components = categoryComponents.get(selectedCategory);
                int rows = ((GridLayout)formPanel.getLayout()).getRows();

                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                if (formComponents.contains(financialComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(financialComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(physicalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(physicalComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (formComponents.contains(relationshipComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(relationshipComboBox);
                    rows -= 1;
                    rows += components.size()/2;
                } else if (!formComponents.contains(educationalComboBox)) {
                    rows += components.size()/2;
                }
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));

                for (Component component : components) {
                    formPanel.add(component);
                }
                educationalComboBox.setSelectedItem(((EducationalGoal) goal.getType()).getActivity());
            }
            else {
                List<Component> formComponents = Arrays.asList(formPanel.getComponents());
                int rows = ((GridLayout)formPanel.getLayout()).getRows();
                if (formComponents.contains(financialComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(financialComboBox);
                    rows -= 1;
                } else if (formComponents.contains(physicalComboBox)){
                    formPanel.remove(actionLabel);
                    formPanel.remove(physicalComboBox);
                    rows -= 1;
                } else if (formComponents.contains(educationalComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(educationalComboBox);
                    rows -= 1;
                } else if (formComponents.contains(relationshipComboBox)) {
                    formPanel.remove(actionLabel);
                    formPanel.remove(relationshipComboBox);
                    rows -= 1;
                } 
                formPanel.setLayout(new GridLayout(rows, 2, 10, 10));
            }
            formPanel.revalidate();
            formPanel.repaint();
        });

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
            String description = descriptionArea.getText();
            Goal newGoal = new Goal(name, description);
            String category = (String) categoryComboBox.getSelectedItem();
            if (category.equals("Financial")) {
                String activity = (String) financialComboBox.getSelectedItem();
                newGoal.setType(new FinancialGoal(activity));
            } else if (category.equals("Educational")) {
                String activity = (String) financialComboBox.getSelectedItem();
                newGoal.setType(new EducationalGoal(activity));
            } else if (category.equals("Relationship")) {
                String activity = (String) financialComboBox.getSelectedItem();
                newGoal.setType(new RelationshipGoal(activity));
            } else if (category.equals("Physical")) {
                String activity = (String) physicalComboBox.getSelectedItem();
                newGoal.setType(new PhysicalGoal(activity));
            } else if (category.equals("General")) {
                newGoal.setType(new GeneralGoal());
            }

            String interval = (String) timeComboBox.getSelectedItem();
            if (interval.equals("Indefinite")) {
                String timeFrame = (String) timeFrameComboBox.getSelectedItem();
                int freq = (int) timeFreqSpinner.getValue();
                newGoal.setInterval(new IndefiniteGoal(timeFrame, freq));
            } else if (interval.equals("Definite")) {
                Date date = (Date) dueDateSpinner.getValue();
                LocalDate dueDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                newGoal.setInterval(new DefiniteGoal(dueDate));
            } 

            JOptionPane.showMessageDialog(this, name + " created!");

            currentUser.goals.add(newGoal);
            dispose();
            new HomeFrame(currentUser);
        } else if (e.getActionCommand().startsWith("finaledit_")) {
            Goal goal = currentUser.goals.get(Integer.parseInt(e.getActionCommand().substring(10)));
            goal.setName(nameField.getText());
            goal.setDescription(descriptionArea.getText());
            String category = (String) categoryComboBox.getSelectedItem();
            if (category.equals("Financial")) {
                String activity = (String) financialComboBox.getSelectedItem();
                goal.setType(new FinancialGoal(activity));
            } else if (category.equals("Educational")) {
                String activity = (String) financialComboBox.getSelectedItem();
                goal.setType(new EducationalGoal(activity));
            } else if (category.equals("Relationship")) {
                String activity = (String) financialComboBox.getSelectedItem();
                goal.setType(new RelationshipGoal(activity));
            } else if (category.equals("Physical")) {
                String activity = (String) physicalComboBox.getSelectedItem();
                goal.setType(new PhysicalGoal(activity));
            } else if (category.equals("General")) {
                goal.setType(new GeneralGoal());
            }
            
            String interval = (String) timeComboBox.getSelectedItem();
            if (interval.equals("Indefinite")) {
                String timeFrame = (String) timeFrameComboBox.getSelectedItem();
                int freq = (int) timeFreqSpinner.getValue();
                goal.setInterval(new IndefiniteGoal(timeFrame, freq));
            } else if (interval.equals("Definite")) {
                Date date = (Date) dueDateSpinner.getValue();
                LocalDate dueDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                goal.setInterval(new DefiniteGoal(dueDate));
            }

            dispose();
            new ViewGoalsFrame(currentUser);
        }
    }
}