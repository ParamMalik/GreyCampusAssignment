package com.trantor;

import java.util.ArrayList;

public class DisplayingFetchedData {

	public static void main(String[] args) {
		

		FetchingDataFromCustomerDetails details = new FetchingDataFromCustomerDetails();
		
     
		ArrayList<CustomerDetails> emplist = details.fetchRecords();
		emplist.forEach(customer -> {
			
			System.out.println("");
			System.out.println(customer.getCid());
			System.out.println(customer.getFirstName());
			System.out.println(customer.getLastName());
			System.out.println(customer.getStreet());
			System.out.println(customer.getCity());
			System.out.println(customer.getState());
			System.out.println(customer.getZipCode());
			System.out.println(customer.getProductName());
			System.out.println(customer.getCreatedOn());
			System.out.println(customer.getCreatedBy());
			System.out.println(customer.getUpdateOn());
			System.out.println(customer.getUpdatedBy());

			System.out.println();
		});

	}

}
