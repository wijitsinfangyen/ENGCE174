package lab3.lab3_13;

import java.util.Scanner;

public class lab3_13 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        sc.nextLine();

	        for (int i = 0; i < n; i++) {
	            String cmd = sc.nextLine();

	            if (cmd.equals("SET")) {
	                int max = sc.nextInt();
	                sc.nextLine();
	                licensemanager.setMax(max);
	            } else if (cmd.equals("CHECKOUT")) {
	                licensemanager.checkOut();
	            } else if (cmd.equals("CHECKIN")) {
	                licensemanager.checkIn();
	            } else if (cmd.equals("STATUS")) {
	                licensemanager.displayStatus();
	            }
	        }
	    }
	}
