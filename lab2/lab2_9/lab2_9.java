package lab2.lab2_9;

import java.util.Scanner;

public class lab2_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();      
        String street = sc.nextLine();   
        String city = sc.nextLine();     
        String zip = sc.nextLine();      

        Address addr = new Address(street, city, zip);
        Student st = new Student(name, addr);

        st.displayProfile();
    }
}
