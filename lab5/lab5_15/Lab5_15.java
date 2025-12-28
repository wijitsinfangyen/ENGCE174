package Lab_5.Lab5_15;

import java.util.Locale;
import java.util.Scanner;

class RentalVehicle {
    protected String model;
    protected double rentalRate;
    public RentalVehicle(String model, double rentalRate) {
        this.model = model;
        this.rentalRate = rentalRate;
    }
    public double calculateFee() {
        return rentalRate;
    }
}

class Car extends RentalVehicle {
    public Car(String model, double rentalRate) {
        super(model, rentalRate);
    }
    @Override
    public double calculateFee() {
        return rentalRate + 100.0;
    }
}

class Motorcycle extends RentalVehicle {
    public Motorcycle(String model, double rentalRate) {
        super(model, rentalRate);
    }
    @Override
    public double calculateFee() {
        return rentalRate * 1.10;
    }
}

public class Lab5_15 {
    private static String readNonEmptyString(Scanner sc, String prompt) {
        String s;
        while (true) {
            System.out.print(prompt);
            s = sc.nextLine().trim();
            if (!s.isEmpty()) break;
            System.out.println("Input cannot be empty. Please try again.");
        }
        return s;
    }

    private static double readNonNegativeDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line);
                if (v < 0) {
                    System.out.println("Rate must be non-negative. Please try again.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric rate.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        String cModel = readNonEmptyString(input, "Enter Car Model: ");
        double cRate = readNonNegativeDouble(input, "Enter Car Rental Rate: ");
        String mModel = readNonEmptyString(input, "Enter Motorcycle Model: ");
        double mRate = readNonNegativeDouble(input, "Enter Motorcycle Rental Rate: ");

        Car car = new Car(cModel, cRate);
        Motorcycle moto = new Motorcycle(mModel, mRate);

        RentalVehicle[] vehicles = { car, moto };

        double totalFee = 0.0;
        for (RentalVehicle v : vehicles) {
            totalFee += v.calculateFee();
        }

        System.out.println(totalFee);

        input.close();
    }
}
