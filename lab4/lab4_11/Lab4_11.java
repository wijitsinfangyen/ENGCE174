package Lab_4.Lab4_11;

import java.util.Locale;
import java.util.Scanner;

class Configuration {
    private final String theme;
    private final int fontSize;
    private final boolean darkMode;

    public Configuration(String theme, int fontSize, boolean darkMode) {
        String t = (theme == null) ? "" : theme.trim();
        this.theme = t.isEmpty() ? "Light" : t;

        if (fontSize < 10) {
            this.fontSize = 10;
        } else if (fontSize > 20) {
            this.fontSize = 20;
        } else {
            this.fontSize = fontSize;
        }

        this.darkMode = darkMode;
    }

    public Configuration(Configuration base, Configuration user) {
        if (base == null && user == null) {
            this.theme = "Light";
            this.fontSize = 10;
            this.darkMode = false;
            return;
        }
        if (base == null) {
            this.theme = user.theme;
            this.fontSize = user.fontSize;
            this.darkMode = user.darkMode;
            return;
        }
        if (user == null) {
            this.theme = base.theme;
            this.fontSize = base.fontSize;
            this.darkMode = base.darkMode;
            return;
        }

        this.theme = user.theme;
        this.fontSize = base.fontSize;
        this.darkMode = user.darkMode;
    }

    public void displaySettings() {
        System.out.println("Theme: " + this.theme + ", Size: " + this.fontSize + ", Dark: " + this.darkMode);
    }
}

public class Lab4_11 {
    private static final int MAX_TRIES = 5;

    private static String readTheme(Scanner sc) {
        String t = sc.nextLine().trim();
        return t.isEmpty() ? "Light" : t;
    }

    private static int readFontSize(Scanner sc) {
        int tries = 0;
        while (tries < MAX_TRIES) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("กรุณาใส่ตัวเลขสำหรับ Font Size (เช่น 12): ");
                tries++;
            }
        }
        System.out.println("\nอ่านค่า Font Size ไม่สำเร็จ ใช้ค่าเริ่มต้น 12");
        return 12;
    }

    private static boolean readBoolean(Scanner sc) {
        int tries = 0;
        while (tries < MAX_TRIES) {
            String s = sc.nextLine().trim().toLowerCase(Locale.ROOT);
            if (s.equals("true") || s.equals("t") || s.equals("1") || s.equals("yes") || s.equals("y")) {
                return true;
            }
            if (s.equals("false") || s.equals("f") || s.equals("0") || s.equals("no") || s.equals("n")) {
                return false;
            }
            System.out.print("กรุณาใส่ค่า boolean (true/false, y/n, 1/0): ");
            tries++;
        }
        System.out.println("\nอ่านค่า Dark Mode ไม่สำเร็จ ใช้ค่าเริ่มต้น false");
        return false;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter Base Theme: ");
            String baseTheme = readTheme(input);

            System.out.print("Enter Base Font Size: ");
            int baseSize = readFontSize(input);

            System.out.print("Enter Base Dark Mode (true/false): ");
            boolean baseDark = readBoolean(input);

            System.out.print("Enter User Theme: ");
            String userTheme = readTheme(input);

            System.out.print("Enter User Font Size: ");
            int userSize = readFontSize(input);

            System.out.print("Enter User Dark Mode (true/false): ");
            boolean userDark = readBoolean(input);

            Configuration baseConfig = new Configuration(baseTheme, baseSize, baseDark);
            Configuration userConfig = new Configuration(userTheme, userSize, userDark);
            Configuration finalConfig = new Configuration(baseConfig, userConfig);

            finalConfig.displaySettings();
        }
    }
}
