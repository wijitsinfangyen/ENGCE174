package lab1;

import java.util.Scanner;

public class lab1_11 {

   
    public static int sumArray(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();        
        int[] arr = new int[n];      

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();   
        }

        int total = sumArray(arr);   

        System.out.println(total);   
    }
}
