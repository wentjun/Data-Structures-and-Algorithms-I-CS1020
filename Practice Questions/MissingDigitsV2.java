// MissingDigitsV2.java
// To find digits that do not appear in user's input number.
// This version uses the Vector class.
import java.util.*;

public class MissingDigitsV2 {

	public static void main(String[] args) {
		Vector<Integer> digitList;
		digitList = new Vector<Integer>();

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int inputNumber = sc.nextInt();

		System.out.print("Missing digits in " + inputNumber + ": ");
		
		while(inputNumber != 0) {
			digitList.add(inputNumber % 10);
			inputNumber = inputNumber / 10;
		}

		for (int i = 0; i < 10; i++) {
			if (!digitList.contains(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
	
