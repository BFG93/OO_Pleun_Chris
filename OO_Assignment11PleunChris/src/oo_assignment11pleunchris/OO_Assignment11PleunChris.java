/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment11pleunchris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class OO_Assignment11PleunChris extends Application {

    private double time = -1;
    private double maxTime = 0;

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
        grid.setStyle("-fx-background-color: #ffffff;"); //White

        ProgressBar bar = new ProgressBar(1);
        bar.setMaxWidth(200);
        DoubleProperty percentage = new SimpleDoubleProperty(1F);

        Timeline timeLine = new Timeline(new KeyFrame(
                Duration.millis(100), (ActionEvent t) -> {
            if (time <= 0) {
                grid.setStyle("-fx-background-color: #ff0000;"); //Red
                bar.progressProperty().unbind();
                bar.setProgress(0);
            } else {
                percentage.set(time / maxTime);
                time -= 0.1;
            }
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);

        grid.add(bar, 0, 0);
        grid.add(textField, 0, 1);
        grid.add(startBtn, 0, 2);
        grid.add(stopBtn, 1, 2);
        grid.add(quitBtn, 1, 1);

        startBtn.setOnAction((ActionEvent event) -> {
            grid.setStyle("-fx-background-color: #ffffff;"); //White
            try {
                //Run the thing
                time = Double.parseDouble(textField.getText());
                maxTime = time;
                bar.progressProperty().bind(percentage);
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
            timeLine.pause();
            grid.setStyle("-fx-background-color: #ffffff;"); //White
            percentage.set(1F);
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
