package vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

	public static int balance = 0, outBoxBalance = 0;
	public static String productReturned, messageBox, errorMessage;
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
		balance = 0;
		outBoxBalance = 0;
		messageBox = "Welcome!";
		System.out.println(messageBox);
	}

	public static void addCoin(String coin) {

		if (coin.equals("PENNY")) {
			balance = balance + Coin.PENNY.getDenomination();
			messageBox = "you entered PENNY. value: " + Coin.PENNY.getDenomination() + ". Total money you entered: "
					+ balance;
			System.out.println(messageBox);
		} else if (coin.equals("NICKEL")) {
			balance = balance + Coin.NICKLE.getDenomination();
			messageBox = "you entered NICKLE. value: " + Coin.NICKLE.getDenomination() + ". Total money you entered: "
					+ balance;
			System.out.println(messageBox);
		} else if (coin.equals("DIME")) {
			balance = balance + Coin.DIME.getDenomination();
			messageBox = "you entered DIME. value: " + Coin.DIME.getDenomination() + ". Total money you entered: "
					+ balance;
			System.out.println(messageBox);
		} else if (coin.equals("QUARTER")) {
			balance = balance + Coin.QUARTER.getDenomination();
			messageBox = "you entered QUARTER. value: " + Coin.QUARTER.getDenomination() + ". Total money you entered: "
					+ balance;
			System.out.println(messageBox);
		} else {
			outBoxBalance = balance;
			balance = 0;
			messageBox = "Invalid denomination or invalid coin. Terminating the transaction. Please collect the amount.";
			errorMessage = "Invalid denomination or invalid coin. Terminating the transaction. Please collect the amount.";
			System.out.println(messageBox);
		}

	}

	public static void selectProduct(String product) {

		if (product.equals(Product.COKE.getName())) {
			if (balance >= Product.COKE.getPrice()) {
				balance = balance - Product.COKE.getPrice();
				productReturned = Product.COKE.getName();
				messageBox = "Delivered your Coke. Enjoy your drink!";
				System.out.println(messageBox);
			} else {
				productReturned = ERROR;
				messageBox = "Insufficient amount, retry again with correct amount. Collect your change.";
				errorMessage="Insufficient amount, retry again with correct amount. Collect your change.";
				System.out.println(messageBox);
			}
		} else if (product.equals(Product.PEPSI.getName())) {
			if (balance >= Product.PEPSI.getPrice()) {
				balance = balance - Product.PEPSI.getPrice();
				productReturned = Product.PEPSI.getName();
				messageBox = "Delivered your PEPSI. Enjoy your drink!";
				System.out.println(messageBox);
			} else {
				productReturned = ERROR;
				messageBox = "Insufficient amount, retry again with correct amount. Collect your change.";
				errorMessage="Insufficient amount, retry again with correct amount. Collect your change.";
				System.out.println(messageBox);
			}
		} else if (product.equals(Product.SODA.getName())) {
			if (balance >= Product.SODA.getPrice()) {
				balance = balance - Product.SODA.getPrice();
				productReturned = Product.SODA.getName();
				messageBox = "Delivered your SODA. Enjoy your drink!";
				System.out.println(messageBox);
			} else {
				productReturned = ERROR;
				messageBox = "Insufficient amount, retry again with correct amount. Collect your change.";
				errorMessage="Insufficient amount, retry again with correct amount. Collect your change.";
				System.out.println(messageBox);
			}
		}
		returnChange();

	}

	private static void returnChange() {
		outBoxBalance = balance;
		if (outBoxBalance > 0) {
			messageBox = "Please collect your change " + outBoxBalance + " from return box. ";
			System.out.println(messageBox);
		}
	}

	public static void cancel() {
		messageBox = "You terminated the transaction.";
		System.out.println(messageBox);
		returnChange();
	}

	public static void adminReset() {
		initiateInventory();
	}

}
