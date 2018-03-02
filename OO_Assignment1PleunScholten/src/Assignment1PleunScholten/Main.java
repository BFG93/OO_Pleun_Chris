package Assignment1PleunScholten;

import java.util.Scanner;

/**
 * Main running class of assignment 1.
 * @author Pleun Scholten | s4822250
 * @author Christian Lammers | s...
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Group group = createGroup(scanner);
        fillStudentArray(scanner, group); 
        System.out.println(group.toString());
        userInterface(scanner, group);
    }
    
    private static void userInterface(Scanner scanner, Group group) {
        boolean stop = false;
        while(!stop) {
            System.out.println("Please enter the student number of the student who's name you would like to change.");
            int studentNumber = getIntFromInput(scanner);
            //Exit the program.
            if(studentNumber < 0) {
                stop = true;
                System.out.println("See ya!");
            }
            else {
                //Find the student given the student number.
                Student student = group.findStudent(studentNumber);
                if(student != null) {
                    //Ask user for first and second name again.
                    System.out.printf("Please enter the first name of the student with number s%d:%n",studentNumber);
                    student.setFirstName(scanner.nextLine());
                    System.out.printf("Please enter the last name of the student with number s%d:%n",studentNumber);
                    student.setLastName(scanner.nextLine());
                    //Then show the group again.
                    System.out.println(group.toString());
                }
                else {
                    //Display error message.
                    System.out.printf("No student found with numer %d!%n",studentNumber);
                }
            }
        }
    }
    
    /**
     * Fills the students array with inputs from the user. 
     * @param scanner user input
     * @param students array
     */
    private static void fillStudentArray(Scanner scanner, Group group) {
        int index = 0;
        while (index < group.length() && group.getStudent(index) == null) {
            //Initialize the Student object.
            Student s = new Student();
            //Index + 1 is used to make the numbers 'logical' in speaking language, so start counting from 1.
            System.out.printf("For student %d, please enter the first name. %n",index +1);
            s.setFirstName(scanner.nextLine());
            System.out.printf("For student %d, please enter the last name. %n",index +1);
            s.setLastName(scanner.nextLine());   
            System.out.printf("For student %d, please enter the student number. %n",index +1);
            s.setStudentNumber(getIntFromInput(scanner));
            //Change from null to s.
            group.changeGroup(index, s);
            index++;
        }        
    }
    
    /**
     * Asks user for an integer, checks legality of that number and creates an
     * empty Student array with the size given by the user. 
     * @param scanner
     * @return Group with user-determined size.
     */
    private static Group createGroup(Scanner scanner) {
        System.out.println("Please enter the number of students.");
        int size = getIntFromInput(scanner);
        return new Group(size);
    }
    
    /**
     * Returns a non-negative int from a user-inputted String.
     * @param scanner User Input
     * @return int from user-inputted String.
     */
    private static int getIntFromInput(Scanner scanner) {
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
