
package com.goaltracker.forms;

import com.goaltracker.AccrueGoal;
import com.goaltracker.AtomicGoal;
import com.goaltracker.CountGoal;
import com.goaltracker.Goal;
import com.goaltracker.GoalTracker;
import com.goaltracker.MultiAtomicGoal;
import com.goaltracker.PriorityLevel;
import java.util.ArrayList;

public class PagePriorityGoals extends javax.swing.JPanel {

    public PagePriorityGoals() {
        initComponents();
        ribbon.setVisible(false);
        ArrayList<Goal> goals = GoalTracker.getGoals();
        int numDisplayed = 0;
        if (goals != null) {
            int count = goals.size();
            if (count > 0) {
                for (int i = count - 1; i >= 0; i--) {
                    Goal g = goals.get(i);
                    if (!(g.getIsSubGoal() == true) && !(g.getIsAbandoned()) && !(g.getIsAccomplished()) && (g.getPriority() == PriorityLevel.HIGH)) {
                        if (g instanceof AccrueGoal || g instanceof CountGoal) {
                            summaryPanel.add(new CardAccrueOrCountGoal(g, false, false, true, false));
                        } else if (g instanceof AtomicGoal) {
                            summaryPanel.add(new CardAtomicGoal(g, false, false, true, false));
                        } else if (g instanceof MultiAtomicGoal) {
                            summaryPanel.add(new CardMultiAtomicGoal(g, false, false, true, false));
                        }
                        numDisplayed++;
                    }
                }
            }
        } else {
        }
        if (numDisplayed > 0) {
            header.setVisible(true);
        } else {
            header.setVisible(false);
        }
        updateSummaries();
    }

    public void updateSummaries() {
        int openGoalsCount = GoalTracker.getOpenGoalsCount();
        openGoalsValue.setText(Integer.toString(openGoalsCount));
        int completedGoalsCount = GoalTracker.getCompletedGoalsCount();
        completedGoalsValue.setText(Integer.toString(completedGoalsCount));
        int priorityGoalsCount = GoalTracker.getPriorityGoalsCount();
        priorityGoalsValue.setText(Integer.toString(priorityGoalsCount));
        repaint();
        validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JPanel();
        newGoalLabel = new javax.swing.JLabel();
        ribbon = new javax.swing.JLayeredPane();
        openGoalsBox = new javax.swing.JPanel();
        openGoalsLabel = new javax.swing.JLabel();
        openGoalsValue = new javax.swing.JLabel();
        priorityGoalsBox = new javax.swing.JPanel();
        priorityGoalsLabel = new javax.swing.JLabel();
        priorityGoalsValue = new javax.swing.JLabel();
        completedGoalsBox = new javax.swing.JPanel();
        completedGoalsLabel = new javax.swing.JLabel();
        completedGoalsValue = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        summaryPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(229, 244, 252));
        setMinimumSize(new java.awt.Dimension(657, 0));

        jPanel2.setOpaque(false);

        title.setOpaque(false);

