package lab2.lab2_9;

public class Address {
    String street;
    String city;
    String zipCode;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getFullAddress() {
        return street + ", " + city + ", " + zipCode;
    }
}
