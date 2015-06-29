import java.util.*;

public class MileToKm {

	static final double KMS_PER_MILE = 1.609;

	public static void main(String[] args) {
		double miles, kms;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter distance in miles: ");
		miles = sc.nextDouble();

		kms = KMS_PER_MILE * miles;

		System.out.printf("That equals %9.2f km.\n ", kms);
	}
}
