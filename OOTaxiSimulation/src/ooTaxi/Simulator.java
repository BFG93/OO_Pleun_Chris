package ooTaxi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class Simulator {

    /**
     * Constants for the size of the simulation
     */
    public static final int TRAIN_TRIPS = 10;
    public static final int MIN_TRAVELLERS = 60;
    public static final int MAX_TRAVELLERS = 90;
    public static final int CAPACITY_SMALL = 4;
    public static final int CAPACITY_LARGE = 7;
    public static final int TIME_SMALL = 2;
    public static final int TIME_LARGE = 3;
    public static final int NR_OF_TAXIS = 4;
    public static final int NR_OF_SMALL_TAXIS = 2;

    private Taxi[] taxis;
    private Station station;
    private Train train;

    public Simulator() {
        station = new Station();
        taxis = new Taxi[NR_OF_TAXIS];
        for (int i = 0; i < NR_OF_TAXIS; i++)
            taxis[i] = i < NR_OF_SMALL_TAXIS
                    ? new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station)
                    : new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
        train = new Train(station);
    }

    public void start() {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(train);
        for(Taxi taxi : taxis)
            executor.execute(taxi);
        executor.shutdown();
    }

    public boolean hasEnded() {
        return station.isClosed() && station.getWaitingPassengers() == 0;
    }
    
    
    public void showStatistics() {
        System.out.println("All persons have been transported");
        System.out.println("Total transport time in this simulation:" + getTotalTime(taxis));
        System.out.println("Total number of train travelers: " + station.getTotalNrOfPassengers());
        System.out.println("Total number of persons transported in this simulation: " + getTotalNrOfPassengers(taxis));
    }

    /**
     * Calculates the total time of the simulation by looping over all taxis
     *
     * @param taxis
     * @return total time
     */
    private static int getTotalTime(Taxi[] taxis) {
        int time = 0;
        for (Taxi taxi : taxis)
            time += taxi.getTotalTransportationTime();
        return time;
    }

    /**
     * Calculates the total number of passengers that has been transported by
     * looping over all taxis
     *
     * @param taxis
     * @return total number of passengers
     */
    private static int getTotalNrOfPassengers(Taxi[] taxis) {
        int total = 0;
        for (Taxi taxi : taxis)
            total += taxi.getTotalNrOfPassengers();
        return total;
    }
}
