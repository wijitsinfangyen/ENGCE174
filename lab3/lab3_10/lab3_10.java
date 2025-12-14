package lab3.lab3_10;

import java.util.Scanner;

public class lab3_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String cmd = sc.nextLine();
            if (cmd.equals("SET")) {
                int level = sc.nextInt();
                sc.nextLine();
                systemlogger.setLogLevel(level);
            } else if (cmd.equals("LOG")) {
                int level = sc.nextInt();
                sc.nextLine();
                String msg = sc.nextLine();
                systemlogger.log(level, msg);
            }
        }
    }
}
