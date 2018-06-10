package ooTaxi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that holds the number of persons arriving by train at the station and
 * is waiting for a taxi.
 *
 * @author pieterkoopman
 */
public class Station {

    private int nrOfPassengersAtStation = 0;
    private int totalNrOfPassengers = 0;
    private boolean isClosed = false;
    private boolean isAccessed = false;
    private Lock myLock = new ReentrantLock();
    private Condition free = myLock.newCondition();

    public void enterStation(int nrOfPassengers) {
        myLock.lock();
        try {
            while (isAccessed)
                free.await();
            isAccessed = true;
            nrOfPassengersAtStation += nrOfPassengers;
            totalNrOfPassengers += nrOfPassengers;
            System.out.println(nrOfPassengers + " passengers arrived at station");
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        } finally {
            myLock.unlock();
        }
    }

    public void taxiOrTrainLeaves() {
        myLock.lock();
        try {
            isAccessed = false;
            free.signalAll();
        } finally {
            myLock.unlock();
        }
    }

    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param nrOfPassengers
     */
    public void leaveStation(int nrOfPassengers) throws Exception {
        myLock.lock();
        try {
            while(isAccessed)
                free.await();
//             Is waiting for the station to be free, but maxNrOfPassengers can change??
            isAccessed = true;
            if (nrOfPassengers <= nrOfPassengersAtStation)
                nrOfPassengersAtStation -= nrOfPassengers;
            else
                throw new Exception();
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        } finally {
            myLock.unlock();
        }
    }

    public int getWaitingPassengers() {
        return nrOfPassengersAtStation;
    }

    public void close() {
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }

    public Lock getLock() {
        return myLock;
    }
}
