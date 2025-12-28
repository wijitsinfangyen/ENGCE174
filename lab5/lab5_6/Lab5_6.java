package Lab_5.Lab5_6;

import java.util.Scanner;

class Media {
    protected final String title;

    public Media(String title) {
        this.title = sanitizeText(title, "Untitled");
    }

    protected static String sanitizeText(String text, String fallback) {
        if (text == null) {
            return fallback;
        }
        String trimmed = text.trim();
        return trimmed.isEmpty() ? fallback : trimmed;
    }

    public void process() {
        System.out.println("Starting generic media processing.");
    }
}

class Video extends Media {
    protected final int durationMinutes;

    public Video(String title, int durationMinutes) {
        super(title);
        this.durationMinutes = Math.max(0, durationMinutes);
    }

    @Override
    public void process() {
        System.out.println("Processing video: " + this.title + " for " + this.durationMinutes + " minutes.");
    }
}

class Audio extends Media {
    protected final String qualityLevel;

    public Audio(String title, String qualityLevel) {
        super(title);
        this.qualityLevel = sanitizeText(qualityLevel, "Standard");
    }

    @Override
    public void process() {
        System.out.println("Processing audio: " + this.title + " with " + this.qualityLevel + " quality.");
    }
}

class Processor {
    public static void runProcessor(Media media) {
        if (media == null) {
            return;
        }
        media.process();
    }
}

public class Lab5_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String videoTitle = readNonEmptyLine(scanner, "Enter Video Title: ");
        int videoDuration = readNonNegativeInt(scanner, "Enter Video Duration: ");

        String audioTitle = readNonEmptyLine(scanner, "Enter Audio Title: ");
        String audioQuality = readNonEmptyLine(scanner, "Enter Audio Quality: ");

        Video video = new Video(videoTitle, videoDuration);
        Processor.runProcessor(video);

        Audio audio = new Audio(audioTitle, audioQuality);
        Processor.runProcessor(audio);

        scanner.close();
    }

    private static String readNonEmptyLine(Scanner scanner, String prompt) {
        String value = "";
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            value = scanner.nextLine();
            String sanitized = Media.sanitizeText(value, "");
            if (!sanitized.isEmpty()) {
                valid = true;
                value = sanitized;
            } else {
                System.out.println("Input cannot be empty.");
            }
        }
        return value;
    }

    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        boolean valid = false;
        int result = 0;
        while (!valid) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            String trimmed = line == null ? "" : line.trim();
            try {
                int value = Integer.parseInt(trimmed);
                if (value >= 0) {
                    result = value;
                    valid = true;
                } else {
                    System.out.println("Please enter a non-negative integer.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again.");
            }
        }
        return result;
    }
}
