package ooassignment14;

/**
 *
 * @author Pleun
 */
public class OOAssignment14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        run();
    }
    
    private static void run() {
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
}
