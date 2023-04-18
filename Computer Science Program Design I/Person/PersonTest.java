package Person;

public class PersonTest {
    public static void main(String[] args) {
        PersonBuilder person = new PersonBuilder();

        Person john = person.create("John", "Slattery", 19).Married(true).build();
        System.out.println(john.getFirstName());
        System.out.println(john.isMarried());

        Person jack = person.create("Jack", "Walk", 19).Blind(true).build();


        System.out.println(jack);
        System.out.println(john);

    }
}
