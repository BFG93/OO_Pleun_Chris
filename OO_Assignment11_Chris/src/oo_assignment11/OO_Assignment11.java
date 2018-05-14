/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment11;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author christianlammers
 */
public class OO_Assignment11 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
        grid.setVgap(10);
        
       
        ProgressBar p = new ProgressBar();
        p.setProgress(1);
        grid.add(p,0,2);
        
        int counter=1;
        Timeline timeLine = new Timeline( new KeyFrame( Duration.seconds(1), (ActionEvent event) -> p.setProgress(counter-0.1)));
        timeLine.setCycleCount( Timeline.INDEFINITE );
  
        
        TextField timeField = new TextField("Enter time"); 
        grid.add(timeField,0,3);
        
        Button btnStart = new Button();
        btnStart.setText("Start");
        btnStart.setOnAction((ActionEvent event) -> {System.out.println(Integer.parseInt(timeField.getText()));
        });
        grid.add(btnStart, 1, 3);
        
        Button btnQuit = new Button();
        btnQuit.setText("Quit");
        btnQuit.setOnAction((ActionEvent event) ->  {primaryStage.close();
        });
        grid.add(btnQuit, 1, 4);
        
        Button btnStop = new Button();
        btnStop.setText("Stop");
        btnStop.setOnAction((ActionEvent event) -> {
        });
        grid.add(btnStop, 0, 4);
        
        
        
       
 
        
        Scene scene = new Scene(grid, 300, 150);
        
        primaryStage.setTitle("Time flies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
