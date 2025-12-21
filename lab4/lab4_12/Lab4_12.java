package Lab_4.Lab4_12;

import java.util.Scanner;

class Schedule {
    private int hour;

    public Schedule(int hour) { this.hour = hour; }
    public void setHour(int newHour) { this.hour = newHour; }
    public int getHour() { return this.hour; }
    public Schedule(Schedule other) { this.hour = other.hour; }
}

class EmployeeSchedule {
    private String name;
    private Schedule schedule;

    public EmployeeSchedule(String name, Schedule schedule) {
        this.name = name;
        this.schedule = schedule;
    }

    public EmployeeSchedule(EmployeeSchedule other) {
        this.name = other.name;
        this.schedule = new Schedule(other.schedule);
    }

    public void displaySchedule() {
        System.out.println(this.name + ": " + this.schedule.getHour() + ":00");
    }
}

public class Lab4_12 {
    private static int readHour(Scanner input, String prompt) {
        System.out.print(prompt);
        while (true) {
            if (input.hasNextInt()) {
                int h = input.nextInt();
                if (h >= 0 && h <= 23) {
                    return h;
                } else {
                    System.out.print("Invalid hour. Enter a value between 0 and 23: ");
                }
            } else {
                input.next();
                System.out.print("Invalid number. Enter a value between 0 and 23: ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = input.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter Name: ");
            name = input.nextLine().trim();
        }

        int startHour = readHour(input, "Enter Start Hour: ");
        int newHour = readHour(input, "Enter New Hour: ");

        Schedule sch1 = new Schedule(startHour);
        EmployeeSchedule emp1 = new EmployeeSchedule(name, sch1);
        EmployeeSchedule emp2 = new EmployeeSchedule(emp1);

        sch1.setHour(newHour);

        emp1.displaySchedule();
        emp2.displaySchedule();

        input.close();
    }
}
