package lab2.lab2_3;

import java.util.Scanner;

public class lab2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  
        sc.nextLine();          

        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();

            new Student(id, name);   
        }

        System.out.println(Student.studentCount);  
    }
}
