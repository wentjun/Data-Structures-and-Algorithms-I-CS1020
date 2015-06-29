import java.util.*;

public class CircleArea {

	public static double area(double r) {
		return Math.PI*Math.pow(r, 2);
	}

	public static void main(String[] args) { 
		double lengthSquare;   //length of side of a square
		double radius;		   //radius of circle

		Scanner sc = new Scanner(System.in);
		
		//gets the input of length of side of square
		System.out.print("Enter side of square: ");
		lengthSquare = sc.nextDouble();
		
		//formula for radius of circle by pythagoras's theorem
		radius = (Math.hypot(lengthSquare, lengthSquare)) / 2;
		
		//prints the area of circle
		System.out.printf("Area of circle = %.2f\n",
						  area(radius));
	}
}
