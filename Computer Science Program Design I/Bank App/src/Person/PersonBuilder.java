package Person;


public class PersonBuilder {

    public Person person;
    public Person lastPerson;
    private int currentAge;
    private double weight, height;
    private boolean glasses, deaf, blind, deceased, married, isDemoPerson;
    private String firstName, lastName, hairColor, eyeColor;

    // Getter and Setter Methods
    // Constructors
    public PersonBuilder() {
        person = null;
    }

    public PersonBuilder FirstName(String i) {
        firstName = i;
        return this;
    }

    public PersonBuilder LastName(String i) {
        lastName = i;
        return this;
    }

    public PersonBuilder HairColor(String i) {
        hairColor = i;
        return this;
    }

    public PersonBuilder EyeColor(String i) {
        eyeColor = i;
        return this;
    }

    public PersonBuilder CurrentAge(int i) {
        currentAge = i;
        return this;
    }

    public PersonBuilder Weight(double i) {
        weight = i;
        return this;
    }

    public PersonBuilder Height(double i) {
        height = i;
        return this;
    }

    public PersonBuilder Glasses(boolean i) {
        glasses = i;
        return this;
    }

    public PersonBuilder Deaf(boolean i) {
        deaf = i;
        return this;
    }

    public PersonBuilder Blind(boolean i) {
        blind = i;
        return this;
    }

    public PersonBuilder Deceased(boolean i) {
        deceased = i;
        return this;
    }

    public PersonBuilder Married(boolean i) {
        married = i;
        return this;
    }

    // Constructor
    public PersonBuilder create(String firstName, String lastName, int currentAge) {
        person = new Person(firstName, lastName, currentAge);
        return this;
    }

    public Person build() {
        if ( person != null && person != lastPerson ) {
            setAndCheck();
            lastPerson = this.person;
            return this.person;
        } else {
            throw new NullPointerException("Must call PersonBuilder.create first");
        }
    }

    public void setAndCheck() {
        if ( !person.setFirstName(person.getFirstName()) || person.getFirstName().isEmpty() )
            throw new NullPointerException("First name is empty");
        else if ( !person.setLastName(person.getLastName()) || person.getLastName().isEmpty() )
            throw new NullPointerException("Last name is empty");
        else if ( !person.setCurrentAge(person.getCurrentAge()) )
            throw new NullPointerException("Current age is invalid");
        else if ( person.setHairColor(this.hairColor) == 1 )
            throw new NullPointerException("Hair color is invalid");
        else if ( person.setEyeColor(this.eyeColor) == 1 )
            throw new NullPointerException("Eye color is invalid");
        else if ( !person.setWeight(this.weight) )
            throw new NullPointerException("Weight is invalid");
        else if ( !person.setHeight(this.height) )
            throw new NullPointerException("Height is invalid");
        else {
            person.setGlasses(this.glasses);
            person.setDeaf(this.deaf);
            person.setBlind(this.blind);
            person.setDeceased(this.deceased);
            person.setMarried(this.married);
        }
    }

}
