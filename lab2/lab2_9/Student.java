package lab2.lab2_9;

public class Student {
    String name;
    Address address;

    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void displayProfile() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address.getFullAddress());
    }
}
