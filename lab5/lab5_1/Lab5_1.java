
package Lab_5.Lab5_1;
import java.util.Scanner;

class Animal {
    protected String name;
    protected int age;

    public void displayInfo() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

public class Lab5_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String inputName = input.nextLine();
        if (inputName == null) inputName = "";
        inputName = inputName.trim();

        System.out.print("Enter Age: ");
        String ageLine = input.nextLine();

        int inputAge = 0;
        try {
            inputAge = Integer.parseInt(ageLine.trim());
            if (inputAge < 0) inputAge = 0;
        } catch (Exception e) {
            inputAge = 0;
        }

        Dog myDog = new Dog();
        myDog.name = inputName;
        myDog.age = inputAge;

        myDog.makeSound();
        myDog.displayInfo();

        input.close();
    }
}
