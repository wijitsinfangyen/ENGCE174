package Lab_4.Lab4_10;

import java.util.InputMismatchException;
import java.util.Scanner;

class TimePeriod {
    private int startHour;
    private int endHour;

    public TimePeriod() {
        this(9, 17);
    }

    public TimePeriod(int startHour, int endHour) {
        if (startHour < 0) {
            startHour = 0;
        } else if (startHour > 23) {
            startHour = 23;
        }
        if (endHour < 0) {
            endHour = 0;
        } else if (endHour > 23) {
            endHour = 23;
        }
        if (startHour > endHour) {
            int t = startHour;
            startHour = endHour;
            endHour = t;
        }
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public void displayPeriod() {
        System.out.println(this.startHour + ":00 - " + this.endHour + ":00");
    }
}

public class Lab4_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Mode (1 or 2): ");
        int mode;
        try {
            mode = input.nextInt();
        } catch (InputMismatchException e) {
            mode = 1;
        }

        TimePeriod tp = null;

        if (mode == 1) {
            tp = new TimePeriod();
        } else if (mode == 2) {
            int start;
            int end;
            try {
                System.out.print("Enter Start Hour: ");
                start = input.nextInt();
                System.out.print("Enter End Hour: ");
                end = input.nextInt();
            } catch (InputMismatchException e) {
                start = 9;
                end = 17;
            }
            tp = new TimePeriod(start, end);
        } else {
            tp = new TimePeriod();
        }

        tp.displayPeriod();
        input.close();
    }
}
