package Bank;

import Person.Person;

public class AccountCreator {
    private Account account, lastAccount;

    private int accountNumber, consecutiveDeposits, numberOfWithdrawals;
    private double currentBalance, withdrawLimit, cashWithdrew;
    private boolean hasFunds, isSavingsAccount, accountOnHold;
    private String password, holdReason, dateCreated;
    private Person accountHolder;

    // Getter and Setter Methods
    // Constructors
    public AccountCreator() {
        this.account = null;
    }

    // Methods
    public AccountCreator AccountHolder(Person i) {
        this.accountHolder = i;
        return this;
    }

    public AccountCreator CashWithdrew(double i) {
        this.cashWithdrew = i;
        return this;
    }

    public AccountCreator CurrentBalance(double i) {
        this.currentBalance = i;
        return this;
    }

    public AccountCreator SavingsAccount(boolean i) {
        this.isSavingsAccount = i;
        return this;
    }

    public AccountCreator Password(String i) {
        this.password = i;
        return this;
    }

    public AccountCreator AccountOnHold(boolean i) {
        this.accountOnHold = i;
        return this;
    }

    public AccountCreator ConsecutiveDeposits(int i) {
        this.consecutiveDeposits = i;
        return this;
    }

    public AccountCreator HasFunds(boolean i) {
        this.hasFunds = i;
        return this;
    }

    public AccountCreator NumberOfWithdrawals(int i) {
        this.numberOfWithdrawals = i;
        return this;
    }

    public AccountCreator HoldReason(String i) {
        this.holdReason = i;
        return this;
    }

    public AccountCreator WithdrawLimit(double i) {
        this.withdrawLimit = i;
        return this;
    }

    public AccountCreator OnHold(Boolean i) {
        this.accountOnHold = i;
        return this;
    }


    public AccountCreator create(Person accountHolder, String password, int accountNumber, String dateCreated) {
        this.account = new Account(accountHolder, password, accountNumber, dateCreated);
        return this;
    }

    public AccountCreator createSavingsAccount(Person accountHolder, String password, int accountNumber, String dateCreated) {
        this.account = new SavingsAccount(accountHolder, password, accountNumber, dateCreated);
        return this;
    }

    public AccountCreator createCheckingAccount(Person accountHolder, String password, int accountNumber, String dateCreated) {
        this.account = new CheckingAccount(accountHolder, password, accountNumber, dateCreated);
        return this;
    }

    public Account build() {
        lastAccount = this.account;
        setAndCheck(lastAccount);
        return lastAccount;
    }

    public Account getLastAccountCreated() {
        return lastAccount;
    }

    private void setAndCheck(Account account) {
        if (!account.setAccountHolder(account.getAccountHolder()))
            throw new IllegalArgumentException("account Holder is null");
        else if (!account.setPassword(account.getPassword()))
            throw new IllegalArgumentException("Password is null");
        else if (!account.setCurrentBalance(this.currentBalance))
            throw new IllegalArgumentException("Current Balance is null");
        else if (!account.setWithdrawLimit(this.withdrawLimit))
            throw new IllegalArgumentException("Withdraw Limit is null");
        else if (!account.setCashWithDrew(this.cashWithdrew))
            throw new IllegalArgumentException("Cash Withdrew is null");
        else if (account.setConsecutiveDeposits(this.consecutiveDeposits) != 0)
            throw new IllegalArgumentException("Consecutive Deposits is null");
        else if (!account.setNumberOfWithdrawals(this.numberOfWithdrawals))
            throw new IllegalArgumentException("Number of Withdrawals is null");
        else if (!account.setHoldReason(this.holdReason))
            throw new IllegalArgumentException("Hold Reason is null");
        else if (!account.setAccountOnHold(this.accountOnHold))
            throw new IllegalArgumentException("Account On Hold is null");
        else {
            account.setSavingsAccount(this.isSavingsAccount);
        }
        reset();
    }

    public void reset() {
        currentBalance = 0;
        withdrawLimit = 0;
        cashWithdrew = 0;
        hasFunds = false;
        isSavingsAccount = false;
        accountOnHold = false;
        password = null;
        holdReason = null;
        dateCreated = null;
        accountHolder = null;
        account = null;
    }


}
