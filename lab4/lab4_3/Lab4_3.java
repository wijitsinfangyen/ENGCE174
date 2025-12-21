package Lab_4.Lab4_3 ;

import java.util.Scanner ;


class Player {

    private String username;
    private int level;

    public Player() {
        this.username = "Guest";
        this.level = 1;
    }

    public Player(String username, int level) {
        this.username = username;
        this.level = level;
    }

    public void displayProfile() {
        System.out.printf("User: %s , Level: %d", this.username, this.level);
    }
}

public class Lab4_3 {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter Mode (1 or 2) : ");
        int mode = input.nextInt();
        input.nextLine();

        Player player = null;

        if (mode == 1) {
            player = new Player();
        } else if (mode == 2) {
            System.out.print("Enter Username : ");
            String name = input.nextLine();

            System.out.print("Enter Level : ");
            int level = input.nextInt();
            player = new Player(name, level);
        }

        if (player != null) {
            player.displayProfile();
        }

        input.close();
    }
}