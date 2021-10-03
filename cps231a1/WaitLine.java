public class WaitLine {
	private LinkedQueue<Customer> line;
	private LinkedQueue<Customer> line2;
	private LinkedQueue<Customer> line3;

	private int numberOfArrivals;
	private int numberServed;
	private int lineServed;
	private int line2Served;
	private int line3Served;

	private int totalTimeWaited;
	private int queueCount;

	public WaitLine() {
		line = new LinkedQueue<>();
		line2 = new LinkedQueue<>();
		line3 = new LinkedQueue<>();
		reset();
	} // end default constructor

	/**
	 * Simulates a waiting line with one serving agent
	 * 
	 * @param duration           The number of simulated minutes
	 * @param arrivalProbability A real number between 0 and 1, and the probability
	 *                           that a customer arrives at a given time
	 * @param maxTransactionTime The longest transaction time for a customer
	 */

	public void simulate(int duration, double arrivalProbability, int maxTransactionTime, int numberOfQueues) {
		reset();
		queueCount = numberOfQueues;
		int transactionTimeLeft = 0;
		Customer nextCustomer = null;
		/*
		 * If statements to decide numberOfQueues
		 */
		for (int clock = 0; clock < duration; clock++) {
			if (Math.random() < arrivalProbability) {
				numberOfArrivals++;
				int transactionTime = (int) (Math.random() * maxTransactionTime + 1);
				Customer nextArrival = new Customer(clock, transactionTime, numberOfArrivals);
				if (numberOfQueues == 1) {
					line.enqueue(nextArrival);
				} else if (numberOfQueues == 2) {
					if (shortest() == 1) {
						line.enqueue(nextArrival);

					} else if (shortest() == 2) {
						line2.enqueue(nextArrival);
					}
				} else if (numberOfQueues == 3) {
					if (shortest() == 1) {
						line.enqueue(nextArrival);
					} else if (shortest() == 2) {
						line2.enqueue(nextArrival);
					} else if (shortest() == 3) {
						line3.enqueue(nextArrival);
					}
				}
			} // end if
			if (transactionTimeLeft > 0) {
				transactionTimeLeft--;

			} else {
				if (!line.isEmpty()) {
					nextCustomer = line.dequeue();
					transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
					int timeWaited = clock - nextCustomer.getArrivalTime();
					totalTimeWaited = totalTimeWaited + timeWaited;
					lineServed++;
					numberServed++;

				}
				if (!line2.isEmpty()) {
					nextCustomer = line2.dequeue();
					transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
					int timeWaited = clock - nextCustomer.getArrivalTime();
					totalTimeWaited = totalTimeWaited + timeWaited;
					line2Served++;
					numberServed++;

				}
				if (!line3.isEmpty()) {
					nextCustomer = line3.dequeue();
					transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
					int timeWaited = clock - nextCustomer.getArrivalTime();
					totalTimeWaited = totalTimeWaited + timeWaited;
					numberServed++;
					line3Served++;
				}
			}
		} // end for

	}// end simulate

	/**
	 * Displays summary results of the simulation
	 */
	public void displayResults() {
		if (queueCount == 1) {
			System.out.println("\nSingle Queue\n");
			System.out.println("Number served = " + numberServed);
			System.out.println("Total time waited = " + totalTimeWaited);
			double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
			System.out.println("Average time waited = " + averageTimeWaited);
			int leftInLine = numberOfArrivals - numberServed;
			System.out.println("Number left in line = " + leftInLine);
			System.out.println("Line 1 Served = " + lineServed);

		} else if (queueCount == 2) {
			System.out.println("\n2 Queues\n");
			System.out.println("Number served = " + numberServed);
			System.out.println("Total time waited = " + totalTimeWaited);
			double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
			System.out.println("Average time waited = " + averageTimeWaited);
			int leftInLine = numberOfArrivals - numberServed;
			System.out.println("Number left in line = " + leftInLine);
			System.out.println("Line 1 Served = " + lineServed);
			System.out.println("Line 2 Served = " + line2Served);

		} else if (queueCount == 3) {
			System.out.println("\n3 Queues\n");
			System.out.println("Number served = " + numberServed);
			System.out.println("Total time waited = " + totalTimeWaited);
			double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
			System.out.println("Average time waited = " + averageTimeWaited);
			int leftInLine = numberOfArrivals - numberServed;
			System.out.println("Number left in line = " + leftInLine);
			System.out.println("Line 1 Served = " + lineServed);
			System.out.println("Line 2 Served = " + line2Served);
			System.out.println("Line 3 Served = " + line3Served);
		}
	}// end displayResults

	/**
	 * Determines shortest line and returns 1,2, or 3 corresponding with line,
	 * 
	 * @return
	 */
	public int shortest() {
		if (queueCount == 1) {
			return 1;
		}
		if (queueCount == 2) {
			if (line.getSize() <= line2.getSize()) {
				return 1;
			} else if (line2.getSize() <= line.getSize()) {
				return 2;
			} else
				return 1;
		}
		if (queueCount == 3) {
			if ((line.getSize() <= line2.getSize()) && (line.getSize() <= line3.getSize()))
				return 1;
			else if ((line2.getSize() <= line.getSize()) && (line2.getSize() <= line3.getSize())) {
				return 2;
			} else if ((line3.getSize() <= line.getSize()) && (line3.getSize() <= line2.getSize())) {
				return 3;
			} // else
				// return 1;
		}
		if (queueCount != 1 && queueCount != 2 && queueCount != 3) {
			throw new IllegalArgumentException();
		}
		return 1;
	}

	/**
	 * Initializes the simulation
	 */
	public final void reset() {
		line.clear();
		line2.clear();
		line3.clear();
		numberOfArrivals = 0;
		numberServed = 0;
		totalTimeWaited = 0;
		queueCount = 0;
		lineServed = 0;
		line2Served = 0;
		line3Served = 0;

	} // end reset

} // end WaitLine
