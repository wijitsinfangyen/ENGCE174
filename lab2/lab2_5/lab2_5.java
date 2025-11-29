package lab2.lab2_5;

import java.util.Scanner;

public class lab2_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double width = sc.nextDouble();  
        double height = sc.nextDouble();  

        Rectangle r = new Rectangle(width, height);

        System.out.println(r.getArea());      
        System.out.println(r.getPerimeter());  
    }
}
