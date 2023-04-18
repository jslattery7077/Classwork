//@formatter:on
package Bank;

import Person.Person;

public class SavingsAccount extends Account {
    // Constructors
    public SavingsAccount(Person accountHolder, String password, int accountNumber, String dateCreated) {
        super(accountHolder, password, accountNumber, dateCreated);
    }

    //
    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            if (getConsecutiveDeposits() % 10 == 0 && getConsecutiveDeposits() != 0) {
                double interest = getCurrentBalance() * 0.2;
                super.deposit(interest); // Savings Interest
                System.out.printf("\tInterest of $%1.2f added to Account #%d%n", interest, getAccountNumber());
            }
            super.deposit(amount);
            setConsecutiveDeposits(getConsecutiveDeposits() + 1);
            return true;
        } else {
            return false;
        }
    }

    public void extraFunction() {
        System.out.println("This is a Savings account");
    }


}
