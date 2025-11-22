package lab1;
import java.util.Scanner;

public class lab1_14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();       
        int C = sc.nextInt();        

        char[][] map = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.next().charAt(0);
            }
        }

        int targetR = sc.nextInt();     
        int targetC = sc.nextInt();    

        if (map[targetR][targetC] == '*') {
            System.out.println("Mine");
            return;
        }

       
        int count = 0;

      
        int[] dR = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dC = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int nr = targetR + dR[k];
            int nc = targetC + dC[k];

         
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if (map[nr][nc] == '*') {
                    count++;
                }
            }
        }

        System.out.println(count);   
    }
}
