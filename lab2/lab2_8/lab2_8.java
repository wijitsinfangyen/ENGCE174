package lab2.lab2_8;

import java.util.Scanner;

public class lab2_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String mode = sc.nextLine();     
        double temp = sc.nextDouble();   

        double result;

        if (mode.equals("C_TO_F")) {
            result = TempConverter.celsiusToFahrenheit(temp);
        } else { // F_TO_C
            result = TempConverter.fahrenheitToCelsius(temp);
        }

        System.out.println(result);
    }
}
