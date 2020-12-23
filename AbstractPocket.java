package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Top level class of the pockets
 * @author Lawrence 
 */
public abstract class AbstractPocket {
	private Circle view1;
	private double pocx;
	private double pocy;
	private double pocR;

	/**
	 * Construct a Pocket object with the given parameters.
	 * @param pocx:Position X of the pocket
	 * @param pocy:Postion Y of the pocket
	 * @param pocR:Radius of the pocket
	 */

	public AbstractPocket(double pocx, double pocy, double pocR) {

		this.pocx = pocx;
		this.pocy = pocy;
		this.pocR = pocR;
		this.setView1();
	}

	/**
	 * Sets the X position of the pocket
	 * 
	 * @param pocx:
	 *            X position of the pocket
	 */

	public void setpocX(Double pocx) {
		this.pocx = pocx;
	}

	/**
	 * Gets y position of the pocket
	 * 
	 * @return: y position of the pocket
	 */

	public double getpocY() {
		return pocx;
	}

	/**
	 * Gets radius of the pocket
	 * 
	 * @return: radius of the pocket
	 */
	public double getpocR() {
		return pocR;
	}

	/**
	 * Sets the radius of the pocket
	 * 
	 * @param pocR:
	 *            radius of the pocket
	 */
	public void setpocR(Double pocR) {
		this.pocR = pocR;
	}

	/**
	 * Sets the y position of the pocket
	 * 
	 * @param pocy:
	 *            y position of the pocket
	 */

	public void setpocY(Double pocy) {
		this.pocy = pocy;
	}

	/**
	 * 
	 * @return: The view of the pocket
	 */

	public Circle getView1() {
		return view1;

	}

	/**
	 * 
	 * @return: The view1 of the pocket
	 */
	public void setView1() {
		// fixme delete System.out.println(pocx +""+ ""+pocy+""+ pocR);
		this.view1 = new Circle(this.pocx, this.pocy, this.pocR);
		view1.setFill(Color.BLACK);
	}

}
