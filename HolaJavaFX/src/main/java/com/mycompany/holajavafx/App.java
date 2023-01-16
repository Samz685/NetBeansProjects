package com.mycompany.holajavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        
        var pane = new VBox();
        pane.getChildren().add(label);
        
        var button = new Button("Texto del botón");
        pane.getChildren().add(button);
        
        var scene = new Scene(pane, 300, 200);
        
                
        Circle c = new Circle();
        c.setRadius(100);
        c.setCenterX(100);
        c.setCenterY(100);
        c.setFill(Color.DARKOLIVEGREEN);
       
        
        var scene2= new Scene( new StackPane(c), 300, 200);
        
        button.setOnAction(( t) -> {
            label.setText("ADIOS A TODOS LOS DE 2DAM");
            stage.setScene(scene2);
        });               
        
        stage.setScene(scene);       
        stage.setTitle("Mi primera vez con JavaFX");
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setX(0);
        stage.setY(0);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}