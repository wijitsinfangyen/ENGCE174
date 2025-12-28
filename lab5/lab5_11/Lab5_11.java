package Lab_5.Lab5_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Document {
    protected String title;
    public Document(String title) { this.title = title == null ? "" : title.trim(); }
    public void displayDetails() {
        System.out.println("Document: " + this.title);
    }
}

class TextDocument extends Document {
    protected int wordCount;
    public TextDocument(String title, int wordCount) {
        super(title);
        this.wordCount = Math.max(0, wordCount);
    }
    @Override
    public void displayDetails() {
        System.out.println("Text: " + this.title + ", Words: " + this.wordCount);
    }
}

class PDFDocument extends Document {
    protected int pageCount;
    public PDFDocument(String title, int pageCount) {
        super(title);
        this.pageCount = Math.max(0, pageCount);
    }
    @Override
    public void displayDetails() {
        System.out.println("PDF: " + this.title + ", Pages: " + this.pageCount);
    }
}

public class Lab5_11 {
    private static String readNonEmptyString(Scanner sc, String prompt) {
        String s;
        while (true) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s != null && !s.trim().isEmpty()) return s.trim();
            System.out.println("Input cannot be empty.");
        }
    }

    private static int readNonNegativeInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                int v = Integer.parseInt(line.trim());
                if (v >= 0) return v;
                System.out.println("Please enter a non-negative integer.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter digits only.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String t1Title = readNonEmptyString(input, "Enter Text Document 1 Title: ");
        int t1Words = readNonNegativeInt(input, "Enter Word Count: ");

        String p1Title = readNonEmptyString(input, "Enter PDF Document 1 Title: ");
        int p1Pages = readNonNegativeInt(input, "Enter Page Count: ");

        String t2Title = readNonEmptyString(input, "Enter Text Document 2 Title: ");
        int t2Words = readNonNegativeInt(input, "Enter Word Count: ");

        String p2Title = readNonEmptyString(input, "Enter PDF Document 2 Title: ");
        int p2Pages = readNonNegativeInt(input, "Enter Page Count: ");

        TextDocument t1 = new TextDocument(t1Title, t1Words);
        PDFDocument p1 = new PDFDocument(p1Title, p1Pages);
        TextDocument t2 = new TextDocument(t2Title, t2Words);
        PDFDocument p2 = new PDFDocument(p2Title, p2Pages);

        List<Document> docs = new ArrayList<>();
        docs.add(t1);
        docs.add(p1);
        docs.add(t2);
        docs.add(p2);

        int totalPages = 0;
        for (Document doc : docs) {
            if (doc instanceof PDFDocument) {
                totalPages += ((PDFDocument) doc).pageCount;
            }
        }

        for (Document doc : docs) {
            doc.displayDetails();
        }

        System.out.println("Total Pages: " + totalPages);

        input.close();
    }
}
