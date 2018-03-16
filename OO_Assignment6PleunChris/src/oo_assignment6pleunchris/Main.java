package oo_assignment6pleunchris;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Sjaak Smetsers
 */
public class Main
{
    public static void main(String[] args) {
        int [] game = {1,2,3, 4,5,6, 7,9,8};

        SlidingGame s = new SlidingGame (game);
//        System.out.printf("Parent: \n%s\n",s);
//        ArrayList<Configuration> succs = (ArrayList) s.successors();
//        for (int i = 0; i < succs.size(); i++) {
//            System.out.printf("Child %d: \n%s\n",i,(SlidingGame)succs.get(i));
//        }


//        int[] winningGame = {1,2,3, 4,5,6, 7,8,9};
//        SlidingGame s = new SlidingGame(winningGame);
//        System.out.printf("State:\n%s\nisSolution: %b\nsolution:\n",s,s.isSolution());
//        for (int i = 0; i < s.getSolution().length; i++) {
//            System.out.println(Arrays.toString(s.getSolution()[i]));
//        }
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
