package application;

import java.util.List;

import javafx.scene.shape.Circle;
/**
 * ComponentBall that can contain other balls and extends to abstractball
 * @author Lawrence
 *
 */
public abstract class ComponentBall extends PoolBall {
/**
 *  Constructor 1
	 * @param colour : Color of the ball
	 * @param xPosition : X position of the ball
	 * @param yPosition : Y position of the ball
 * @param mass 
	 * @param view : The javafx view of the ball
 */
	Double Strength;
	public ComponentBall(String colour, double xPosition, double yPosition, 
		 double mass, Circle view) {
		super(colour, xPosition, yPosition,  yPosition, yPosition, yPosition, view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Stub implementation
	 */
	protected abstract void move();
	/**
	 * For balls to split
	 * @return
	 */
	protected List<PoolBall> split() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * set strength of the Component ball
	 * @param strength of the Component ball
	 */
	public void setStrength(Double strength) {
		this.Strength = strength;
		// TODO Auto-generated method stub
		
	}
	
}
