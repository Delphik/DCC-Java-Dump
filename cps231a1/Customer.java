/**
 * 
 */

/**
 * @author max
 *
 */
public class Customer {

	public int arrivalTime;
	public int transactionTime;
	public int customerNumber;
	public int timeWaited;

	public int getTimeWaited() {
		return timeWaited;
	}

	public void setTimeWaited(int timeWaited) {
		this.timeWaited = timeWaited;
	}

	public Customer(int clock, int newTransactionTime, int numberOfArrivals) {
		arrivalTime = clock;
		transactionTime = newTransactionTime;
		customerNumber = numberOfArrivals;

	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(int transactionTime) {
		this.transactionTime = transactionTime;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

}
