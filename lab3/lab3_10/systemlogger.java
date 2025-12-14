package lab3.lab3_10;

public class systemlogger {
    private static int currentLogLevel = 1;

    private static String getLevelName(int level) {
        if (level == 1) return "INFO";
        if (level == 2) return "DEBUG";
        if (level == 3) return "ERROR";
        return "UNKNOWN";
    }

    public static void setLogLevel(int newLevel) {
        if (newLevel >= 1 && newLevel <= 3) {
            currentLogLevel = newLevel;
            System.out.println("Log level set to " + getLevelName(newLevel));
        } else {
            System.out.println("Invalid log level.");
        }
    }

    public static void log(int messageLevel, String message) {
        if (messageLevel >= currentLogLevel) {
            System.out.println("[" + getLevelName(messageLevel) + "]: " + message);
        }
    }
}
