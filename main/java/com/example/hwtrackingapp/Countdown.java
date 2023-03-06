package com.example.hwtrackingapp;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Countdown {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter due date (yyyy-mm-dd):");
        String dueDate;
        dueDate= scanner.nextLine();
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



}}