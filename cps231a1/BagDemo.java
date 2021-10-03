
import java.math.BigInteger;
import java.util.Random;

/**
 * A test of the class MyBag. DO NOT CHANGE ANY OF THIS CODE
 * 
 * @author JLC
 */
public class BagDemo {
	public static void main(String[] args) {

		// Tests on a bag that is empty
		System.out.println("Creating an empty bag.");
		BagInterface<String> aBag = new MyBag<>();
		displayBag(aBag);
		System.out.println("In this bag empty? " + aBag.isEmpty());

		String testItem = "B";
		System.out.println("In this bag, the count of " + testItem + " is " + aBag.getFrequencyOf(testItem));
		System.out.println("Does this bag contain " + testItem + "? " + aBag.contains(testItem));
		System.out.println("\nRemoving \"" + testItem + "\" from the bag:");
		boolean result = aBag.remove(testItem);
		System.out.println("remove(\"" + testItem + "\") returns " + result);
		System.out.println("remove() returns " + aBag.remove());

		// Adding strings
		String[] content = { "A", "D", "B", "A", "C", "A", "D", "C", "B" };
		System.out.print("\nAdding to the bag: ");
		for (int index = 0; index < content.length; index++) {
			aBag.add(content[index]);
			System.out.print(content[index] + " ");
		} // end for
		System.out.println();

		displayBag(aBag);

		// Tests on a bag that is not empty
		System.out.println("In this bag empty? " + aBag.isEmpty());
		String[] test = { "A", "B", "C", "D", "Z" };
		System.out.println("\nTesting the method getFrequencyOf:");
		for (int index = 0; index < test.length; index++)
			System.out.println("In this bag, the count of " + test[index] + " is " + aBag.getFrequencyOf(test[index]));
		System.out.println("\nTesting the method contains:");
		for (int index = 0; index < test.length; index++)
			System.out.println("Does this bag contain " + test[index] + "? " + aBag.contains(test[index]));

		// Test remove()
		String removed = aBag.remove();
		System.out.println("\nremoved " + removed);
		displayBag(aBag);
		removed = aBag.remove();
		System.out.println("removed " + removed);
		displayBag(aBag);

		// Removing strings
		String[] tests = { "A", "B", "C", "D", "Z" };
		for (int index = 0; index < tests.length; index++) {
			String aString = tests[index];
			System.out.println("\nRemoving \"" + aString + "\" from the bag:");
			result = aBag.remove(aString);
			System.out.println("remove(\"" + aString + "\") returns " + result);
			displayBag(aBag);
		} // end for

		System.out.println("\nClearing the bag:");
		aBag.clear();
		System.out.println("In this bag empty? " + aBag.isEmpty());
		displayBag(aBag);

		aBag.add("Alpha");
		aBag.add("Beta");
		aBag.add("Omega");
		displayBag(aBag);

		Random random = new Random(0);
		BagInterface<BigInteger> bigIntBag = new MyBag<>();
		for (int count = 1; count <= 13; count++) {
			BigInteger next = new BigInteger(4, random);
			System.out.println(next);
			bigIntBag.add(next);
		}
		displayBag(bigIntBag);
		for (Integer value = 12; value >= 0; value--) {
			while (bigIntBag.contains(new BigInteger(value.toString()))) {
				System.out.println("Remove " + value + " " + bigIntBag.remove(new BigInteger(value.toString())));
				displayBag(bigIntBag);
			}
		}

		while (!bigIntBag.isEmpty()) {
			BigInteger item = bigIntBag.remove();
			System.out.println("removed " + item);
			displayBag(bigIntBag);
		}

	} // end main

	// Tests the method toArray while displaying the bag.
	private static <T> void displayBag(BagInterface<T> aBag) {
		System.out.println("The bag contains " + aBag.getCurrentSize() + " item(s), as follows:");
		T[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		} // end for

		System.out.println();
	} // end displayBag
} // end BagDemo
