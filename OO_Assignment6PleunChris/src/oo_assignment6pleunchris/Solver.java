package oo_assignment6pleunchris;

import java.util.*;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 *
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.5
 * @date 25-02-2017
 */
public class Solver {
    // A queue for maintaining graphs that are not visited yet.

    Queue<Configuration> toExamine;
    HashSet<Configuration> observed;

    public Solver(Configuration g) {
        toExamine = new LinkedList<>();
        toExamine.add(g);
        
        observed = new HashSet<>();
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        int counter = 0;
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            //System.out.printf("It: %d\nNext:\n%sParent:\n%s\n",counter,next, next.parent());
            //If the next state is not yet been evaluated.
            if (!observed.contains(next)) {
                observed.add(next);
                if (next.isSolution())
                    return "Success!";
                else
                    for (Configuration succ : next.successors())
                        toExamine.add(succ);
                counter++;
            }
        }
        return "Failure!";
    }

}
