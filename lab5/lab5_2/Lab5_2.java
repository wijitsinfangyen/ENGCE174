package Lab_5.Lab5_2;

import java.util.Scanner;

class Animal {
    protected String name;
    protected int age;

    public void makeSound() {
        System.out.println("I am an animal.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setAge(int age) {
        this.age = Math.max(0, age); // Ensure age is non-negative
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Lab5_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get valid name from user
        String inputName = getValidName(input);

        // Get valid age from user
        int inputAge = getValidAge(input);

        // Create Cat object and set properties
        Cat myCat = new Cat();
        myCat.setName(inputName);
        myCat.setAge(inputAge);

        // Display info and sound
        myCat.displayInfo();
        myCat.makeSound();

        input.close();
    }

    // Method to validate name input
    private static String getValidName(Scanner input) {
        String name;
        while (true) {
            System.out.print("Enter Name: ");
            name = input.nextLine();
            if (!name.trim().isEmpty()) {
                return name;
            }
            System.out.println("Name cannot be empty.");
        }
    }

    // Method to validate age input
    private static int getValidAge(Scanner input) {
        int age;
        while (true) {
            System.out.print("Enter Age: ");
            String ageInput = input.nextLine();
            try {
                age = Integer.parseInt(ageInput.trim());
                if (age >= 0) {
                    return age;
                }
                System.out.println("Age must be non-negative.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer for age.");
            }
        }
    }
}
