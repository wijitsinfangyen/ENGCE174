package lab4.lab4_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mode = sc.nextInt();
        sc.nextLine();

        if (mode == 1) {
            String title = sc.nextLine();
            Book book = new Book(title);
            book.displayInfo();
        } else if (mode == 2) {
            String title = sc.nextLine();
            String author = sc.nextLine();
            Book book = new Book(title, author);
            book.displayInfo();
        }

        sc.close();
    }
}
