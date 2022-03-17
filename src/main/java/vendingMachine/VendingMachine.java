package vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

	private static int balance = 0, outBoxBalance = 0;
	public static String productReturned;
	public static final String ERROR = "error";
	private static Map<String, Integer> productInventory = new HashMap<String, Integer>();
	private static Map<String, Integer> coinInventory = new HashMap<String, Integer>();

	public static void initiateInventory() {
		for (Product product : Product.values()) {
			productInventory.put(product.getName(), 5);
		}
		for (Coin coin : Coin.values()) {
			coinInventory.put(coin.getName(), 5);
		}
	}

	public static void addCoin(String coin) {

		if (coin.equals("PENNY")) {
			balance = balance + Coin.PENNY.getDenomination();
			System.out.println("you entered PENNY. value: " + Coin.PENNY.getDenomination()
					+ ". Totla money you entered: " + balance);
		} else if (coin.equals("NICKEL")) {
			balance = balance + Coin.NICKLE.getDenomination();
			System.out.println("you entered NICKLE. value: " + Coin.NICKLE.getDenomination()
					+ ". Totla money you entered: " + balance);
		} else if (coin.equals("DIME")) {
			balance = balance + Coin.DIME.getDenomination();
			System.out.println("you entered DIME. value: " + Coin.DIME.getDenomination() + ". Totla money you entered: "
					+ balance);
		} else if (coin.equals("QUARTER")) {
			balance = balance + Coin.QUARTER.getDenomination();
			System.out.println("you entered QUARTER. value: " + Coin.QUARTER.getDenomination()
					+ ". Totla money you entered: " + balance);
		} else {
			outBoxBalance = balance;
			balance = 0;
			System.out.println("Invalid input. Terminating the transaction. Please collect the amount.");
		}

	}

	public static void selectProduct(String product) {

		if (product.equals(Product.COKE.getName())) {
			if (balance >= Product.COKE.getPrice()) {
				balance = balance - Product.COKE.getPrice();
				productReturned = Product.COKE.getName();
				System.out.println("Delivered your Coke. Enjoy your drink!");
			} else {
				productReturned = ERROR;
				System.out.println("Insufficient amount, retry again with correct amount. Collect your change.");
			}
		} else if (product.equals(Product.PEPSI.getName())) {
			if (balance >= Product.PEPSI.getPrice()) {
				balance = balance - Product.PEPSI.getPrice();
				productReturned = Product.COKE.getName();
				System.out.println("Delivered your PEPSI. Enjoy your drink!");
			} else {
				productReturned = ERROR;
				System.out.println("Insufficient amount, retry again with correct amount. Collect your change.");
			}
		} else if (product.equals(Product.SODA.getName())) {
			if (balance >= Product.SODA.getPrice()) {
				balance = balance - Product.SODA.getPrice();
				productReturned = Product.COKE.getName();
				System.out.println("Delivered your SODA. Enjoy your drink!");
			} else {
				productReturned = ERROR;
				System.out.println("Insufficient amount, retry again with correct amount. Collect your change.");
			}
		}
		returnChange();

	}

	private static void returnChange() {
		outBoxBalance = balance;
		if (outBoxBalance > 0)
			System.out.println("Please collect your change " + outBoxBalance + " from return box. ");
	}

}
