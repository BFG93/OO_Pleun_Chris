/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment12pleun;

import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class Main extends Application {

    public final static double WIDTH = 500;
    public final static double HEIGHT = WIDTH;
    public final static double RADIUS = 20;
    public final static int G = 0;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane(); //Uses a proper coordinate system thank god.

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        initialize(root);
        MouseController mouse = new MouseController(root);
        
        primaryStage.setTitle("String 'n balls.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the pane by adding a line and a single circle at a random x and y within the screen.
     * @param root 
     */
    private void initialize(Pane root) {
        double x = ThreadLocalRandom.current().nextDouble(0+RADIUS, WIDTH-RADIUS);
        double y = ThreadLocalRandom.current().nextDouble(0+RADIUS, HEIGHT-RADIUS);
        
        Circle firstCirc = new Circle(RADIUS, rgb(0, G, 255));
        firstCirc.setTranslateX(x);
        firstCirc.setTranslateY(y);
        
        Line line = new Line(0.0f, 0.0f, x, y);
        root.getChildren().addAll(line, firstCirc);
    }
}
