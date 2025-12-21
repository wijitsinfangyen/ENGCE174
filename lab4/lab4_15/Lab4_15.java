package Lab_4.Lab4_15;

import java.util.Scanner;

class AuditRecord {

    private final String user;
    private final String[] logMessages;

    private static int maxMessages = 3;

    public AuditRecord(String user) {
        this(user, new String[0]);
    }

    public AuditRecord(String user, String[] logs) {
        this.user = user == null ? "" : user;
        int limit = maxMessages;
        int len = logs == null ? 0 : logs.length;
        int copyCount = len > limit ? limit : len;
        this.logMessages = new String[copyCount];
        int startIndex = len - copyCount;
        for (int i = 0; i < copyCount; i++) {
            String v = logs[startIndex + i];
            this.logMessages[i] = v == null ? "" : v;
        }
    }

    public static void setMaxMessages(int max) {
        if (max <= 0) {
            System.out.println("Invalid policy.");
        } else {
            maxMessages = max;
            System.out.println("Policy set to " + max);
        }
    }

    public AuditRecord addMessage(String message) {
        String msg = message == null ? "" : message;
        if (this.logMessages.length < maxMessages) {
            String[] newLogs = new String[this.logMessages.length + 1];
            for (int i = 0; i < this.logMessages.length; i++) {
                newLogs[i] = this.logMessages[i];
            }
            newLogs[newLogs.length - 1] = msg;
            System.out.println(msg + " added.");
            return new AuditRecord(this.user, newLogs);
        } else {
            System.out.println("Log is full.");
            return this;
        }
    }

    public void displayLog() {
        System.out.print("User: " + this.user + ", Logs: " + this.logMessages.length + " [");
        for (int i = 0; i < this.logMessages.length; i++) {
            System.out.print(this.logMessages[i]);
            if (i < this.logMessages.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

public class Lab4_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Max Policy: ");
        Integer maxPolicy = readIntSafe(input);
        if (maxPolicy != null) {
            AuditRecord.setMaxMessages(maxPolicy);
        }
        input.nextLine();

        System.out.print("Enter Username: ");
        String user = input.hasNextLine() ? input.nextLine() : "";
        AuditRecord rec = new AuditRecord(user);

        System.out.print("Enter number of commands (N): ");
        Integer n = readIntSafe(input);
        if (n != null && n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter Command or Log Message: ");
                String token = input.hasNext() ? input.next() : "";
                if ("SET_POLICY".equals(token)) {
                    Integer val = readIntSafe(input);
                    if (val != null) {
                        AuditRecord.setMaxMessages(val);
                    } else {
                        System.out.println("Invalid policy.");
                        input.nextLine();
                    }
                } else {
                    rec = rec.addMessage(token);
                }
            }
        }

        rec.displayLog();

        input.close();
    }

    private static Integer readIntSafe(Scanner sc) {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            return null;
        }
    }
}
