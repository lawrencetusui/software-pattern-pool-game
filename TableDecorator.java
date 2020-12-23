package application;
/**
 * TableDecorator class that decorates the table
 * @author Lawrence
 *
 */
public abstract class TableDecorator implements DecoratorInterface {

	protected Table decoratedtable; 
	@Override
	/**
	 * Set view for decorated table
	 */
	public void setfriction(Table decoratedtable) {
		
		this.decoratedtable = decoratedtable;
	}

}
