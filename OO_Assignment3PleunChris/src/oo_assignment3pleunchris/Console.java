package oo_assignment3pleunchris;

import java.util.Scanner;

/**
 * A console class meant to deal with I/O using a Scanner.
 * @author Pleun Scholten s4822250
 */
public class Console {
    private Scanner scanner;    
    
    /**
     * Constructor function for the Console. 
     */
    public Console() {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Returns the next line typed in by the user. 
     * @return next line.
     */
    public String getNextLine() {
        return scanner.nextLine();
    }
    
    /**
     * Prints a given output and a next line.
     * @param output 
     */    
    public void println(String output) {
        System.out.println(output);
    }
    /**
     * Prints a given output and a next line.
     * @param output 
     */    
    public void println(double output) {
        System.out.println(output);
    }
    /**
     * Prints a given output and a next line.
     * @param output 
     */    
    public void println(int output) {
        System.out.println(output);
    }
    /**
     * 
     * Prints a given output.
     * @param output 
     */    
    public void print(int output) {
        System.out.println(output);
    }
    
    /**
     * Prints a given output.
     * @param output 
     */  
    public void print(String output) {
        System.out.print(output);
    }
    
    /**
     * Prints the elements of the given array. 
     * @param array any array.
     */
    public <T extends Comparable<T>>void printArray(T[] array) {
        System.out.print("[");
        for(int i=0;i<array.length;i++) {
            if(array[i] != null)
                System.out.print(array[i].toString());
            else 
                System.out.print("_");
            if(i < array.length-1)
                System.out.print(",");
        }
        System.out.println("]");
    }
    
    /**
     * Returns the next String typed in by the user. 
     * @return next String.
     */
    public String getNext() {
        return scanner.next();
    }
    
    /**
     * Returns the next n characters of the String inputted by the user. 
     * @param n
     * @return next n characters of the String inputted by the user.
     */
    public String getNext(int n) {
        String input = scanner.nextLine();
        if (n>=input.length())
            return input;
        else 
            return input.substring(0, n);
    }
    
    /**
     * Returns an integer from a user-inputted String.
     * @return integer from user-inputted String.
     */
    public int getIntFromInput() {
        //Catches non-integers. 
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input, please enter a number > 0.");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }   
    
    /**
     * Returns a non-negative integer from a user-inputted String.
     * @return non-negative integer from user-inputted String.
     */
    public int getNonNegIntFromInput() {
        int number = -1;
        //Initial input, catches negative integers and non-integers.
        if (scanner.hasNextInt()) 
            number = scanner.nextInt();
        else
            scanner.nextLine();
        //Catches negative integers and non-integers. Equals included, since an empty group of students is nonsense. 
        while (number <= 0) {
            System.out.println("Invalid input, please enter a number > 0.");
            if (scanner.hasNextInt()) 
                number = scanner.nextInt();
            else
                scanner.nextLine();
        }
        scanner.nextLine();
        return number;
    }       
}
