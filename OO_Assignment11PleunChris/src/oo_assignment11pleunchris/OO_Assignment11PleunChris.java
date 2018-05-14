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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    private int time = 0;

    @Override
    public void start(Stage stage) {
        Button startBtn = new Button();
        Button stopBtn = new Button();
        Button quitBtn = new Button();
        startBtn.setText("Start");
        stopBtn.setText("Stop");
        quitBtn.setText("Quit");

        TextField textField = new TextField("Time in sec.");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        ProgressBar bar = new ProgressBar(1);
        bar.setMinSize(100, 5);

        Timeline timeLine = new Timeline(new KeyFrame(
                Duration.seconds(1), (ActionEvent t) -> {
            System.out.println(time);
            time--;
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);

        grid.add(bar, 0, 0);
        grid.add(textField, 0, 1);
        grid.add(startBtn, 0, 2);
        grid.add(stopBtn, 1, 2);
        grid.add(quitBtn, 1, 1);

        startBtn.setOnAction((ActionEvent event) -> {
            try {
                time = Integer.parseInt(textField.getText());
                timeLine.play();
            } catch (IllegalArgumentException e) {
                //Give error message
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please only enter numbers");

                alert.showAndWait();
            }
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
    }

}
