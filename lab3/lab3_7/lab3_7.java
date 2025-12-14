package lab3.lab3_7;

import java.util.Scanner;

public class lab3_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();         
        String dept = sc.nextLine();       
        String newDept = sc.nextLine();    

        Employee emp = new Employee(id, dept);

        emp.setDepartment(newDept);         

        System.out.println(emp.getEmployeeId());
        System.out.println(emp.getDepartment());
    }
}
