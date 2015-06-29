import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class TriangleCentroid {

	// Returns the centroid of a triangle with 
	// 3 verticles v1, v2 and v3
	public static Point2D.Double centroid(Point v1, Point v2, Point v3) {
		double x1, y1; //x and y coordinates of centroidCoord

		x1 = ((double)(v1.x + v2.x + v3.x)) / 3.0;
		y1 = ((double)(v1.y + v2.y + v3.y)) / 3.0;

		//coordinates of centroid
		Point2D.Double centroidCoord = new Point2D.Double(x1, y1);
	
		return centroidCoord;
	}

	public static void main(String[] args) {
		int x1, y1;   //x and y coordinates of v1
		int x2, y2;   //x and y coordinates of v2
		int x3, y3;   //x and y coordinates of v3

		Scanner sc = new Scanner(System.in);

		//input of coordinates of v1,v2,v3
		System.out.print("Enter 3 vertices: ");
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		x3 = sc.nextInt();
		y3 = sc.nextInt();
		
		Point v1 = new Point(x1, y1);
		Point v2 = new Point(x2, y2);
		Point v3 = new Point(x3, y3);

		System.out.println("Centroid at " + centroid(v1, v2, v3));
	}
}
