package lab1;
import java.util.Scanner;
public class lab1_7 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();  
	        int sum = 0;           
	        for (int i = 0; i < n; i++) {
	            int value = sc.nextInt();   
	            sum += value;              
	        }
	        System.out.println(sum);        
	}
}