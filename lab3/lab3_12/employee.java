package lab3.lab3_12;

public class employee {
    private String name;
    private double monthlysalary;

    public employee(String name, double monthlysalary) {
        this.name = name;
        if (monthlysalary > 0) {
            this.monthlysalary = monthlysalary;
        } else {
            this.monthlysalary = 0;
        }
    }

    public String getname() {
        return name;
    }

    public void giveraise(double amount) {
        if (amount > 0) {
            monthlysalary += amount;
            System.out.println("Raise applied.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private double getannualsalary() {
        return monthlysalary * 12;
    }

    public double calculatetax(double taxrate) {
        return getannualsalary() * taxrate;
    }
}
