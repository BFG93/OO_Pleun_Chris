/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment11pleunchris;

import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class OO_Assignment11PleunChris extends Application {
    
    private static int counter;
    
    @Override
    public void start(Stage stage) {
        Button startBtn = new Button();
        Button stopBtn = new Button();
        Button quitBtn = new Button();
        startBtn.setText("Start");
        stopBtn.setText("Stop");
        quitBtn.setText("Quit");


        
        TextField textField = new TextField ("Enter the time pls.");
        GridPane grid = new GridPane();
        
        ProgressBar bar = new ProgressBar(1);
        bar.setMinSize(100,5);
        
        
        Timeline timeLine = new Timeline( new KeyFrame( 
                Duration.seconds(1), (ActionEvent t) -> {
            System.out.println(counter);
            counter++;
        }));
        timeLine.setCycleCount( Timeline.INDEFINITE );

        
        grid.add(textField,250,250);
        grid.add(startBtn,250,300);
        grid.add(bar,200, 250);
        
        timeLine.play();
        
        System.out.println("Eddie is cool.");
        
        startBtn.setOnAction((ActionEvent event) -> {
            System.out.println(textField.getText());
        });
        stopBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Stop");
        });
        quitBtn.setOnAction((ActionEvent event) -> {
            stage.close();
        });
        
        
        
        Scene scene = new Scene(grid, 500, 500);
        
        stage.setTitle("Time Flies");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        counter = 0;
    }
    
}
