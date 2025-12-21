package Lab_4.Lab4_8 ;

import java.util.Scanner;

class Movie {
    private String title;
    private String director;
    private double rating;

    public Movie(String title) {
        this(title, "Unknown");
    }

    public Movie(String title, String director) {
        this(title, director, 0.0);
    }

    public Movie(String title, String director, double rating) {
        this.title = title;
        this.director = director;
        if (rating < 0.0) {
            this.rating = 0.0;
        } else if (rating > 10.0) {
            this.rating = 10.0;
        } else {
            this.rating = rating;
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + title + ", Director: " + director + ", Rating: " + rating);
    }
}

public class Lab4_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Mode (1, 2, or 3): ");
        int mode = input.nextInt();
        input.nextLine();
        Movie movie = null;

        if (mode == 1) {
            System.out.print("Enter Title: ");
            String title = input.nextLine();
            movie = new Movie(title);
        } else if (mode == 2) {
            System.out.print("Enter Title: ");
            String title = input.nextLine();
            System.out.print("Enter Director: ");
            String director = input.nextLine();
            movie = new Movie(title, director);
        } else if (mode == 3) {
            System.out.print("Enter Title: ");
            String title = input.nextLine();
            System.out.print("Enter Director: ");
            String director = input.nextLine();
            System.out.print("Enter Rating: ");
            double rating = input.nextDouble();
            movie = new Movie(title, director, rating);
        }

        if (movie != null) {
            movie.displayDetails();
        }
        input.close();
    }
}
