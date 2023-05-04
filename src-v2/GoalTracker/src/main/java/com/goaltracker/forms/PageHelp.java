
package com.goaltracker.forms;

public class PageHelp extends javax.swing.JPanel {

    public PageHelp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newGoalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(229, 244, 252));

        newGoalLabel.setBackground(new java.awt.Color(153, 255, 204));
        newGoalLabel.setFont(new java.awt.Font("Avenir Next", 0, 24)); // NOI18N
        newGoalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newGoalLabel.setText("Help");
        newGoalLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jScrollPane2.setOpaque(false);

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(246, 251, 253));
        jTextPane1.setContentType("text/html"); // NOI18N
        jTextPane1.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jTextPane1.setText("<html>\n  <head>\n  </head>\n  <body>\n    <div style=\"text-align: center\">\n      <div style=\"font-size: 1.1em;font-weight: bold;margin-bottom:20px\">Goal Tracker Help</div>\n    </div>\n      <div style=\"font-weight:bold;\">About Goal Types</div>\n      <div style=\"padding-bottom: 20px\"><strong>Atomic</strong> goals are goals that are either done or not done. For example, if you want to visit the Pacific Ocean some day, that would be an Atomic goal, since you've either done it or you haven't.</div>\n    <div style=\"padding-bottom: 20px\"><strong>Accrue</strong> goals are goals where you are aiming towards a numeric goal. For example, if your goal was to set aside $500.00 over the next year to pay for a new synthesizer, that would be an Accrue goal. Goal Tracker lets you add amounts towards your target at any time, and will automatically mark the goal as accomplished when the target is reached.\n    </div>\n    <div style=\"padding-bottom: 20px\"><strong>Count</strong> goals are goals that can be measured by an integer number. For example, if you want to work out three times in the next week, or you want to bike 50 miles, that would be a Count goal. Goal Tracker lets you add amounts towards your target at any time, and will automatically mark the goal as accomplished when the target is reached.\n    </div>\n    <div style=\"padding-bottom: 20px\"><strong>Multi-Atomic</strong> goals are goals that consist of many done/not-done tasks. For example, if you needed to complete 25 homework problems for your Physics class, you could create a Multi-Atomic goal, enter the problem numbers on separate lines, and Goal Tracker will treat these tasks as a group of sub-goals. Once you have completed all of the tasks within a Multi-Atomic goal, the goal will be marked as accomplished.\n    </div>\n  </body>\n</html>");
        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newGoalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(newGoalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel newGoalLabel;
    // End of variables declaration//GEN-END:variables
}