        newGoalLabel.setFont(new java.awt.Font("Avenir Next", 0, 24)); // NOI18N
        newGoalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newGoalLabel.setText("Priority Goals");
        newGoalLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newGoalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newGoalLabel)
        );

        ribbon.setBackground(new java.awt.Color(255, 255, 51));

        openGoalsBox.setBackground(new java.awt.Color(137, 231, 255));
        openGoalsBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        openGoalsLabel.setBackground(new java.awt.Color(51, 51, 255));
        openGoalsLabel.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        openGoalsLabel.setForeground(new java.awt.Color(255, 255, 255));
        openGoalsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        openGoalsLabel.setText("Open Goals Count");
        openGoalsLabel.setOpaque(true);

        openGoalsValue.setFont(new java.awt.Font("Avenir Next", 1, 24)); // NOI18N
        openGoalsValue.setForeground(new java.awt.Color(0, 0, 255));
        openGoalsValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout openGoalsBoxLayout = new javax.swing.GroupLayout(openGoalsBox);
        openGoalsBox.setLayout(openGoalsBoxLayout);
        openGoalsBoxLayout.setHorizontalGroup(
            openGoalsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(openGoalsValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(openGoalsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        openGoalsBoxLayout.setVerticalGroup(
            openGoalsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openGoalsBoxLayout.createSequentialGroup()
                .addComponent(openGoalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(openGoalsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        priorityGoalsBox.setBackground(new java.awt.Color(255, 204, 204));
        priorityGoalsBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        priorityGoalsLabel.setBackground(new java.awt.Color(255, 51, 51));
        priorityGoalsLabel.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        priorityGoalsLabel.setForeground(new java.awt.Color(255, 255, 255));
        priorityGoalsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priorityGoalsLabel.setText("Priority Goals Count");
        priorityGoalsLabel.setOpaque(true);

        priorityGoalsValue.setFont(new java.awt.Font("Avenir Next", 1, 24)); // NOI18N
        priorityGoalsValue.setForeground(new java.awt.Color(255, 0, 0));
        priorityGoalsValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout priorityGoalsBoxLayout = new javax.swing.GroupLayout(priorityGoalsBox);
        priorityGoalsBox.setLayout(priorityGoalsBoxLayout);
        priorityGoalsBoxLayout.setHorizontalGroup(
            priorityGoalsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(priorityGoalsValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(priorityGoalsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        priorityGoalsBoxLayout.setVerticalGroup(
            priorityGoalsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(priorityGoalsBoxLayout.createSequentialGroup()
                .addComponent(priorityGoalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(priorityGoalsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        completedGoalsBox.setBackground(new java.awt.Color(130, 255, 132));
        completedGoalsBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        completedGoalsLabel.setBackground(new java.awt.Color(0, 153, 153));
        completedGoalsLabel.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        completedGoalsLabel.setForeground(new java.awt.Color(255, 255, 255));
        completedGoalsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completedGoalsLabel.setText("Completed Goals Count");
        completedGoalsLabel.setOpaque(true);

        completedGoalsValue.setFont(new java.awt.Font("Avenir Next", 1, 24)); // NOI18N
        completedGoalsValue.setForeground(new java.awt.Color(0, 153, 102));
        completedGoalsValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout completedGoalsBoxLayout = new javax.swing.GroupLayout(completedGoalsBox);
        completedGoalsBox.setLayout(completedGoalsBoxLayout);
        completedGoalsBoxLayout.setHorizontalGroup(
            completedGoalsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(completedGoalsValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(completedGoalsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        completedGoalsBoxLayout.setVerticalGroup(
            completedGoalsBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completedGoalsBoxLayout.createSequentialGroup()
                .addComponent(completedGoalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(completedGoalsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        ribbon.setLayer(openGoalsBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ribbon.setLayer(priorityGoalsBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ribbon.setLayer(completedGoalsBox, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout ribbonLayout = new javax.swing.GroupLayout(ribbon);
        ribbon.setLayout(ribbonLayout);
        ribbonLayout.setHorizontalGroup(
            ribbonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ribbonLayout.createSequentialGroup()
                .addComponent(openGoalsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(priorityGoalsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(completedGoalsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        ribbonLayout.setVerticalGroup(
            ribbonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(priorityGoalsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(openGoalsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(completedGoalsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        header.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        jLabel1.setText("High Priority Goals");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1))
        );

        summaryPanel.setBackground(new java.awt.Color(0, 204, 204));
        summaryPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        summaryPanel.setMinimumSize(new java.awt.Dimension(0, 2000));
        summaryPanel.setOpaque(false);
        summaryPanel.setLayout(new javax.swing.BoxLayout(summaryPanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 255, 102));
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ribbon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ribbon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(summaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 872, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel completedGoalsBox;
    private javax.swing.JLabel completedGoalsLabel;
    private javax.swing.JLabel completedGoalsValue;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel newGoalLabel;
    private javax.swing.JPanel openGoalsBox;
    private javax.swing.JLabel openGoalsLabel;
    private javax.swing.JLabel openGoalsValue;
    private javax.swing.JPanel priorityGoalsBox;
    private javax.swing.JLabel priorityGoalsLabel;
    private javax.swing.JLabel priorityGoalsValue;
    private javax.swing.JLayeredPane ribbon;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JPanel title;
    // End of variables declaration//GEN-END:variables
}
