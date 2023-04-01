package com.example.hwtrackingapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;
//make pretty

//Extending the Application class
public class Driver extends Application {
    double start1 = 0;
    double start2 = 0;
    double start3 = 0;
    double start4 = 0;

    double finish1 = 0;
    double finish2 = 0;
    double finish3 = 0;
    double finish4 = 0;



    String[] assignmentTitles = {"", "", "", "", ""};
    String[] dueDates = {"", "", "", "", ""};
    Integer[] totalEstimatedTimes = {null, null, null, null, null};
    Integer[] remainingTimes = {null, null, null, null, null};

    // Get size of screen
    double screenWidth = javafx.stage.Screen.getPrimary().getVisualBounds().getWidth();
    double screenHeight = javafx.stage.Screen.getPrimary().getVisualBounds().getHeight();

    // Current amount of time spent
    double timer1 = 0;
    double timer2 = 0;
    double timer3 = 0;
    double timer4 = 0;
    double timer5 = 0;

    // Streak val
    int streak1 = 0;
    int streak2 = 0;
    int streak3 = 0;
    int streak4 = 0;
    int streak5 = 0;

    // Total amount of time required to be spent
    double total1 = 1;
    double total2 = 0;
    double total3 = 0;
    double total4 = 0;
    double total5 = 0;

    boolean timer1Status = false;
    boolean timer2Status = false;
    boolean timer3Status = false;
    boolean timer4Status = false;
    boolean timer5Status = false;

    int counter = 0;

    //Override the start() method
    @Override
    public void start(Stage primaryStage) {

        //Creating a GridPane
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);

        //Creating Assignment Title Labels
        Label l1 = new Label("English Essay");
        l1.setFont(Font.font("Serif Bold", 50));
        Label l2 = new Label("Math Homework");
        l2.setFont(Font.font("Serif Bold", 50));
        Label l3 = new Label("History Presentation");
        l3.setFont(Font.font("Serif Bold", 50));
        Label l4 = new Label("Chemistry Lab Report");
        l4.setFont(Font.font("Serif Bold", 50));
        Label l5 = new Label("Add New Task");
        l5.setFont(Font.font("Serif Bold", 50));

        //Creating Streak Labels
        Label s1 = new Label("Streak: " + streak1);
        s1.setFont(Font.font("Serif Bold", 50));
        Label s2 = new Label("Streak: " + streak2);
        s2.setFont(Font.font("Serif Bold", 50));
        Label s3 = new Label("Streak: " + streak3);
        s3.setFont(Font.font("Serif Bold", 50));
        Label s4 = new Label("Streak: " + streak4);
        s4.setFont(Font.font("Serif Bold", 50));
        Label s5 = new Label("Streak: " + streak5);
        s5.setFont(Font.font("Serif Bold", 50));

        //Creating timers
        Label t1 = new Label("Current Time Spent (Mins): " + timer1 + "\nTime Required (Hours): " + total1);
        t1.setFont(Font.font("Serif Bold", 34));
        Label t2 = new Label("Current Time Spent (Mins): " + timer2 + "\nTime Required (Hours): " + total2);
        t2.setFont(Font.font("Serif Bold", 34));
        Label t3 = new Label("Current Time Spent (Mins): " + timer3 + "\nTime Required (Hours): " + total3);
        t3.setFont(Font.font("Serif Bold", 34));
        Label t4 = new Label("Current Time Spent (Mins): " + timer4 + "\nTime Required (Hours): " + total4);
        t4.setFont(Font.font("Serif Bold", 34));

        // Adding a button to the left of the timers
        Button b1 = new Button("Start");
        Button b2 = new Button("Start");
        Button b3 = new Button("Start");
        Button b4 = new Button("Start");
        Button b5 = new Button("+");

        // Adjust style of buttons
        // dynamically adjust buttons
        b1.setFont(Font.font("Serif Bold", 50));
        b2.setFont(Font.font("Serif Bold", 50));
        b3.setFont(Font.font("Serif Bold", 50));
        b4.setFont(Font.font("Serif Bold", 50));
        b5.setFont(Font.font("Serif Bold", 50));

        // On start1 pressed
        b1.setOnAction(e -> {
            if (timer1Status == false) { // if timer was not already running
                start1 = System.currentTimeMillis(); // start timer
                timer1Status = true;
                b1.setText("Stop"); // Change start button to stop button

            } else { // if timer was already running
                finish1 = System.currentTimeMillis(); // stop timer
                timer1 += Math.round(((finish1 - start1) / 1000 / 60)*10) / 10.0; // Add elapsed time to timer (Mins)

                total1 -= ((finish1 - start1) / 1000 / 60) / 60; // Subtract elapsed time from total time (Hours
                timer1Status = false;
                b1.setText("Start"); // Reset button

                // Reset label with timer and total time
                t1.setText("Current Time Spent (Mins): " + timer1 + "\nTime Required (Hours): " + Math.round(total1 * 10) / 10.0);

                // Reset time counters
                start1 = 0.0;
                finish1 = 0.0;
            }
        });

        // On start1 pressed
        b2.setOnAction(e -> {
            if (timer2Status == false) { // if timer was not already running
                start2 = System.currentTimeMillis(); // start timer
                timer2Status = true;
                b2.setText("Stop"); // Change start button to stop button

            } else { // if timer was already running
                finish2 = System.currentTimeMillis(); // stop timer
                timer2 += Math.round(((finish2 - start2) / 1000 / 60)*10) / 10.0; // Add elapsed time to timer (Mins)

                total2 -= ((finish2 - start2) / 1000 / 60) / 60; // Subtract elapsed time from total time (Hours
                timer2Status = false;
                b2.setText("Start"); // Reset button

                // Reset label with timer and total time
                t2.setText("Current Time Spent (Mins): " + timer2 + "\nTime Required (Hours): " + Math.round(total2 * 10) / 10.0);

                // Reset time counters
                start2 = 0.0;
                finish2 = 0.0;
            }
        });

