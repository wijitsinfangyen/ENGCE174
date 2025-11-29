package lab2.lab2_6;

import java.util.Scanner;

public class lab2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();      
        double initial = sc.nextDouble(); 
        double depositAmount = sc.nextDouble(); 

        BankAccount acc = new BankAccount(name, initial);

        acc.deposit(depositAmount); 
        acc.displaySummary();        
    }
}
