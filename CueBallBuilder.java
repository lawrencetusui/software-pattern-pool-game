package application;

import org.json.simple.JSONObject;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
/**
 * This class carries out the steps in building a cue ball
 *
 */
public class CueBallBuilder implements BallBuilder {
	private final String colour = "white";
	private double xPosition;
	private double yPosition;
	private double xVelocity;
	private double yVelocity;
	private double mass;
	private double radius = 10.0;	// Default radius 10.0cm
	private Circle view;
	@Override
	/**
	 * Auto set Colour Method
	 */
	public void setColour(JSONObject jsonBall) {	}	// Colour has to be white
	@Override
	/**
	 * Sets the x position of the ball
	 * 
	 * @param xPosition
	 *            x position of the ball
	 */
	public void setpositionX(JSONObject jsonBall) {
		Double positionX = (Double) ((JSONObject) jsonBall.get("position")).get("x");
		this.xPosition = positionX;
		
	}
	@Override
	/**
	 * Sets the y position of the ball
	 * 
	 *            y position of the ball
	 */
	public void setpositionY(JSONObject jsonBall) {
		Double positionY = (Double) ((JSONObject) jsonBall.get("position")).get("y");
		this.yPosition = positionY;
		
	}
	@Override
	/**
	 * Sets the y Velocity of the ball
	 * 
	 *      
	 */
	public void setvelocityX(JSONObject jsonBall) {
		Double velocityX = (Double) ((JSONObject) jsonBall.get("velocity")).get("x");
		this.xVelocity = velocityX;
		
	}
	@Override
	/**
	 * Sets x Velocity of the ball
	 */
	public void setvelocityY(JSONObject jsonBall) {
		Double velocityY = (Double) ((JSONObject) jsonBall.get("velocity")).get("y");
		this.yVelocity = velocityY;
		
	}
	@Override
	/**
	 * Set mass for the ball
	 */
	public void setmass(JSONObject jsonBall) {
		Double mass = (Double)jsonBall.get("mass");
		this.mass = mass;	
	}
	/**
	 * Set view for the ball circle 
	 */
	@Override
	public void setView(JSONObject jsonBall) {
		this.view = new Circle(this.xPosition,this.yPosition,this.radius,Paint.valueOf(this.colour));
		
	}
	/**
	 * Returns the built cue ball object
	 */
	public AbstractBall getResult() {
		return new CueBall("white", this.xPosition, this.yPosition, this.xVelocity, this.yVelocity, this.mass,this.view);
	}
	
	/**
	 * Get Component Ball Result 
	 */
	@Override
	public ComponentBall getComponentResult() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
