package Person;


public class PersonBuilder {

    private int currentAge;
    private double weight, height;
    private boolean glasses, deaf, blind, deceased, married, isDemoPerson;
    private String firstName, lastName, hairColor, eyeColor;
    
    public Person person;
    public Person lastPerson;
    
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

    public boolean setAndCheck(){
        if (!person.setFirstName(person.getFirstName()) || person.getFirstName().isEmpty())
            return false;
         else if (!person.setLastName(person.getLastName()) || person.getLastName().isEmpty())
            return false;
        else if (!person.setCurrentAge(person.getCurrentAge()))
            return false;
        else if (person.setHairColor(this.hairColor) == 1)
            return false;
        else if (person.setEyeColor(this.eyeColor) == 1)
            return false;
        else if (!person.setWeight(this.weight))
            return false;
        else if (!person.setHeight(this.height))
            return false;
        else {
            person.setGlasses(this.glasses);
            person.setDeaf(this.deaf);
            person.setBlind(this.blind);
            person.setDeceased(this.deceased);
            person.setMarried(this.married);
            return true;
        }
    }

    public PersonBuilder create(String firstName, String lastName, int currentAge) {
        person = new Person(firstName, lastName, currentAge);
        return this;
    }

    public Person build() {
        if (person != null && person != lastPerson) {
            boolean validate = setAndCheck();
            if (validate) {
                lastPerson = this.person;
                return this.person;
            } else
                return null;
        } else {
            throw new NullPointerException("Must call PersonBuilder.create first!");
        }
    }

    public PersonBuilder(){
        person = null;
    }

}
