package lab3.lab3_3;

import java.util.Scanner;

public class lab3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String oldPass = sc.nextLine();  
        String newPass = sc.nextLine();  
        
        User user = new User(oldPass);

        user.setPassword(newPass);                
        System.out.println(user.getPassword());    
    }
}
