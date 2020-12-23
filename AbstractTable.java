package application;

import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
/**
 * Top level class of the table that can take in two conditions one with picture and one without
 * 
 *
 */
public abstract class AbstractTable  implements DecoratorInterface{
	 private Node view;
	    private Circle view1; 

	    private String colour;
	    private double friction;
	    private long x;   // x,y determine table size
	    private long y;
	    private Background bac; 
	    private double pocx;
	    private double pocy;
	    private double pocR;
	    private long XOffSet;
	    private long YOffSet;




	    /**
	     * Construct a table object with the given parameters.
	     *
	     * @param colour:   colour of the table
	     * @param friction: friction of the table
	     * @param x:        width of the table
	     * @param y:        height of the table
	     */
	

	  
	    public AbstractTable(Background bac, String colour, double friction, long x, long y, long XOffSet, long YOffSet) {
	        super();
	        this.colour=colour;
	        this.bac = bac;
	        this.friction = friction;
	        this.x = x;
	        this.y = y;
	        this.XOffSet = XOffSet;
	        this.YOffSet = YOffSet;
	        this.setView();

	    }



	  /**
	   * 
	   * @return image off set X
	   */
	    
	    public long getXOffSet() {
	        return this.XOffSet;
	    }

	    /**
		   * 
		   * @return image off set X
		   */
	    public void setXOffSet(long XOffSet){
	        this.XOffSet = XOffSet;
	    }

	
	    /**
		   * 
		   * @return image off set Y
		   */
	    public long getYOffSet() {
	        return this.YOffSet;
	    }
	    /**
		   * 
		   * @return image off set Y
		   */
	   
	    public void setYOffSet(long YOffSet){
	        this.YOffSet = YOffSet;
	    }


	    /**
	     * Return the background 
	     * @return
	     */
	
	 
	    public Background getBackground() {
	        return this.bac;
	    }

	    /**
	     * Return the background 
	     * @return
	     */
	
	    public void setBackground(Background bac){
	        this.bac = bac;
	    }

	    /**
	     * @return Colour of the table
	     */
	    public String getColour() {
	        return this.colour;
	    }

	    /**
	     * @param colour: colour of the table
	     */
	    public void setColour(String colour) {
	        this.colour = colour;
	    }

	    /**
	     * Gets friction  of the table
	     *
	     * @return friction of the table
	     */
	    public double getFriction() {
	        return friction;
	    }

	    /**
	     * Sets friction  of the table
	     *
	     * @param friction of the table
	     */
	    public void setFriction(double friction) {
	        this.friction = friction;
	    }

	    /**
	     * Gets x position of the table
	     *
	     * @return x: x position of the table
	     */
	    public long getX() {
	        return x;
	    }

	  

	    /**
	     * Sets x position of the table
	     *
	     * @param x: x position  of the table
	     */
	    public void setX(long x) {
	        this.x = x;
	    }

	  
	
	    /**
	     * Gets y position of the table
	     *
	     * @return: y position of the table
	     */
	    public long getY() {
	        return y;
	    }

	    

	    /**
	     * Sets the y position of the table
	     *
	     * @param y: y position of the table
	     */
	    public void setY(long y) {
	        this.y = y;
	    }

	    public void setpocY(Double pocy) {
	        this.pocy = pocy;
	    }
	    /**
	     * Gets the view of the table
	     *
	     * @return: view of the table
	     */
	    public Node getView() {
	        return view;
	    }
	    /**
	     * 
	     * @return the view1 as a circle
	     */
	    public Circle getView1() {
	        return view1;

	    }
	    /**
	     * Sets the view of the table as a rectangle with specified parameters
	     */
		
	    public void setView() {
	      
	        if (colour == null) {
	            this.view = new Rectangle(this.x, this.y, Paint.valueOf(String.valueOf(Color.TRANSPARENT)));
	        } else {
	            this.view = new Rectangle(this.x, this.y, Paint.valueOf(this.colour));

	        }
	    }
	    /**
	     * Sets the second view of the table as a rectangle with specified parameters
	     */
	    public void setView1() {
	        System.out.println(pocx +""+ ""+pocy+""+ pocR);
	        this.view1 = new Circle(this.pocx, this.pocy, this.pocR);
	        view1.setFill(Color.BLACK);
	    }
	    

	    /**
	     * Will return this string when called
	     */
	    @Override
	    public String toString() {
	        return "Table [colour=" + colour + ", friction=" + friction + ", x=" + x + ", y=" + y + "]";
	    }
	}

