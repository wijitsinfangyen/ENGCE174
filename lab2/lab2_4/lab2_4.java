package lab2.lab2_4;

import java.util.Scanner;

public class lab2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();   
        int mid = sc.nextInt();       
        int fin = sc.nextInt();        

        Student st = new Student(name, mid, fin);
        st.displaySummary();
    }
}
