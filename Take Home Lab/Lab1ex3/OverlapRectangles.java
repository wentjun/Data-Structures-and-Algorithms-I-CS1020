// CS1020 (AY2014/5 Semester 2)
// Take-home Lab1 Ex3
// Name: CHAN WEN TJUN
// Matric. No.: A0121262
// Lab group: 7
/* This program finds the area of overlap triangle by reading in 2 sets of
   opposite vertices from one rectangle and another 2 sets of opposite vertices
   of another rectangle. This program will always rearrange the vertices of the
   rectangles such that the first vertex represents the bottom left corner of the rectangle
   while the second vertex represents the top right corner. By comparing the differences
   in x and y coordinates from the overlap triangle, the area can be found.
 */

import java.util.*;
import java.awt.*;

public class OverlapRectangles {
	//this method rearranges the verticles of the given rectangles.
	//first verticle is minimum(xCoord, yCoord) while 
	//second verticle is maximum(xCoord, yCoord)
	private static void arrangeVertices (Point a, Point b) {
		int maxX, minX, maxY, minY;

		maxX = Math.max(a.x, b.x);
		minX = Math.min(a.x, b.x);
		maxY = Math.max(a.y, b.y);
		minY = Math.min(a.y, b.y);

		a.setLocation(minX, minY);
		b.setLocation(maxX, maxY);
	}
	//this method calculates the area of overlap rectangle.
	//By comparing the differences in x and y coordinates.
	private static int overlapArea (Point r1V1, Point r1V2,
			Point r2V1, Point r2V2) {
		int overlapX, overlapY;

		overlapX = Math.max(0, Math.min(r1V2.x, r2V2.x) -
				Math.max(r1V1.x, r2V1.x));		//if rectangle does not overlap, it will be 0. Thus the calculated overlap area will be 0 as a result.
		overlapY = Math.max(0, Math.min(r1V2.y, r2V2.y) -
				Math.max(r1V1.y, r2V1.y));		//if rectangle does not overlap, it will be 0. Thus the calculated overlap area will be 0 as a result.

		return overlapX * overlapY;
	}

	public static void main(String[] args) {
		int areaofOverlapRect;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 2 opposite vertices of 1st rectangle: ");
		Point rect1Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect1Vertex2 = new Point(sc.nextInt(), sc.nextInt());

		System.out.print("Enter 2 opposite vertices of 2nd rectangle: ");
		Point rect2Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect2Vertex2 = new Point(sc.nextInt(), sc.nextInt());

		//rearranges vertices as explained in the arrangeVertices method
		arrangeVertices(rect1Vertex1, rect1Vertex2);
		arrangeVertices(rect2Vertex1, rect2Vertex2);

		areaofOverlapRect = overlapArea(rect1Vertex1,
				rect1Vertex2,
				rect2Vertex1,
				rect2Vertex2);

		System.out.println("Overlap area = " + areaofOverlapRect);
		// For testing. Remove or comment off the statement below after testing.
		//printAllVertices(rect1Vertex1, rect1Vertex2, rect2Vertex1, rect2Vertex2);
		//
	}
}

// This method is provided for your testing.
// To print the 2 opposite vertices of each of the 2 rectangles.
/*	public static void printAllVertices(Point r1V1, Point r1V2,
	Point r2V1, Point r2V2) {
	System.out.println("1st rectangle vertex 1: " + r1V1);
	System.out.println("1st rectangle vertex 2: " + r1V2);
	System.out.println("2nd rectangle vertex 1: " + r2V1);
	System.out.println("2nd rectangle vertex 2: " + r2V2);
	}

	}
 */
