
package com.goaltracker.forms;

import com.goaltracker.forms.*;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JViewport;

public class Main extends javax.swing.JFrame {
    PageDashboard dashboard;
    
    public Main() {
        dashboard = new PageDashboard();
        initComponents();
        setView(dashboard);
    }

    public void setView(JComponent view) {
        JViewport mainView = mainPanel.getViewport();
        mainView.add(view);
        mainView.repaint();
        mainView.validate();
    }
    
    public void showDashboard() {
        dashboard = new PageDashboard();
        setView(dashboard);
    }
    
    public void updateDashboard() {
        dashboard.updateSummaries();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JScrollPane();
        menuPanel = new javax.swing.JPanel();
        menuTitle = new javax.swing.JPanel();
        GoalTracker = new javax.swing.JLabel();
        dashboardMenuItem = new javax.swing.JLabel();
        aboutMenuItem = new javax.swing.JLabel();
        myGoalsMenuPanel = new javax.swing.JPanel();
        myGoalsLabel = new javax.swing.JLabel();
        currentGoalsMenuItem = new javax.swing.JLabel();
        priorityGoalsMenuItem = new javax.swing.JLabel();
        createNewGoalMenuItem = new javax.swing.JLabel();
        archivesMenuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        completedGoalsMenuItem = new javax.swing.JLabel();
        abandonedGoalsMenuItem = new javax.swing.JLabel();
        helpMenuItemLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1075, 580));

        appPanel.setBackground(new java.awt.Color(255, 255, 255));

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.setOpaque(false);

        mainPanel.setBackground(new java.awt.Color(158, 255, 244));
        mainPanel.setBorder(null);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        menuPanel.setBackground(new java.awt.Color(163, 218, 250));
        menuPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(51, 102, 255)), null));
        menuPanel.setMinimumSize(new java.awt.Dimension(200, 0));

        menuTitle.setOpaque(false);

        GoalTracker.setBackground(new java.awt.Color(50, 204, 255));
        GoalTracker.setFont(new java.awt.Font("Robofan Free", 0, 22)); // NOI18N
        GoalTracker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GoalTracker.setText("Goal Tracker");

        javax.swing.GroupLayout menuTitleLayout = new javax.swing.GroupLayout(menuTitle);
        menuTitle.setLayout(menuTitleLayout);
        menuTitleLayout.setHorizontalGroup(
            menuTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GoalTracker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuTitleLayout.setVerticalGroup(
            menuTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GoalTracker, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dashboardMenuItem.setBackground(new java.awt.Color(202, 247, 253));
        dashboardMenuItem.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        dashboardMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardMenuItem.setText("Dashboard");
        dashboardMenuItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        dashboardMenuItem.setOpaque(true);
        dashboardMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboardMenuItemMousePressed(evt);
            }
        });

        aboutMenuItem.setBackground(new java.awt.Color(202, 247, 253));
        aboutMenuItem.setFont(new java.awt.Font("Avenir Next", 2, 14)); // NOI18N
        aboutMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aboutMenuItem.setText("About Goal Tracker");
        aboutMenuItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        aboutMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutMenuItemMousePressed(evt);
            }
        });

        myGoalsMenuPanel.setBackground(new java.awt.Color(43, 181, 252));

        myGoalsLabel.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        myGoalsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myGoalsLabel.setText("My Goals");
        myGoalsLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        myGoalsLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        currentGoalsMenuItem.setBackground(new java.awt.Color(202, 247, 253));
        currentGoalsMenuItem.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        currentGoalsMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentGoalsMenuItem.setText("Current Goals");
        currentGoalsMenuItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        currentGoalsMenuItem.setOpaque(true);
        currentGoalsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currentGoalsMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentGoalsMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentGoalsMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                currentGoalsMenuItemMousePressed(evt);
            }
        });

        priorityGoalsMenuItem.setBackground(new java.awt.Color(202, 247, 253));
        priorityGoalsMenuItem.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        priorityGoalsMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priorityGoalsMenuItem.setText("Priority Goals");
        priorityGoalsMenuItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        priorityGoalsMenuItem.setOpaque(true);
        priorityGoalsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                priorityGoalsMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                priorityGoalsMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                priorityGoalsMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                priorityGoalsMenuItemMousePressed(evt);
            }
        });

        createNewGoalMenuItem.setBackground(new java.awt.Color(202, 247, 253));
        createNewGoalMenuItem.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        createNewGoalMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createNewGoalMenuItem.setText("Create New Goal");
        createNewGoalMenuItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        createNewGoalMenuItem.setOpaque(true);
        createNewGoalMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createNewGoalMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createNewGoalMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createNewGoalMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createNewGoalMenuItemMousePressed(evt);
            }
        });

        javax.swing.GroupLayout myGoalsMenuPanelLayout = new javax.swing.GroupLayout(myGoalsMenuPanel);
        myGoalsMenuPanel.setLayout(myGoalsMenuPanelLayout);
        myGoalsMenuPanelLayout.setHorizontalGroup(
            myGoalsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myGoalsMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myGoalsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myGoalsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentGoalsMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priorityGoalsMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createNewGoalMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addContainerGap())
        );
        myGoalsMenuPanelLayout.setVerticalGroup(
            myGoalsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myGoalsMenuPanelLayout.createSequentialGroup()
                .addComponent(myGoalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentGoalsMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priorityGoalsMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createNewGoalMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        archivesMenuPanel.setBackground(new java.awt.Color(113, 183, 252));

        jLabel1.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Archive");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        completedGoalsMenuItem.setBackground(new java.awt.Color(202, 247, 253));
        completedGoalsMenuItem.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        completedGoalsMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completedGoalsMenuItem.setText("Completed Goals");
        completedGoalsMenuItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        completedGoalsMenuItem.setOpaque(true);
        completedGoalsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                completedGoalsMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                completedGoalsMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                completedGoalsMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                completedGoalsMenuItemMousePressed(evt);
            }
        });

        abandonedGoalsMenuItem.setBackground(new java.awt.Color(202, 247, 253));
        abandonedGoalsMenuItem.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        abandonedGoalsMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        abandonedGoalsMenuItem.setText("Abandoned Goals");
        abandonedGoalsMenuItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        abandonedGoalsMenuItem.setOpaque(true);
        abandonedGoalsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abandonedGoalsMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abandonedGoalsMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abandonedGoalsMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                abandonedGoalsMenuItemMousePressed(evt);
            }
        });

        javax.swing.GroupLayout archivesMenuPanelLayout = new javax.swing.GroupLayout(archivesMenuPanel);
        archivesMenuPanel.setLayout(archivesMenuPanelLayout);
        archivesMenuPanelLayout.setHorizontalGroup(
            archivesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archivesMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(archivesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(completedGoalsMenuItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(abandonedGoalsMenuItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        archivesMenuPanelLayout.setVerticalGroup(
            archivesMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archivesMenuPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(completedGoalsMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abandonedGoalsMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        helpMenuItemLabel.setBackground(new java.awt.Color(202, 247, 253));
        helpMenuItemLabel.setFont(new java.awt.Font("Avenir Next", 0, 18)); // NOI18N
        helpMenuItemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helpMenuItemLabel.setText("Help");
        helpMenuItemLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        helpMenuItemLabel.setOpaque(true);
        helpMenuItemLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMenuItemLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpMenuItemLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpMenuItemLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                helpMenuItemLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(aboutMenuItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(archivesMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myGoalsMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(helpMenuItemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(menuTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(dashboardMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myGoalsMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(archivesMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(helpMenuItemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout appPanelLayout = new javax.swing.GroupLayout(appPanel);
        appPanel.setLayout(appPanelLayout);
        appPanelLayout.setHorizontalGroup(
            appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        appPanelLayout.setVerticalGroup(
            appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMenuItemMouseClicked
        setView(new PageDashboard());
    }//GEN-LAST:event_dashboardMenuItemMouseClicked

    private void currentGoalsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentGoalsMenuItemMouseClicked
        setView(new PageCurrentGoals());
    }//GEN-LAST:event_currentGoalsMenuItemMouseClicked

    private void priorityGoalsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priorityGoalsMenuItemMouseClicked
        setView(new PagePriorityGoals());
    }//GEN-LAST:event_priorityGoalsMenuItemMouseClicked

    private void completedGoalsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completedGoalsMenuItemMouseClicked
        setView(new PageCompletedGoals());
    }//GEN-LAST:event_completedGoalsMenuItemMouseClicked

    private void createNewGoalMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewGoalMenuItemMouseClicked
        setView(new PageCreateGoal());
    }//GEN-LAST:event_createNewGoalMenuItemMouseClicked

    private void helpMenuItemLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMenuItemLabelMouseClicked
        setView(new PageHelp());
    }//GEN-LAST:event_helpMenuItemLabelMouseClicked

    private void aboutMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMenuItemMouseClicked
        setView(new PageAbout());
    }//GEN-LAST:event_aboutMenuItemMouseClicked

    private void dashboardMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMenuItemMouseEntered
        dashboardMenuItem.setBackground(new Color(253,249,202));
    }//GEN-LAST:event_dashboardMenuItemMouseEntered

    private void dashboardMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMenuItemMouseExited
        dashboardMenuItem.setBackground(new Color(202,247,253));
    }//GEN-LAST:event_dashboardMenuItemMouseExited

    private void currentGoalsMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentGoalsMenuItemMouseEntered
        currentGoalsMenuItem.setBackground(new Color(253,249,202));
    }//GEN-LAST:event_currentGoalsMenuItemMouseEntered

    private void priorityGoalsMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priorityGoalsMenuItemMouseEntered
        priorityGoalsMenuItem.setBackground(new Color(253,249,202));
    }//GEN-LAST:event_priorityGoalsMenuItemMouseEntered

    private void createNewGoalMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewGoalMenuItemMouseEntered
        createNewGoalMenuItem.setBackground(new Color(253,249,202));
    }//GEN-LAST:event_createNewGoalMenuItemMouseEntered

    private void completedGoalsMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completedGoalsMenuItemMouseEntered
        completedGoalsMenuItem.setBackground(new Color(253,249,202));
    }//GEN-LAST:event_completedGoalsMenuItemMouseEntered

    private void helpMenuItemLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMenuItemLabelMouseEntered
        helpMenuItemLabel.setBackground(new Color(253,249,202));
    }//GEN-LAST:event_helpMenuItemLabelMouseEntered

    private void currentGoalsMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentGoalsMenuItemMouseExited
        currentGoalsMenuItem.setBackground(new Color(202,247,253));
    }//GEN-LAST:event_currentGoalsMenuItemMouseExited

    private void priorityGoalsMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priorityGoalsMenuItemMouseExited
        priorityGoalsMenuItem.setBackground(new Color(202,247,253));
    }//GEN-LAST:event_priorityGoalsMenuItemMouseExited

    private void createNewGoalMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewGoalMenuItemMouseExited
        createNewGoalMenuItem.setBackground(new Color(202,247,253));
    }//GEN-LAST:event_createNewGoalMenuItemMouseExited

    private void completedGoalsMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completedGoalsMenuItemMouseExited
        completedGoalsMenuItem.setBackground(new Color(202,247,253));
    }//GEN-LAST:event_completedGoalsMenuItemMouseExited

    private void helpMenuItemLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMenuItemLabelMouseExited
        helpMenuItemLabel.setBackground(new Color(202,247,253));
    }//GEN-LAST:event_helpMenuItemLabelMouseExited

    private void aboutMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMenuItemMouseExited
        aboutMenuItem.setBackground(new Color(202,247,253));
    }//GEN-LAST:event_aboutMenuItemMouseExited

    private void aboutMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMenuItemMouseEntered
        aboutMenuItem.setBackground(new Color(253,249,202));
    }//GEN-LAST:event_aboutMenuItemMouseEntered

    private void dashboardMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMenuItemMousePressed
        setView(new PageDashboard());
    }//GEN-LAST:event_dashboardMenuItemMousePressed

    private void currentGoalsMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentGoalsMenuItemMousePressed
        setView(new PageCurrentGoals());
    }//GEN-LAST:event_currentGoalsMenuItemMousePressed

    private void priorityGoalsMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priorityGoalsMenuItemMousePressed
        setView(new PagePriorityGoals());
    }//GEN-LAST:event_priorityGoalsMenuItemMousePressed

    private void createNewGoalMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewGoalMenuItemMousePressed
        setView(new PageCreateGoal());
    }//GEN-LAST:event_createNewGoalMenuItemMousePressed

    private void completedGoalsMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completedGoalsMenuItemMousePressed
        setView(new PageCompletedGoals());
    }//GEN-LAST:event_completedGoalsMenuItemMousePressed

    private void abandonedGoalsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abandonedGoalsMenuItemMouseClicked
        setView(new PageAbandonedGoals());
    }//GEN-LAST:event_abandonedGoalsMenuItemMouseClicked

    private void abandonedGoalsMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abandonedGoalsMenuItemMouseEntered
        abandonedGoalsMenuItem.setBackground(new Color(253,249,202));
    }//GEN-LAST:event_abandonedGoalsMenuItemMouseEntered

    private void abandonedGoalsMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abandonedGoalsMenuItemMouseExited
        abandonedGoalsMenuItem.setBackground(new Color(202,247,253));
    }//GEN-LAST:event_abandonedGoalsMenuItemMouseExited

    private void abandonedGoalsMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abandonedGoalsMenuItemMousePressed
        setView(new PageAbandonedGoals());
    }//GEN-LAST:event_abandonedGoalsMenuItemMousePressed

    private void helpMenuItemLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMenuItemLabelMousePressed
        setView(new PageHelp());
    }//GEN-LAST:event_helpMenuItemLabelMousePressed

    private void aboutMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMenuItemMousePressed
        setView(new PageAbout());
    }//GEN-LAST:event_aboutMenuItemMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GoalTracker;
    private javax.swing.JLabel abandonedGoalsMenuItem;
    private javax.swing.JLabel aboutMenuItem;
    private javax.swing.JPanel appPanel;
    private javax.swing.JPanel archivesMenuPanel;
    private javax.swing.JLabel completedGoalsMenuItem;
    private javax.swing.JLabel createNewGoalMenuItem;
    private javax.swing.JLabel currentGoalsMenuItem;
    private javax.swing.JLabel dashboardMenuItem;
    private javax.swing.JLabel helpMenuItemLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel menuTitle;
    private javax.swing.JLabel myGoalsLabel;
    private javax.swing.JPanel myGoalsMenuPanel;
    private javax.swing.JLabel priorityGoalsMenuItem;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
