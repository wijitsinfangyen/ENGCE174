package lab3.lab3_2;

import java.util.Scanner;

public class lab3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int initialScore = sc.nextInt(); 
        int newScore = sc.nextInt();     
        
        Player player = new Player(initialScore);
        player.setScore(newScore);

        System.out.println(player.getScore());
    }
}
