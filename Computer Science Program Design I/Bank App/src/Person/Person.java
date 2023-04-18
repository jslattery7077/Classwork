package Person;

import java.util.Arrays;

public class Person {
    private final int AVG_LIFESPAN = 100;

    private int currentAge;
    private double weight, height;
    private boolean glasses, deaf, blind, deceased, married, isDemoPerson;
    private String firstName, lastName, hairColor, eyeColor;

    private String[] hairColors = {"green", "red", "pink", "blue"};
    private String[] eyeColors = {"black", "brown", "blue", "green", "red"};

// Getter and Setter Methods
    public boolean setCurrentAge(int i) {
        if ( i >= 0 ) {
            currentAge = i;
            return true;
        } else
            return false;
    }

    public int setEyeColor(String i) {
        if ( i != null ) {
            for (String eyeColor : this.eyeColors) {
                if ( i.equalsIgnoreCase(eyeColor) ) {
                    this.eyeColor = i;
                    return 0;
                }
            }
            return 1;
        } else
            return 2;
    }

    public boolean setFirstName(String i) {
        if ( i.length() < 25 ) {
            firstName = i;
            return true;
        } else
            return false;
    }

    public void setGlasses(boolean glasses) {
        this.glasses = glasses;
    }

    public int setHairColor(String i) {
        if ( i != null ) {
            for (String hairColor : this.hairColors) {
                if ( i.equalsIgnoreCase(hairColor) ) {
                    this.hairColor = i;
                    return 0;
                }
            }
            return 1;
        } else
            return 2;
    }

    public boolean setHeight(double i) {
        if ( i >= 0 ) {
            height = i;
            return true;
        } else
            return false;
    }

    public boolean setLastName(String i) {
        if ( i.length() < 25 ) {
            lastName = i;
            return true;
        } else
            return false;
    }

    public boolean setWeight(double i) {
        if ( i >= 0 ) {
            weight = i;
            return true;
        } else
            return false;
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getHairColor() {
        return hairColor;
    }

    public double getHeight() {
        return height;
    }

    public String getLastName() {
        return lastName;
    }

    public double getWeight() {
        return weight;
    }

// Constructors
    public Person(String firstName, String lastName, int currentAge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentAge = currentAge;
    }

    public boolean hasGlasses() {
        return glasses;
    }

    public boolean isDeaf() {
        return deaf;
    }

    public void setDeaf(boolean deaf) {
        this.deaf = deaf;
    }

    public boolean isBlind() {
        return blind;
    }

    public void setBlind(boolean blind) {
        this.blind = blind;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public boolean age(int years) {
        if ( years < AVG_LIFESPAN ) {
            this.currentAge += years;
        } else {
            deceased = true;
            currentAge = -1;
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "currentAge=" + currentAge +
                ", weight=" + weight +
                ", height=" + height +
                ", glasses=" + glasses +
                ", deaf=" + deaf +
                ", blind=" + blind +
                ", deceased=" + deceased +
                ", married=" + married +
                ", isDemoPerson=" + isDemoPerson +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hairColors=" + Arrays.toString(hairColors) +
                ", eyeColors=" + Arrays.toString(eyeColors) +
                '}';
    }
}
