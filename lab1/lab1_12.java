package lab1;

import java.util.Scanner;

public class lab1_12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();        

        int[] productID = new int[n];   
        int[] stockQty = new int[n];    
        
        for (int i = 0; i < n; i++) {
            productID[i] = sc.nextInt();   
            stockQty[i] = sc.nextInt();    
        }

        int searchID = sc.nextInt();       
        boolean found = false;

    
        for (int i = 0; i < n; i++) {
            if (productID[i] == searchID) {
                System.out.println(stockQty[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product " + searchID + " not found");
        }
    }
}
