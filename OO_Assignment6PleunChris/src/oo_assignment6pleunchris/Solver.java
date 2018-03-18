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

    private Queue<Configuration> toExamine;
    private HashSet<Configuration> observed;

    public Solver(Configuration g) {
        toExamine = new PriorityQueue<>();
        toExamine.add(g);

        observed = new HashSet<>();
    }

    /**
     * Solves the configuration and prints the solution.
     * @return the path.
     */
    public String solve() {
        int counter = 0;
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            //System.out.printf("It: %d\nNext:\n%sParent:\n%s\n",counter,next, next.parent());
            //If the next state is not yet been evaluated.
            if (next.isSolution()) {
                return "Success!\n"+getPath(next.pathFromRoot());
            } else
                for (Configuration succ : next.successors())
                    if (observed.add(succ)) //Returns true if next is not in observed
                        toExamine.add(succ);
            counter++;
        }
        return "Failure!";
    }

    /**
     * Prints the solution with a clean layout.
     *
     * @param pathFromRoot
     * @return the path formatted properly
     */
    private String getPath(List<Configuration> pathFromRoot) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pathFromRoot.size(); i++) {
            sb.append(String.format("%s\n", pathFromRoot.get(i)));
        }
        return sb.toString();
    }
}
