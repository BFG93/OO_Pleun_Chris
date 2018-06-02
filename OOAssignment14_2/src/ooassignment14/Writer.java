package ooassignment14;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pleun
 */
public class Writer implements Runnable {
    
    private BoundedBuffer buffer;
    private String name;
    private Random rnd;
    
    public Writer(BoundedBuffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
        this.rnd = new Random();
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                buffer.put(String.format("%s wrote %d",name,i));
                Thread.sleep(100+rnd.nextInt(500));
            }
        } catch (InterruptedException ex) {
            System.out.println("Something went wrong in writer -> run()");
        }
    }

}
