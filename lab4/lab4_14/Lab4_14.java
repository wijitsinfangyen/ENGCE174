package Lab_4.Lab4_14;

import java.util.Scanner;

class ScoreBoard {
    private final String gameName;
    private final int[] scores;

    public ScoreBoard(String gameName, int[] scores) {
        this.gameName = gameName == null ? "Unknown Game" : gameName;
        this.scores = scores == null ? new int[]{0, 0, 0} : scores;
    }

    public ScoreBoard(ScoreBoard other) {
        this.gameName = other.gameName;
        this.scores = new int[other.scores.length];
        for (int i = 0; i < other.scores.length; i++) {
            this.scores[i] = other.scores[i];
        }
    }

    public void displayScores() {
        System.out.println(this.gameName + ": " + this.scores[0] + ", " + this.scores[1] + ", " + this.scores[2]);
    }
}

public class Lab4_14 {
    private static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                int v = input.nextInt();
                input.nextLine();
                return v;
            } else {
                System.out.println("Invalid integer. Please try again.");
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Game Name: ");
        String gameName = input.nextLine().trim();
        if (gameName.isEmpty()) gameName = "Unknown Game";

        int s1 = readInt(input, "Enter Score 1: ");
        int s2 = readInt(input, "Enter Score 2: ");
        int s3 = readInt(input, "Enter Score 3: ");
        int modVal = readInt(input, "Enter Modified Score 1: ");

        int[] originalScores = { s1, s2, s3 };

        ScoreBoard sb1 = new ScoreBoard(gameName, originalScores);
        ScoreBoard sb2 = new ScoreBoard(sb1);

        originalScores[0] = modVal;

        sb1.displayScores();
        sb2.displayScores();

        input.close();
    }
}
