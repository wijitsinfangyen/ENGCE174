package Lab_4.Lab4_2 ;


import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name) {
        this(name, 0.0);
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo() {
        System.out.printf("Product: %s , Price: %.2f", this.name, this.price);
    }
}

public class Lab4_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Mode (1 or 2) : ");
        int mode = input.nextInt();
        input.nextLine();
        
        System.out.print("Enter Product Name : ");
        String name = input.nextLine();
        Product product = null;
        
        if (mode == 1) {
            product = new Product(name);
        } else if (mode == 2) {
            System.out.print("Enter Price : ");
            double price = input.nextDouble();
            product = new Product(name, price);
        }
        
        if (product != null) {
            product.displayInfo();
        }
        
        input.close();
    }
}
