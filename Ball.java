package application;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

/**
 * This is an abstract class that defines the object type ball.
 *
 */
public abstract class Ball extends AbstractBall {

	/**
	 * Constructor for the ball
	 * 
	 * @param colour
	 *            : Color of the ball
	 * @param xPosition
	 *            : X position of the ball
	 * @param yPosition
	 *            : Y position of the ball
	 * @param xVelocity
	 *            : X Velocity (speed)of the ball
	 * @param yVelocity
	 *            : Y velocity (speed) of the ball
	 * @param mass
	 *            : The mass of the ball
	 * @param view
	 *            : The javafx view of the ball
	 */
	public Ball(String colour, double xPosition, double yPosition, double xVelocity, double yVelocity, double mass,
			Circle view) {
		super(colour, xPosition, yPosition, xVelocity, yVelocity, mass, view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Second constructor for the ball
	 * 
	 * @param colour
	 *            : Color of the ball
	 * @param xPosition
	 *            : X position of the ball
	 * @param yPosition
	 *            : Y position of the ball
	 * @param mass
	 *            : The mass of the ball
	 * @param view
	 *            : The javafx view of the ball
	 */

	public Ball(String colour, double xPosition, double yPosition, double mass, Circle view) {
		super(colour, xPosition, yPosition, mass, view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calculate position of the ball in next frame, change velocity if touching
	 * wall
	 * 
	 * @param tableBounds:
	 *            boundaries of the table
	 */
	public void calculatePosition(Bounds tableBounds) {
		double x = this.getView().getCenterX();
		double y = this.getView().getCenterY();
		// Do nothing if ball at best
		if (new Double(x).equals(new Double(0)) && new Double(y).equals(new Double(0))) {
			return;
		}
		// Increase x and y velocity based on animation shows 60 frames per
		// second
		x += this.getxVelocity() / 60;
		y += this.getyVelocity() / 60;
		// Detect if balls are touching the borders
		boolean atRightBorder = x > tableBounds.getWidth() - this.getRadius();
		boolean atLeftBorder = x < tableBounds.getMinX() + this.getRadius();
		boolean atTopBorder = y < tableBounds.getMinY() + this.getRadius();
		boolean atBottomBorder = y > tableBounds.getHeight() - this.getRadius();
		if (atLeftBorder || atRightBorder) { // Left/right border
			this.setxVelocity(this.getxVelocity() * -1);
			return;
		}
		if (atTopBorder || atBottomBorder) { // Top/bottom border
			this.setyVelocity(this.getyVelocity() * -1);
			return;
		}
		// Update position of the ball
		this.getView().setCenterX(x);
		this.getView().setCenterY(y);
		this.setxPosition(x);
		this.setyPosition(y);
	}

	/**
	 * If ball will collide in the next frame
	 * 
	 * @param ball2:
	 *            ball to check collision against
	 * @return boolean denoting if balls will collide in the next frame
	 */
	public boolean isColliding(AbstractBall ball2) {
		// Create Node to represent location of the balls in the next frame and
		// check if colliion
		// will happen in next frame
		double x = this.getView().getCenterX() + this.getxVelocity() / 60;
		double y = this.getView().getCenterY() + this.getyVelocity() / 60;
		double x2 = ball2.getView().getCenterX() + ball2.getxVelocity() / 60;
		double y2 = ball2.getView().getCenterY() + ball2.getyVelocity() / 60;
		Circle temp = new Circle(x, y, this.getView().getRadius());
		Circle temp2 = new Circle(x2, y2, ball2.getView().getRadius());
		// Detect collision based on if boundaries are touching each other
		Bounds bounds = temp.getBoundsInParent();
		Bounds bounds2 = temp2.getBoundsInParent();
		return bounds.intersects(bounds2);
	}
}
