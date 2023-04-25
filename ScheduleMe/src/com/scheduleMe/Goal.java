package com.scheduleMe;

import java.time.LocalDate;
import java.util.Locale.Category;

public abstract class Goal {
    private String name;
    private String category;
    private String description;
    private LocalDate dueDate;
    private LocalDate completedDate;
    private boolean isComplete;

    public Goal(String name, String description, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public String getCategory(){
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getCompleteDate() {
        return completedDate;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate date) {
        this.dueDate = date;
    }

    public void setComplete(boolean isComplete){
        this.isComplete = isComplete;
    }

    public void setCompleteDate(LocalDate completed){
        completedDate = completed;
    }

    @Override
    public String toString() {
        return name;
    }
}




