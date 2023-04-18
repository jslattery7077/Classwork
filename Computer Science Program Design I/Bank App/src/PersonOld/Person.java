package PersonOld;


public class Person {
    // Person Starter Variables

    // Constants
    private final int AVG_LIFESPAN = 100;
    public final Builder.Validator validate;
    //

    // Strings
    private String firstName;
    private String lastName;
    private String hairColor;
    private String eyeColor;
    //

    // Integers
    private int currentAge;
    //

    // Doubles
    private double weight;
    private double height;
    //

    // Boolean
    private boolean glasses;
    private boolean deaf;
    private boolean blind;
    private boolean deceased;
    private boolean married;
    //

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (validate.FirstName(firstName)) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (validate.LastName(lastName)) {
            this.lastName = lastName;
        }

    }

    public String getHairColor() {
        return hairColor;
    }

    public boolean setHairColor(String hairColor) {
        if (validate.LastName(hairColor)) {
            this.hairColor = hairColor;
            return true;
        }
        return false;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean setEyeColor(String eyeColor) {
        if (validate.EyeColor(eyeColor)) {
            this.eyeColor = eyeColor;
            return true;
        }
        return false;

    }

    public int getCurrentAge() {
        return currentAge;
    }

    public boolean setCurrentAge(int currentAge) {
        if (validate.CurrentAge(currentAge)) {
            this.currentAge = currentAge;
            return true;
        }
        return false;

    }

    public double getWeight() {
        return weight;
    }

    public boolean setWeight(double weight) {
        if (validate.Weight(weight)) {
            this.weight = weight;
            return true;
        }
        return false;
    }

    public double getHeight() {
        return height;
    }

    public boolean setHeight(double height) {
        if (validate.Height(height)) {
            this.height = height;
            return true;
        }
        return false;

    }

    public boolean isGlasses() {
        return glasses;
    }

    public void setGlasses(boolean glasses) {
        this.glasses = glasses;

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

    public Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.hairColor = builder.hairColor;
        this.eyeColor = builder.eyeColor;
        this.currentAge = builder.currentAge;
        this.weight = builder.weight;
        this.height = builder.height;
        this.glasses = builder.glasses;
        this.deaf = builder.deaf;
        this.blind = builder.blind;
        this.deceased = builder.deceased;
        this.married = builder.married;
        this.validate = builder.Validate;
    }
    // Builder
    public static class Builder {
        // Starter Variables

        // Strings
        private String firstName;
        private String lastName;
        private String hairColor;
        private String eyeColor;
        //

        // Integers
        private int currentAge;
        //

        // Doubles
        private double weight;
        private double height;
        //

        // Boolean
        private boolean glasses;
        private boolean deaf;
        private boolean blind;
        private boolean deceased;
        private boolean married;

        // Misc.
        private String[] hairTypes = {"green", "red", "pink", "blue"};
        private String[] eyeTypes = {"black", "brown", "blue", "green", "red"};
        Validator Validate = new Builder.Validator(hairTypes, eyeTypes);

        public Builder(String firstName, String lastName, int currentAge) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.currentAge = currentAge;
        }

        // Builders
        public Builder HairColor(String hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder EyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder Weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder Height(double height) {
            this.height = height;
            return this;
        }

        public Builder Glasses(boolean glasses) {
            this.glasses = glasses;
            return this;
        }

        public Builder Deaf(boolean deaf) {
            this.deaf = deaf;
            return this;
        }

        public Builder Blind(boolean blind) {
            this.blind = blind;
            return this;
        }

        public Builder Deceased(boolean deceased) {
            this.deceased = deceased;
            return this;
        }

        public Builder Married(boolean married) {
            this.married = married;
            return this;
        }

        public Builder HairTypes(String[] hairTypes) {
            this.hairTypes = hairTypes;
            return this;
        }

        public Builder EyeTypes(String[] eyeTypes) {
            this.eyeTypes = eyeTypes;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

        public Person.Builder start(String firstName, String lastName, int currentAge){
            this.firstName = firstName;
            this.lastName = lastName;
            this.currentAge = currentAge;
            return this;
        }

        public static class Validator {
            public String[] hairTypes;
            public String[] eyeTypes;
            public Validator(String[] hairTypes, String[] eyeTypes) {
                this.hairTypes = hairTypes;
                this.eyeTypes = eyeTypes;
            }

            public boolean FirstName(String i) {
                return i.length() < 25;
            }

            public boolean LastName(String i) {
                return i.length() < 25;
            }

            public boolean HairColor(String i) {
                for (String hairType: this.hairTypes) {
                    if (i.equals(hairType)) {
                        return true;
                    }
                }
                return false;
            }

            public boolean EyeColor(String i) {
                for (String eyeType: this.eyeTypes) {
                    if (i.equals(eyeType)) {
                        return true;
                    }
                }
                return false;
            }

            public boolean CurrentAge(int i) {
                return i >= 0;
            }

            public boolean Weight(double i) {
                return !(i < 0);
            }

            public boolean Height(double i) {
                return !(i < 0);
            }
        }
    }

    public boolean age(int years) {
        if (years < AVG_LIFESPAN) {
            this.currentAge += years;
        } else {
            deceased = true;
            currentAge = -1;
            return false;
        }
        return true;
    }

    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", currentAge=" + currentAge +
                ", weight=" + weight +
                ", height=" + height +
                ", glasses=" + glasses +
                ", deaf=" + deaf +
                ", blind=" + blind +
                ", deceased=" + deceased +
                ", married=" + married +
                '}';
    }
}