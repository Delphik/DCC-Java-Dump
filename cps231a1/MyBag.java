import java.util.Arrays;

public class MyBag<T> implements BagInterface<T> {

	private T[] bag;
	private int numberOfEntries;
	private static final int MAX_CAPACITY = 10000;

	/*
	 * Default Constructor
	 */

//	public MyBag(int initialCapacity) {
//		checkCapacity(initialCapacity);
//		@SuppressWarnings("unchecked")
//		T[] tempBag = (T[]) new Object[initialCapacity];
//		bag = tempBag;
//		numberOfEntries = 0;
//	}

	public MyBag() {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[500];
		bag = tempBag;
		numberOfEntries = 0;
	}

	/**
	 * Creates a bag containing given entries
	 * 
	 * @param contents
	 */
	public MyBag(T[] contents) {
		checkCapacity(contents.length);
		bag = Arrays.copyOf(contents, contents.length);
		numberOfEntries = contents.length;

	}

	/**
	 * Gets the current number of entries in this bag.
	 * 
	 * @return The integer number of entries currently in the bag.1
	 */
	public int getCurrentSize() {
		return this.numberOfEntries;
	}

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return True if the bag is empty, or false if not.
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Adds a new entry to this bag, so that duplicates are next to each other
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean add(T newEntry) {
		if (isArrayFull()) {
			doubleCapacity();
		}
		if (contains(newEntry) == true) {
			int lastIndex = numberOfEntries - 1;
			int dupeIndex = getIndexOf(newEntry);
			for (int i = lastIndex; i > dupeIndex; i--) {
				bag[i] = bag[i + 1];
			}
			bag[dupeIndex] = newEntry;
		} else {
			bag[numberOfEntries] = newEntry;
		}

		numberOfEntries++;
		return true;
	}

	/**
	 * Removes one unspecified entry from this bag, if possible, and keeps duplicate
	 * items next to each other
	 * 
	 * @return Either the removed entry, if the removal. was successful, or null.
	 */
	public T remove() {
		T result = removeEntry(numberOfEntries - 1);
		return result;
	}

	/**
	 * Removes one occurrence of a given entry from this bag, if possible, and keeps
	 * duplicate items next to each other
	 * 
	 * @param anEntry The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean remove(T anEntry) {
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);

	}

	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	}

	/**
	 * Counts the number of times a given entry appears in this bag. NOTE: this
	 * method should take advantage of the requirement that duplicate items are next
	 * to each other in the bag and stops counting once the end of the duplicate
	 * sequence is encountered
	 * 
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in the bag.
	 */
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for (int index = 0; index < numberOfEntries; index++) {
			if (anEntry.equals(bag[index])) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Locates a given entry and returns index of said entry
	 * 
	 * @param anEntry
	 * @return
	 */
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;

		while (!found && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		return where;
	}

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry The entry to find.
	 * @return True if the bag contains anEntry, or false if not.
	 */
	public boolean contains(T anEntry) {
		return getIndexOf(anEntry) > 1;
	}

	/*
	 * Removes and returns entry at a given index, if no such entry exists return
	 * null
	 */
	private T removeEntry(int givenIndex) {
		T result = null;
		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex];
			bag[lastIndex] = null;
			numberOfEntries--;
		}
		return result;
	}

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries in the bag. Note: If the
	 *         bag is empty, the returned array is empty.
	 */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		}
		return result;
	}

	/*
	 * Returns true if the array bag is full
	 */
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	}

	/*
	 * Doubles the size of the array bag
	 */
	public void doubleCapacity() {
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	}

	/*
	 * Throws an exception if client requests a capacity that is too large
	 */
	public void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalStateException("Capacity exceeds Max capacity");
		}
	}

}
