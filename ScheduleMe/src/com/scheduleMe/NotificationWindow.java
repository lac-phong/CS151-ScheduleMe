package com.scheduleMe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NotificationWindow extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 120;

    private JPanel messagePane;
    private JPanel contentPane;
    private JLabel titleLabel;
    private JLabel messageLabel;
    private JButton okButton;

    public NotificationWindow(String title, String message) {
        setTitle(title);
        setUndecorated(true);
        setResizable(false);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(10, 10));

        messagePane = new JPanel(new GridBagLayout());
        messagePane.setBackground(new Color(255, 255, 255, 0));
        messagePane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 0, 10);
        gbc.anchor = GridBagConstraints.WEST;

        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messagePane.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 10, 10, 10);
        messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        messagePane.add(messageLabel, gbc);
        contentPane.add(messagePane, BorderLayout.CENTER);

        okButton = new JButton("Ok");
        okButton.addActionListener(this);
        contentPane.add(okButton, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setAlwaysOnTop(true);
    }

    public void display() {
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            dispose();
        }
    }
}
