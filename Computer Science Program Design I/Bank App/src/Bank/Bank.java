package Bank;

import Person.Person;
import Person.PersonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.random.RandomGenerator;

public class Bank {
    public final PersonBuilder pc = new PersonBuilder(); // Person Creator
    private final AccountCreator ac = new AccountCreator(); // Account Creator
    private final ArrayList<Account> accounts = new ArrayList<Account>();
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    private final LocalDate localDate = LocalDate.now();
    private Account lastAccountCreated;

    // Constructors
    public Bank() {
        load();
    }

    private static int generateAccountNumber() {
        return RandomGenerator.getDefault().nextInt(867000000, 867999999);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void load() {
        try {

            JSONParser jsonParser = new JSONParser();
            // if no file make a new one
            if (!new File("accounts.json").exists()) {
                FileWriter file = new FileWriter("./accounts.json");
                file.write("{}");
                file.flush();
                file.close();
            }
            FileReader reader = new FileReader("./accounts.json");
            JSONObject accountMaps = (JSONObject) jsonParser.parse(reader);

            for (Object i : accountMaps.values()) {
                HashMap<String, Object> curAcct = (HashMap<String, Object>) i;
                HashMap<String, Object> curPerson = (HashMap<String, Object>) curAcct.get("accountHolder");
                Person newPerson =
                        pc.create((String) curPerson.get("firstName"), (String) curPerson.get("lastName"), 12)// (int) curPerson.get("currentAge")
                                .Deaf((boolean) curPerson.get("isDeaf"))
                                .Blind((boolean) curPerson.get("isBlind"))
                                .Married((boolean) curPerson.get("isMarried"))
                                .Deceased((boolean) curPerson.get("isDeceased")).build();
                Long acctNum = (Long) curAcct.get("accountNumber");
                if ((boolean) curAcct.get("isSavingsAccount")) {
                    Account newAccount =
                            ac.createSavingsAccount(newPerson, (String) curAcct.get("password"), ((Long) curAcct.get("accountNumber")).intValue(), (String) curAcct.get("dateCreated"))
                                    .SavingsAccount((boolean) curAcct.get("isSavingsAccount"))
                                    .CurrentBalance((double) curAcct.get("currentBalance"))
                                    .WithdrawLimit((double) curAcct.get("withdrawLimit"))
                                    .AccountOnHold((boolean) curAcct.get("accountOnHold"))
                                    .HoldReason((String) curAcct.get("holdReason"))
                                    .build();
                    accounts.add(newAccount);
                } else {
                    Account newAccount =
                            ac.createCheckingAccount(newPerson, (String) curAcct.get("password"), ((Long) curAcct.get("accountNumber")).intValue(), (String) curAcct.get("dateCreated"))
                                    .SavingsAccount((boolean) curAcct.get("isSavingsAccount"))
                                    .CurrentBalance((double) curAcct.get("currentBalance"))
                                    .WithdrawLimit((double) curAcct.get("withdrawLimit"))
                                    .AccountOnHold((boolean) curAcct.get("accountOnHold"))
                                    .HoldReason((String) curAcct.get("holdReason"))
                                    .build();
                    accounts.add(newAccount);
                }
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error occurred ");
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

    public void save() {
        JSONObject accountMaps = new JSONObject();
        for (Account i : accounts) {
            HashMap<String, Object> accountMap = new HashMap<>();
            accountMap.put("accountNumber", i.getAccountNumber());
            accountMap.put("dateCreated", i.getDateCreated());
            accountMap.put("isSavingsAccount", i.isSavingsAccount());
            accountMap.put("currentBalance", i.getCurrentBalance());
            accountMap.put("withdrawLimit", i.getWithdrawLimit());
            accountMap.put("accountOnHold", i.isAccountOnHold());
            accountMap.put("holdReason", i.getHoldReason());
            accountMap.put("password", i.getPassword());


            // Adds Person To Bank Save
            HashMap<String, Object> personMap = new HashMap<>();
            personMap.put("firstName", i.getAccountHolder().getFirstName());
            personMap.put("lastName", i.getAccountHolder().getLastName());
            personMap.put("currentAge", i.getAccountHolder().getCurrentAge());
            personMap.put("isDeaf", i.getAccountHolder().isDeaf());
            personMap.put("isBlind", i.getAccountHolder().isBlind());
            personMap.put("isDeceased", i.getAccountHolder().isDeceased());
            personMap.put("isMarried", i.getAccountHolder().isMarried());

            accountMap.put("accountHolder", personMap);

            accountMaps.put(String.valueOf(i.getAccountNumber()), accountMap);
        }

        try {
            if (!new File("./accounts.json").exists()) {
                FileWriter file = new FileWriter("./accounts.json");
                file.write("{}");
                file.flush();
                file.close();
            } else {
                FileWriter file = new FileWriter("./accounts.json");
                file.write(accountMaps.toJSONString());
                file.flush();
                file.close();
                System.out.println("JSON file updated: " + accountMaps);
            }
        } catch (IOException e) {
            System.out.println("Error occurred ");
            e.printStackTrace();
        }
    }

    public void accountsToString() {
        for (Account i : accounts) {
            System.out.println(i);
        }
    }

    private int checkAccount(int accountNumber, int maxAttempts) {
        if (accounts.size() > 0) {
            for (Account i : accounts) {
                if (i.getAccountNumber() == accountNumber) {
                    int newAccountNumber = RandomGenerator.getDefault().nextInt(867000000, 867999999);
                    return checkAccount(newAccountNumber, maxAttempts);
                }
            }
        }
        return accountNumber;
    }

    public AccountCreator createAccount(Person accountHolder, String password, char accountType) {
        int accountNumber = checkAccount(generateAccountNumber(), 10);
        if (accountType == 's') {
            return ac.createSavingsAccount(accountHolder, password, accountNumber, getDate()).SavingsAccount(true);
        } else
            return ac.createCheckingAccount(accountHolder, password, accountNumber, getDate());


    }

    public boolean addAccount(Account account) {
        if (account == ac.getLastAccountCreated()) {
            accounts.add(account);
            return true;
        } else {
            throw new SecurityException("Account wasn't the last account made with the account creator");
        }
    }

    public Account findAccount(int accountNumber, String password) {
        for (Account i : accounts) {
            if (i.getAccountNumber() == accountNumber && i.getPassword().equals(password)) {
                return i;
            }
        }
        return null;
    }

    public String getDate() {
        return dtf.format(localDate);
    }

    @Override
    public String toString() {
        return "BankApp{" +
                "accounts=" + accounts +
                '}';
    }
}
