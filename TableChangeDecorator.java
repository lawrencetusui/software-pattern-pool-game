package application;
/**
 * Decorator class that changes friction
 * @author Lawrence
 *
 */
public class TableChangeDecorator extends TableDecorator{

	/**
	 * Constructor 
	 * @param table 
	 */
	 public TableChangeDecorator(Table table) {
	      super();		
	   }
	 /**
	  * The method that changes friction
	  * @param table
	  */

	
	@Override
	public void setfriction(Table decoratedtable) {
		double friction = decoratedtable.getFriction();
		  double updatedfriction = friction +0.001;
		  decoratedtable.setFriction(updatedfriction);
		
	}
}
