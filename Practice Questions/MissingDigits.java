// MissingDigits.java
// To find digits that do not appear in user's input number.
import java.util.*;
import java.util.Arrays;

public class MissingDigits {

	public static void main(String[] args) {
		boolean[] arr = new boolean[10];

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int inputNumber = sc.nextInt();

		System.out.print("Missing digits in " + inputNumber + ": ");

		while (inputNumber !=0) {
			Arrays.fill(arr, inputNumber % 10, inputNumber % 10 +1, true);
			inputNumber = inputNumber / 10;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true) {
				continue;
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}

