package lab2.lab2_3;

public class Student {
    String studentId;     
    String name;          
    static int studentCount = 0;  

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;

        studentCount++;   
    }
}
