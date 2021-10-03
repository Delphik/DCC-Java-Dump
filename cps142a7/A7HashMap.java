import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 * @author maxh
 *
 */
public class A7HashMap {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	
		Map <Integer, GroceryItem> groceryMap = new HashMap(5150);
		fileToArray();
		for(int i:gItems) {	
		}
			
	}
	
	
	
	/**
	 * populates array from file
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	
	public static <T extends Comparable<T>> GroceryItem[] fileToArray() throws IOException, FileNotFoundException {
		int FileIndex = 0;
		GroceryItem[] gItems = new GroceryItem[5150];
		File file = new File("GroceryData.txt");
		Scanner inputFile = new Scanner(file);
		while (inputFile.hasNext()) {
			String line = inputFile.nextLine();
			String[] tokens = line.split(";");
			gItems[FileIndex] = new GroceryItem(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]),
					Integer.parseInt(tokens[4]));
			System.out.println(gItems[FileIndex]);
			FileIndex++;
		}
		return null; // error returning gItems[]
	}}
