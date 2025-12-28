package Lab_5.Lab5_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class ProjectTask {
    protected String description;
    protected int baseHours;

    public ProjectTask(String description, int baseHours) {
        this.description = description == null ? "" : description.trim();
        this.baseHours = Math.max(0, baseHours);
    }

    public double calculateCost() {
        return baseHours * 50.0;
    }

    public String getDescription() {
        return description;
    }

    public int getBaseHours() {
        return baseHours;
    }
}

class ComplexTask extends ProjectTask {
    protected double setupFee;

    public ComplexTask(String description, int baseHours, double setupFee) {
        super(description, baseHours);
        this.setupFee = Math.max(0.0, setupFee);
    }

    @Override
    public double calculateCost() {
        return (super.calculateCost() * 1.10) + setupFee;
    }

    public double getSetupFee() {
        return setupFee;
    }
}

class SimpleTask extends ProjectTask {
    public SimpleTask(String description, int baseHours) {
        super(description, baseHours);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost();
    }
}

public class Lab5_10 {
    private static final Scanner input = new Scanner(System.in).useLocale(Locale.US);

    private static String readNonEmptyLine(String prompt) {
        System.out.print(prompt);
        String s = input.nextLine();
        while (s == null || s.trim().isEmpty()) {
            System.out.print(prompt);
            s = input.nextLine();
        }
        return s.trim();
    }

    private static int readNonNegativeInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            String line = input.nextLine();
            try {
                int v = Integer.parseInt(line.trim());
                if (v >= 0) return v;
            } catch (NumberFormatException ignored) {}
            System.out.print(prompt);
        }
    }

    private static double readNonNegativeDouble(String prompt) {
        System.out.print(prompt);
        while (true) {
            String line = input.nextLine();
            try {
                double v = Double.parseDouble(line.trim());
                if (v >= 0.0) return v;
            } catch (NumberFormatException ignored) {}
            System.out.print(prompt);
        }
    }

    private static String formatMoney(double value) {
        return String.format(Locale.US, "%.2f", value);
    }

    public static void main(String[] args) {
        String cDesc = readNonEmptyLine("Enter Complex Task Description: ");
        int cHours = readNonNegativeInt("Enter Hours: ");
        double cFee = readNonNegativeDouble("Enter Setup Fee: ");

        String sDesc = readNonEmptyLine("Enter Simple Task Description: ");
        int sHours = readNonNegativeInt("Enter Hours: ");

        ComplexTask complexTask = new ComplexTask(cDesc, cHours, cFee);
        SimpleTask simpleTask = new SimpleTask(sDesc, sHours);

        List<ProjectTask> tasks = new ArrayList<>();
        tasks.add(complexTask);
        tasks.add(simpleTask);

        for (ProjectTask task : tasks) {
            System.out.println(formatMoney(task.calculateCost()));
        }
    }
}