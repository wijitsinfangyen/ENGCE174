package lab2.lab2_7;

import java.util.Scanner;

public class lab2_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();       
        double initial = sc.nextDouble();    
        double withdraw1 = sc.nextDouble(); 
        double withdraw2 = sc.nextDouble();  

        BankAccount acc = new BankAccount(name, initial);

        acc.withdraw(withdraw1);  
        acc.withdraw(withdraw2);  
        acc.displayBalance();    
    }
}
