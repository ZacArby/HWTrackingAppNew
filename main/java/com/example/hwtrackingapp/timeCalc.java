package com.example.hwtrackingapp;

import java.time.LocalDate;

public class timeCalc extends Countdown {
    LocalDate dueDate;
    int totalWork;
    int dailyWork;

    public static void main(String[] args) {

    }

    public void setDailyWork() {
        dailyWork = totalWork / daysUntil;

    }
}
