package com.scheduleMe;

//use the singleton design pattern to handle userlist

import com.scheduleMe.utility.UserCSVHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserList {

    private static HashMap<String, User> userHashMap ;

    public static HashMap getInstance() throws IOException {
        if (userHashMap == null) {
            userHashMap = new HashMap<>(UserCSVHandler.CSVToHashMap());
        }
        return userHashMap;
    }
    //helper method to retrieve goal list
    public static ArrayList<Goal> getGoalList(User user){
        return userHashMap.get(user.getUsername()).goals;
    }

}
