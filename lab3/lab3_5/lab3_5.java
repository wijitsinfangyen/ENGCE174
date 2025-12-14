package lab3.lab3_5;

import java.util.Scanner;

public class lab3_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String conn = sc.nextLine();  
        DatabaseConnection db = new DatabaseConnection(conn);

        db.connect();
        db.disconnect();
        db.disconnect();              
        System.out.println(db.isConnected());
    }
}
