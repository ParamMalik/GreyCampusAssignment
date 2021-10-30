package com.trantor;

import java.util.Scanner;

public class TakingDataFromUserToUpdateInTable {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter CID where you want to update : ");
		int cid = scan.nextInt();
		System.out.println("Enter firstName : ");
		String firstName = scan.next();
		System.out.println("Enter lastName : ");
		String lastName = scan.next();
		System.out.println("Enter street :");
		String street = scan.next();
		System.out.println("Enter city : ");
		String city = scan.next();
		System.out.println("Enter state : ");
		String state = scan.next();
		System.out.println("Enter ZIP Code : ");
		int zipCode = scan.nextInt();
		
		CustomerDetails details = new CustomerDetails();
		details.setCid(cid);
		details.setFirstName(firstName);
		details.setLastName(lastName);
		details.setStreet(street);
		details.setCity(city);
		details.setState(state);
		details.setZipCode(zipCode);
		
		UpdateDataIsInCustomerDetailsTable update = new UpdateDataIsInCustomerDetailsTable();
		int i = update.updateRecord(details);
		System.out.println(i + " record updated.");
		scan.close();

	}

}

