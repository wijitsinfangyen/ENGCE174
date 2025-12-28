package Lab_5.Lab5_14 ;

import java.util.Scanner;
import java.util.Locale;

class Shipping {
    protected String trackingId;
    protected double baseFee;
    public Shipping(String trackingId, double baseFee) {
        this.trackingId = trackingId;
        this.baseFee = baseFee;
    }
    public double calculateTotalFee() {
        return baseFee;
    }
    public String getTrackingId() {
        return trackingId;
    }
}

class StandardShipping extends Shipping {
    public StandardShipping(String trackingId, double baseFee) {
        super(trackingId, baseFee);
    }
    @Override
    public double calculateTotalFee() {
        return baseFee * 1.05;
    }
}

class PremiumShipping extends Shipping {
    protected double insuranceFee;
    public PremiumShipping(String trackingId, double baseFee, double insuranceFee) {
        super(trackingId, baseFee);
        this.insuranceFee = insuranceFee;
    }
    @Override
    public double calculateTotalFee() {
        return super.calculateTotalFee() + insuranceFee;
    }
}

public class Lab5_14 {
    private static String readNonEmptyString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Invalid input. Try again.");
        }
    }

    private static double readNonNegativeDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line);
                if (v >= 0.0 && Double.isFinite(v)) return v;
                System.out.println("Value must be non-negative and finite. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        String sId = readNonEmptyString(input, "Enter Standard Tracking ID: ");
        double sFee = readNonNegativeDouble(input, "Enter Base Fee for Standard: ");

        String pId = readNonEmptyString(input, "Enter Premium Tracking ID: ");
        double pFee = readNonNegativeDouble(input, "Enter Base Fee for Premium: ");
        double pIns = readNonNegativeDouble(input, "Enter Insurance Fee for Premium: ");

        StandardShipping sShip = new StandardShipping(sId, sFee);
        PremiumShipping pShip = new PremiumShipping(pId, pFee, pIns);

        Shipping[] shipments = { sShip, pShip };

        for (Shipping s : shipments) {
            System.out.printf("Tracking: %s, Total Fee: %.2f%n", s.getTrackingId(), s.calculateTotalFee());
        }

        input.close();
    }
}
