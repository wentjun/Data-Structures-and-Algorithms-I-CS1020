// CentredCircle class:
// Subclass of Circle
//   Instance attribute: centre

// Add import statement(s) below
import java.awt.geom.Point2D;

class CentredCircle extends Circle {

	/************* Data members **********************/
	protected Point2D.Double centre;

	/************** Constructors **********************/
	// Default constructor creates a yellow circle 
	// with radius 10.0 circle and centre at (0,0)

	public CentredCircle() {
		super("yellow", 10.0);
		centre = new Point2D.Double(0, 0);
	}

	public CentredCircle(String colour, double radius, Point2D.Double centre) {
		super(colour, radius);
		this.centre = centre;
	}

	/**************** Accessor ***********************/
	public Point2D.Double getCentre() {
		return this.centre;
	}

	/**************** Mutator ************************/
	public void setCentre(Point2D.Double centre) {
		this.centre = centre;
	}

	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		return ("[" + 
				getColour() + 
				", " + 
				getRadius() + 
				", (" +
				getCentre().getX() +
				"," +
				getCentre().getY() +
				")]");
		}

	// Overriding equals() method
	public boolean equals(Object obj) {
		if (obj instanceof CentredCircle) {
			CentredCircle circle = (CentredCircle) obj;
			return this.getColour().equals(circle.getColour()) &&
				this.getRadius() == circle.getRadius() &&
				this.getCentre().getX() == circle.getCentre().getX() &&
				this.getCentre().getY() == circle.getCentre().getY();
		}
		else
			return false; 
	}
}

