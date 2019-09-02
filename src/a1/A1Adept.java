package a1;

import java.util.Scanner;
import java.util.Arrays;
public class A1Adept {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		
		//global 
		int numberOfItemsInStore = key.nextInt();
			//parallel arrays for the items and prices
		String[] items = new String[numberOfItemsInStore];
		double[] itemPrices = new double[numberOfItemsInStore];
		
		//updates the array of names of items in the store and their respective prices
		for(int p = 0; p < numberOfItemsInStore; p++) {
			items[p] = key.next().toLowerCase();
			itemPrices[p] = key.nextDouble();
		}
		
		int numberOfCustomers = key.nextInt();
		//parallel arrays to store the customers' names
		double[] customerSpendingOrder = new double[numberOfCustomers];
		String[] customerNameOrder = new String[numberOfCustomers];
	
		for(int i = 1; i <= numberOfCustomers; i++) {
			//local
			double totalSpent = 0;
			String firstName = key.next();
			String lastName = key.next();
			//updates the array of names
			customerNameOrder[i - 1] = firstName + " " + lastName;
			int numberOfItemsBought = key.nextInt();
			
			//updates the amount that each respective customer spent in total 
			for(int n = 1; n <= numberOfItemsBought; n++) {
				int quantity = key.nextInt();
				String item = key.next().toLowerCase();
				double price = itemPrices[Arrays.asList(items).indexOf(item)];
				double spentOnItem = quantity * price;
				totalSpent += spentOnItem;
			}
			
			//updates the total amount spent in the array for each customer's 'total spent' value
			customerSpendingOrder[i - 1] = totalSpent;
		}
		
		//organizes both customer arrays simultaneously in descending order
		for(int m = 0; m < customerSpendingOrder.length; m++) {
			for(int j = m + 1 ; j < customerSpendingOrder.length; j++) {				
				if(customerSpendingOrder[m] < customerSpendingOrder[j]) {
					double temp = customerSpendingOrder[m];
					String temp1 = customerNameOrder[m];
		            customerSpendingOrder[m] = customerSpendingOrder[j];
		            customerNameOrder[m] = customerNameOrder[j];
		            customerSpendingOrder[j] = temp;
		            customerNameOrder[j] = temp1;
		        }
		    }
		}
		
		double totalAllSpent = 0;
		
		//calculates the total amount spent by all customers (for the avg calculation)
		for(int k = 0; k < customerSpendingOrder.length; k++) {
			totalAllSpent += customerSpendingOrder[k];
		}
		
		//prints output
		System.out.printf("Biggest: " + customerNameOrder[0] + " (%1.2f)" , customerSpendingOrder[0]);
		System.out.println();
		System.out.printf("Smallest: " + customerNameOrder[customerNameOrder.length - 1] + " (%1.2f)" , customerSpendingOrder[customerSpendingOrder.length - 1]);
		System.out.println();
		System.out.printf("Average: %1.2f", totalAllSpent/numberOfCustomers); //calculates the average amount spent 
		System.out.println();

		key.close();
	}
}
