package oo_assignment11pleunchris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class MyTimeLine {

    private int time;
    private int maxTime;
    private final ProgressBar bar;
    private final Timeline timeLine;

    public MyTimeLine(ProgressBar bar) {
        time = -1;
        maxTime = -1;
        this.bar = bar;

        timeLine = new Timeline(new KeyFrame(
                Duration.seconds(1), (ActionEvent t) -> {
            System.out.println(time);
            if (time == -1)
                bar.setProgress(1);
            else {
                double value = (double) time / maxTime;
                System.out.printf("T: %d, M: %d, R: %f\n", time, maxTime, value);
                bar.setProgress(value);
                time--;
            }
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);

    }

    public void run(int time) {
        this.time = time;
        this.maxTime = time;
        timeLine.play();
    }

    public void stop() {
        timeLine.pause();
    }
}
