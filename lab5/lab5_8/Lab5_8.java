package Lab_5.Lab5_8;

import java.util.Scanner;

class Person {
    protected final String name;

    public Person(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public String getStatus() {
        return "Person: " + this.name;
    }
}

class Student extends Person {
    protected final int studentId;

    public Student(String name, int studentId) {
        super(name);
        this.studentId = studentId;
    }

    @Override
    public String getStatus() {
        return "Student: " + this.name + ", ID: " + this.studentId;
    }
}

class Employee extends Person {
    protected double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public void applyBonus(double bonus) {
        this.salary += bonus;
    }

    @Override
    public String getStatus() {
        return "Employee: " + this.name + ", Salary: " + this.salary;
    }
}

public class Lab5_8 {
    private static String readNonEmptyLine(Scanner sc, String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = sc.nextLine();
            if (value != null) value = value.trim();
        } while (value == null || value.isEmpty());
        return value;
    }

    private static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int v = sc.nextInt();
                sc.nextLine();
                if (v > 0) return v;
            } else {
                sc.nextLine();
            }
        }
    }

    private static double readNonNegativeDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                double v = sc.nextDouble();
                sc.nextLine();
                if (v >= 0.0) return v;
            } else {
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String sName = readNonEmptyLine(input, "Enter Student Name: ");
        int sId = readPositiveInt(input, "Enter Student ID (positive integer): ");

        String eName = readNonEmptyLine(input, "Enter Employee Name: ");
        double eSalary = readNonNegativeDouble(input, "Enter Employee Salary (non-negative): ");

        Student student = new Student(sName, sId);
        Employee employee = new Employee(eName, eSalary);

        Person[] people = { student, employee };

        for (Person p : people) {
            if (p instanceof Employee) {
                ((Employee) p).applyBonus(1000.0);
            }
        }

        for (Person p : people) {
            System.out.println(p.getStatus());
        }

        input.close();
    }
}
