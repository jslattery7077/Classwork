// @formatter:on
package Bank;

import Person.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class Account {
    private final String dateCreated;
    private final int accountNumber;

    public ArrayList<Character> SPECIAL_CHARACTERS = new ArrayList<Character>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*'));
    private String currentDate, password, holdReason;
    private double currentBalance, withdrawLimit, cashWithdrew;
    private int consecutiveDeposits, numberOfWithdrawals;
    private boolean hasFunds, accountOnHold, isSavingsAccount;
    private Person accountHolder;

    // Getter and Setter Methods

    // Constructors

    public Account(Person accountHolder, String password, int accountNumber, String dateCreated) {
        setAccountHolder(accountHolder);
        this.password = password;
        this.dateCreated = dateCreated;
        this.accountNumber = accountNumber;
    }

    public boolean setAccountOnHold(boolean accountOnHold) {
        this.accountOnHold = accountOnHold;
        return true;
    }

    public boolean setCashWithDrew(double cashWithdrew) {
        if (cashWithdrew >= 0) {
            this.cashWithdrew = cashWithdrew;
            return true;
        } else
            return false;
    }

    public int setConsecutiveDeposits(int ConsecutiveDeposits) {
        if (ConsecutiveDeposits >= 0) {
            this.consecutiveDeposits = ConsecutiveDeposits;
            return 0;
        } else {
            return 1;
        }
    }

    public boolean setCurrentBalance(double currentBalance) {
        if (currentBalance >= 0) {
            this.currentBalance = currentBalance;
            return true;
        } else
            return false;
    }

    public boolean setHasFunds(boolean hasFunds) {
        this.hasFunds = hasFunds;
        return true;
    }

    public boolean setHoldReason(String holdReason) {
        if (holdReason != null) {
            this.holdReason = holdReason;
        } else {
            holdReason = "No reason given";
        }
        return true;
    }

    public boolean setNumberOfWithdrawals(int numberOfWithdrawals) {
        if (numberOfWithdrawals >= 0) {
            this.numberOfWithdrawals = numberOfWithdrawals;
            return true;
        } else {
            return false;
        }
    }

    public boolean setPassword(String password) {
        if (password != null && !password.isEmpty() && checkPassword(password)) {
            this.password = password;
            return true;
        } else
            return false;
    }

    private boolean checkPassword(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (SPECIAL_CHARACTERS.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean setWithdrawLimit(double withdrawLimit) {
        if (withdrawLimit >= 0 && !accountOnHold) {
            this.withdrawLimit = withdrawLimit;
            return true;
        } else
            return false;
    }

    public Person getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getCashWithdrew() {
        return cashWithdrew;
    }

    public int getConsecutiveDeposits() {
        return consecutiveDeposits;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getHoldReason() {
        return holdReason;
    }

    public double getNumberOfWithdrawals() {
        return numberOfWithdrawals;
    }

    public String getPassword() {
        return password;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public boolean isAccountOnHold() {
        return accountOnHold;
    }

    public boolean isSavingsAccount() {
        return isSavingsAccount;
    }

    public void setSavingsAccount(boolean isSavingsAccount) {
        this.isSavingsAccount = isSavingsAccount;
    }

    public boolean setAccountHolder(Person accountHolder) {
        if (accountHolder != null) {
            this.accountHolder = accountHolder;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            return true;
        } else {
            return false;
        }
    }

    public int withdraw(double amount) {
        if (amount > 0) {
            if (withdrawLimit >= (cashWithdrew + amount)) {
                cashWithdrew += amount;
                currentBalance -= amount;
                consecutiveDeposits = 0;
                return 0;
            } else {
                return 2; // Withdraw Limit Reached
            }
        }
        return 1; // Invalid input
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountHolderFirstName=" + accountHolder.getFirstName() +
                ", dateCreated='" + dateCreated + '\'' +
                ", accountNumber=" + accountNumber +
                ", isSavingsAccount=" + isSavingsAccount +
                ", currentDate='" + currentDate + '\'' +
                ", password='" + password + '\'' +
                ", currentBalance=" + currentBalance +
                ", withdrawLimit=" + withdrawLimit +
                ", cashWithdrew=" + cashWithdrew +
                ", hasFunds=" + hasFunds +
                ", accountOnHold=" + accountOnHold +
                ", accountHolder=" + accountHolder +
                '}';
    }
}
