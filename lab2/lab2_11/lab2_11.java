package lab2.lab2_11;

import java.util.Scanner;

public class lab2_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String model = sc.nextLine();  
        int year = sc.nextInt();      
        int updateYear = sc.nextInt(); 

        Car car = new Car(model, year);

        car.setYear(updateYear); 

        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
    }
}
