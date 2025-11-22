package lab1;

import java.util.Scanner;

public class lab1_9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();        
        int[] arr = new int[n];      

        double sum = 0;              

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();   
            sum += arr[i];          
        }

        double avg = sum / n;       

        System.out.println(avg);     
    }
}
