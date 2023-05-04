
package com.goaltracker.forms;

import com.goaltracker.AtomicGoal;
import com.goaltracker.Goal;
import com.goaltracker.GoalTracker;
import com.goaltracker.PriorityLevel;
import static com.goaltracker.PriorityLevel.HIGH;
import static com.goaltracker.PriorityLevel.LOW;
import static com.goaltracker.PriorityLevel.MEDIUM;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTextAreaUI;

public class CardAtomicGoal extends javax.swing.JPanel {
    Goal theGoal;
    Boolean doCompleted;
    Boolean doPriority;
    Boolean doCurrent;
    Boolean doAbandoned;
    
    public CardAtomicGoal(Goal aGoal, Boolean aDoCurrent, Boolean aDoCompleted, Boolean aDoPriority, Boolean aDoAbandoned) {
        initComponents();
        doCurrent = aDoCurrent;
        doCompleted = aDoCompleted;
        doPriority = aDoPriority;
        doAbandoned = aDoAbandoned;
        if (doAbandoned) {
            abandonButton.setForeground(Color.green);
            abandonButton.setText("♼");
        }
        theGoal = aGoal;
        if (aDoAbandoned) {
            abandonButton.setForeground(Color.green);
            abandonButton.setText("♼");
        }
        
        PriorityLevel priority = theGoal.getPriority();
        if (priority != null) {
            switch (priority) {
                case HIGH:
                    containerPanel.setBorder(new LineBorder(new Color(255,0,0), 4, true));
                    break;
                case MEDIUM:
                    containerPanel.setBorder(new LineBorder(new Color(128,255,128), 4, true));
                    break;
                case LOW:
                    containerPanel.setBorder(new LineBorder(new Color(128,128,128), 4, true));
                    break;
                default:
                    break;
            }
        }
        notes.setUI(new BasicTextAreaUI() {
            private final Insets borderInsets = new Insets(0, 0, 0, 0);
        });
        AtomicGoal g = (AtomicGoal)theGoal;
        descriptionField.setText(g.getDescription());
        notes.setText(g.getNotes());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        descriptionField = new javax.swing.JLabel();
        descriptionLabel1 = new javax.swing.JLabel();
        notes = new javax.swing.JTextArea();
        abandonButton = new javax.swing.JLabel();
        updateGoalBox = new javax.swing.JPanel();
        accomplishedButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(0, 150));
        setOpaque(false);

        containerPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 0), 5, true));

        descriptionField.setBackground(new java.awt.Color(51, 255, 51));
        descriptionField.setFont(new java.awt.Font("Avenir Next", 1, 16)); // NOI18N
        descriptionField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        descriptionLabel1.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        descriptionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descriptionLabel1.setText("Notes:");

        notes.setEditable(false);
        notes.setColumns(20);
        notes.setFont(new java.awt.Font("Avenir Next", 2, 13)); // NOI18N
        notes.setRows(5);
        notes.setWrapStyleWord(true);
        notes.setBorder(null);
        notes.setFocusable(false);
        notes.setOpaque(false);

        abandonButton.setForeground(new java.awt.Color(255, 0, 0));
        abandonButton.setText("ⓧ");
        abandonButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abandonButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abandonButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(descriptionLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notes, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                    .addComponent(descriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abandonButton)
                    .addComponent(descriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        updateGoalBox.setBackground(new java.awt.Color(205, 248, 200));
        updateGoalBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateGoalBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accomplishedButton.setText("Accomplished");
        accomplishedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accomplishedButtonMouseClicked(evt);
            }
        });
        updateGoalBox.add(accomplishedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, -1));

        jLabel2.setBackground(new java.awt.Color(18, 132, 0));
        jLabel2.setFont(new java.awt.Font("Avenir Next", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Update Goal");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel2.setOpaque(true);
        updateGoalBox.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(updateGoalBox, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateGoalBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void accomplishedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accomplishedButtonMouseClicked
        if (theGoal instanceof AtomicGoal) {
            AtomicGoal g = (AtomicGoal)theGoal;

            g.setIsAccomplished(true);
            this.setVisible(false);
            GoalTracker.save();
            GoalTracker.updateDashboard();
        }
    }//GEN-LAST:event_accomplishedButtonMouseClicked

    private void abandonButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abandonButtonMouseClicked
        if (doAbandoned) {
            theGoal.setIsAbandoned(false);
            this.setVisible(true);
        } else {
            theGoal.setIsAbandoned(true);
            this.setVisible(false);
        }
        GoalTracker.save();
        GoalTracker.showDashboard();
    }//GEN-LAST:event_abandonButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abandonButton;
    private javax.swing.JButton accomplishedButton;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JLabel descriptionField;
    private javax.swing.JLabel descriptionLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextArea notes;
    private javax.swing.JPanel updateGoalBox;
    // End of variables declaration//GEN-END:variables
}
