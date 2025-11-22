package lab1;
import java.util.Scanner;
public class lab1_7 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();   // จำนวนตัวเลขที่จะรับ
	        int sum = 0;            // ตัวแปรเก็บผลรวม

	        for (int i = 0; i < n; i++) {
	            int value = sc.nextInt();   // รับค่าทีละตัว
	            sum += value;               // บวกสะสม
	        }

	        System.out.println(sum);        // แสดงผลรวม
	}

}
