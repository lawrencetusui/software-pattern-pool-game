package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

/**
 * CompositeBall for the ball which contains other balls
 * 
 * @author Lawrence
 *
 */
public class CompositeBall extends ComponentBall {
	/**
	 * CompositeBall constructor
	 * 
	 * @param colour
	 *            of the compositeBall
	 * @param xPosition
	 *            of the compositeBall
	 * @param yPosition
	 *            of the compositeBall
	 * @param mass
	 *            of the compositeBall
	 * @param view
	 *            of the compositeBall
	 */
	public CompositeBall(String colour, double xPosition, double yPosition, double mass, Circle view) {
		super(colour, xPosition, yPosition, mass, view);
		// TODO Auto-generated constructor stub
	}

	List<ComponentBall> children;

	private double oldVX;
	private double oldVY;

	/**
	 * To move the composite ball
	 */
	@Override
	protected void move() {
		// TODO Auto-generated method stub
		this.setxPosition(this.getxPosition() + this.getxVelocity());
		this.setyPosition(this.getyPosition() + this.getyVelocity());

		for (ComponentBall child : this.children) {
			child.move();
		}
	}

	/**
	 * Split ball function
	 */
	@Override
	protected List<PoolBall> split() {

		return null;
	}

	/**
	 * Get strength
	 * 
	 * @return the strength of the ball
	 */
	private double getStrength() {
		// TODO Auto-generated method stub
		return Strength;
	}

	/**
	 * Set the children inside component Ball as an array lsit
	 * 
	 * @param children2
	 */
	public void setChildren(ArrayList<ComponentBall> children2) {
		// TODO Auto-generated method stub
		this.children = children;
	}

}
