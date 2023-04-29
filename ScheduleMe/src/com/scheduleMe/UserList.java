package com.scheduleMe;

//use the singleton design pattern to handle userlist

import com.scheduleMe.utility.CSVHandler;

import java.io.IOException;
import java.util.HashMap;

public class UserList {

    private static HashMap<String, User> userHashMap ;

    public static HashMap getInstance() throws IOException {
        if (userHashMap == null) {
            userHashMap = new HashMap<>(CSVHandler.CSVToHashMap("output.csv"));
        }
        return userHashMap;
    }


}
