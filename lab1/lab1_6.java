package lab1;
import java.util.Scanner;
public class lab1_6 {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // รับแม่สูตรคูณ

        for (int i = 1; i <= 12; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
	}

}
