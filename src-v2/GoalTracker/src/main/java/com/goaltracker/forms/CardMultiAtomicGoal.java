
package com.goaltracker.forms;

import com.goaltracker.Goal;
import com.goaltracker.GoalTracker;
import com.goaltracker.MultiAtomicGoal;
import com.goaltracker.PriorityLevel;
import static com.goaltracker.PriorityLevel.HIGH;
import static com.goaltracker.PriorityLevel.LOW;
import static com.goaltracker.PriorityLevel.MEDIUM;
import java.awt.Color;
import java.awt.Font;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class CardMultiAtomicGoal extends javax.swing.JPanel {
    Goal theGoal;
    Boolean doCurrent;
    Boolean doCompleted;
    Boolean doPriority;
    Boolean doAbandoned;
    
    public CardMultiAtomicGoal(Goal aGoal, Boolean aDoCurrent, Boolean aDoCompleted, Boolean aDoPriority, Boolean aDoAbandoned) {
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

        DefaultTableModel table = (DefaultTableModel)(taskTable.getModel());
        taskTable.getTableHeader().setFont(new Font("Avenir Next", Font.BOLD, 13));
        table.setRowCount(0);
        ArrayList<Goal> subgoals = ((MultiAtomicGoal)theGoal).subgoals;
        int total = 0;
        int completed = 0;
        if (subgoals != null) {
            for (Goal g: subgoals) {
                String description = g.getDescription();
                String notes = g.getNotes();
                String status = g.getIsAccomplished()?"DONE":"NOT DONE";
                if (status.equals("DONE")) {
                    completed++;
                }
                total++;
                String controls = "";
                table.insertRow(table.getRowCount(),new Object[]{status, description, notes, controls});
            }
            double pct = (float)completed/(float)total*100.0;
            completeCount.setText(String.format("%.2f%% (%d of %d tasks)", pct, completed, total));
        } else {
            completeCount.setText("No tasks found.");
        }
        taskTable.repaint();
        taskTable.validate();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        completeCount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();

        setOpaque(false);

        containerPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 5, true));

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
                        .addComponent(notes))
                    .addComponent(descriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abandonButton)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel1)
                    .addComponent(notes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Percentage Done:");

        completeCount.setFont(new java.awt.Font("Avenir Next", 1, 13)); // NOI18N
        completeCount.setForeground(new java.awt.Color(51, 102, 255));
        completeCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        completeCount.setText("123");

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Status", "Task", "Notes", "Actions"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taskTable.setShowGrid(true);
        jScrollPane1.setViewportView(taskTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(completeCount, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(completeCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel completeCount;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JLabel descriptionField;
    private javax.swing.JLabel descriptionLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea notes;
    private javax.swing.JTable taskTable;
    // End of variables declaration//GEN-END:variables
}
