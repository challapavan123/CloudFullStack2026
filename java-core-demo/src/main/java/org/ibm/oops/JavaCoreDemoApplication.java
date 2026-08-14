package org.ibm.oops;


//@SpringBootApplication
public class JavaCoreDemoApplication {

	public static void main(String[] args) {
		
		
		MinMaxArray<Integer> intArray = new MinMaxArrayImpl<>(3, 5, 1, 8, 2);
		System.out.println("Max: " + intArray.findMax());
		System.out.println("Min: " + intArray.findMin());

		MinMaxArray<String> strArray = new MinMaxArrayImpl<>("apple", "banana", "cherry");
		System.out.println("Max: " + strArray.findMax());
		System.out.println("Min: " + strArray.findMin());	

		MinMaxArray<Double> doubleArray = new MinMaxArrayImpl<>
		(3.0, 1.0, 4.0, 2.0);
		System.out.println("Max: " + doubleArray.findMax());
		System.out.println("Min: " + doubleArray.findMin());

		MinMaxArray<Character> charArray = new MinMaxArrayImpl<>('z', 'a', 'm', 'b');
		System.out.println("Max: " + charArray.findMax());
		System.out.println("Min: " + charArray.findMin());

		MinMaxArray<Transaction> transactionArray = new MinMaxArrayImpl<>
		(new Transaction(1L, 78654.5, "Payment for services"),
		new Transaction(2L, 12345.0, "Refund for order"),
		new Transaction(3L, 98765.0, "Payment for products"),
		new Transaction(4L, 54321.0, "Refund for subscription"));
		System.out.println("Min Trxn	"+transactionArray.findMin());
		System.out.println("Max Trxn "+transactionArray.findMax());
	}

}
