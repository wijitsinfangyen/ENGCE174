package Lab_4.Lab4_7 ;

import java.util.Scanner ;

class Resource {

    private String id;

    public Resource(String id) {
        this.id = id;
        System.out.println("Resource " + this.id + " created.");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Resource " + this.id + " finalized (destroyed).");
        super.finalize();    }
}

public class Lab4_7 {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter ID 1: ");
        String id1 = input.nextLine();

        System.out.print("Enter ID 2: ");
        String id2 = input.nextLine();

        System.out.print("Enter ID 3: ");
        String id3 = input.nextLine();

        Resource r1 = new Resource(id1);
        Resource r2 = new Resource(id2);
        Resource r3 = new Resource(id3);

        r1 = null;
        r2 = null;
        System.gc();

        r3 = null;
        System.gc();

        input.close();
    }
}
