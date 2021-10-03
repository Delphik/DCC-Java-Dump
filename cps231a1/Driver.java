/**
 * 
 */

/**
 * @author max
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WaitLine customerLine = new WaitLine();
		customerLine.simulate(720, 0.5, 5, 1);
		customerLine.displayResults();
		
		customerLine.simulate(720, 0.5, 5, 2);
		customerLine.displayResults();
		
		customerLine.simulate(720, 0.5, 5, 3);
		customerLine.displayResults();
		System.out.println("\n\nDone.");
	} // end main

}// end Driver
