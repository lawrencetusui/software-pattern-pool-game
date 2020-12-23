package application;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Pocket class that extends to AbstractPocket
 * 
 * @author Lawrence
 *
 */
public class Pocket extends AbstractPocket {

	/**
	 * Construct a Pocket object with the given parameters.
	 * 
	 * @param pocx:Position
	 *            X of the pocket
	 * @param pocy:Postion
	 *            Y of the pocket
	 * @param pocR:Radius
	 *            of the pocket
	 */
	public Pocket(double pocx, double pocy, double pocR) {
		super(pocx, pocy, pocR);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calculate Position for pockets
	 * 
	 * @param tableBounds
	 */
	public void calculatePosition(Bounds tableBounds) { // FIXME PROBABLY DONT
														// NEED
		double x = this.getView1().getCenterX();
		double y = this.getView1().getCenterY();
		// Do nothing if ball at best
		if (new Double(x).equals(new Double(0)) && new Double(y).equals(new Double(0))) {
			return;
		}
	}

	/**
	 * Check is pocket collides
	 * 
	 * @param ball1
	 * @return
	 */
	public boolean isCollidingPocket(AbstractBall ball1) {
		// Create Node to represent location of the balls in the next frame and
		// check if colliion
		// will happen in next frame
		double x = this.getView1().getCenterX();
		// System.out.println("The Pockets X is "+ x );
		double y = this.getView1().getCenterY();
		// System.out.println("The Pockets Y is "+ y );
		double x2 = ball1.getView().getCenterX() + ball1.getxVelocity() / 60;
		// System.out.println("The ball2 X is "+ x2 );
		double y2 = ball1.getView().getCenterY() + ball1.getyVelocity() / 60;
		// System.out.println("The ball2 Y is "+ y2 );
		Circle temp = new Circle(x, y, this.getView1().getRadius());

		Circle temp2 = new Circle(x2, y2, ball1.getView().getRadius());
		// Detect collision based on if boundaries are touching each other
		Bounds bounds = temp.getBoundsInParent();
		Bounds bounds2 = temp2.getBoundsInParent();
		// ball2.setMassZero(ball2);
		if (bounds.intersects(bounds2))

			return true;

		else
			return false;
	}

}