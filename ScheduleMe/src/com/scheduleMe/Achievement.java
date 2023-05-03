package com.scheduleMe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Achievement {
    String title;
    String description;
    boolean isUnlocked;

    boolean achievementFlashed;

    LocalDate dateUnlocked; //TODO add in this

    public Achievement(String title, String description, boolean isUnlocked){
        this.title = title;
        this.description = description;
        this.isUnlocked = isUnlocked;
    }
    public static HashMap<String, Achievement> generateAchievements(){
        HashMap<String, Achievement> achievements = new HashMap<>();
        achievements.put("Juggernaut",new Achievement("Juggernaut", "Complete 5 " +
                        "Physical goals", false));
        achievements.put("Scholar",new Achievement("Scholar", "Complete 5 " +
                "Educational goals", false));
        achievements.put("Debt Collector",new Achievement("Debt Collector", "Complete 5 " +
                "Financial goals", false ));
        achievements.put("Suave",new Achievement("Suave", "Complete 5 " +
                "Relationship goals", false));
        achievements.put("Variety",new Achievement("Variety", "Complete 3 " +
                "of each type of goal", false));
        achievements.put("Dedicated",new Achievement("Dedicated", "Complete 25 " +
                "total goals", false));
        achievements.put("???",new Achievement("???", "Secret achievement" +
                "...", false));
        return achievements;
    }


    public static void validateAchievements(User user){
        if(user.numOfPhysicalGoalsCompleted >= 5){
            user.achievements.get("Juggernaut").setUnlocked(true);
        }
        if(user.numOfEducationalGoalsCompleted >= 5){
            user.achievements.get("Scholar").setUnlocked(true);
        }
        if(user.numOfRelationshipGoalsCompleted >= 5){
            user.achievements.get("Suave").setUnlocked(true);
        }
        if(user.numOfFinancialGoalsCompleted >= 5){
            user.achievements.get("Debt Collector").setUnlocked(true);
        }
        if(user.numOfTotalGoalsComplete >= 25){
            user.achievements.get("Dedicated").setUnlocked(true);
        }
        if(user.numOfPhysicalGoalsCompleted >= 3 && user.numOfFinancialGoalsCompleted >= 3 && user.numOfRelationshipGoalsCompleted >= 3
        && user.numOfRelationshipGoalsCompleted >= 3 && user.numOfEducationalGoalsCompleted >= 3){
            user.achievements.get("Variety").setUnlocked(true);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }


    public LocalDate getDateUnlocked() {
        return dateUnlocked;
    }

    public void setDateUnlocked(LocalDate dateUnlocked) {
        this.dateUnlocked = dateUnlocked;
    }
}
