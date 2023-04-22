package com.scheduleMe;

import java.time.LocalDate;

public class Goal {
    private String name;
    private String category;
    private String description;
    private LocalDate dueDate;

    public Goal(String name, String category, String description, LocalDate dueDate) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return name;
    }
}




