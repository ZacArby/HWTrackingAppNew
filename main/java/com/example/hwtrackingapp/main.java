package com.example.hwtrackingapp;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

//Extending the Application class
public class main extends Application {

    //Override the start() method
    @Override
    public void start(Stage primaryStage) {

        //Creating a BorderPane
        BorderPane root = new BorderPane();

        //Creating a Scene by passing the root group object
        Scene scene = new Scene(root, 700, 1000);

        //Setting the title to the Stage
        primaryStage.setTitle("HW Tracker");

        //Adding the scene to the Stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();
    }

    //The main() method is ignored in JavaFX applications
    public static void main(String args[]){
        //Launching the application
        launch(args);
    }
}