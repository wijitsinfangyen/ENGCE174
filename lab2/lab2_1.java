package lab2;

import java.util.Scanner;

public class lab2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // รับข้อมูล 2 บรรทัด
        String id = sc.nextLine();
        String name = sc.nextLine();

        // สร้าง object Student
        Student st = new Student();
        st.studentId = id;
        st.name = name;

        // แสดงผล
        System.out.println(st.studentId);
        System.out.println(st.name);
    }
}
