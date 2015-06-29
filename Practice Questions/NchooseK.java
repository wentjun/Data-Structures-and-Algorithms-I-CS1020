// This program reads in a string of N distinct letters in alphabetical order
// and prints all K-letter strings from it also in alphabetical order.

import java.util.*;

public class NchooseK {

	public static void main(String[] args) {

		// Read input data
		Scanner sc = new Scanner(System.in);
		int numOfLetters = sc.nextInt();
		String str = sc.next();

		generate(numOfLetters, str, "");
	}

	// Driver (auxiliary) method to call recursive method 
	public static void generate(int k, String str, String substr) {
		if (str.length() == k) {
			System.out.println(substr + str);
		} 
		else if (k == 0) {
			System.out.println(substr);
		}
		else {
			generate(k-1, str.substring(1), substr + str.charAt(0));
			generate(k, str.substring(1), substr);
		}
	}
}

