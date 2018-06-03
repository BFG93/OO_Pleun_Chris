package ooassignment14;

import java.util.Iterator;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class OOAssignment14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //runBufferTest();
        runPrimeTest(1000);
    }
    
    private static void runBufferTest() {
        BoundedBuffer buffer = new BoundedBuffer(2);
        
        String[] names = {"Plöm","Chris-Chen","Belena"};
        for(String name : names) {
            Writer writer = new Writer(buffer, name);
            Thread thread = new Thread(writer);
            thread.start();
        }
        
        for (int i = 0; i < 20; i++) {
            System.out.println(String.format("%d : %s",i, buffer.get()));
            
        }
    }
    
    private static void runPrimeTest(int max) {
        Iterator<Integer> source = new Generator();
        for (int i = 1; i <= max; i++) {
            int prime = source.next();
            source = new SieveOfEratosthenes(prime, source);
            System.out.println(String.format("%d : %d",i,prime));
        }
    }
}
