package oo_assignment12pleun;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import static oo_assignment12pleun.Main.G;
import static oo_assignment12pleun.Main.RADIUS;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class MouseController {

    private final Pane root;

    public MouseController(Pane root) {
        this.root = root;

        root.setOnMouseClicked(e -> handleClicked());
        root.setOnMouseMoved(e -> handleMouseMoved(e));
    }

    private void handleClicked() {
        // Add new Circle
        Circle newCirc = new Circle(RADIUS);
        root.getChildren().add(newCirc);
        // Update circles
        for (int i = root.getChildren().size() - 1; i >= 1; i--) {
            updatePositions();
            updateColors();
        }
    }

    private void handleMouseMoved(MouseEvent e) {
        //Little bit ugly cast but it's safe since elements are only added to the end of pane.getChildren().
        Line line = (Line) root.getChildren().get(0);
        Node firstCirc = root.getChildren().get(1);
        line.setEndX(e.getX());
        line.setEndY(e.getY());
        firstCirc.setTranslateX(e.getX());
        firstCirc.setTranslateY(e.getY());

        updatePositions();
    }

    private void updatePositions() {
        // First get first circle's X,Y
        // Safe get since there are always two objects: a line and a circle.
        double circX = root.getChildren().get(1).getTranslateX(); //Correct
        double circY = root.getChildren().get(1).getTranslateY();
        
        //Loop till 1 to avoid the line.
        for (int i = root.getChildren().size() - 1; i >= 1; i--) {
            
            //Need to cast everything to double to avoid automatic rounding.
            double segment = (double) root.getChildren().size()-i;
            double numberOfBalls = (double)(root.getChildren().size() - 1);
            
            double newX = segment * circX / numberOfBalls;
            double newY = segment * circY / numberOfBalls;
                        
            root.getChildren().get(i).setTranslateX(newX);
            root.getChildren().get(i).setTranslateY(newY);
        }
    }

    private void updateColors() {
        for (int i = root.getChildren().size() - 1; i >= 1; i--) {
            // Didn't bother with the precise i-/+1 that should be there for precision, because it's a rounded value anyway.
            // This is good enough ;)
            int blue = 255/root.getChildren().size()*(root.getChildren().size()-i+1);
            int red = 255/root.getChildren().size()*(i-1); 
            Circle circle = (Circle) root.getChildren().get(i);
            circle.setFill(rgb(red, G, blue));
        }
    }
}
