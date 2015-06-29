import java.util.*;

class TestCentredBall {

	// This method reads ball's input data from user, creates
	// a ball object, and returns it to the caller.
	public static CentredBall readBall(Scanner sc) {

		System.out.print("Enter colour, radius and centre: ");
		String inputColour = sc.next();
		double inputRadius = sc.nextDouble();
		int inputCentreX = sc.nextInt();
		int inputCentreY = sc.nextInt();

		return new CentredBall(inputColour, inputRadius, inputCentreX, inputCentreY);
	}

	public static CentredBall compare(CentredBall b1, CentredBall b2) {
		if ((b1.getRadius()) > (b2.getRadius())) {
			return b1;
		} else if ((b1.getRadius()) < (b2.getRadius())) {
			return b2;
		} else {
			return b1;			//if both b1 and b2 have same radius
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read input and create 1st ball object
		System.out.println("1st ball");
		CentredBall b1 = readBall(scanner);

		// Read input and create 2nd ball object
		System.out.println("2nd ball");
		CentredBall b2 = readBall(scanner);

		// Read input and create 3rd ball object
		System.out.println("3rd ball");
		CentredBall b3 = readBall(scanner);
		System.out.println();

		if (b1.equals(b2)) {
			System.out.println("1st and 2nd balls are the same.");
		} else {
			System.out.println("1st and 2nd balls are not the same.");
		}

		System.out.println("The largest ball created is:");
		System.out.println(compare(compare(b1,b2), b3).toString());
	}
}

