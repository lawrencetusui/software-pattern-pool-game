package application;

import org.json.simple.JSONObject;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
/**
 * This class specifies the steps in building a non-white balls for the pool game.
 *
 */
public class PoolBallBuilder implements BallBuilder {
	private String colour;
	private double xPosition;
	private double yPosition;
	private double xVelocity;
	private double yVelocity;
	private double mass;
	private double radius = 10.0;	// Default radius 10.0cm
	private Circle view;
	/**
	 * Set the colour for the poolBall
	 */
	@Override
	public void setColour(JSONObject jsonBall) {
		String colour = (String)jsonBall.get("colour");
		this.colour = colour;
	}
	/**
	 * Set position X of the poolball
	 */
	@Override
	public void setpositionX(JSONObject jsonBall) {
		Double positionX = (Double) ((JSONObject) jsonBall.get("position")).get("x");
		this.xPosition = positionX;
		
	}
	/**
	 * Set position Y of the poolball
	 */
	@Override
	public void setpositionY(JSONObject jsonBall) {
		Double positionY = (Double) ((JSONObject) jsonBall.get("position")).get("y");
		this.yPosition = positionY;
		
	}
	/**
	 * Set velocity X of the poolball
	 */
	@Override
	public void setvelocityX(JSONObject jsonBall) {
		Double velocityX = (Double) ((JSONObject) jsonBall.get("velocity")).get("x");
		this.xVelocity = velocityX;
		
	}
	/**
	 * Set velocity Y of the poolball
	 */
	@Override
	public void setvelocityY(JSONObject jsonBall) {
		Double velocityY = (Double) ((JSONObject) jsonBall.get("velocity")).get("y");
		this.yVelocity = velocityY;
		
	}
	/**
	 * Set the Mass of the poolball
	 */
	@Override
	public void setmass(JSONObject jsonBall) {
		Double mass = (Double)jsonBall.get("mass");
		this.mass = mass;	
	}
	
	/**
	 * Set the view of the poolball as a circle
	 */
	@Override
	public void setView(JSONObject jsonBall) {
		this.view = new Circle(this.xPosition,this.yPosition,this.radius,Paint.valueOf(this.colour));
		
	}
	
	/**
	 * Return the finished ball object
	 */
	public AbstractBall getResult() {
		return new PoolBall(this.colour, this.xPosition, this.yPosition, this.xVelocity, this.yVelocity, this.mass,this.view);
	}
	/**
	 * Stub implementation
	 */
	@Override
	public ComponentBall getComponentResult() {
		// TODO Auto-generated method stub
		return null;
	}
}
