package Lab_4.Lab4_9;

import java.util.Scanner;

class ImmutableAccount {
    private final String accountId;
    private final double balance;

    public ImmutableAccount(String accountId, double balance) {
        this.accountId = accountId;
        if (balance < 0) {
            this.balance = 0.0;
        } else {
            this.balance = balance;
        }
    }

    public ImmutableAccount(ImmutableAccount other) {
        this.accountId = other.accountId;
        this.balance = other.balance;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public double getBalance() {
        return this.balance;
    }

    public ImmutableAccount deposit(double amount) {
        if (amount > 0) {
            return new ImmutableAccount(this.accountId, this.balance + amount);
        } else {
            System.out.println("Invalid deposit amount.");
            return this;
        }
    }

    public ImmutableAccount withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return this;
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds.");
            return this;
        } else {
            return new ImmutableAccount(this.accountId, this.balance - amount);
        }
    }

    public void displayInfo() {
        System.out.println("ID: " + this.accountId + ", Balance: " + this.balance);
    }
}

public class Lab4_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Account ID: ");
        String id = input.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initial = input.nextDouble();

        System.out.print("Enter Deposit Amount: ");
        double depositAmt = input.nextDouble();

        System.out.print("Enter Withdraw Amount: ");
        double withdrawAmt = input.nextDouble();

        ImmutableAccount acc1 = new ImmutableAccount(id, initial);
        ImmutableAccount acc2 = acc1.deposit(depositAmt);
        ImmutableAccount acc3 = acc2.withdraw(withdrawAmt);

        acc1.displayInfo();
        acc3.displayInfo();

        input.close();
    }
}