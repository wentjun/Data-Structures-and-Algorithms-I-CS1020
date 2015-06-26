// CS1020 (AY2014/5 Semester 2)
// Name: CHAN WEN TJUN
// Matric. No.: A0121262
// Lab group: (not allocated yet)
/* This program will read an input of a string in the UK date format
and output the date in American format. It will also check if the date 
falls on a leap year.
*/

import java.util.*;
public class DateConvert {

	// metod class to check if the year is a leap year
	public static boolean isLeapYear(int year) {
		return ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 !=  0)));
	}

	public static void main(String[] args) {
		String date, month;
		int year;
		boolean leapYear;

		Scanner sc = new Scanner(System.in);
		//reads input 
		System.out.print("Enter date in UK format: ");
		month = sc.next();
		date = sc.next();
		year = sc.nextInt();

		System.out.print("Date in American format: ");
		System.out.println(date.replace(",", "") + " " + month + " " + year);
		
		leapYear = isLeapYear(year);
		//prints whether the year is a leap year or not
		if (leapYear) {
			System.out.println(year + " is a leap year.");
		} else {
			System.out.println(year + " is not a leap year.");
		}
	}
}
