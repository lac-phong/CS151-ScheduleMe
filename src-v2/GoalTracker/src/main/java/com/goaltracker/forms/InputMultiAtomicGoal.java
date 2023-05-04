
package com.goaltracker.forms;

public class InputMultiAtomicGoal extends javax.swing.JPanel {

    public InputMultiAtomicGoal() {
        initComponents();
    }

    public String getTargetDate() {
        return targetDateTextField.getText();
    }
    
    public String getCountdown() {
        return countdownComboBox.getSelectedItem().toString();
    }
    
    public String getNotes() {
        return notesTextArea.getText();
    }

    public String getTasks() {
        return tasksTextArea.getText();
    }
    
    public String getTaskDescriptor() {
        return taskDescriptorTextField.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        targetDateLabel = new javax.swing.JLabel();
        targetDateTextField = new javax.swing.JTextField();
        taskDescriptorLabel = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();
        tasksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        taskDescriptorTextField = new javax.swing.JTextField();
        hint = new javax.swing.JLabel();
        countdownLabel = new javax.swing.JLabel();
        countdownComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(615, 436));
        setOpaque(false);

        targetDateLabel.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        targetDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        targetDateLabel.setText("Target Deadline:");

        taskDescriptorLabel.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        taskDescriptorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        taskDescriptorLabel.setText("Task Descriptor:");

        notesLabel.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        notesLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        notesLabel.setText("Notes:");

        tasksLabel.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        tasksLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tasksLabel.setText("Tasks::");

        tasksTextArea.setColumns(20);
        tasksTextArea.setRows(5);
        jScrollPane1.setViewportView(tasksTextArea);

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        jScrollPane2.setViewportView(notesTextArea);

        hint.setFont(new java.awt.Font("Avenir Next", 2, 13)); // NOI18N
        hint.setForeground(new java.awt.Color(153, 153, 153));
        hint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        hint.setText("(one per line)");

        countdownLabel.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        countdownLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        countdownLabel.setText("Countdown?");

        countdownComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        jLabel1.setFont(new java.awt.Font("Avenir Next", 2, 13)); // NOI18N
        jLabel1.setText("(e.g., \"Chapter\" or \"Problem #\")");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tasksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(notesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(targetDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addComponent(taskDescriptorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(countdownLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(targetDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(taskDescriptorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addComponent(countdownComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetDateLabel)
                    .addComponent(targetDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskDescriptorLabel)
                    .addComponent(taskDescriptorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countdownComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countdownLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tasksLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hint))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notesLabel))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> countdownComboBox;
    private javax.swing.JLabel countdownLabel;
    private javax.swing.JLabel hint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JLabel targetDateLabel;
    private javax.swing.JTextField targetDateTextField;
    private javax.swing.JLabel taskDescriptorLabel;
    private javax.swing.JTextField taskDescriptorTextField;
    private javax.swing.JLabel tasksLabel;
    private javax.swing.JTextArea tasksTextArea;
    // End of variables declaration//GEN-END:variables
}
