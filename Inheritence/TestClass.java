import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
        Person p1 = new Person("Albert", "123 Fake St", "123-456-7890");
        String[] courses = {"ICS4UI", "SCH4UI", "LUNCH", "MDM4UI", "AMU4UI"};
        Student s1 = new Student("Eliza", "543 Evergreen Ter.", "867-5309", 12345, courses);
        Person p2 = new Person("Bob", "1234 address St", "986-2345");
        Student s2 = new Student("Leanne", "145 South St", "987-654-3214", 15432, courses);
        Telephone t = new Telephone();

       


        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(s1);
        people.add(s2);

        

        for(Person p: people){
            // is the object really a Student
            if(p instanceof Student){
                // casting the object p back to a Student
                Student s = (Student)p;
                // now can call Student methods
                System.out.println(s.getStudentNumber());
            }
            System.out.println(p);
            System.out.println();
        }


        ArrayList<Savable> savables = new ArrayList<>();
        savables.add(p1);
        savables.add(s2);
        savables.add(t);

        for(Savable s: savables){
            s.load("thefile.txt");
        }
    }
}
