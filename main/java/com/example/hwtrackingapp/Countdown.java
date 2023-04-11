package com.example.hwtrackingapp;

import java.text.ParseException;
import java.util.Date;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Countdown  extends Assignment{
    int daysUntil;




    public static void main(String[] args) {




    }
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

    public void counter() throws ParseException {
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter due date (yyyy-mm-dd):");
        String dueDate = assignmentTitles[curr];
       // dueDate = scanner.nextLine();
        // System.out.println(dueDate);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currDate = format.parse(String.valueOf(LocalDate.now()));
        // System.out.println(currDate);
        Date deadDate = format.parse(dueDate);
        // System.out.println(deadDate);
        long diff = deadDate.getTime() - currDate.getTime();
        // saying it is one day longer than it is
        long daysTo = (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        //daysTo = (daysTo-1);
        // never mind it works now
        System.out.println("Days: " + daysTo);
        daysUntil = (int) daysTo;

        daysTillDue[curr] = daysUntil;

    }
    public class timeCalc {
        LocalDate dueDate;
        double totalWork;


        public static void main(String[] args) {

        }


        public void setDailyWork() {
            for (int i = 0; i < 4; i++) {
                curr = i;
                new Countdown();
                new timeCalc();
                new streak();
                new Assignment();
                try {
                    counter();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                daysUntil = daysTillDue[curr];
                totalWork =  totalTimes[curr];
                dailyWork[curr] = (int) (totalWork / daysUntil);


            }


        }
    }
}