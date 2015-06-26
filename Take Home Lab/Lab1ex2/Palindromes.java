// CS1020 (AY2014/5 Semester 2)
// Take-home Lab1 Ex2
// Name: CHAN WEN TJUN
// Matric. No.: A0121262
// Lab group: 7
/* This program reads a series of input sentences, and will run a check
if each of the input is a valid palindrome. The program will continue asking
for an input until the user terminates the program. The number of palindromes 
among the input will be printed as a result.
*/

import java.util.*;

public class Palindromes {
	// this method tests if the input is a Palindrome.
	// reverses the input, and will return true if the reversed input is a Palindrome
	private static boolean isPalindrome (String input) {
		int lengthInput;
		String reverse = "";

		lengthInput = input.length();

		for (int i = lengthInput - 1; i >= 0; i--) {
	        reverse = reverse + input.charAt(i);
		}

		if (input.equals(reverse)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int numPalindromes = 0;
		boolean validPalindrome = true;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter text: ");
		
		while (sc.hasNextLine()) {
			String inputText = sc.nextLine();
			//converts the input text to lower case, as well as removing
			//case and non-letters. This is to facilitate the input to be tested
			//if it is a valid palindrome.
			String sameCaseText = inputText.toLowerCase();
			String filterText4 = sameCaseText.replaceAll("\\W|\\d", "");

			validPalindrome = isPalindrome(filterText4);
			//if the input sentence is a palindrome, the counter will increase by 1
			if (validPalindrome) {
				numPalindromes++;
			} else {
				;
			}
			System.out.print("Enter text: ");
		}

		// prints out the number of valid palindromes amongst the input
		System.out.println("Number of palindromes = " + numPalindromes);
	}
}
