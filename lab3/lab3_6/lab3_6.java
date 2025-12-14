package lab3.lab3_6;

import java.util.Scanner;

public class lab3_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double initial = sc.nextDouble();  
        double deposit = sc.nextDouble();  
        double withdraw = sc.nextDouble(); 

        BankAccount acc = new BankAccount(initial);

        acc.deposit(deposit);
        acc.withdraw(withdraw);

        System.out.println("Final Balance: " + acc.getBalance());
    }
}
