package Assignment1PleunScholten;

/**
 * A group is a group of Students.
 * @author Pleun Scholten | s4822250
 * @author Christian Lammers | s...
 */
public class Group {
    private Student[] group;
    
    /**
     * Constructor function for a group.
     * @param size the size of the group.
     */
    public Group(int size) {
        group = new Student[size];
    }
    
    /**
     * Returns the length of the group.
     * @return length of the group.
     */
    public int length() {
        return group.length;
    }
    
    /**
     * Getter function for the group.
     * @return group
     */
    public Student[] getGroup() {
        return group;
    }
    
    /**
     * Returns a Student at position index from group.
     * @param index
     * @return Student at index.
     */
    public Student getStudent(int index) {
        return group[index];
    }
    
    /**
     * Sets the Student at position index in group to s.
     * @param index
     * @param student Student
     */
    public void changeGroup(int index, Student student) {
        group[index] = student;
    }
    
    /**
     * Returns the string version of a group in the format:
     * 
     * The group now contains:
     * s1FirstName s1LastName s1StudentNumber
     * s2...
     * sNFirstName sNLastName sNStudentNumber
     * @return 
     */
    @Override
    public String toString() {
        String string = "\nThe group now contains:\n";
        for (Student s : group) {
            string += s.toString()+"\n";
        }
        return string;
    }
    
    /**
     * Returns the Student that matches the studentNumber given in group. 
     * Returns null if no match is found.
     * @param studentNumber
     * @return Student with studentNumber studentNumber, or null if no match is found.
     */
    public Student findStudent(int studentNumber) {
        for (Student s : group) {
            if (s.getStudentNumber() == studentNumber) {
                return s;
            }
        }
        //No student has been found.
        return null;
    }
}
