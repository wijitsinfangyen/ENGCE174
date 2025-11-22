package lab1;

import java.util.Scanner;

public class lab1_10 {

    public static double calculateArea(double width, double height) {
        return width * height;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double width = sc.nextDouble();   
        double height = sc.nextDouble();  

        double area = calculateArea(width, height); 

        System.out.println(area);  
    }
}
