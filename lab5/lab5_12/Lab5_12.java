package Lab_5.Lab5_12;

import java.util.Scanner;

class Service {
    protected String name;
    protected double basePrice;

    public Service(String name, double basePrice) {
        this.name = name == null ? "" : name.trim();
        this.basePrice = basePrice;
    }

    public double calculateFinalPrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }
}

class BasicService extends Service {
    public BasicService(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double calculateFinalPrice() {
        return basePrice * 1.05;
    }
}

class PremiumService extends Service {
    protected double premiumRate;

    public PremiumService(String name, double basePrice, double premiumRate) {
        super(name, basePrice);
        this.premiumRate = premiumRate;
    }

    @Override
    public double calculateFinalPrice() {
        return basePrice * (1.0 + premiumRate);
    }
}

public class Lab5_12 {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String bName = readNonEmptyString("Enter Basic Service Name: ");
        double bPrice = readNonNegativeDouble("Enter Base Price: ");

        String pName = readNonEmptyString("Enter Premium Service Name: ");
        double pPrice = readNonNegativeDouble("Enter Base Price: ");
        double pRate = readRateDouble("Enter Premium Rate (e.g., 0.20 for 20%): ");

        BasicService basic = new BasicService(bName, bPrice);
        PremiumService premium = new PremiumService(pName, pPrice, pRate);

        Service[] services = { basic, premium };

        for (Service s : services) {
            System.out.println(s.getName() + " final price: " + formatMoney(s.calculateFinalPrice()));
        }

        input.close();
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Input cannot be empty.");
        }
    }

    private static double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                double value = Double.parseDouble(line);
                if (value >= 0.0) return value;
                System.out.println("Value must be non-negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    private static double readRateDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                double value = Double.parseDouble(line);
                if (value >= 0.0 && value <= 10.0) return value;
                System.out.println("Rate must be between 0.0 and 10.0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    private static String formatMoney(double amount) {
        return String.format("%.2f", amount);
    }
}
