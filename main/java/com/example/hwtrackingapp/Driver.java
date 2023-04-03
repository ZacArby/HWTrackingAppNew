package com.example.hwtrackingapp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

import java.util.stream.IntStream;

/**
 * The Driver class is the main class for the HWTrackingApp. This class extends the Application class from JavaFX and
 * contains the start method which initializes the GUI for the app. This class includes an array of Strings to store
 * the assignment titles, an array of Strings to store the due dates, an array of Integers to store the estimated times
 * for completion, and an array of Integers to store the remaining times to completion for each assignment.
 *
 * @author Zac Arbuthnot
 * @version 1.0
 * @since 2023-04-02
 */

public class Driver extends Application {
    // Declaring input variables
    String[] assignmentTitles = {"", "", "", ""};
    String[] dueDates = {"", "", "", ""};

    // Timer variables
    Double[] timerCounts = {0.0, 0.0, 0.0, 0.0};
    Double[] startTimes = {0.0, 0.0, 0.0, 0.0};
    Double[] finishTimes = {0.0, 0.0, 0.0, 0.0};
    Double[] totalTimes = {0.00, 0.00, 0.00, 0.00};
    Boolean[] timerStatuses = {false, false, false, false};

    // Get size of screen
    double screenWidth = javafx.stage.Screen.getPrimary().getVisualBounds().getWidth();
    double screenHeight = javafx.stage.Screen.getPrimary().getVisualBounds().getHeight();

    // Declaring the labels
    Label[] labels = IntStream.range(0, 5)
            .mapToObj(i -> new Label(""))
            .toArray(Label[]::new);

    Label[] streaks = IntStream.range(0, 4)
            .mapToObj(i -> new Label(""))
            .toArray(Label[]::new);

    Button[] buttons = IntStream.range(0, 5)
            .mapToObj(i -> new Button(""))
            .toArray(Button[]::new);

    Label[] timers = IntStream.range(0, 4)
            .mapToObj(i -> new Label(""))
            .toArray(Label[]::new);

    int[] streakValues = {0, 0, 0, 0};
    int assignmentsAdded = 0;

    //Override the start() method
    @Override
    public void start(Stage primaryStage) {
        //Creating GridPane
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);

        // Create the elements of the UI
        createAssignmentTitlesAll(assignmentTitles, labels);
        createStreakLabels(streaks, streakValues);
        createTimerLabels(timers, timerCounts, totalTimes);
        createButtons(buttons);

        // Checks for start button press
        for (int i = 0; i < 4; i++) {
            buttons[i].setOnAction(e -> setStartButtonAction(buttons, startTimes, finishTimes, timerCounts, totalTimes, timerStatuses, timers));
        }

        // On "+" button pressed
        buttons[4].setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog(); // Creates pop-up
            // Set-up pop-up text
            dialog.setTitle("HW Tracker");
            dialog.setHeaderText("Add Assignment");
            dialog.setContentText("Please enter your name, age, and gender:");

            // Set lay-out of pop-up
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            // Creates text fields
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
            dialog.showAndWait();

            // Updates the arrays controlling the assignments
            assignmentTitles[assignmentsAdded] = assignmentTitleTF.getText();
            dueDates[assignmentsAdded] = dueDateTF.getText();
            totalTimes[assignmentsAdded] = (double) Integer.parseInt(totalEstimatedTimeTF.getText());

            // Updates the labels
            createNewAssignment(assignmentsAdded, assignmentTitles, totalTimes);
            assignmentsAdded++;
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
        Scene scene = new Scene(root, screenWidth*0.78, screenHeight*0.87);
        scene.setFill(Color.WHITE);

        //Setting the title to the Stage
        primaryStage.setTitle("HW Tracker");

        //Adding the scene to the Stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /** Sets the text, font, and style for an array of labels representing assignment titles,
     * as well as adding a label for adding a new task.
     *
     * @param assignmentTitles An array of strings representing assignment titles.
     * @param labels An array of labels to represent the assignment titles and the "Add New Task" label.
     */
    public void createAssignmentTitlesAll(String[] assignmentTitles, Label[] labels) {
        // Draws each assignment title
        for (int i = 0; i < labels.length - 1; i++) {
            labels[i].setText(" " + assignmentTitles[i]);
            labels[i].setFont(Font.font("Serif Bold", 50));
            labels[i].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-min-width:600px; -fx-min-height: 200px;");
        }
        // Draws new task label
        labels[labels.length - 1].setText(" Add New Task");
        labels[labels.length - 1].setFont(Font.font("Serif Bold", 50));
    }

    /** Sets the text and font of an array of Label objects to display a streak value.
     *
     * @param streaks An array of Label objects to display the streak values.
     * @param streakValues An array of integers representing the streak values to display.
     * @throws IllegalArgumentException if the length of the streaks and streakValues arrays do not match.
     */
    public void createStreakLabels(Label[] streaks, int[] streakValues) {
        for(int i = 0; i < streaks.length; i++) {
            streaks[i].setText(" Streak: " + streakValues[i] + " ");
            streaks[i].setFont(Font.font("Serif Bold", 50));
        }
    }

