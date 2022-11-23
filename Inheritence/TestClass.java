import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
        Person p1 = new Person("Albert", "123 Fake St", "123-456-7890");
        String[] courses = {"ICS4UI", "SCH4UI", "LUNCH", "MDM4UI", "AMU4UI"};
        Student s1 = new Student("Eliza", "543 Evergreen Ter.", "867-5309", 12345, courses);
        Person p2 = new Person("Bob", "1234 address St", "986-2345");
        Student s2 = new Student("Leanne", "145 South St", "987-654-3214", 15432, courses);
        
        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(s1);
        people.add(s2);

        

        for(Person p: people){
            System.out.println(p);
            System.out.println();
        }
    }
}
