package lab1;

import java.util.Scanner;

public class lab1_7 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt(), sum = 0;

	        while (n-- > 0) sum += sc.nextInt();

	        System.out.println(sum);      
	}
}