/**
 * 
 */

/**
 * @author max
 *
 */
public class DLinkedList<T> implements ListInterface<T> {

	private Node firstNode; // Reference to first node of chain
	private Node lastNode; // Reference to last node of chain
	private int numberOfEntries;

	public DLinkedList() {
		initializeDataFields();
	} // end default constructor

	/**
	 * Adds a new entry to the end of this list. Entries currently in the list are
	 * unaffected. The list's size is increased by 1.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 */
	@Override
	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if (isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			lastNode.setNextNode(newNode);
			newNode.setPrevNode(lastNode);
			lastNode = newNode;
		}
		numberOfEntries++;
	}

	/**
	 * From Handout Adds a new entry at a specified position within this list.
	 * Entries originally at and above the specified position are at the next higher
	 * position within the list. The list's size is increased by 1.
	 * 
	 * @param newPosition An integer that specifies the desired position of the new
	 *                    entry.
	 * @param newEntry    The object to be added as a new entry.
	 * @throws IndexOutOfBoundsException if either newPosition < 1 or newPosition >
	 *                                   getLength() + 1.
	 */
	@Override
	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			Node newNode = new Node(newEntry);
			if (isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			} else if (newPosition == 1) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else if (newPosition == numberOfEntries + 1) {
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			} else {
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} // end if
			numberOfEntries++;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
	}

	/**
	 * From Handout Removes the entry at a given position from this list. Entries
	 * originally at positions higher than the given position are at the next lower
	 * position within the list, and the list's size is decreased by 1.
	 * 
	 * @param givenPosition An integer that indicates the position of the entry to
	 *                      be removed.
	 * @return A reference to the removed entry.
	 * @throws IndexOutOfBoundsException if either givenPosition < 1 or
	 *                                   givenPosition > getLength().
	 */
	@Override
	public T remove(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion !isEmpty()
			if (givenPosition == 1) { // Case 1: Remove First Entry
				result = firstNode.getData();// Save entry to be removed
				firstNode = firstNode.getNextNode();
				if (numberOfEntries == 1)
					lastNode = null; // Solitary entry was removed
			} else { // Case 2: Not first entry
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
				result = nodeToRemove.getData();
				if (givenPosition == numberOfEntries)
					lastNode = nodeBefore;// Last Node was removed
			} // end if
			numberOfEntries--;
		} else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation");
		return result; // Reutrn removed entry
	}

	/** Removes all entries from this list. */
	@Override
	public void clear() {
		initializeDataFields();
	}

	/**
	 * Replaces the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the entry to
	 *                      be replaced.
	 * @param newEntry      The object that will replace the entry at the position
	 *                      givenPosition.
	 * @return The original entry that was replaced.
	 * @throws IndexOutOfBoundsException if either givenPosition < 1 or
	 *                                   givenPosition > getLength().
	 */
	@Override
	public T replace(int givenPosition, T newEntry)
	{
	   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
	   {
	      // Assertion: !isEmpty()
	      Node desiredNode = getNodeAt(givenPosition);
	      T originalEntry = desiredNode.getData();
	      desiredNode.setData(newEntry);
	      return originalEntry;
	   }
	   else
	      throw new IndexOutOfBoundsException(
	                "Illegal position given to replace operation.");
	} // end replace


	/**
	 * Retrieves the entry at a given position in this list.
	 * 
	 * @param givenPosition An integer that indicates the position of the desired
	 *                      entry.
	 * @return A reference to the indicated entry.
	 * @throws IndexOutOfBoundsException if either givenPosition < 1 or
	 *                                   givenPosition > getLength().
	 */
	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: !isEmpty()
			return getNodeAt(givenPosition).getData();
		} else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	} // end getEntry

	/**
	 * Retrieves all entries that are in this list in the order in which they occur
	 * in the list.
	 * 
	 * @return A newly allocated array of all the entries in the list. If the list
	 *         is empty, the returned array is empty.
	 */
	@Override
	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} // end while

		return result;
	} // end toArray

	/**
	 * Sees whether this list contains a given entry.
	 * 
	 * @param anEntry The object that is the desired entry.
	 * @return True if the list contains anEntry, or false if not.
	 */
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while

		return found;
	} // end contains

	/**
	 * Gets the length of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */
	@Override
	public int getLength() {
		return numberOfEntries;
	}

	/**
	 * Sees whether this list is empty.
	 * 
	 * @return True if the list is empty, or false if not.
	 */
	@Override
	public boolean isEmpty() {
		boolean result;

		if (numberOfEntries == 0) // Or getLength() == 0
		{
			// Assertion: firstNode == null
			result = true;
		} else {
			// Assertion: firstNode != null
			result = false;
		} // end if

		return result;
	} // end isEmpty

	public void displayList() {
		System.out.println("The list contains " + numberOfEntries + " entries, as follows:");
		Node currentNode = firstNode;
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNextNode();

		}
	}// end displayList

	// Returns a reference to the node at a given position.
	// Precondition: The chain is not empty;
	// 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		// Assertion: (firstNode != null) &&
		// (1 <= givenPosition) && (givenPosition <= numberOfEntries)
		Node currentNode = firstNode;

		// Traverse the chain to locate the desired node
		// (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();
		// Assertion: currentNode != null
		return currentNode;
	} // end getNodeAt

	/*
	 * Sets first and last nodes to null and numberOfEntries equal to 0
	 */
	private void initializeDataFields() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} // end initializeDataFields

	private class Node {
		private T data; // Entry in list
		private Node next; // Link to next node
		private Node prev; // Link to previous node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
			prev = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode, Node prevNode) {
			data = dataPortion;
			next = nextNode;
			prev = prevNode;

		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode

		/**
		 * @return the prev
		 */
		public Node getPrevNode() {
			return prev;
		}

		/**
		 * @param prev the prev to set
		 */
		public void setPrevNode(Node prevNode) {
			prev = prevNode;
		}

	} // end Node
}
