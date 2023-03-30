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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//PLEASE SAVE NAME AS A STRING SOMEWHERE
//Same with due date
//Please SAVE ESTIMATED TIME AS INT
//ARRAY IS THE EASIEST WAY OR JUST MAKE A BUNCH OF VARIABLES

//Extending the Application class
public class Driver extends Application {
    List<String> assignmentTitle = new ArrayList<>();
    List<String> dueDate = new ArrayList<>();
    List<Double> totalEstimatedTime = new ArrayList<>();
    List<Double> timeRemaining = new ArrayList<>();

    // Get size of screen
    double screenWidth = javafx.stage.Screen.getPrimary().getVisualBounds().getWidth();
    double screenHeight = javafx.stage.Screen.getPrimary().getVisualBounds().getHeight();

    // Current amount of time spent
    double timer1 = 0;
    double timer2 = 0;
    double timer3 = 0;
    double timer4 = 0;
    double timer5 = 0;
    double timer6 = 0;
    double timer7 = 0;

    // Total amount of time required to be spent
    double total1 = 0;
    double total2 = 0;
    double total3 = 0;
    double total4 = 0;
    double total5 = 0;
    double total6 = 0;
    double total7 = 0;

    boolean timer1Status = false;
    boolean timer2Status = false;
    boolean timer3Status = false;
    boolean timer4Status = false;
    boolean timer5Status = false;
    boolean timer6Status = false;
    boolean timer7Status = false;

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

        //Creating timers
        Label t1 = new Label("Current Time Spent: " + String.valueOf(timer1) + "\nTime Required: " + String.valueOf(total1));
        t1.setFont(Font.font("Serif Bold", 34));
        Label t2 = new Label("Current Time Spent: " + String.valueOf(timer2) + "\nTime Required: " + String.valueOf(total2));
        t2.setFont(Font.font("Serif Bold", 34));
        Label t3 = new Label("Current Time Spent: " + String.valueOf(timer3) + "\nTime Required: " + String.valueOf(total3));
        t3.setFont(Font.font("Serif Bold", 34));
        Label t4 = new Label("Current Time Spent: " + String.valueOf(timer4) + "\nTime Required: " + String.valueOf(total4));
        t4.setFont(Font.font("Serif Bold", 34));

        // Adding a button to the left of the timers
        Button b1 = new Button("Start");
        Button b2 = new Button("Start");
        Button b3 = new Button("Start");
        Button b4 = new Button("Start");
        Button b5 = new Button("+");

        b1.setFont(Font.font("Serif Bold", 50));
        b2.setFont(Font.font("Serif Bold", 50));
        b3.setFont(Font.font("Serif Bold", 50));
        b4.setFont(Font.font("Serif Bold", 50));
        b5.setFont(Font.font("Serif Bold", 50));

        /*b1.setOnAction(e -> { //https://examples.javacodegeeks.com/java-development/desktop-java/javafx/dialog-javafx/javafx-dialog-example/
            timer1Status = true;
            System.out.println(timer1Status);
        });*/

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
            //////////////////////////////////////

            // Sets variables equal to text field equivalents
            assignmentTitle.add(assignmentTitleTF.getText());
            dueDate.add(assignmentTitleTF.getText());
            totalEstimatedTime.add(Double.valueOf(assignmentTitleTF.getText()));
        });



        // Adding Labels to the GridPane
        root.add(l1, 0, 0, 1, 1);
        root.add(l2, 0, 1, 5, 1);
        root.add(l3, 0, 2, 5, 1);
        root.add(l4, 0, 3, 5, 1);
        root.add(l5, 0, 4, 5, 1);



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
        Scene scene = new Scene(root, screenWidth*0.6052, screenHeight*0.9259);
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

    //The main() method is ignored in JavaFX applications
    public static void main(String args[]) {
        //Launching the application
        launch(args);
        //Creating timers
    }
}