package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
Scanner key = new Scanner(System.in);
		
		//global 
		int numberOfItemsInStore = key.nextInt();
		String[] items = new String[numberOfItemsInStore];
		int[] itemCounts = new int[numberOfItemsInStore];
		int[] itemCustomerCounts = new int[numberOfItemsInStore];
	
		for(int p = 0; p < numberOfItemsInStore; p++) {
			items[p] = key.next();
			//takes in the data, but doesn't do anything with it
			double itemPrice = key.nextDouble();
		}
		
		int numberOfCustomers = key.nextInt();
	
		for(int i = 1; i <= numberOfCustomers; i++) {
			//takes in the data, but doesn't do anything with it
			String firstName = key.next();
			String lastName = key.next();
			int numberOfItemsBought = key.nextInt();
			String[] itemsBought = new String[numberOfItemsBought];
			
			for(int n = 0; n < numberOfItemsBought; n++) {
				int quantity = key.nextInt();
				itemsBought[n] = key.next();
				
				int counter = 0;
				for(int s = 0; s < numberOfItemsBought; s++) {
					if(itemsBought[n].equalsIgnoreCase(itemsBought[s]))
						counter++;
				}	
				
				if(counter == 1)
					itemCustomerCounts[Arrays.asList(items).indexOf(itemsBought[n])]+= 1;

				itemCounts[Arrays.asList(items).indexOf(itemsBought[n])] += quantity;
			}
			
		}
		
		for(int m = 0; m < items.length; m++) {
			
			if(itemCounts[m] == 0) 
				System.out.println("No customers bought " + items[m]);
			else
				System.out.println(itemCustomerCounts[m] + " customers bought " + itemCounts[m] + " " + items[m]);
		}

		key.close();		
		
	}
}
