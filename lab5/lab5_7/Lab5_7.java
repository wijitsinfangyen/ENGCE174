package Lab_5.Lab5_7;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

class Employee {
    protected String name;
    protected double baseSalary;
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public double calculatePay() {
        return baseSalary;
    }
}

class SalesEmployee extends Employee {
    protected double commissionRate;
    public SalesEmployee(String name, double baseSalary, double commissionRate) {
        super(name, baseSalary);
        this.commissionRate = commissionRate;
    }
    @Override
    public double calculatePay() {
        return baseSalary + (baseSalary * commissionRate);
    }
}

class Manager extends Employee {
    protected double fixedBonus;
    public Manager(String name, double baseSalary, double fixedBonus) {
        super(name, baseSalary);
        this.fixedBonus = fixedBonus;
    }
    @Override
    public double calculatePay() {
        return baseSalary + fixedBonus;
    }
}

class PayrollProcessor {
    private static final DecimalFormat DF = new DecimalFormat("#,##0.00");
    public static void process(Employee e) {
        System.out.println(e.name + " total pay: " + DF.format(e.calculatePay()));
    }
}

public class Lab5_7 {
    private static String readNonEmptyString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    private static double readPositiveDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v > 0) return v;
                System.out.println("Value must be greater than 0.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number.");
            }
        }
    }

    private static double readDoubleInRange(Scanner sc, String prompt, double minInclusive, double maxInclusive) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v >= minInclusive && v <= maxInclusive) return v;
                System.out.println("Value must be between " + minInclusive + " and " + maxInclusive + ".");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number.");
            }
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        String sName = readNonEmptyString(input, "Enter Sales Employee Name: ");
        double sSalary = readPositiveDouble(input, "Enter Base Salary: ");
        double sRate = readDoubleInRange(input, "Enter Commission Rate (0-1): ", 0.0, 1.0);

        String mName = readNonEmptyString(input, "Enter Manager Name: ");
        double mSalary = readPositiveDouble(input, "Enter Base Salary: ");
        double mBonus = readDoubleInRange(input, "Enter Fixed Bonus (>=0): ", 0.0, Double.MAX_VALUE);

        SalesEmployee salesEmp = new SalesEmployee(sName, sSalary, sRate);
        Manager manager = new Manager(mName, mSalary, mBonus);

        PayrollProcessor.process(salesEmp);
        PayrollProcessor.process(manager);

        input.close();
    }
}
