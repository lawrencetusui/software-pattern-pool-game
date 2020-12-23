package application;

import java.awt.Color;
/**
 * A class that contains all proeprties for the cue
 * @author Lawrence
 *
 */
public class InteractiveCue {
	protected Color color;
	protected double xPosition;
	protected double yPosition;
	protected double angle;
	protected long length;
	protected long width;
	
	/**
	 * Constructor for the cue
	 * @param cyan
	 * @param xPosition
	 * @param yPosition
	 * @param angle
	 * @param length
	 * @param width
	 */
	public InteractiveCue(Color cyan, double xPosition, double yPosition, double angle, long length, long width) {
		 this.color = cyan;
		 this.xPosition = xPosition;
		 this.yPosition = yPosition;
		 this.angle = angle;
		 this.length = length;
		 this.width = width;
	}

	
	/**
	 * Get X position of the cue
	 * @return x position
	 */
	
	public double getXPosition(){
		return this.xPosition;
	}
	
	/**
	 * Get y position of the cue
	 * @return y position
	 */
	public double getYPosition(){
		return this.yPosition;
	}
	
	/**
	 * Set X position of the cue
	 * 
	 */
	public void setXPosition(double d){
		this.xPosition = d;
	}
	
	/**
	 * Set X position of the cue
	 * 
	 */
	public void setYPosition(double d){
		this.yPosition = d;
	}
	
	/**
	 * Get angle of the cue
	 * @return angle
	 */
	public double getAngle(){
		return this.angle;
	}
	
	/**
	 * Set angle of the cue
	 * 
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	/**
	 * Get the length of the cue
	 * @return the length
	 */
	public long getLength() {
		return this.length;
	}
	/**
	 * Get the width of the cue
	 * @return the width
	 */
	public long getWidth() {
		return this.width;
	}

	/**
	 * Return the cue 
	 * @return InteractiveCue
	 */
	public static InteractiveCue getcue(){
		return new InteractiveCue(Color.cyan, 0, 1, 30, 160, 30); 
	}
	
}