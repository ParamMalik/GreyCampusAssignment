package com.trantor;

import java.util.Scanner;

public class TakingDataFromUser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter CID : ");
		int cid = scan.nextInt();
		System.out.println("Enter First Name :");
		String firstName = scan.next();
		System.out.println("Enter Last Name : ");
		String lastName = scan.next();
		System.out.println("Enter Street : ");
		String street = scan.next();
		System.out.println("Enter City : ");
		String city = scan.next();
		System.out.println("Enter State : ");
		String state = scan.next();
		System.out.println("Enter ZipCode : ");
		int zipCode = scan.nextInt();
		System.out.println("Enter Product Name : ");
		String productName = scan.next();
		System.out.println("Enter Created On :  (yyyy-mm-dd)");
		String createdOn = scan.next();
		System.out.println("Enter Created By : ");
		String createdBy = scan.next();
		System.out.println("Enter Updated On :  (yyyy-mm-dd)");
		String updatedOn = scan.next();
		System.out.println("Enter Updated By : ");
		String updatedBy = scan.next();

		CustomersDetail detail = new CustomersDetail();
		detail.setCid(cid);
		detail.setFirstName(firstName);
		detail.setLastName(lastName);
		detail.setStreet(street);
		detail.setCity(city);
		detail.setState(state);
		detail.setZipCode(zipCode);
		detail.setProductName(productName);
		detail.setCreatedOn(createdOn);
		detail.setCreatedBy(createdBy);
		detail.setUpdateOn(updatedOn);
		detail.setUpdatedBy(updatedBy);

		InsertingDataIntoTableJdbc data = new InsertingDataIntoTableJdbc();
		int i = data.insertData(detail);

		System.out.println(i + " row inserted");

		scan.close();

	}

}
