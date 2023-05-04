package com.scheduleMe;


import com.scheduleMe.utility.UserCSVHandler;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        UserCSVHandler.createUserCSV();
        ScheduleMeFrame scheduleMeFrame = new ScheduleMeFrame();

    }
}
