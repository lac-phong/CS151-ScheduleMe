package com.scheduleme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompleteGoalFrame extends JFrame implements ActionListener {

    private GoalType type;
    private JSpinner amountSpinner;
    private JButton saveButton;
    private boolean completed;
    private GoalCompletionListener completionListener;

    public CompleteGoalFrame(GoalType type, GoalCompletionListener completionListener) {
        this.type = type;
        this.completionListener = completionListener;
        setTitle("Your progress");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout());
        JLabel amountLabel = new JLabel("Amount To " + type.getActivity());
        amountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 100));
        saveButton = new JButton("Save progress");
        saveButton.addActionListener(this);

        contentPane.add(amountLabel, BorderLayout.NORTH);
        contentPane.add(amountSpinner, BorderLayout.CENTER);
        contentPane.add(saveButton, BorderLayout.SOUTH);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
    }

    public void display() {
        setVisible(true);
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            int amountInput = (Integer) amountSpinner.getValue();
            int totalAmount = ((FinancialGoal) type).getAmount();
            int amount = totalAmount - amountInput;
            ((FinancialGoal) type).setAmount(amount);
            if (amount == 0) {
                setCompleted(true);
            }
            completionListener.onGoalCompleted(completed);
            dispose();
        }

    }

}
