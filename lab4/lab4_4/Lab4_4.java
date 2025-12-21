package Lab_4.Lab4_4 ;

import java.util.Scanner ;

class Location {

    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(Location other) {
        this.latitude = other.latitude;
        this.longitude = other.longitude;
    }

    public void setLatitude(double newLat) {
        this.latitude = newLat;
    }

    public void displayInfo() {
        System.out.println("Lat: " + this.latitude + " , Lon: " + this.longitude);
    }
}

public class Lab4_4 {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter Latitude : ");
        double lat = input.nextDouble();

        System.out.print("Enter Longitude : ");
        double lon = input.nextDouble();

        System.out.print("Enter New Latitude : ");
        double newLat = input.nextDouble();

        Location loc1 = new Location(lat, lon);
        Location loc2 = new Location(loc1);

        loc1.setLatitude(newLat);

        loc1.displayInfo();
        loc2.displayInfo();

        input.close();
    }
}