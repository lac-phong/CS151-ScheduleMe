
package com.goaltracker.forms;

import com.goaltracker.AccrueGoal;
import com.goaltracker.CountGoal;
import com.goaltracker.Goal;
import com.goaltracker.GoalTracker;
import com.goaltracker.PriorityLevel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class CardAccrueOrCountGoal extends javax.swing.JPanel {
    Goal theGoal;
    Boolean doCurrent;
    Boolean doCompleted;
    Boolean doPriority;
    Boolean doAbandoned;
    int startCount;
    int currentCount;
    int targetCount;
    int pct;
    double startAmount;
    double currentAmount;
    double targetAmount;
    
    public CardAccrueOrCountGoal(Goal aGoal, Boolean aDoCurrent, Boolean aDoCompleted, Boolean aDoPriority, Boolean aDoAbandoned) {
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
        if (aGoal instanceof CountGoal) {
            CountGoal g = (CountGoal)aGoal;
            descriptionField.setText(g.getDescription());
            startCount = g.getStartCount();
            currentCount = g.getCurrentCount();
            targetCount = g.getTargetCount();
            startValue.setText(Integer.toString(startCount));
            targetValue.setText(Integer.toString(targetCount));
            progressBar.setMinimum(startCount);
            progressBar.setMaximum(targetCount);
            updateCountFields();
        } else if (aGoal instanceof AccrueGoal) {
            AccrueGoal g = (AccrueGoal)aGoal;
            descriptionField.setText(g.getDescription());
            startAmount = g.getStartAmount();
            currentAmount = g.getCurrentAmount();
            targetAmount = g.getTargetAmount();
            double stAmt = startAmount;
            double tgtAmt = targetAmount;
            startValue.setText(String.format("%.2f", stAmt));
            targetValue.setText(String.format("%.2f", tgtAmt));
            progressBar.setMinimum(0);
            progressBar.setMaximum(100);
            updateAccrueFields();
        }
    }

    private void updateCountFields() {
        CountGoal g = (CountGoal)theGoal;
        if (g.getIsAccomplished()) {
            this.setVisible(false);
            GoalTracker.updateDashboard();
        }
        pct = (int)(((float)currentCount - (float)startCount) / ((float)targetCount - (float)startCount) * 100);
        currentValueField.setText(Integer.toString(currentCount));
        progressBar.setValue(currentCount);
        progressValue.setText(String.format("%d%%",pct));
        repaint();
        validate();
    }

    private void updateAccrueFields() {
        AccrueGoal g = (AccrueGoal)theGoal;
        if (g.getIsAccomplished()) {
            this.setVisible(false);
            GoalTracker.updateDashboard();
        }
        pct = (int)((currentAmount - startAmount) / (targetAmount - startAmount) * 100);
        double cur = currentAmount;
        currentValueField.setText(String.format("%.2f", cur));
        progressBar.setValue(pct);
        progressValue.setText(String.format("%d%%",pct));
        repaint();
        validate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        descriptionField = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        progressLabel = new javax.swing.JLabel();
        progressValue = new javax.swing.JLabel();
        startValue = new javax.swing.JLabel();
        targetValue = new javax.swing.JLabel();
        currentValueField = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        abandonButton = new javax.swing.JLabel();
        updateGoalBox = new javax.swing.JPanel();
        addToCountButton = new javax.swing.JButton();
        newAmount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setMinimumSize(new java.awt.Dimension(0, 150));
        setOpaque(false);

        containerPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 5, true));

        descriptionField.setFont(new java.awt.Font("Avenir Next", 1, 16)); // NOI18N
        descriptionField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        progressBar.setForeground(new java.awt.Color(0, 255, 102));

        progressLabel.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        progressLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        progressLabel.setText("Progress:");

        progressValue.setToolTipText("");

        startValue.setFont(new java.awt.Font("Avenir Next", 0, 10)); // NOI18N
        startValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        startValue.setText("0");

        targetValue.setFont(new java.awt.Font("Avenir Next", 0, 10)); // NOI18N
        targetValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        targetValue.setText("100");

        currentValueField.setFont(new java.awt.Font("Avenir Next", 1, 12)); // NOI18N
        currentValueField.setForeground(new java.awt.Color(51, 102, 255));
        currentValueField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        currentValueField.setText("100");

        jLabel3.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Current Count:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(progressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(startValue, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(targetValue, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressValue, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentValueField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(currentValueField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressValue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startValue)
                    .addComponent(targetValue)))
        );

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
                .addGap(18, 18, 18)
                .addComponent(descriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abandonButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        updateGoalBox.setBackground(new java.awt.Color(200, 248, 248));
        updateGoalBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateGoalBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addToCountButton.setText("Add");
        addToCountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addToCountButtonMouseClicked(evt);
            }
        });
        addToCountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCountButtonActionPerformed(evt);
            }
        });
        updateGoalBox.add(addToCountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        newAmount.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        newAmount.setToolTipText("");
        newAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAmountActionPerformed(evt);
            }
        });
        updateGoalBox.add(newAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 64, -1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 255));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(updateGoalBox, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(containerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(updateGoalBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addToCountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCountButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addToCountButtonActionPerformed

    private void newAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newAmountActionPerformed

    private void addToCountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCountButtonMouseClicked
        if (theGoal instanceof CountGoal) {
            CountGoal g = (CountGoal)theGoal;
            int v = Integer.parseInt(newAmount.getText());
            currentCount = g.addToCount(v);
            newAmount.setText("");
            updateCountFields();
        } else if (theGoal instanceof AccrueGoal) {
            AccrueGoal g = (AccrueGoal)theGoal;
            int v = Integer.parseInt(newAmount.getText());
            currentAmount = g.addToAmount(v);
            newAmount.setText("");
            updateAccrueFields();
        }
    }//GEN-LAST:event_addToCountButtonMouseClicked

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
    private javax.swing.JButton addToCountButton;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JLabel currentValueField;
    private javax.swing.JLabel descriptionField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField newAmount;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JLabel progressValue;
    private javax.swing.JLabel startValue;
    private javax.swing.JLabel targetValue;
    private javax.swing.JPanel updateGoalBox;
    // End of variables declaration//GEN-END:variables
}
