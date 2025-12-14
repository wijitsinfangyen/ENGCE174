package lab3;

import java.util.Scanner;

public class lab3_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String cmd = sc.nextLine();
            systemconfig config = systemconfig.getInstance();

            if (cmd.equals("SET_URL")) {
                String url = sc.nextLine();
                config.setServerUrl(url);
            } else if (cmd.equals("SET_MAX")) {
                int max = sc.nextInt();
                sc.nextLine();
                config.setMaxConnections(max);
            } else if (cmd.equals("SHOW")) {
                System.out.println("URL: " + config.getServerUrl());
                System.out.println("MAX: " + config.getMaxConnections());
            }
        }
    }
}
