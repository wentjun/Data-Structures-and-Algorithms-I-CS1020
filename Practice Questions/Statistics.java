// This program computes the mean and standard deviation
// of an array of values.

// Add import statement(s) below
import java.util.*;
import java.text.*;

public class Statistics {

	public static void main(String[] args) {

		int[] arr = readArray();

		DecimalFormat df1 = new DecimalFormat("0.000");

		// For checking; remove the following 2 lines before submission
		//System.out.println("values: ");
		//printArray(arr);

		System.out.println("Mean = " + 
				df1.format(computeMean(arr)));
		System.out.println("Standard deviation = " + 
				df1.format(computeStdDev(arr)));
	}

	// Read a list of values into an array arr
	public static int[] readArray() {

		int arraySize = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter size of array: ");
		arraySize = sc.nextInt();		
		int[] arr = new int[arraySize];
		if (arraySize == 1) {
			System.out.println("Enter " + arraySize + " value: ");
			for (int i = 0; i < arraySize; i++) {
				arr[i] = sc.nextInt();
			}
			return arr;
		} else {
			System.out.println("Enter " + arraySize + " values: ");
			for (int i = 0; i < arraySize; i++) {
				arr[i] = sc.nextInt();
			}

			return arr;
		}
	}
		// Compute mean of the values in arr
		// Precond: arr.length > 0
		public static double computeMean(int[] arr) {
			int sum = 0;
			if (arr.length > 0) {
				for (int i =0; i < arr.length; i++) {
					sum += arr[i];
				}

				return (double) sum / arr.length;
			} else {
				return 0;
			}
		}
		// Compute standard deviation of the values in arr
		// Precond: arr.length > 0
		public static double computeStdDev(int[] arr) {
			double mean = computeMean(arr);
			double sumSquare = 0.0;
			if (arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					sumSquare += Math.pow((arr[i] - mean) , 2);
				}

				return Math.sqrt(sumSquare * (1.0/arr.length));
			} else {
				return 0;
			}
		}
		// Print the array arr on a single line.
		// Note that the last element has a space after it.
		public static void printArray(int[] arr) {
			for (int element: arr) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

