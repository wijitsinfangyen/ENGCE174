package lab3.lab3_9;

import java.util.Scanner;

public class lab3_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minLength1 = sc.nextInt();
        sc.nextLine();

        String user1_name = sc.nextLine();
        String user1_pass = sc.nextLine();

        String user2_name = sc.nextLine();
        String user2_pass = sc.nextLine();

        int minLength2 = sc.nextInt();
        sc.nextLine();

        String user2_newPass = sc.nextLine();

        user.setMinLength(minLength1);

        user user1 = new user(user1_name, user1_pass);
        user user2 = new user(user2_name, user2_pass);

        user.setMinLength(minLength2);

        user2.setPassword(user2_newPass);

        System.out.println(user1.getPassword());
        System.out.println(user2.getPassword());
    }
}

