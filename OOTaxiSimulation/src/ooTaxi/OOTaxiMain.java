package ooTaxi;

/**
 * main Class: create a SImulation and execute it.
 *
 * @author pieterkoopman
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class OOTaxiMain {

    public static void main(String[] args) {
        // Previous ugly solution:
        
        /*
            Simulation simulation = new Simulation();
            while (! simulation.ended()) {
              simulation.step();
            }
            simulation.showStatistics();
        */
        
        Simulator simulator = new Simulator();
        simulator.start();
        while(!simulator.hasEnded());  //Wait for simulation to end.
        simulator.showStatistics();
    }
}

        // Trace of the simulation:
        
        /*
            Taxi 1 created
            Taxi 2 created
            Taxi 3 created
            Taxi 4 created
            There are no passengers for taxi 2
            There are no passengers for taxi 1
            There are no passengers for taxi 3
            There are no passengers for taxi 4
            86 passengers arrived at station
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            87 passengers arrived at station
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 4 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            75 passengers arrived at station
            Taxi 1 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 4 takes 7 passengers
            Taxi 2 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            64 passengers arrived at station
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 2 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            65 passengers arrived at station
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            62 passengers arrived at station
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            69 passengers arrived at station
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            69 passengers arrived at station
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            80 passengers arrived at station
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            79 passengers arrived at station
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 4 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 4 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 4 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 4 takes 7 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 4 takes 7 passengers
            Taxi 3 takes 7 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 4 takes 7 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 3 takes 7 passengers
            Taxi 4 takes 7 passengers
            Taxi 2 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 1 takes 4 passengers
            Taxi 2 takes 4 passengers
            All persons have been transported
            Total transport time in this simulation:340
            Total number of train travelers: 736
            Total number of persons transported in this simulation: 736
        */
