package lab2.lab2_7;

public class BankAccount {
    String ownerName;
    double balance;

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}
