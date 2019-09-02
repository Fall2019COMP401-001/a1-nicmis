package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);

//		System.out.println("How many customers?");
		int numberOfCustomers = key.nextInt();
		for(int i = 1; i <= numberOfCustomers; i++) {
			double totalSpent = 0;
//			System.out.println("first name:");
			String firstName = key.next();
			char firstLetter = firstName.charAt(0);
//			System.out.println("last name:");
			String lastName = key.next();
//			System.out.println("num items");
			int numberOfItemsBought = key.nextInt();
			for(int n = 1; n <= numberOfItemsBought; n++) {
//				System.out.println("quantity");
				int quantity = key.nextInt();
//				System.out.println("item");
				String item = key.next();
//				System.out.println("price");
				double price = key.nextDouble();
				double spentOnItem = quantity * price;
				totalSpent += spentOnItem;
			}
			System.out.printf(firstLetter + ". " + lastName + ": " + "%1.2f" , totalSpent);
			System.out.println("\n");
		}
		
		key.close();
		
	}
}
