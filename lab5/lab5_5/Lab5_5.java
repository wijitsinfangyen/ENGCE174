package Lab_5.Lab5_5;

import java.util.Scanner;

class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public double calculateArea() {
        return 0.0;
    }

    public String getName() {
        return name;
    }
}

class Circle extends Shape {
    protected double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

public class Lab5_5 {
    private static double readPositiveDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line);
                if (v > 0.0 && Double.isFinite(v)) return v;
                System.out.println("Invalid value. Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid value. Please enter a positive number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radius = readPositiveDouble(input, "Enter Circle Radius: ");
        double width = readPositiveDouble(input, "Enter Rectangle Width: ");
        double height = readPositiveDouble(input, "Enter Rectangle Height: ");

        Circle circle = new Circle("Circle", radius);
        Rectangle rectangle = new Rectangle("Rectangle", width, height);

        Shape[] shapes = { circle, rectangle };

        for (Shape s : shapes) {
            System.out.printf("%s Area: %.4f%n", s.getName(), s.calculateArea());
        }

        input.close();
    }
}
