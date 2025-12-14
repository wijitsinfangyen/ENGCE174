package lab3.lab3_15;

import java.util.Scanner;

public class lab3_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();
        user u = new user(username);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String cmd = sc.nextLine();

            if (cmd.equals("SET_POLICY")) {
                int max = sc.nextInt();
                sc.nextLine();
                user.setPolicy(max);
            } else if (cmd.equals("LOGIN")) {
                String pass = sc.nextLine();
                u.login(pass);
            }
        }
    }
}
