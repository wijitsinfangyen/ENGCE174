package Lab_5.Lab5_3;

import java.util.Scanner;

class Employee {
    protected double salary;

    public double calculateBonus() {
        return this.salary * 0.10;
    }
}

class Manager extends Employee {
    @Override
    public double calculateBonus() {
        return super.calculateBonus() + (this.salary * 0.05);
    }
}

public class Lab5_3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double inputSalary = readValidSalary(input);
        Manager myManager = new Manager();
        myManager.salary = inputSalary;
        System.out.println(myManager.calculateBonus());
        input.close();
    }

    private static double readValidSalary(Scanner input) {
        while (true) {
            System.out.print("Enter Salary: ");
            if (!input.hasNextDouble()) {
                input.next();
                continue;
            }
            double value = input.nextDouble();
            if (Double.isNaN(value) || Double.isInfinite(value) || value < 0.0) {
                continue;
            }
            return value;
        }
    }
}
