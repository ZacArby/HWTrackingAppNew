package com.example.hwtrackingapp;

public class Assignment extends Driver {
    int curr;
     int[] daysTillDue = new int[3];
    int[] dailyWork = new int[3];


        public Assignment(String name, String dueDate, double timeRequired, int dailyWork , int daysTillDue) {
            Assignment assignment1 = new Assignment(assignmentTitles[0], dueDates[0], totalTimes[0] , this.daysTillDue[0], 1);
            Assignment assignment2 = new Assignment(assignmentTitles[1], dueDates[1], totalTimes[1] , this.daysTillDue[1] , 1);
            Assignment assignment3 = new Assignment(assignmentTitles[2], dueDates[2], totalTimes[2] , this.daysTillDue[2] , 1);
            Assignment assignment4 = new Assignment(assignmentTitles[3], dueDates[3], totalTimes[3] , this.daysTillDue[3] , 1);
            int dw = 0;
            for (int i = 0; i < 4; i++) {
                curr = i;
                new Countdown();


            }
        }

    public Assignment() {

    }


    // getters and setters for name, dueDate, and timeRequired

        public static void main(String[] args) {
            new Assignment();





        }
    }

