package com.example.hwtrackingapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;


//Extending the Application class
public class Driver extends Application {

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
        Label t1 = new Label("  6h14m");
        t1.setFont(Font.font("Serif Bold", 34));
        Label t2 = new Label("  2h0m");
        t2.setFont(Font.font("Serif Bold", 34));
        Label t3 = new Label("  3h27m");
        t3.setFont(Font.font("Serif Bold", 34));
        Label t4 = new Label("  0h20m");
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

        b5.setOnAction(e -> { //https://examples.javacodegeeks.com/java-development/desktop-java/javafx/dialog-javafx/javafx-dialog-example/
            // Mke pop-up window
            Dialog dialog = new Dialog();
            TextField question1 = new TextField("...");
            dialog.setHeaderText("Enter the name of your new assignment:");

            Optional<String> result = dialog.showAndWait();
            String assignmentName = "none";

            if (result.isPresent()) {
                assignmentName = result.get();
            }
        });

        //Adding Labels to the GridPane
        root.add(l1, 0, 0, 1, 1);
        root.add(l2, 0, 1, 5, 1);
        root.add(l3, 0, 2, 5, 1);
        root.add(l4, 0, 3, 5, 1);
        root.add(l5, 0, 4, 5, 1);

        root.add(t1, 5, 0);
        root.add(t2, 5, 1);
        root.add(t3, 5, 2);
        root.add(t4, 5, 3);

        // i=x and i1=y
        root.add(b1, 4, 0);
        root.add(b2, 4, 1);
        root.add(b3, 4, 2);
        root.add(b4, 4, 3);
        root.add(b5, 4, 4);

        //Creating a Scene by passing the root group object
        Scene scene = new Scene(root, 1000, 1000);
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
    }
}