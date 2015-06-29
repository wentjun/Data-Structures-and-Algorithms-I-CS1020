import java.awt.*;

class CentredBall {

	/************** Data members **********************/
	private static int quantity = 0; 

	private String colour;
	private double radius;
	private Point  centre;
	private int xCoord = 0;
	private int yCoord = 0;

	/************** Constructors **********************/
	public CentredBall() {
		setColour("yellow");
		setRadius(10);;
	}

	public CentredBall(String colour, double radius, Point centre) {
		setColour(colour);
		setRadius(radius);
		centre.setLocation(0, 0);
	}

	public CentredBall(String colour, double radius, int xCoord, int yCoord) {
		setColour(colour);
		setRadius(radius);
		setXCoord(xCoord);
		setYCoord(yCoord);
	}

	/**************** Accessors ***********************/
	public String getColour() {
		return colour;
	}

	public double getRadius() {
		return radius;
	}

	public int getXCoord() {
		return xCoord;
	}

	public int getYCoord() {
		return yCoord;
	}

	/**************** Mutators ************************/
	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		return ("[colour=" + 
				getColour() + 
				", radius=" + 
				getRadius() +
				", centre=(" +
				getXCoord() +
				"," +
				getYCoord() +
				")]");
	}

	// Overriding equals() method
	public boolean equals(Object obj) {
		if (obj instanceof CentredBall) {
			CentredBall ball = (CentredBall) obj;
			return this.getColour().equals(ball.getColour()) &&
				this.getRadius() == ball.getRadius() &&
				this.getXCoord() == ball.getXCoord() &&
				this.getYCoord() == ball.getYCoord();
		}
		else
			return false;
	}
}


