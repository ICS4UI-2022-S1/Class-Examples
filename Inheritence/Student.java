import java.util.Arrays;

/**
 * Represents a student within the school
 * @author Mr. A. Lamont
 * @version 1.0
 */
public class Student extends Person {
    private int studentNumber;
    private String[] classes;

    /**
     * Creates a new student
     * @param name The student's name
     * @param address The student's address
     * @param phoneNumber The student's phone number
     * @param studentNumber The student's unique identifier
     * @param classes A list of the classes in a 5 period day
     */
    public Student(String name, String address, String phoneNumber, int studentNumber, String[] classes) {
        // calling the constructor of the super class
        // this gives it the information to store
        super(name, address, phoneNumber);
        this.studentNumber = studentNumber;
        this.classes = classes;
    }

    /**
     * Gets the student's phone number
     * @return The student's phone number
     */
    public int getStudentNumber() {
        return this.studentNumber;
    }

    /**
     * Returns a class for a given period
     * @param period The period of the day starting with period 1
     * @return The class at the given period
     */
    public String getClass(int period) {
        return this.classes[period - 1];
    }

    /**
     * A String representation of a Student
     * @return The String with the information
     */
    public String toString(){
        String output = super.getName() + "\n" + super.getAddress() + "\n" + this.studentNumber + "\n" + Arrays.toString(this.classes);
        return output;
    }
}
