package oo_assignment4pleunchris;

import java.util.Scanner;

/**
 * A console class meant to deal with I/O using a Scanner.
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class View {

    private Scanner scanner;

    /**
     * Constructor function for the Console.
     */
    public View() {
        scanner = new Scanner(System.in);
    }

    /**
     * Returns the next line typed in by the user.
     *
     * @return next line.
     */
    public String getNextLine() {
        return scanner.nextLine();
    }

    /**
     * Prints a given output and a next line.
     *
     * @param <T> any type implementing toString method.
     * @param output to be printed.
     */
    public <T> void println(T output) {
        System.out.println(output);
    }

    /**
     * Prints an empty line.
     *
     * @param <T> any type implementing toString method.
     */
    public <T> void println() {
        System.out.println();
    }

    /**
     *
     * Prints a given output.
     *
     * @param <T> any type implementing toString method.
     * @param output to be printed.
     */
    public <T> void print(T output) {
        System.out.println(output);
    }

    /**
     * Prints the elements of the given array.
     *
     * @param array any array.
     */
    public <T> void printArray(T[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                System.out.print(array[i].toString());
            else
                System.out.print("_");
            if (i < array.length - 1)
                System.out.print(",");
        }
        System.out.println("]");
    }

    /**
     * Returns the next String typed in by the user.
     *
     * @return next String.
     */
    public String getNext() {
        return scanner.next();
    }

    /**
     * Returns the next n characters of the String inputted by the user.
     *
     * @param n
     * @return next n characters of the String inputted by the user.
     */
    public String getNext(int n) {
        String input = scanner.nextLine();
        if (n >= input.length())
            return input;
        else
            return input.substring(0, n);
    }

    /**
     * @return simple nextInt() from the scanner.
     */
    public int getInt() {
        return scanner.nextInt();
    }

    /**
     * Returns an integer from a user-inputted String.
     *
     * @return integer from user-inputted String.
     */
    public int getIntFromInput() {
        //Catches non-integers. 
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input, please enter a number > 0.");
            scanner.nextLine();
        }
        int i = scanner.nextInt();
        //Repair for next input.
        scanner.nextLine();
        return i;
    }

    /**
     * Returns a non-negative integer from a user-inputted String.
     *
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
