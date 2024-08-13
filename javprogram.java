import java.util.ArrayList;
import java.util.List;

class BankAccount {
    protected String accountHolderName;
    protected int accountNumber;
    protected double balance;

    public BankAccount(String name, int number, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = number;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + " to account number: " + accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + " from account number: " + accountNumber);
        } else {
            System.out.println("Insufficient balance in account number: " + accountNumber);
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String name, int number, double initialBalance, double rate) {
        super(name, number, initialBalance);
        this.interestRate = rate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of $" + interest + " applied to account number: " + accountNumber);
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String name, int number, double initialBalance, double overdraft) {
        super(name, number, initialBalance);
        this.overdraftLimit = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + " from account number: " + accountNumber);
        } else {
            System.out.println("Exceeded overdraft limit for account number: " + accountNumber);
        }
    }
}

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            account.displayBalance();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        Bank bank = new Bank();

        BankAccount savings = new SavingsAccount("Alice", 1001, 5000.0, 2.5);
        BankAccount checking = new CheckingAccount("Bob", 1002, 2000.0, 500.0);

        bank.addAccount(savings);
        bank.addAccount(checking);

        savings.deposit(1000.0);
        ((SavingsAccount) savings).applyInterest();
        savings.withdraw(3000.0);

        checking.withdraw(2500.0);
        checking.deposit(500.0);

        bank.displayAllAccounts();
    }
}
