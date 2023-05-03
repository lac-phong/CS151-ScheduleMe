package com.scheduleMe;

import java.util.ArrayList;
import java.util.HashMap;

public class User { //TODO maybe create a trophy page for completing x amount of goals?
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public ArrayList<Goal> goals;
    public ArrayList<Goal> completedGoals;

    public int numOfFinancialGoalsCompleted;
    public int numOfEducationalGoalsCompleted;
    public int numOfPhysicalGoalsCompleted;
    public int numOfRelationshipGoalsCompleted;
    public int numOfTotalGoalsComplete;

    public HashMap<String, Achievement> achievements;

    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        goals = new ArrayList<>();
        completedGoals = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}