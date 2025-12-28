package Lab_5.Lab5_13;

import java.util.Scanner;

class User {
    protected String name;
    public User(String name) { this.name = name == null ? "" : name.trim(); }
    public int getClearanceLevel() { return 1; }
}

class Developer extends User {
    protected int projects;
    public Developer(String name, int projects) {
        super(name);
        this.projects = Math.max(0, projects);
    }
    @Override
    public int getClearanceLevel() { return 2; }
}

class Admin extends Developer {
    protected String adminKey;
    public Admin(String name, int projects, String adminKey) {
        super(name, projects);
        this.adminKey = adminKey == null ? "" : adminKey.trim();
    }
    @Override
    public int getClearanceLevel() { return 3; }
    public String getAdminKey() { return adminKey; }
}

public class Lab5_13 {
    private static String readNonEmpty(Scanner sc, String prompt) {
        String s;
        while (true) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s != null && !s.trim().isEmpty()) return s.trim();
            System.out.println("Invalid input. Please enter a non-empty value.");
        }
    }

    private static int readNonNegativeInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                int v = Integer.parseInt(line.trim());
                if (v >= 0) return v;
                System.out.println("Invalid input. Please enter a non-negative integer.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String dName = readNonEmpty(input, "Enter Developer Name: ");
        int dProjects = readNonNegativeInt(input, "Enter Number of Projects: ");

        String aName = readNonEmpty(input, "Enter Admin Name: ");
        int aProjects = readNonNegativeInt(input, "Enter Number of Projects: ");
        String aKey = readNonEmpty(input, "Enter Admin Key: ");

        User u1 = new User("Guest");
        Developer d1 = new Developer(dName, dProjects);
        Admin a1 = new Admin(aName, aProjects, aKey);

        User[] users = {u1, d1, a1};

        int totalClearance = 0;
        for (User user : users) {
            totalClearance += user.getClearanceLevel();
        }

        for (User user : users) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                System.out.println(admin.getAdminKey());
            }
        }

        System.out.println(totalClearance);

        input.close();
    }
}
