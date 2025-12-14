package lab3.lab3_1;

import java.util.Scanner;

public class lab3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();   

        User user = new User(name);    

        System.out.println(user.getUsername()); 
    }
}
