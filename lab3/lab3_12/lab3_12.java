package lab3.lab3_12;

import java.util.Scanner;

public class lab3_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        double monthlysalary = sc.nextDouble();
        double taxrate = sc.nextDouble();
        double raiseamount = sc.nextDouble();

        employee emp = new employee(name, monthlysalary);

        System.out.println(emp.calculatetax(taxrate));
        emp.giveraise(raiseamount);
        System.out.println(emp.calculatetax(taxrate));
    }
}