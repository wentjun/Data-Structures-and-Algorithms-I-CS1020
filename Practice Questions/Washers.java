import java.util.*;

public class Washers {
	//To calculate area of a circle
	public static double circleArea(double diameter) {
		return Math.PI * Math.pow((diameter / 2), 2);
	}

	public static void main(String[] args) {
		double d1,        //hole circle's diameter
			   d2, 		  //big circle's diameter
			   thickness, 
			   density;
		int    qty;

		double unit_weight,     //single washer's weight
			   total_weight,    // a batch of washer's total weight
			   rim_area;		//single washer's rim area

		Scanner sc = new Scanner(System.in);

		System.out.print("Inner diameter in cm: ");
		d1 = sc.nextDouble();
		System.out.print("Outer diameter in cm: ");
		d2 = sc.nextDouble();
		System.out.print("Thickness in cm: ");
		thickness = sc.nextDouble();
		System.out.print("Density in grams per cubic cm: ");
		density = sc.nextDouble();
		System.out.print("Quantity: ");
		qty = sc.nextInt();

		// compute weight of a single washer
		rim_area = circleArea(d2) - circleArea(d1);
		unit_weight = rim_area * thickness * density;

		//compute weight of a batch of washers
		total_weight = unit_weight * qty;

		System.out.printf("Total weight of %d washers is %.2f grams.\n",
						  qty,
						  total_weight);
	}
}
