package lab1;

import java.util.Scanner;

public class lab1_13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();          
        int C = sc.nextInt();          

        int[][] grid = new int[R][C];  
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int countOnline = 0;

       
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    countOnline++;
                }
            }
        }

        System.out.println(countOnline);
    }
}
