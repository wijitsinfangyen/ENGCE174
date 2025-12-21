package Lab_4.Lab4_13;

import java.util.Scanner;

class Subscription {
    private final String planName;
    private final int durationDays;
    private static int maxDuration = 365;

    public Subscription(String planName, int durationDays) {
        this.planName = planName == null ? "" : planName.trim();
        if (durationDays > maxDuration) {
            this.durationDays = maxDuration;
        } else if (durationDays < 0) {
            this.durationDays = 0;
        } else {
            this.durationDays = durationDays;
        }
    }

    public Subscription(Subscription other) {
        this.planName = other == null ? "" : other.planName;
        this.durationDays = other == null ? 0 : other.durationDays;
    }

    public static void setMaxDuration(int max) {
        if (max > 0) {
            maxDuration = max;
            System.out.println("Max duration set to " + max);
        } else {
            System.out.println("Invalid max policy.");
        }
    }

    public Subscription extend(int days) {
        if (days <= 0) {
            System.out.println("Invalid extension days.");
            return this;
        }
        int newDays = this.durationDays + days;
        if (newDays > maxDuration) {
            System.out.println("Extension failed: Exceeds max policy.");
            return this;
        }
        System.out.println("Extension successful.");
        return new Subscription(this.planName, newDays);
    }

    public void displayInfo() {
        System.out.println("Plan: " + this.planName + ", Days: " + this.durationDays);
    }
}

public class Lab4_13 {
    private static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (true) {
            if (sc.hasNextInt()) {
                int v = sc.nextInt();
                sc.nextLine();
                return v;
            } else {
                sc.nextLine();
                System.out.print(prompt);
            }
        }
    }

    private static String readLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        while (s == null || s.trim().isEmpty()) {
            System.out.print(prompt);
            s = sc.nextLine();
        }
        return s.trim();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int max = readInt(input, "Enter Max Duration: ");
        Subscription.setMaxDuration(max);

        String plan = readLine(input, "Enter Plan Name: ");

        int initDays = readInt(input, "Enter Initial Days: ");
        int ext1 = readInt(input, "Enter Extension 1: ");
        int ext2 = readInt(input, "Enter Extension 2: ");

        Subscription sub = new Subscription(plan, initDays);
        sub = sub.extend(ext1);
        sub = sub.extend(ext2);

        sub.displayInfo();

        input.close();
    }
}
