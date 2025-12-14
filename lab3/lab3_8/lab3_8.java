package lab3.lab3_8;

import java.util.Scanner;

public class lab3_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();   
        int stock = sc.nextInt();      
        int n = sc.nextInt();          
        sc.nextLine();                 

        InventoryItem item = new InventoryItem(name, stock);

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine(); 
            int amount = sc.nextInt();
            sc.nextLine();                 

            if (command.equals("ADD")) {
                item.addStock(amount);
            } else if (command.equals("SELL")) {
                item.sellStock(amount);
            }
        }

        System.out.println("Final Stock: " + item.getStock());
    }
}
