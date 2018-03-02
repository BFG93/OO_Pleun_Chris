package oo_assignment3pleunchris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250
 */
public class OO_Assignment3PleunChris {

    private static final int MAX_SHAPES = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Console console = new Console();
        Geometric[] shapes = new Geometric[MAX_SHAPES];
//        ArrayList<Geometric> shapes = new ArrayList<>();
        userInterface(console, shapes);
    }

    /**
     * The main user interface command line loop. 
     * @param console IO object
     * @param shapes 
     */
    private static void userInterface(Console console, Geometric[] shapes) {
        Pattern p = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)"); //Regex for doubles (inlcuding e.g. '5' as 5.0, '5.' as 5.0 and '.5' as 0.5
        boolean stop = false;
        while (!stop) {
            console.println("Enter input command: quit, show, circle<x><y><r>, rectangle <x><y><h><w>, move<i><dx><dy>, remove<i>");
            String input = console.getNextLine();
            //Used for getting the doubles from the string.
            Matcher m = p.matcher(input);
            ArrayList<Double> inputs = new ArrayList<>();
            while(m.find())
                inputs.add(Double.parseDouble(m.group(1)));
            
            //Get the command from the input
            String[] commands = input.split(" ");
            int index = findFree(shapes);
            switch (commands[0]) {
                case "quit":
                    stop = true;
                    break;
                case "show":
                    console.printArray(shapes);
                    break;
                case "circle":
                    if(index!=shapes.length)
                        shapes[index] = new Circle(inputs.get(0),inputs.get(1),inputs.get(2));
                    else
                        console.println("Array is full.");
                    break;
                case "rectangle":
                    if(index!=shapes.length)
                        shapes[index] = new Rectangle(inputs.get(0),inputs.get(1),inputs.get(2),inputs.get(3));
                    else
                        console.println("Array is full.");
                    break;
                case "move":
                    int im = inputs.get(0).intValue();
                    if(shapes[im]!=null)
                        shapes[im].move(inputs.get(1), inputs.get(2));
                    else 
                        console.println("No element found at index "+im);
                    break;
                case "remove":
                    int ir = inputs.get(0).intValue();
//                    shapes[ir] = null;
                    shiftArray(shapes, ir);
                    break; 
                case "sort":
                    if(commands.length == 1)
                        Arrays.sort(shapes, 0, index);
                    else if(commands[1].equals("x")) {
                        XComparator xc = new XComparator();
                        Arrays.sort(shapes, 0, index, xc);
                    }
                    else if(commands[1].equals("y")) {
                        YComparator yc = new YComparator();
                        Arrays.sort(shapes, 0, index, yc);
                    }
                    else
                        console.print("Invalid input.");
                    break;
                default:
                    console.println("Invalid input.");
            }
            inputs.clear();
        }
    }
    
    /**
     * Finds the first free spot in the given array. 
     * @param array Generic array
     * @return index of the first free spot, or array.length if the array is full.
     */
    private static <T extends Comparable<T>> int findFree(T[] array) {
        for(int i=0;i<array.length;i++)
            if (array[i] == null)
                return i;
        return array.length;
    }
    
    /**
     * Shifts all elements in the array to the left from a specified index
     * @param array
     * @param index of the null position.
     */
    private static <T extends Comparable<T>> void shiftArray(T[] array, int index) {
        for(int i = index; i<array.length-1; i++)
            array[i] = array[i+1];
        array[array.length-1] = null;
    }
}
