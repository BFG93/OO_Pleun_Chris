package oo_assignment6pleunchris;

/**
 * An interface for representing nodes in a state space.
 * 
 * @author Sjaak Smetsers
 * @version 1.3
 * @date 25-02-2017
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Configuration extends Comparable<Configuration> {  
    /**
     * To obtain the parent of the current configuration, i.e.
     * the configuration which had this as one of its successors
     *
     * @return a reference to the parent
     */
    public abstract Configuration parent();
    
    /**
     * To obtain the successors for a specific configuration
     *
     * @return a collection of configurations containing the successors
     */
    public abstract Collection<Configuration> successors();

    /**
     * For marking final / solution configurations.
     * 
     * @return true if a this is a solution, false otherwise
     */
    public abstract boolean isSolution();
        
    /**
     * @return the Manhattan distance of the current configuration.
     */
    public abstract int getManhattanDist();

    
    /**
     * To build a path from the root configuration to the current one.
     *
     * @return a list of successive configurations from the root to 'this'
     */
    public default List<Configuration> pathFromRoot(){
        ArrayList<Configuration> path = new ArrayList<>();
        if(this.parent() != null)
            path.addAll(parent().pathFromRoot());
        path.add(this);
        return path;
    }
}
