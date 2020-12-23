package application;

import javafx.geometry.Bounds;
import javafx.scene.shape.Circle;

/**
 * Top level class of all balls
 * @author Lawrence 
 */
public abstract class AbstractBall {
	private Circle view;
	protected String colour;
	protected double xPosition;
	protected double yPosition;
	protected double xVelocity;
	protected double yVelocity;
	protected double mass;
	protected double radius;

	/**
	 * Construct Ball Object with given parameters
	 * 
	 * @param colour:
	 *            colour of the ball
	 * @param xPosition:
	 *            x position of the ball relative to the scene
	 * @param yPosition:
	 *            y position of the ball relative to the scene
	 * @param xVelocity:
	 *            x velocity of the ball
	 * @param yVelocity:
	 *            y velocity of the ball
	 * @param mass:
	 *            mass of the ball
	 * @param view:
	 *            stores a circle that visually represents the ball on screen
	 */
	public AbstractBall(String colour, double xPosition, double yPosition, double xVelocity, double yVelocity,
			double mass, Circle view) {
		super();
		this.colour = colour;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.mass = mass;
		this.radius = 10.0; // Default radius 10.0cm
		this.view = view;
	}

	public AbstractBall(String colour2, double xPosition2, double yPosition2, Circle view2) {
		// TODO Auto-generated constructor stub
	}

	public AbstractBall(String colour2, double xPosition2, double yPosition2, double mass2, Circle view2) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return colour of the ball
	 * 
	 * @return colour of the ball
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * Sets the colour of the abll
	 * 
	 * @param colour
	 *            colour of the ball
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * Returns the x position of the ball
	 * 
	 * @return x position of the ball
	 */
	public double getxPosition() {
		return xPosition;
	}

	/**
	 * Sets the x position of the ball
	 * 
	 * @param xPosition
	 *            x position of the ball
	 */
	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * 
	 * @return
	 */
	public double getyPosition() {
		return yPosition;
	}

	/**
	 * Sets the y position of the ball
	 * 
	 * @param yPosition:
	 *            y position of the ball
	 */
	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * Gets the x velocity of the ball
	 * 
	 * @return x velocity of the ball
	 */
	public double getxVelocity() {
		return xVelocity;
	}

	/**
	 * Sets the x velocity of the ball
	 * 
	 * @param xVelocity:
	 *            x velocity of the ball
	 */
	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	/**
	 * Gets the y velocity of the ball
	 * 
	 * @return y velocity of the ball
	 */
	public double getyVelocity() {
		return yVelocity;
	}

	/**
	 * Sets the y velocity of the ball
	 * 
	 * @param yVelocity:
	 *            y velocity of the ball
	 */
	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}

	/**
	 * Gets the mass of the ball
	 * 
	 * @return mass of the ball
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * Sets the mass of the ball
	 * 
	 * @param mass:
	 *            mass of the ball
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}

	/**
	 * Returns the radius of the ball
	 * 
	 * @return: radius of the ball
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Sets the radius of the ball
	 * 
	 * @param radius:
	 *            radius of the ball
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Returns the view of the ball
	 * 
	 * @return view: of the ball
	 */
	public Circle getView() {
		return view;
	}

	/**
	 * Sets the view of the ball
	 * 
	 * @param view:
	 *            view of the ball
	 */
	public void setView(Circle view) {
		this.view = view;
	}

	public boolean isColliding(AbstractBall ball2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void calculatePosition(Bounds tableBounds) {
		// TODO Auto-generated method stub
		
	}
}
