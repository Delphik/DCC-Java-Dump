/**
 * author max
 */

public interface QueueInterface<T> {
	/**
	 * adds a new entry to the back of this queue
	 * 
	 * @param newEntry
	 */
	public void enqueue(T newEntry);

	/**
	 * Removes and returns the entry at the front of this queue
	 * 
	 * @return The object at the front of the Queue
	 * @throws EmptyQueueException if empty before operation
	 */
	public T dequeue();

	/**
	 * Retrieves the entry at the front of this queue
	 * 
	 * @return The object at the front of the queue
	 * @throws EmptyQueueException if the queue is empty
	 */

	public T getFront();

	/**
	 * Detects whether this queue is empty
	 * 
	 * @return True if the queue is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Removes all Entries from this queue
	 */
	public void clear();
	
	
}