        // On start3 pressed
        b3.setOnAction(e -> {
            if (timer3Status == false) { // if timer was not already running
                start3 = System.currentTimeMillis(); // start timer
                timer3Status = true;
                b3.setText("Stop"); // Change start button to stop button

            } else { // if timer was already running
                finish3 = System.currentTimeMillis(); // stop timer
                timer3 += Math.round(((finish3 - start3) / 1000 / 60)*10) / 10.0; // Add elapsed time to timer (Mins)

                total3 -= ((finish3 - start3) / 1000 / 60) / 60; // Subtract elapsed time from total time (Hours
                timer3Status = false;
                b3.setText("Start"); // Reset button

                // Reset label with timer and total time
                t3.setText("Current Time Spent (Mins): " + timer3 + "\nTime Required (Hours): " + Math.round(total3 * 10) / 10.0);

                // Reset time counters
                start3 = 0.0;
                finish3 = 0.0;
            }
        });

        // On start4 pressed
        b4.setOnAction(e -> {
            if (timer4Status == false) { // if timer was not already running
                start4 = System.currentTimeMillis(); // start timer
                timer4Status = true;
                b4.setText("Stop"); // Change start button to stop button

            } else { // if timer was already running
                finish4 = System.currentTimeMillis(); // stop timer
                timer4 += Math.round(((finish4 - start4) / 1000 / 60)*10) / 10.0; // Add elapsed time to timer (Mins)

                total4 -= ((finish4 - start4) / 1000 / 60) / 60; // Subtract elapsed time from total time (Hours
                timer4Status = false;
                b4.setText("Start"); // Reset button

                // Reset label with timer and total time
                t4.setText("Current Time Spent (Mins): " + timer4 + "\nTime Required (Hours): " + Math.round(total4 * 10) / 10.0);

                // Reset time counters
                start4 = 0.0;
                finish4 = 0.0;
            }
        });

        // On "+" button pressed
        b5.setOnAction(e -> { //https://examples.javacodegeeks.com/java-development/desktop-java/javafx/dialog-javafx/javafx-dialog-example/
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Text Input Dialog");
            dialog.setHeaderText("Look, a Text Input Dialog");
            dialog.setContentText("Please enter your name, age, and gender:");

            // Set lay-out of pop-up
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField assignmentTitleTF = new TextField();
            TextField dueDateTF = new TextField();
            TextField totalEstimatedTimeTF = new TextField();

            // Create input boxes
            grid.add(new Label("Assignment Title:"), 0, 0);
            grid.add(assignmentTitleTF, 1, 0);
            grid.add(new Label("Due Date (yyyy-mm-dd):"), 0, 1);
            grid.add(dueDateTF, 1, 1);
            grid.add(new Label("Total Estimated Time Needed (Hours):"), 0, 2);
            grid.add(totalEstimatedTimeTF, 1, 2);

            dialog.getDialogPane().setContent(grid);
            Optional<String> result = dialog.showAndWait(); // Freezes main window

            // Sets variables equal to text field equivalents
            assignmentTitles[counter] = assignmentTitleTF.getText();
            dueDates[counter] = assignmentTitleTF.getText();
            totalEstimatedTimes[counter] = Integer.valueOf(assignmentTitleTF.getText());
            counter++;
        });

        // Adding Labels to the GridPane
        root.add(l1, 0, 0, 1, 1);
        root.add(l2, 0, 1, 5, 1);
        root.add(l3, 0, 2, 5, 1);
        root.add(l4, 0, 3, 5, 1);
        root.add(l5, 0, 4, 5, 1);

        // Adding streaks to the GridPane
        root.add(s1, 1, 0, 1, 1);
        root.add(s2, 1, 1, 5, 1);
        root.add(s3, 1, 2, 5, 1);
        root.add(s4, 1, 3, 5, 1);
        root.add(s5, 1, 4, 5, 1);

        // Adding timers to grid
        root.add(t1, 5, 0);
        root.add(t2, 5, 1);
        root.add(t3, 5, 2);
        root.add(t4, 5, 3);

        // Adding buttons to grid
        root.add(b1, 4, 0);
        root.add(b2, 4, 1);
        root.add(b3, 4, 2);
        root.add(b4, 4, 3);
        root.add(b5, 4, 4);

        //Creating a Scene by passing the root group object
        Scene scene = new Scene(root, screenWidth*0.8, screenHeight*0.9259);
        scene.setFill(Color.WHITE);

        //Setting the style of the Labels
        l1.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-min-width:600px; -fx-min-height: 200px;");
        l2.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-min-width:600px; -fx-min-height: 200px;");
        l3.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-min-width:600px; -fx-min-height: 200px;");
        l4.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-min-width:600px; -fx-min-height: 200px;");
        l5.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-min-width:600px; -fx-min-height: 200px;");

        t1.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:240px; -fx-min-height: 200px;");
        t2.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:240px; -fx-min-height: 200px;");
        t3.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:240px; -fx-min-height: 200px;");
        t4.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:240px; -fx-min-height: 200px;");

        b1.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:200px; -fx-max-height: 50px;");
        b2.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:200px; -fx-max-height: 50px;");
        b3.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:200px; -fx-max-height: 50px;");
        b4.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:200px; -fx-max-height: 50px;");
        b5.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:200px; -fx-max-height: 50px;");

        //Setting the title to the Stage
        primaryStage.setTitle("HW Tracker");

        //Adding the scene to the Stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}