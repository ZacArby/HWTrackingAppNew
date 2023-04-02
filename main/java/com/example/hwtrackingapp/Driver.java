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
import java.util.stream.IntStream;
//make pretty
//after every + plus press update assignment names etc
// after timer update streaks

//Extending the Application class
public class Driver<labels> extends Application {
    String[] assignmentTitles = {"", "", "", ""};
    String[] dueDates = {"", "", "", ""};
    Integer[] totalEstimatedTimes = {null, null, null, null};
    Integer[] remainingTimes = {null, null, null, null};

    // Get size of screen
    double screenWidth = javafx.stage.Screen.getPrimary().getVisualBounds().getWidth();
    double screenHeight = javafx.stage.Screen.getPrimary().getVisualBounds().getHeight();

    int counter = 0;

    Label[] labels = IntStream.range(0, 5)
            .mapToObj(i -> new Label(""))
            .toArray(Label[]::new);

    Label[] streaks = IntStream.range(0, 4)
            .mapToObj(i -> new Label(""))
            .toArray(Label[]::new);

    Button[] buttons = IntStream.range(0, 5)
            .mapToObj(i -> new Button(""))
            .toArray(Button[]::new);

    int[] streakValues = {0, 0, 0, 0};

    //Timer
    Double[] timerCounts = {0.0, 0.0, 0.0, 0.0};
    Double[] startTimes = {0.0, 0.0, 0.0, 0.0};
    Double[] finishTimes = {0.0, 0.0, 0.0, 0.0};
    Double[] totalTimes = {0.00, 0.00, 0.00, 0.00};
    Boolean[] timerStatuses = {false, false, false, false};

    Label[] timers = IntStream.range(0, 4)
            .mapToObj(i -> new Label(""))
            .toArray(Label[]::new);


    //Override the start() method
    @Override
    public void start(Stage primaryStage) {

        //Creating a GridPane
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);

        createAssignmentTitleLabels(assignmentTitles, labels);
        createStreakLabels(streaks, streakValues);
        createTimerLabels(timers, timerCounts, totalTimes);
        createButtons(buttons);


        for (int i = 0; i < 4; i++) {
            buttons[i].setOnAction(e -> {
                setButtonAction(buttons, startTimes, finishTimes, timerCounts, totalTimes, timerStatuses, timers);
            });
        }

        // On "+" button pressed
        buttons[4].setOnAction(e -> { //https://examples.javacodegeeks.com/java-development/desktop-java/javafx/dialog-javafx/javafx-dialog-example/
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
        root.add(labels[0], 0, 0, 1, 1);
        root.add(labels[1], 0, 1, 5, 1);
        root.add(labels[2], 0, 2, 5, 1);
        root.add(labels[3], 0, 3, 5, 1);
        root.add(labels[4], 0, 4, 5, 1);

        // Adding streaks to the GridPane
        root.add(streaks[0], 1, 0, 1, 1);
        root.add(streaks[1], 1, 1, 5, 1);
        root.add(streaks[2], 1, 2, 5, 1);
        root.add(streaks[3], 1, 3, 5, 1);

        // Adding timers to grid
        root.add(timers[0], 5, 0);
        root.add(timers[1], 5, 1);
        root.add(timers[2], 5, 2);
        root.add(timers[3], 5, 3);

        // Adding buttons to grid
        root.add(buttons[0], 4, 0);
        root.add(buttons[1], 4, 1);
        root.add(buttons[2], 4, 2);
        root.add(buttons[3], 4, 3);
        root.add(buttons[4], 4, 4);

        //Creating a Scene by passing the root group object
        Scene scene = new Scene(root, screenWidth*0.8, screenHeight*0.9259);
        scene.setFill(Color.WHITE);

        //Setting the title to the Stage
        primaryStage.setTitle("HW Tracker");

        //Adding the scene to the Stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();
    }

    public void createAssignmentTitleLabels(String[] assignmentTitles, Label[] labels) {
        for (int i = 0; i < labels.length - 1; i++) {
            labels[i].setText(" " + assignmentTitles[i]);
            labels[i].setFont(Font.font("Serif Bold", 50));
            labels[i].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-min-width:600px; -fx-min-height: 200px;");
        }
        labels[labels.length - 1].setText(" Add New Task");
        labels[labels.length - 1].setFont(Font.font("Serif Bold", 50));
    }

    public void createStreakLabels(Label[] streaks, int[] streakValues) {
        for(int i = 0; i < streaks.length; i++) {
            streaks[i].setText(" Streak: " + streakValues[i] + " ");
            streaks[i].setFont(Font.font("Serif Bold", 50));
        }
    }

    public void createTimerLabels(Label[] timers, Double[] timerCounts, Double[] totalTimes) {
        for (int i = 0; i < 4; i++) {
            timers[i].setText(" Current Time Spent (Mins): " + timerCounts[i] + " \n Time Required (Hours): " + (totalTimes[i] = Math.round(totalTimes[i] * 100.0) / 100.0) + " ");
            timers[i].setFont(Font.font("Serif Bold", 34));
            timers[i].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:240px; -fx-min-height: 200px;");
        }
    }

    public void createButtons(Button[] buttons) {
        for (int i = 0; i < 4; i++) {
            buttons[i].setText(" Start ");
            buttons[i].setFont(Font.font("Serif Bold", 50));
            buttons[i].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:200px; -fx-max-height: 50px;");
        }
        buttons[4].setText(" + ");
    }

    public void setButtonAction(Button[] buttons, Double[] startTimes, Double[] finishTimes, Double[] timerCounts, Double[] totalTimes, Boolean[] timerStatuses,
                                Label[] timers) {
        for (int i = 0; i < buttons.length; i++) {
            int index = i;
            buttons[i].setOnAction(e -> {
                if (timerStatuses[index] == false) { // if timer was not already running
                    startTimes[index] = Double.valueOf(System.currentTimeMillis()); // start timer
                    timerStatuses[index] = true;
                    buttons[index].setText("Stop"); // Change start button to stop button

                } else { // if timer was already running
                    finishTimes[index] = Double.valueOf(System.currentTimeMillis()); // stop timer
                    timerCounts[index] += Math.round(((finishTimes[index] - startTimes[index]) / 1000 / 60)*10) / 10.00; // Add elapsed time to timer (Mins)

                    totalTimes[index] -= ((finishTimes[index] - startTimes[index]) / 1000 / 60) / 60; // Subtract elapsed time from total time (Hours)
                    timerStatuses[index] = false;
                    buttons[index].setText("Start"); // Reset button

                    // Reset label with timer and total time
                    createTimerLabels(timers, timerCounts, totalTimes);

                    // Reset time counters
                    startTimes[index] = 0.0;
                    finishTimes[index] = 0.0;
                }
            });
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}