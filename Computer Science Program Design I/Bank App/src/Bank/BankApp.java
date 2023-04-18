package Bank;

import Person.Person;

public class BankApp {
    // Methods

    public static void main(String[] args) {
        Bank bank = new Bank(); // Bank App

//        Person john = bank.pc.create("John", "Slattery", 10).build();
//        Account johnAccount = bank.ac.create(john, "P@ssword1").build();
//        bank.addAccount(johnAccount);
//        System.out.println("John's Account Has been created. Account Number: " + johnAccount.getAccountNumber());
//
//
        Person janko = bank.pc.create("Janko", "User", 7).Blind(true).Married(true).EyeColor("green").build();
//        Account jankoAccount = bank.ac.create(janko, "P@ssword1").SavingsAccount(true).build();
//        bank.addAccount(jankoAccount);
//        System.out.println("Janko's Account Has been created. Account Number: " + jankoAccount.getAccountNumber());
//        bank.accountsToString();

//        Person janks = bank.pc.create("Janks", "User", 7).Blind(true).Married(true).EyeColor("green").build();
//        SavingsAccount janksSavingsAccount = bank.ac.create(janks, "P@ssword1", 123, "10/10/10").SavingsAccount(true).build();
//        //bank.addAccount(jankoAccount);
//        System.out.println("Janko's Account Has been created. Account Number: " + janksSavingsAccount.getAccountNumber());
        Account currentAccount = bank.createAccount(janko, "P@ssword1", 'C').CashWithdrew(0).build();
        if (bank.addAccount(currentAccount)) {
            System.out.println("Account Created Successfully");
        } else {
            System.out.println("Account wasn't made with the creator");
        }

        System.out.printf("Name: %s%nMoney: %f%n", currentAccount.getAccountHolder().getFirstName(), currentAccount.getCurrentBalance());
        currentAccount = bank.createAccount(janko, "P@ssword1", 'S').CashWithdrew(0).build();
        if (bank.addAccount(currentAccount)) {
            System.out.println("Account Created Sucessfully");
        } else {
            System.out.println("Account wasn't made with the creator");
        }
        currentAccount.deposit(109);
        System.out.printf("Name: %s%nMoney: %f%n", currentAccount.getAccountHolder().getFirstName(), currentAccount.getCurrentBalance());
        double currentBal;
        for (int x = 0; x <= 11; x++) {
            for (Account i : bank.getAccounts()) {
                String accountType;
                if (i.isSavingsAccount()) {
                    accountType = "Savings";
                    i.deposit(10);
                } else {
                    accountType = "Checking";
                    i.deposit(10);
                }
                System.out.printf("%s Account %d has a $%1.2f%n", accountType, i.getAccountNumber(), i.getCurrentBalance());
            }
        }


        //bank.save();
    }
}