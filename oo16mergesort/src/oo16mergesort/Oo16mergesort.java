/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo16mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250
 */
public class Oo16mergesort {

    static MergeSort ms;
    final static int THRESHOLD = 1000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        int[] array = random.ints(100000, 10, 100000).toArray();

        if (array.length < THRESHOLD) { // sequential sorting
            ms.sort(array);
            System.out.println(ms.isSorted(array));
        } else { // parallel sorting
            int[] part1 = new int[array.length / 2];
            int[] part2 = new int[array.length / 2];
            System.arraycopy(array, 0, part1, 0, part1.length);
            System.arraycopy(array, part1.length, part2, 0, part2.length);
            SortRunner sr1 = new SortRunner(part1);
            SortRunner sr2 = new SortRunner(part2);

            Thread t1 = new Thread(sr1);
            Thread t2 = new Thread(sr2);

            t1.start();
            t2.start();

            t1.join();
            t2.join();
            
            // So it doesn't work but we don't know why
            int [] sortedArray = new int [array.length];
            ms.merge(part1, part2, sortedArray);
            System.out.printf("%b, %d\n",ms.isSorted(part1), part1.length);
            System.out.printf("%b, %d\n",ms.isSorted(part2), part2.length);
            System.out.println(Arrays.toString(sortedArray));
            System.out.println(ms.isSorted(sortedArray));

        }
    }

}
