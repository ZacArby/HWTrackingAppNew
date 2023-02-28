//Modified code
package com.example.hwtrackingapp;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


//Extending the Application class
public class main extends Application {

    //Override the start() method
    @Override
    public void start(Stage primaryStage) {

        //Creating a GridPane
        GridPane root = new GridPane();

        //Creating 5 Labels
        Label l1 = new Label("    Funny Thing 1");
        l1.setFont(Font.font("    Serif Bold", 34));
        Label l2 = new Label("    Funny Thing 2");
        l2.setFont(Font.font("    Serif Bold", 34));
        Label l3 = new Label("    Funny Thing 3");
        l3.setFont(Font.font("    Serif Bold", 34));
        Label l4 = new Label("    Funny Thing 4");
        l4.setFont(Font.font("    Serif Bold", 34));
        Label l5 = new Label("    Funny Thing 5");
        l5.setFont(Font.font("    Serif Bold", 34));

        //Adding Labels to the GridPane
        root.add(l1, 0, 0);
        root.add(l2, 0, 1);
        root.add(l3, 0, 2);
        root.add(l4, 0, 3);
        root.add(l5, 0, 4);

        //Creating a Scene by passing the root group object
        Scene scene = new Scene(root, 700, 1000);

        //Setting the style of the Labels
        l1.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:700px; -fx-min-height: 200px;");
        l2.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:700px; -fx-min-height: 200px;");        l2.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:700px; -fx-min-height: 200px;");
        l3.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:700px; -fx-min-height: 200px;");
        l4.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:700px; -fx-min-height: 200px;");
        l5.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width:700px; -fx-min-height: 200px;");

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