// MyRect class
import java.awt.*;
import java.util.*;

class MyRect {

	/************** Data members **********************/
	private Point vertex1, vertex2;

	/************** Constructors **********************/

	public MyRect() {
		this(0, 0, 1, 1); //Default rectangle with vertices (0,0) and (1,1)
	}

	public MyRect(Point v1, Point v2) {
		setVertex1(new Point(v1));
		setVertex2(new Point(v2));
	}

	public MyRect(int v1X, int v1Y, int v2X, int v2Y) {
		setVertex1(new Point(v1X, v1Y));
		setVertex2(new Point(v2X, v2Y));
	}

	/**************** Accessors ***********************/
	public Point getVertex1() {
		return vertex1;
	}

	public Point getVertex2() {
		return vertex2;
	}

	public int getV1x(){
		return vertex1.x;
	}

	public int getV1y(){
		return vertex1.y;
	}

	public int getV2x(){
		return vertex2.x;
	}

	public int getV2y() {
		return vertex2.y;
	}

	/**************** Mutators ************************/
	public void setVertex1(Point pt) {
		vertex1 = pt;
	}

	public void setVertex2(Point pt) {
		vertex2 = pt;
	}

	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		return "[(" + getVertex1().x + ", " + getVertex1().y + "); " +
			"(" + getVertex2().x + ", " + getVertex2().y + ")]";
	}

	// Overriding equals() method
	public boolean equals(Object obj) {
		if (obj instanceof MyRect) {
			MyRect rect = (MyRect) obj;
			return this.getVertex1().equals(rect.getVertex1()) &&
				this.getVertex2().equals(rect.getVertex2());
		}
		else
			return false;
	}
}

