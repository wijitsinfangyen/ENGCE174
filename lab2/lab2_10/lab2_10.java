package lab2.lab2_10;

import java.util.Scanner;

public class lab2_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   
        sc.nextLine();         
        
        ShoppingCart cart = new ShoppingCart();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();              
            double price = Double.parseDouble(sc.nextLine()); 

            Product p = new Product(name, price);
            cart.addProduct(p);
        }

        System.out.println(cart.calculateTotalPrice());
    }
}
