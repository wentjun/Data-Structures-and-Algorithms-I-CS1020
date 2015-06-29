// This program reads in 4 vertices representing the opposite vertices
// of 2 rectangles and computes the overlap area of the rectangles.
// This program uses the MyRect class.
import java.util.*;
import java.awt.*;
import java.lang.Math;

public class OverlapRectanglesV2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 2 opposite vertices of 1st rectangle: ");
		Point rect1Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect1Vertex2 = new Point(sc.nextInt(), sc.nextInt());
		MyRect rect1 = new MyRect(rect1Vertex1, rect1Vertex2);

		System.out.print("Enter 2 opposite vertices of 2nd rectangle: ");
		Point rect2Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect2Vertex2 = new Point(sc.nextInt(), sc.nextInt());
		MyRect rect2 = new MyRect(rect2Vertex1, rect2Vertex2);

		arrangeVertices(rect1);
		arrangeVertices(rect2);

		System.out.println("1st rectangle: " + rect1);
		System.out.println("2nd rectangle: " + rect2);

		if (rect1.equals(rect2))
			System.out.println("They are identical.");
		else
			System.out.println("They are not identical.");

		System.out.println("Overlap area = " + overlapArea(rect1, rect2));
	}


	// To rearrange the 2 opposite vertices of rect
	// such that the first vertex v1 becomes the bottom-left vertex
	// and the second vertex v2 becomes the top-right vertex.
	public static void arrangeVertices(MyRect rect) {
		int minX,minY,maxX,maxY;

		minX=Math.min(rect.getV1x(),rect.getV2x());
		minY=Math.min(rect.getV1y(),rect.getV2y());
		maxX=Math.max(rect.getV1x(),rect.getV2x());
		maxY=Math.max(rect.getV1y(),rect.getV2y());
		Point a = new Point();
		Point b = new Point();
		a.move(minX,minY);
		b.move(maxX,maxY);
		rect.setVertex1(a);
		rect.setVertex2(b);

	}

	// To compute the overlap area of rectangles rect1 and rect2
	public static int overlapArea(MyRect rect1, MyRect rect2) {
		int length=0, height=0;

		length = Math.min(rect1.getV2x(),rect2.getV2x())-Math.max(rect1.getV1x(),rect2.getV1x());
		height = Math.min(rect2.getV2y(),rect1.getV2y())-Math.max(rect1.getV1y(),rect2.getV1y());
		if(height>0&&length>0){
			return height*length;
		}
		else{
			return 0;
		}
	}

}

