/*
*//**
	*
	*/
/*
 * import java.util.ArrayList; import java.util.Scanner; import java.io.*;
 * 
 *//**
	 * @author maxh
	 *
	 */
/*
 * public class A5 { public static <T extends Comparable<T>> void main(String[]
 * args) throws FileNotFoundException, IOException {
 * 
 * //ileToArray(); A5GItems[] GItems = fileToArray(); }
 * 
 *//**
	 * Generic Binary Search
	 *
	 * @param array
	 * @param value
	 * @return
	 */
/*
 * public static <T extends Comparable<T>> int search(T[] array, T value) { int
 * first; int last; int middle; int position; boolean found;
 * 
 * first = 0; last = array.length - 1; position = -1; found = false;
 * 
 * while (!found && first <= last) { middle = (first + last) / 2; if
 * (array[middle] == value) { found = true; position = middle; } else if
 * (array[middle].compareTo(value) > 1) last = middle - 1; else first = middle +
 * 1; } return position; }
 * 
 *//**
	 * calls doQuickSort to sort an array
	 *
	 * @param array
	 */
/*
 * public static <T extends Comparable<T>> void quickSort(int array[]) {
 * doQuickSort(array, 0, array.length - 1); }
 * 
 *//**
	 * uses quicksort algorithm to sort an array
	 *
	 * @param array
	 * @param start
	 * @param end
	 */
/*
 * public static <T extends Comparable<T>> void doQuickSort(int array[], int
 * start, int end) { int pivotPoint; if (start < end) { pivotPoint =
 * partition(array, start, end); doQuickSort(array, start, pivotPoint - 1);
 * doQuickSort(array, pivotPoint + 1, end); } }
 * 
 *//**
	 * swaps contents of 2 arrays
	 *
	 * @param array
	 * @param a
	 * @param b
	 */
/*
 * public static <T extends Comparable<T>> void swap(int[] array, int a, int b)
 * { int temp; temp = array[a]; array[a] = array[b]; array[b] = temp; }
 * 
 *//**
	 * Partition
	 *
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
/*
 * public static <T extends Comparable<T>> int partition(int array[], int start,
 * int end) { int pivotValue; int endOfLeftList; int mid; mid = (start + end) /
 * 2; swap(array, start, mid); pivotValue = array[start]; endOfLeftList = start;
 * for (int scan = start + 1; scan <= end; scan++) { if (array[scan] <
 * pivotValue) { endOfLeftList++; swap(array, endOfLeftList, scan); } }
 * swap(array, start, endOfLeftList); return endOfLeftList; }
 * 
 *//**
	 * populates array from file
	 *
	 * @return
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 *//*
		 * public static <T extends Comparable<T>> A5GItem<T>[] fileToArray() throws
		 * IOException, FileNotFoundException { int FileIndex = 0; A5GItem[] gItems =
		 * new A5GItem[5150]; File file = new File("GroceryData.txt"); Scanner inputFile
		 * = new Scanner(file); while (inputFile.hasNext()) { String line =
		 * inputFile.nextLine(); String[] tokens = line.split(";"); gItems[FileIndex] =
		 * new A5GItem(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]),
		 * Integer.parseInt(tokens[4])); System.out.println(gItems[FileIndex]);
		 * FileIndex++; } // return gItems[]; }}
		 */