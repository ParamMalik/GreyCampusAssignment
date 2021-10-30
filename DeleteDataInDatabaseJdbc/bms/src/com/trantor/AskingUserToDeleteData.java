package com.trantor;

import java.util.Scanner;

public class AskingUserToDeleteData {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter CID no from where you want to delete record : ");
		int cid = scan.nextInt();
		
		CustomerDetails details = new CustomerDetails();
		details.setCid(cid);
		
		DeleteDataFromCustomerDetailsTable cdata = new DeleteDataFromCustomerDetailsTable();
		int i = cdata.deleteRecord(details);
		
		System.out.println(i + " Record Deleted.");
		
		scan.close();
	}

}
