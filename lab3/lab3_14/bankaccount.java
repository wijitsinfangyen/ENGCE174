package lab3.lab3_14;

public class bankaccount {
    private double balance;
    private static int totaltransactioncount = 0;

    public bankaccount(double initialdeposit) {
        if (initialdeposit > 0) {
            balance = initialdeposit;
        } else {
            balance = 0;
        }
        System.out.println("Account created.");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            totaltransactioncount++;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            totaltransactioncount++;
            System.out.println("Withdrawal successful.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public double getbalance() {
        return balance;
    }

    public static int gettotaltransactioncount() {
        return totaltransactioncount;
    }
}
