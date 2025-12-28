package Lab_5.Lab5_9;

import java.util.Locale;
import java.util.Scanner;

class Item {
    protected String name;
    public Item(String name) { this.name = name == null ? "" : name.trim(); }
    public double getValue() { return 0.0; }
    public String getName() { return name; }
}

class PhysicalProduct extends Item {
    protected double unitPrice;
    protected int quantity;
    public PhysicalProduct(String name, double unitPrice, int quantity) {
        super(name);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    @Override
    public double getValue() { return unitPrice * quantity; }
}

class DigitalSubscription extends Item {
    protected double monthlyCost;
    protected int months;
    public DigitalSubscription(String name, double monthlyCost, int months) {
        super(name);
        this.monthlyCost = monthlyCost;
        this.months = months;
    }
    @Override
    public double getValue() { return monthlyCost * months; }
}

public class Lab5_9 {
    private static String readName(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine();
        String trimmed = line == null ? "" : line.trim();
        if (!trimmed.isEmpty()) return trimmed;
        System.out.println("Input cannot be empty.");
        return readName(scanner, prompt);
    }

    private static Double parseDoubleOrNull(String s) {
        try { return Double.parseDouble(s.trim()); }
        catch (Exception e) { return null; }
    }

    private static Integer parseIntOrNull(String s) {
        try { return Integer.parseInt(s.trim()); }
        catch (Exception e) { return null; }
    }

    private static double readNonNegativeDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine();
        Double value = parseDoubleOrNull(line);
        if (value == null || Double.isNaN(value) || Double.isInfinite(value)) {
            System.out.println("Please enter a valid number.");
            return readNonNegativeDouble(scanner, prompt);
        }
        if (value < 0) {
            System.out.println("Value must be non-negative.");
            return readNonNegativeDouble(scanner, prompt);
        }
        return value;
    }

    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine();
        Integer value = parseIntOrNull(line);
        if (value == null) {
            System.out.println("Please enter a valid integer.");
            return readNonNegativeInt(scanner, prompt);
        }
        if (value < 0) {
            System.out.println("Value must be non-negative.");
            return readNonNegativeInt(scanner, prompt);
        }
        return value;
    }

    private static double sumValues(Item[] items) {
        double total = 0.0;
        for (Item item : items) {
            total += item.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        String productName = readName(input, "Enter Product Name: ");
        double unitPrice = readNonNegativeDouble(input, "Enter Unit Price: ");
        int quantity = readNonNegativeInt(input, "Enter Quantity: ");

        String subscriptionName = readName(input, "Enter Subscription Name: ");
        double monthlyCost = readNonNegativeDouble(input, "Enter Monthly Cost: ");
        int months = readNonNegativeInt(input, "Enter Months: ");

        PhysicalProduct product = new PhysicalProduct(productName, unitPrice, quantity);
        DigitalSubscription subscription = new DigitalSubscription(subscriptionName, monthlyCost, months);

        Item[] items = new Item[] { product, subscription };
        double totalValue = sumValues(items);

        System.out.println(totalValue);

        input.close();
    }
}
