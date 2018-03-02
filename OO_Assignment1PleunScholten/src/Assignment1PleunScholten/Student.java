package Assignment1PleunScholten;

/**
 * Student class of assignment 1.
 * @author Pleun Scholten | s4822250
 * @author Christian Lammers | s...
 */
public class Student {
    private String firstName;
    private String lastName;
    private int studentNumber;
    
    /**
     * Constructor function which sets all attributes.
     * @param firstName
     * @param lastName
     * @param studentNumber 
     */
    public Student(String firstName, String lastName, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }
    
    /**
     * Constructor function without initialization.
     */
    public Student() {
        
    }
    
    /**
     * Setter function for the firstName attribute.
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Setter function for the lastName attribute
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Setter function for the studentNumber attribute.
     * @param studentNumber 
     */
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    /**
     * Getter function for firstName attribute.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Getter function for lastName attribute.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Getter function for studentNumber attribute.
     * @return studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }
    
    /**
     * Returns a string version of the Student in the format:
     * firstName lastName: sNumber
     * @return string of the Student.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + ": s"+studentNumber;  
    }
}
