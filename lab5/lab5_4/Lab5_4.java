package Lab_5.Lab5_4;

import java.util.Scanner;

class Vehicle {
    protected String color;

    public Vehicle(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class Car extends Vehicle {
    protected int wheels;

    public Car(String color, int wheels) {
        super(color);
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void displayDetails() {
        System.out.println("Color: " + getColor() + ", Wheels: " + getWheels());
    }
}

public class Lab5_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String color;
        while (true) {
            System.out.print("Enter Color: ");
            color = input.nextLine().trim();
            if (!color.isEmpty()) break;
            System.out.println("Color cannot be empty.");
        }

        Integer wheels = null;
        while (wheels == null) {
            System.out.print("Enter Wheels: ");
            String line = input.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value > 0) {
                    wheels = value;
                } else {
                    System.out.println("Wheels must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }

        Car car = new Car(color, wheels);
        car.displayDetails();

        input.close();
    }
}
