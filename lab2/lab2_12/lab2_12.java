package lab2.lab2_12;

import java.util.Scanner;

public class lab2_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String courseId = sc.nextLine();     
        String courseName = sc.nextLine();   
        String studentName = sc.nextLine();  

        Course c = new Course(courseId, courseName);
        Student s = new Student(studentName, c);

        s.displayEnrollment();
    }
}
