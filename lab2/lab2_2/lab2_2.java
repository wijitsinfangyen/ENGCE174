package lab2.lab2_2;

import java.util.Scanner;

public class lab2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();     
        String name = sc.nextLine();   

        Student st = new Student();    
        st.studentId = id;             
        st.name = name;

        st.displayInfo();              
    }
}
