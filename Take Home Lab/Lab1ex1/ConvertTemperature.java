// CS1020 (AY2014/5 Semester 2)
// Take-home Lab1 Ex1
// Name: CHAN WEN TJUN
// Matric. No.: A0121262
// Lab group: 7
/*
   This program reads a temperature entered by the user, and the user selects
   the scale that it is currently in (fromScale), and converts it to another 
   scale (toScale).
 */

import java.util.*;
import java.text.DecimalFormat;

public class ConvertTemperature {
	//method to convert Fahrenheit to Celsius
	private static double fToC (double temperature) {
		return ((5.0 / 9.0) * (temperature - 32));
	}
	//method to convert Fahrenheit to Kelvin
	private static double fToK (double temperature) {
		return (fToC(temperature) + 273.15);
	}
	//method to convert Celsius to Fahrenheit
	private static double cToF (double temperature) {
		return (1.8 * temperature + 32);
	}
	//method to convert Celsius to Kelvin
	private static double cToK (double temperature) {
		return (temperature + 273.15);
	}
	//method to convert Kelvin to Celsius
	private static double kToC (double temperature) {
		return (temperature - 273.15);
	}
	//method to convert Kelvin to Fahrenheit
	private static double kToF (double temperature) {
		return (1.8 * kToC(temperature) + 32);
	}
	//asks user the initial source scale of the temperature he/she enters
	private static void printMenuSource() {
		System.out.println();
		System.out.println("Choose source scale:");
		System.out.println("  1. Celsius");
		System.out.println("  2. Fahrenheit");
		System.out.println("  3. Kelvin");
		System.out.print("Enter your choice: ");
	}

	private static void printMenuDest(int fromScale) {
		System.out.println();
		System.out.println("Choose destination scale:");
	}
	//converts the temperature to the respective scale that the user
	//selects. Prints the result string which contains the converted temperature
	private static void convert(double temperature, int fromScale, int toScale) {
		double convertedTemperature = 0.00;
		String from = "";
		String to = "";

		DecimalFormat df1 = new DecimalFormat("0.00");
		
		if (fromScale == 1 && toScale == 1) {   
			from = "Celsius";
			to = "Fahrenheit";
			convertedTemperature = cToF(temperature);
		} else if (fromScale == 1 && toScale == 2) {
			from = "Celsius";
			to = "Kelvin";
			convertedTemperature = cToK(temperature);
		} else if (fromScale == 2 && toScale == 1) {
			from = "Fahrenheit";
			to = "Celsius";
			convertedTemperature = fToC(temperature);
		} else if (fromScale == 2 && toScale == 2) {
			from = "Fahrenheit";
			to = "Kelvin";
			convertedTemperature = fToK(temperature);
		} else if (fromScale == 3 && toScale == 1) {
			from = "Kelvin";
			to = "Celsius";
			convertedTemperature = kToC(temperature);
		} else if (fromScale == 3 && toScale == 2) {
			from = "Kelvin";
			to = "Fahrenheit";
			convertedTemperature = kToF(temperature);
		} else {
			;
		}

		System.out.println();
		System.out.println(temperature + 
				" degrees " + 
				from + 
				" = " +
				df1.format(convertedTemperature) +
				" degrees " +
				to);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter temperature: ");
		double temperature = sc.nextDouble();
		printMenuSource();
		int fromScale = sc.nextInt();
		printMenuDest(fromScale);
		//asks user for destination scale
		if (fromScale == 1) {           //user selects Celsius for source scale
			System.out.println("  1. Fahrenheit");
			System.out.println("  2. Kelvin");
			System.out.print("Enter your choice: ");
		} else if (fromScale == 2) {   //user selects Fahrenheit for source scale
			System.out.println("  1. Celsius");
			System.out.println("  2. Kelvin");
			System.out.print("Enter your choice: ");
		} else if (fromScale == 3) {   //user selects Kelvin for source scale
			System.out.println("  1. Celsius");
			System.out.println("  2. Fahrenheit");
			System.out.print("Enter your choice: ");
		} else {
			System.out.println("Please select 1, 2, or 3 ONLY");	
		}

		int toScale = sc.nextInt();
		//calls convert method to get converted temperature
		convert(temperature, fromScale, toScale);
	}
}
