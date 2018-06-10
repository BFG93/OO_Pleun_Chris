package ooTaxi;

// To import the final variables.
import java.util.Random;
import static ooTaxi.Simulation.*;

/**
 * The train brings a number of passengers to a station in the simulation.
 *
 * @author pieterkoopman
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class Train implements Runnable {

    private int nrOfPassengers;
    private final Station station;
    private int nrOfTrips = 0;
    private Random rnd = new Random();

    public Train(Station station) {
        this.station = station;
        this.nrOfPassengers = 0;
    }

    @Override
    public void run() {
        while (nrOfTrips < TRAIN_TRIPS)
            try {
                loadPassengers(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
                unloadPassengers();
                station.taxiOrTrainLeaves();
                Thread.sleep(rnd.nextInt(1000));
            } catch (InterruptedException ex) {
                System.out.println("Thread Interrupted");
            }
        station.close();
    }

    /**
     * Populate this train with number nrOfPassengers
     *
     * @param number the number of passengers of this train
     */
    public void loadPassengers(int number) {
        nrOfPassengers = number;
    }

    /**
     * empties this train and augment the number of Passengers at the station
     * with this nrOfPassenegers
     */
    public void unloadPassengers() {
        nrOfTrips += 1;
        station.enterStation(nrOfPassengers);
    }

    public void closeStation() {
        station.close();
    }

    public int getNrOfTrips() {
        return nrOfTrips;
    }

}
