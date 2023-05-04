
package com.goaltracker.forms;

import com.goaltracker.AccrueGoal;
import com.goaltracker.AtomicGoal;
import com.goaltracker.CountGoal;
import com.goaltracker.Goal;
import com.goaltracker.GoalTracker;
import com.goaltracker.MultiAtomicGoal;
import java.util.ArrayList;

public class PageCurrentGoals extends javax.swing.JPanel {

    public PageCurrentGoals() {
        initComponents();
        ArrayList<Goal> goals = GoalTracker.getGoals();
        int numDisplayed = 0;
        if (goals != null) {
            int count = goals.size();
            if (count > 0) {
                for (int i = count - 1; i >= 0; i--) {
                    Goal g = goals.get(i);
                    if (g.getIsSubGoal() == false && !(g.getIsAbandoned()) && !(g.getIsAccomplished())) {
                        if (g instanceof AccrueGoal || g instanceof CountGoal) {
                            summaryPanel.add(new CardAccrueOrCountGoal(g, true, false, false, false));
                        } else if (g instanceof AtomicGoal) {
                            summaryPanel.add(new CardAtomicGoal(g, true, false, false, false));
                        } else if (g instanceof MultiAtomicGoal) {
                            summaryPanel.add(new CardMultiAtomicGoal(g, true, false, false, false));
                        }
                        numDisplayed++;
                    }
                }
            }
        } else {
        }
        updateSummaries();
    }

    public void updateSummaries() {
        repaint();
        validate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JPanel();
        newGoalLabel = new javax.swing.JLabel();
        summaryPanel = new javax.swing.JPanel();
        emptyForm1 = new com.goaltracker.forms.EmptyForm();

        setBackground(new java.awt.Color(229, 244, 252));
        setMinimumSize(new java.awt.Dimension(657, 0));

        jPanel2.setOpaque(false);

        title.setOpaque(false);

        newGoalLabel.setFont(new java.awt.Font("Avenir Next", 0, 24)); // NOI18N
        newGoalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newGoalLabel.setText("Current Goals");
        newGoalLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        summaryPanel.setBackground(new java.awt.Color(0, 204, 204));
        summaryPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        summaryPanel.setMinimumSize(new java.awt.Dimension(0, 800));
        summaryPanel.setOpaque(false);
        summaryPanel.setLayout(new javax.swing.BoxLayout(summaryPanel, javax.swing.BoxLayout.Y_AXIS));

        emptyForm1.setMaximumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout emptyForm1Layout = new javax.swing.GroupLayout(emptyForm1);
        emptyForm1.setLayout(emptyForm1Layout);
        emptyForm1Layout.setHorizontalGroup(
            emptyForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        emptyForm1Layout.setVerticalGroup(
            emptyForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        summaryPanel.add(emptyForm1);

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newGoalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addComponent(newGoalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(summaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(143, 143, 143))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1283, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.goaltracker.forms.EmptyForm emptyForm1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel newGoalLabel;
    private javax.swing.JPanel summaryPanel;
    private javax.swing.JPanel title;
    // End of variables declaration//GEN-END:variables
}
