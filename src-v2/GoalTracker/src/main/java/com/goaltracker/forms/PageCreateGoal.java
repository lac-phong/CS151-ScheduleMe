
package com.goaltracker.forms;

import com.goaltracker.AccrueGoal;
import com.goaltracker.AtomicGoal;
import com.goaltracker.CountGoal;
import com.goaltracker.GoalTracker;
import com.goaltracker.MultiAtomicGoal;
import com.goaltracker.PriorityLevel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class PageCreateGoal extends javax.swing.JPanel {
    private HashMap<String,Integer> forms;
    
    private InputAtomicGoal atomicGoalForm;
    private InputAccrueGoal accrueGoalForm;
    private InputCountGoal  countGoalForm;
    private InputMultiAtomicGoal multiAtomicGoalForm;
    
    public PageCreateGoal() {
        forms = new HashMap<>();
        forms.put("empty",0);
        forms.put("Atomic",1);
        forms.put("Accrue", 2);
        forms.put("Count", 3);
        forms.put("Multi-Atomic", 4);
        
        initComponents();
        atomicGoalForm = new InputAtomicGoal();
        accrueGoalForm = new InputAccrueGoal();
        countGoalForm = new InputCountGoal();
        multiAtomicGoalForm = new InputMultiAtomicGoal();
        
        specificsTabs.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabAreaHeight(int tab_placement, int run_count, int max_tab_height) {
                return 0;
            }
            @Override
            protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {}
            private final Insets borderInsets = new Insets(0, 0, 0, 0);
            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
            }
            @Override
            protected Insets getContentBorderInsets(int tabPlacement) {
                return borderInsets;
            }
        });
        specificsTabs.setSelectedIndex(0);
        specificsTabs.validate();
        specificsTabs.repaint();
        createGoalButton.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newGoalLabel = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        goalNameLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        priorityLabel = new javax.swing.JLabel();
        priorityComboBox = new javax.swing.JComboBox<>();
        goalTypeLabel = new javax.swing.JLabel();
        goalTypeComboBox = new javax.swing.JComboBox<>();
        typeHelp = new javax.swing.JTextField();
        middlePanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        createGoalButton = new javax.swing.JButton();
        specificsTabs = new javax.swing.JTabbedPane();
        empty = new com.goaltracker.forms.EmptyForm();
        jLabel1 = new javax.swing.JLabel();
        atomicGoal = new com.goaltracker.forms.InputAtomicGoal();
        accrueGoal = new com.goaltracker.forms.InputAccrueGoal();
        countGoal = new com.goaltracker.forms.InputCountGoal();
        multiAtomicGoal = new com.goaltracker.forms.InputMultiAtomicGoal();

        setBackground(new java.awt.Color(229, 244, 252));

        newGoalLabel.setFont(new java.awt.Font("Avenir Next", 0, 24)); // NOI18N
        newGoalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newGoalLabel.setText("Create a New Goal");
        newGoalLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        topPanel.setBackground(new java.awt.Color(158, 255, 244));
        topPanel.setOpaque(false);

        goalNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        goalNameLabel.setText("Description:");

        descriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTextFieldActionPerformed(evt);
            }
        });

        priorityLabel.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        priorityLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priorityLabel.setText("Priority:");

        priorityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High", "Medium", "Low" }));
        priorityComboBox.setSelectedIndex(-1);

        goalTypeLabel.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        goalTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        goalTypeLabel.setText("Goal Type:");

        goalTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atomic", "Accrue", "Count", "Multi-Atomic" }));
        goalTypeComboBox.setSelectedIndex(-1);
        goalTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                goalTypeComboBoxItemStateChanged(evt);
            }
        });
        goalTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goalTypeComboBoxActionPerformed(evt);
            }
        });

        typeHelp.setBackground(new java.awt.Color(229, 244, 252));
        typeHelp.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        typeHelp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        typeHelp.setBorder(null);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(goalTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priorityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goalNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(goalTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 145, Short.MAX_VALUE)
                            .addComponent(priorityComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(typeHelp)
                        .addContainerGap())))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goalNameLabel)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityLabel)
                    .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goalTypeLabel)
                    .addComponent(goalTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        middlePanel.setBackground(new java.awt.Color(255, 204, 153));
        middlePanel.setOpaque(false);

        javax.swing.GroupLayout middlePanelLayout = new javax.swing.GroupLayout(middlePanel);
        middlePanel.setLayout(middlePanelLayout);
        middlePanelLayout.setHorizontalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        middlePanelLayout.setVerticalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        bottomPanel.setOpaque(false);

        createGoalButton.setText("Create Goal");
        createGoalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createGoalButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(createGoalButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(createGoalButton)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        specificsTabs.setBackground(new java.awt.Color(204, 255, 204));
        specificsTabs.setMinimumSize(new java.awt.Dimension(0, 0));

        empty.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Avenir Next", 2, 14)); // NOI18N
        jLabel1.setText("Please select a goal type...");

        javax.swing.GroupLayout emptyLayout = new javax.swing.GroupLayout(empty);
        empty.setLayout(emptyLayout);
        emptyLayout.setHorizontalGroup(
            emptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        emptyLayout.setVerticalGroup(
            emptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        specificsTabs.addTab("Empty", empty);
        specificsTabs.addTab("Atomic", atomicGoal);
        specificsTabs.addTab("Accrue", accrueGoal);
        specificsTabs.addTab("Count", countGoal);
        specificsTabs.addTab("Multi-Atomic", multiAtomicGoal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(middlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(specificsTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(newGoalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(newGoalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specificsTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void descriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextFieldActionPerformed
        
    }//GEN-LAST:event_descriptionTextFieldActionPerformed

    private void goalTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goalTypeComboBoxActionPerformed
        
    }//GEN-LAST:event_goalTypeComboBoxActionPerformed

    private void goalTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_goalTypeComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selected = (String)evt.getItem();
            if (selected.equals("Atomic")) {
                middlePanel.setMinimumSize(new Dimension(0,0));
                specificsTabs.setSelectedIndex(forms.get("Atomic"));
                typeHelp.setText("Either done or not done.");
                createGoalButton.setVisible(true);
            } else if (selected.equals("Accrue")) {
                middlePanel.setMinimumSize(new Dimension(0,0));
                specificsTabs.setSelectedIndex(forms.get("Accrue"));
                typeHelp.setText("Sum up amounts towards a target amount.");
                createGoalButton.setVisible(true);
            } else if (selected.equals("Count")) {
                middlePanel.setMinimumSize(new Dimension(0,0));
                typeHelp.setText("Sum up discrete counts towards a target count.");
                specificsTabs.setSelectedIndex(forms.get("Count"));
                createGoalButton.setVisible(true);
            } else if (selected.equals("Multi-Atomic")) {
                specificsTabs.setSelectedIndex(forms.get("Multi-Atomic"));
                typeHelp.setText("Multiple done/not-done tasks.");
                middlePanel.setMinimumSize(new Dimension(0,536));
                createGoalButton.setVisible(true);
            }
        }
    }//GEN-LAST:event_goalTypeComboBoxItemStateChanged

    private void createGoalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createGoalButtonMouseClicked
        String description = descriptionTextField.getText();
        if (description.contains("")) {
            description = "Some Unspecified Goal";
        }
        Object sel = priorityComboBox.getSelectedItem();
        String priority;
        if (sel != null) {
            priority = priorityComboBox.getSelectedItem().toString();
        } else {
            priority = "Low";
        }
        PriorityLevel priorityLevel;
        if (priority.equals("High")) {
            priorityLevel = PriorityLevel.HIGH;
        } else if (priority.equals("Medium")) {
            priorityLevel = PriorityLevel.MEDIUM;
        } else if (priority.equals("Low")) {
            priorityLevel = PriorityLevel.LOW;
        } else {
            priorityLevel = PriorityLevel.LOW;
        }
        sel = goalTypeComboBox.getSelectedItem();
        String goalType;
        if (sel != null) {
            goalType = sel.toString();
        } else {
            goalType = "Atomic";
        }
        if (goalType.equals("Atomic")) {
            InputAtomicGoal ag = (InputAtomicGoal)(specificsTabs.getComponent(forms.get("Atomic")));
            String targetDate = ag.getTargetDate();
            Date tDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            try {
                tDate = sdf.parse(targetDate);
            } catch(ParseException e) {}
            String countdown = ag.getCountdown();
            Boolean bCountdown;
            if (countdown.equals("Yes")) {
                bCountdown = true;
            } else if (countdown.equals("No")) {
                bCountdown = false;
            } else {
                bCountdown = false;
            }
            String notes = ag.getNotes();
            AtomicGoal newRec = new AtomicGoal(description, priorityLevel, tDate, bCountdown, notes);
            GoalTracker.addGoal(newRec);
            GoalTracker.showDashboard();
        } else if (goalType.equals("Accrue")) {
            InputAccrueGoal acf = (InputAccrueGoal)(specificsTabs.getComponent(forms.get("Accrue")));
            String targetDate = acf.getTargetDate();
            Date tDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            try {
                tDate = sdf.parse(targetDate);
            } catch(ParseException e) {}
            String currentAmount = acf.getCurrentAmount();
            String targetAmount = acf.getTargetAmount();
            
            Double tCurrent = 0.0;
            Double tTarget = 100.0;
            try {
                tCurrent = Double.valueOf(currentAmount);
            } catch(NumberFormatException e) {}
            try {
                tTarget = Double.valueOf(targetAmount);
            } catch(NumberFormatException e) {}
            String notes = acf.getNotes();
            AccrueGoal newRec = new AccrueGoal(description, priorityLevel, tDate, tCurrent, tTarget, notes);
            GoalTracker.addGoal(newRec);
            GoalTracker.showDashboard();
        } else if (goalType.equals("Count")) {
            InputCountGoal acf = (InputCountGoal)(specificsTabs.getComponent(forms.get("Count")));
            String targetDate = acf.getTargetDate();
            Date tDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            try {
                tDate = sdf.parse(targetDate);
            } catch(ParseException e) {}
            String currentCount = acf.getCurrentCount();
            String targetCount = acf.getTargetCount();
            
            Integer tCurrent = 0;
            Integer tTarget = 100;
            try {
                tCurrent = Integer.valueOf(currentCount);
            } catch(NumberFormatException e) {}
            try {
                tTarget = Integer.valueOf(targetCount);
            } catch(NumberFormatException e) {}
            String notes = acf.getNotes();
            CountGoal newRec = new CountGoal(description, priorityLevel, tDate, tCurrent, tTarget, notes);
            GoalTracker.addGoal(newRec);
            GoalTracker.showDashboard();
        } else if (goalType.equals("Multi-Atomic")) {
            InputMultiAtomicGoal acf = (InputMultiAtomicGoal)(specificsTabs.getComponent(forms.get("Multi-Atomic")));
            String targetDate = acf.getTargetDate();
            Date tDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            try {
                tDate = sdf.parse(targetDate);
            } catch(ParseException e) {}
            String notes = acf.getNotes();
            String tasks = acf.getTasks();
            String taskDescriptor = acf.getTaskDescriptor();
            Boolean bCountdown;
            String countdown = acf.getCountdown();
            if (countdown.equals("Yes")) {
                bCountdown = true;
            } else if (countdown.equals("No")) {
                bCountdown = false;
            } else {
                bCountdown = false;
            }
            MultiAtomicGoal newRec = new MultiAtomicGoal(description, priorityLevel, tDate, bCountdown, taskDescriptor, tasks, notes);
    
            GoalTracker.addGoal(newRec);
            GoalTracker.showDashboard();
        }  
    }//GEN-LAST:event_createGoalButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.goaltracker.forms.InputAccrueGoal accrueGoal;
    private com.goaltracker.forms.InputAtomicGoal atomicGoal;
    private javax.swing.JPanel bottomPanel;
    private com.goaltracker.forms.InputCountGoal countGoal;
    private javax.swing.JButton createGoalButton;
    private javax.swing.JTextField descriptionTextField;
    private com.goaltracker.forms.EmptyForm empty;
    private javax.swing.JLabel goalNameLabel;
    private javax.swing.JComboBox<String> goalTypeComboBox;
    private javax.swing.JLabel goalTypeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel middlePanel;
    private com.goaltracker.forms.InputMultiAtomicGoal multiAtomicGoal;
    private javax.swing.JLabel newGoalLabel;
    private javax.swing.JComboBox<String> priorityComboBox;
    private javax.swing.JLabel priorityLabel;
    private javax.swing.JTabbedPane specificsTabs;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField typeHelp;
    // End of variables declaration//GEN-END:variables
}
