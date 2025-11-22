package lab1;
import java.util.Scanner;
public class lab1_2 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        double width = sc.nextDouble();   // รับความกว้าง
	        double height = sc.nextDouble();  // รับความสูง

	        double area = width * height;     // คำนวณพื้นที่

	        System.out.println(area);         // แสดงผล
	}

}
