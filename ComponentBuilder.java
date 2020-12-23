package application;

import org.json.simple.JSONObject;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *  Builds Component Ball from Json Config
 * @author Lawrence
 */
public class ComponentBuilder implements BallBuilder {

	private final String colour = "white";
	private double xPosition;
	private double yPosition;
	// private double mass;
	private double radius = 10.0; // Default radius 10.0cm
	private Circle view;

	@Override
	/**
	 * Auto set colour
	 */
	public void setColour(JSONObject jsonBall) {
	} // Colour has to be white

	@Override
	/**
	 * Get position X
	 * 
	 * @param JsonBall
	 */
	public void setpositionX(JSONObject jsonBall) {
		Double positionX = (Double) ((JSONObject) jsonBall.get("position")).get("x");
		this.xPosition = positionX;

	}

	@Override
	/**
	 * Get position Y
	 * 
	 * @param JsonBall
	 */
	public void setpositionY(JSONObject jsonBall) {
		Double positionY = (Double) ((JSONObject) jsonBall.get("position")).get("y");
		this.yPosition = positionY;

	}

	/**
	 * Auto Set method
	 */
	@Override
	public void setmass(JSONObject jsonBall) {

	}

	@Override
	/**
	 * Set view for the ball circle
	 * 
	 * @param: JsonBall
	 */
	public void setView(JSONObject jsonBall) {
		// System.out.println("Make c ball with position of " + xPosition +
		// ""+yPosition);
		this.view = new Circle(this.xPosition, this.yPosition, this.radius, Paint.valueOf(this.colour));

	}

	/**
	 * Returns the built cue ball object
	 */
	public ComponentBall getComponentResult() {
		return null;
	//	return new ComponentBall("white", this.xPosition, this.yPosition, this.view);
	}

	@Override

	/**
	 * Auto Set method
	 */
	public void setvelocityX(JSONObject jsonBall) {
		// TODO Auto-generated method stub

	}

	/**
	 * Auto Set method
	 */
	@Override
	public void setvelocityY(JSONObject jsonBall) {
		// TODO Auto-generated method stub

	}

	/**
	 * Auto get result
	 */
	@Override
	public AbstractBall getResult() {
		return null;
		// TODO Auto-generated method stub
	//	return new ComponentBall("white", this.xPosition, this.yPosition, this.view);
	}

}
