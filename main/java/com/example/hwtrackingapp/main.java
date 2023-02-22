package com.example.hwtrackingapp;

import javafx.application.Application;  //importing the Application class from the javafx package
import javafx.scene.Scene;  //importing the Scene class from the javafx package
import javafx.scene.control.Label;  //importing the Label class from the javafx package
import javafx.scene.layout.StackPane;  //importing the StackPane class from the javafx package
import javafx.stage.Stage;  //importing the Stage class from the javafx package

public class main extends Application {  //creating a class called BozoWindow that extends the Application class

    @Override
    public void start(Stage primaryStage) {  //overriding the start method of the Application class
        Label label = new Label("bozo");  //creating a new Label object with the text "bozo"
        StackPane root = new StackPane(label);  //creating a new StackPane object with the Label object
        Scene scene = new Scene(root);  //creating a new Scene object with the StackPane object as the root
        primaryStage.setScene(scene);  //setting the Scene object as the scene of the primary stage
        primaryStage.show();  //showing the primary stage
    }

    public static void main(String[] args) {  //creating a main method
        launch(args);  //launching the application
    }
}