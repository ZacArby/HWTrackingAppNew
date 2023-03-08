package com.example.hwtrackingapp;

import java.time.LocalDate;

public class streak {
    int streak;
    int days;
    LocalDate lastDay;
    LocalDate currDate = java.time.LocalDate.now();
    public static void main(String[] args) {


    }

    public void days(String[] args) {
        if (lastDay == null) {
            lastDay = java.time.LocalDate.now();
            streak = 0;

        } else if (lastDay == LocalDate.EPOCH.minusDays(1) ) {
            lastDay = currDate;
            streak = streak + 1;


        } else  {
            lastDay = currDate;
            streak = 0;

        }

    }
}

