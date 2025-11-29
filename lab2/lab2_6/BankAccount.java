package lab2.lab2_6;

public class BankAccount {
    String ownerName;
    double balance;

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;   
    }

    void displaySummary() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: " + balance);
    }
}
