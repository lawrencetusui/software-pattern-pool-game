package application;

import javafx.scene.shape.Circle;
/**
 * LeafBall class that extends Ball
 * @author Lawrence
 *
 */
public class LeafBall extends ComponentBall {

	/**
	 * Constructor for the LeafBall
		 * @param colour: colour of the LeafBall
	 * @param xPosition: x position of the LeafBall
	 * @param yPosition: y position of the LeafBall
	 * @param xVelocity: x velocity of the LeafBall
	 * @param yVelocity: y velocity of the LeafBall
	 * @param mass: mass of the LeafBall
	 * @param view: what is displayed visually on screen
	 */
	public LeafBall(String colour, double xPosition, double yPosition,  double mass,
			Circle view) {
		
		super(colour, xPosition, yPosition,  mass, view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void move() {
		// TODO Auto-generated method stub
		
	}
	
	
	}

