package lab3.lab3_14;

import java.util.Scanner;

public class lab3_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bankaccount myaccount = null;

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String cmd = sc.nextLine();

            if (cmd.equals("CREATE")) {
                double init = sc.nextDouble();
                sc.nextLine();
                myaccount = new bankaccount(init);
            } 
            else if (cmd.equals("DEPOSIT")) {
                double amt = sc.nextDouble();
                sc.nextLine();
                if (myaccount == null) {
                    System.out.println("No account exists.");
                } else {
                    myaccount.deposit(amt);
                }
            } 
            else if (cmd.equals("WITHDRAW")) {
                double amt = sc.nextDouble();
                sc.nextLine();
                if (myaccount == null) {
                    System.out.println("No account exists.");
                } else {
                    myaccount.withdraw(amt);
                }
            } 
            else if (cmd.equals("STATUS")) {
                if (myaccount == null) {
                    System.out.println("No account exists.");
                } else {
                    System.out.println("Balance: " + myaccount.getbalance());
                }
            } 
            else if (cmd.equals("GLOBAL_STATUS")) {
                System.out.println("Total Transactions: " + bankaccount.gettotaltransactioncount());
            }
        }
    }
}
