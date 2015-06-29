// TestMyDate class.
// Fill in the parts that are marked "WRITE YOUR CODE HERE."

import java.util.*;
import java.util.InputMismatchException;

public class TestMyDate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Enter the year, month and day (as integers): ");
       
        int year = 0;
		int month = 0;
		int day = 0;
		
		try {
			year = sc.nextInt();
			month = sc.nextInt();
			day = sc.nextInt();	
		} catch (InputMismatchException expObj) {
			System.out.println("Invalid integer input.");
            return;
		}

        // Read the integers year, month and day from the input using 
        // Scanner's nextInt(). 
        // If nextInt() throws an InputMismatchException, then print an
        // error message "Invalid integer input." and terminate program.
       
        // =======================
        // WRITE YOUR CODE HERE.
        // =======================
       
        // Create a MyDate instance with the input year, month and day.
        // If MyDate constructor throws an InvalidDateException, then print
        // the message in the exception and terminate program.
       
        // =======================
        // WRITE YOUR CODE HERE.
        // =======================
		MyDate date;       
       
        // Print out the date input by the user.
		try {
		    date = new MyDate(year, month, day);
		} catch (InvalidDateException e) {
			System.out.println(e.getMessage());
			return;
		}
       	System.out.println("The date you entered is " + date + ".");	
	}
}