    /** Sets the text, font, and style of the given timer Labels with the corresponding timerCounts and totalTimes.
     *
     * @param timers An array of Labels to set the text, font, and style.
     * @param timerCounts An array of Doubles representing the current time spent for each timer.
     * @param totalTimes An array of Doubles representing the total time required for each timer.
     */
    public void createTimerLabels(Label[] timers, Double[] timerCounts, Double[] totalTimes) {
        for (int i = 0; i < 4; i++) {
            // Draws timers with rounded values
            timers[i].setText(" Current Time Spent (Mins): " + timerCounts[i] + " \n Time Required (Hours): " + (totalTimes[i] = Math.round(totalTimes[i] * 100.0) / 100.0) + " ");
            timers[i].setFont(Font.font("Serif Bold", 34));
            timers[i].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:240px; -fx-min-height: 200px;");
        }
    }

    /** This method draws the assignment title and the total time required on the screen for the given index. It updates
     * the total time required to include two decimal places by rounding it to the nearest hundredth.
     * @param index the index of the assignment to create
     * @param assignmentTitles an array of strings representing the titles of the assignments
     * @param totalTimes an array of doubles representing the total times required for each assignment
     */
    public void createNewAssignment(int index, String[] assignmentTitles, Double[] totalTimes) {
        // Draws assignment title
        labels[index].setText(" " + assignmentTitles[index]);

        // Draws total time required
        timers[index].setText(" Current Time Spent (Mins): " + timerCounts[index] + " \n Time Required (Hours): " + (totalTimes[index] = Math.round(totalTimes[index] * 100.0) / 100.0) + " ");
    }

    /** Sets the properties of the given Button objects to create four Start buttons and one Add button.
     * The Start buttons will have a white background, black border, and a text of "Start" with a font size of 50px.
     * The Add button will have the same background, border, and font properties, but with a text of "+".
     *
     *@param buttons an array of Button objects to be created
     */
    public void createButtons(Button[] buttons) {
        // Creates all the start buttons
        for (int i = 0; i < 4; i++) {
            buttons[i].setText(" Start ");
            buttons[i].setFont(Font.font("Serif Bold", 50));
            buttons[i].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:200px; -fx-max-height: 50px;");
        }
        // Creates the "+" button
        buttons[4].setText(" + ");
        buttons[4].setFont(Font.font("Serif Bold", 50));
        buttons[4].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:200px; -fx-max-height: 50px;");
    }

    /** Updates timer labels whenever the start button is pressed. If the timer is not running, it starts the timer and
     * changes the button text to "Stop". If the timer is already running, it stops the timer, calculates the elapsed
     * time, updates the timer count and total time, resets the button text to "Start", and resets the time counters.
     *
     * @param buttons the array of start/stop buttons
     * @param startTimes the array of start times for each timer
     * @param finishTimes the array of finish times for each timer
     * @param timerCounts the array of elapsed times for each timer
     * @param totalTimes the array of total times for each timer
     * @param timerStatuses the array of statuses indicating whether each timer is currently running
     * @param timers the array of timer labels
     */
    public void setStartButtonAction(Button[] buttons, Double[] startTimes, Double[] finishTimes, Double[] timerCounts, Double[] totalTimes, Boolean[] timerStatuses, Label[] timers) {
        for (int i = 0; i < buttons.length - 1; i++) { // cycles through for each possible start button press
            int index = i;
            buttons[i].setOnAction(e -> {
                if (!timerStatuses[index]) { // if timer was not already running
                    startTimes[index] = (double) System.currentTimeMillis(); // start timer
                    timerStatuses[index] = true;
                    buttons[index].setText("Stop"); // change start button to stop button

                } else { // if timer was already running
                    finishTimes[index] = (double) System.currentTimeMillis(); // stop timer
                    timerCounts[index] += Math.round(((finishTimes[index] - startTimes[index]) / 1000 / 60) * 10) / 10.0; // add elapsed time to timer (mins)

                    totalTimes[index] -= ((finishTimes[index] - startTimes[index]) / 1000 / 60) / 60; // subtract elapsed time from total time (hours)
                    timerStatuses[index] = false;
                    buttons[index].setText("Start"); // reset button

                    // reset label with timer and total time
                    createTimerLabels(timers, timerCounts, totalTimes);

                    // reset time counters
                    startTimes[index] = 0.0;
                    finishTimes[index] = 0.0;
                }
            });

            // Updates timer labels every second while the timer is running
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                if (timerStatuses[index]) {
                    double elapsedMillis = System.currentTimeMillis() - startTimes[index];
                    timerCounts[index] = Math.round((elapsedMillis / 1000 / 60) * 10) / 10.0; // round to 1 decimal place
                    createTimerLabels(timers, timerCounts, totalTimes);
                }
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }
}