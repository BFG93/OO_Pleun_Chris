package oo_assignment6pleunchris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Sjaak Smetsers
 */
public class Main {

    public static void main(String[] args) {
        int[] game = {3, 8, 5, 2, 9, 7, 4, 1, 6};

        SlidingGame s = new SlidingGame(game);

        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
