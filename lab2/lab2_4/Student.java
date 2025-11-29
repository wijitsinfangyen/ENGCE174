package lab2.lab2_4;

public class Student {
    String name;
    int midtermScore;
    int finalScore;

    public Student(String name, int midtermScore, int finalScore) {
        this.name = name;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
    }

    double calculateAverage() {
        return (midtermScore + finalScore) / 2.0;
    }

    void displaySummary() {
        double avg = calculateAverage();
        String status = (avg >= 50.0) ? "Pass" : "Fail";

        System.out.println("Name: " + name);
        System.out.println("Average Score: " + avg);
        System.out.println("Status: " + status);
    }
}
