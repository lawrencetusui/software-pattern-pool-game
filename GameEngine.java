package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.prism.paint.Color;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.util.Pair;
/**
 * The game engine class is responsible for storing game information, reading configurations,
 * as well as calculate and store ball and table properties.
 *
 */
public class GameEngine {
	private Table table;
	DecoratorInterface dtable =  getTable(); //Decorator: This helps the TableChange Decorator class
	DecoratorInterface Changetable = new TableChangeDecorator(getTable());//Decorator: This has a method that changes the behavior of the table
	// ..... ObservableList<AbstractBall> balls = ....
	private ObservableList<AbstractBall> balls = FXCollections.observableArrayList();
	private ObservableList<ComponentBall> Comballs = FXCollections.observableArrayList(); //use as composite balls
	private ObservableList<LeafBall> Leafballs = FXCollections.observableArrayList();//use as leaf balls
	public ObservableList<Pocket> pocList = FXCollections.observableArrayList();
	//	private List<Ball> balls = new ArrayList<>();
	//private List<Pockets > pocList = new ArrayList<>();
	private AbstractBall cueBall = null;
	private Pocket pocket;


	/**
	 *
	 * @return Table used in the game
	 */
	public Table getTable() {
		return table;
		
	}
	/**
	 *
	 * @return A list of balls used in the game
	 */
	public List<AbstractBall> getBalls() {
		return balls;
	}

	/**
	 * 
	 * @return A list of Pockets used in the game
	 */
	public List<Pocket> getPockets() {
		return pocList;
	}
	/**
	 * This constructor takes a filePath name and load game information
	 * stored in the given file
	 * @param filePath: file path to read configuration from
	 */
	public GameEngine(String filePath) {
		readConfig(filePath);
	}

	/**
	 * Change all balls velocity due to given table friction
	 */
	public void applyFriction() {

		AbstractBall temp;
		for(int i = 0; i < balls.size(); i++) {	// Calculate for every ball
			temp = balls.get(i);
			// Set x velocity
			if(temp.getxVelocity() > 0) {	// Positive velocity
				temp.setxVelocity(Math.max(0,temp.getxVelocity() - this.getTable().getFriction()*0.4));
			}
			else if(temp.getxVelocity() < 0){
				temp.setxVelocity(Math.min(0,temp.getxVelocity() + this.getTable().getFriction()*0.4));
			}
			// Set y velocity
			if(temp.getyVelocity() > 0) {	// Positive velocity
				temp.setyVelocity(Math.max(0,temp.getyVelocity() - this.getTable().getFriction()*0.4));
			}
			else if(temp.getyVelocity() < 0){
				temp.setyVelocity(Math.min(0,temp.getyVelocity() + this.getTable().getFriction()*0.4));
			}
		}
	}
	/**
	 * Read configuration from the given filepath and load it into GameEngine class.
	 * The actual reading of the data is delegated to respective reader and producer classes
	 * @param filePath: location of the file
	 */
	public void readConfig(String filePath) {
		// Create table reader and ball reader
		Configuration tableConf = ConfigurationProducer.getInstance().geConfiguration("TABLE");
		Configuration ballConf = ConfigurationProducer.getInstance().geConfiguration("BALL");
		//Added line to read config for Pockets
		Configuration pocketConf = ConfigurationProducer.getInstance().geConfiguration("pockets");
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(filePath));
			// convert Object to JSONObject 
			JSONObject jsonObject = (JSONObject) object;
			// reading the Table section:
			JSONObject jsonTable = (JSONObject) jsonObject.get("Table");
			// reading the "Balls" section:
			JSONObject jsonBalls = (JSONObject) jsonObject.get("Balls");
			// reading the "Balls: ball" array:
			JSONArray jsonBallsBall = (JSONArray) jsonBalls.get("ball"); 
			//For composite balls to store inside the array
			JSONArray jsonCballs = (JSONArray) jsonObject.get("balls");
			// reading from the array:
			AbstractBall temp;
			// Create ball object for every ball
			
			
			for (Object obj : jsonBallsBall) {
				
				Double mass = (Double)jsonBalls.get("mass"); //Note *1 
				JSONObject jsonBall = (JSONObject) obj;
				String colour = (String)jsonBall.get("colour");
			     temp = ballConf.getBall(jsonBall);
				
				if(colour.equalsIgnoreCase("white")) {
					
					this.cueBall = temp;
					
				}else //if (jsonBall.containsValue(mass))
                //To notify users that pool Balls are added
				System.out.println("Pool Ball with mass added");
				balls.add(temp);
								
			}
			//Extending the code like jsonBall
            JSONArray jsonPockets =  (JSONArray) jsonTable.get("pockets");
			Pocket pocTemp;
			if(jsonPockets != null) {
				for (Object obj1 : jsonPockets) {
					JSONObject jsonPocket = (JSONObject) obj1;
					System.out.print(pocketConf.getPocket(jsonPocket));
					pocTemp = pocketConf.getPocket(jsonPocket);

					this.pocket = pocTemp;

					pocList.add(pocTemp);

				}
			}
			// Create a table object
			this.table = tableConf.getTable(jsonTable);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Return the string of the Game Config
	 */
	@Override
	public String toString() {
		return "GameConfiguration [table=" + table + ", balls=" + balls + "]";
	}
	/**
	 * Returns the cueball
	 * @return Cueball
	 */
	public CueBall getCueBall() {
		return (CueBall)cueBall;
	}
    /**
     * Setter for the pocket
     * @param pocket: Pocket as an object
     */
	public void setPockets(Pocket pocket){
		this.pocket = pocket;
	}
	/**
	 * Assign the cueball
	 * @param cueBall:
	 */
	public void setCueBall(Ball cueBall) {
		this.cueBall = cueBall;
	}
	/**
	 * Update velocities of all ball by considering collisions
	 * I added physic for the the pocket 
	 */
	public void updateCollision() {
		for(int i = 0; i < this.getBalls().size(); i++) {	// Check every ball against all other balls
			AbstractBall ball1 = this.getBalls().get(i);
			AbstractBall ball2;
			Pocket poc1;
			for(int j = 0; j < this.getBalls().size(); j++) {
				if(i == j)	// Do not check a ball against itself
					continue;
				ball2 = this.getBalls().get(j);
				if(ball1.isColliding(ball2)) {					
					// Construct points to pass on to the physics engine
					Point2D posA = new Point2D(ball1.getView().getCenterX(), ball1.getView().getCenterY());
					Point2D velA = new Point2D(ball1.getxVelocity(), ball1.getyVelocity());
					double massA = ball1.getMass();

					Point2D posB = new Point2D(ball2.getView().getCenterX(), ball2.getView().getCenterY());
					Point2D velB = new Point2D(ball2.getxVelocity(), ball2.getyVelocity());
					double massB = ball2.getMass();

					// Invoke the physics engine with calculated points
					Pair<Point2D, Point2D> results = PhysicsEngine.calculateCollision(posA, velA, massA, posB, velB, massB);

					// Set velocities of colliding balls according to calculated velocity
					ball1.setxVelocity(results.getKey().getX());
					ball1.setyVelocity(results.getKey().getY());
					ball2.setxVelocity(results.getValue().getX());
					ball2.setyVelocity(results.getValue().getY());				
				}
				//Check by iterating the size of Pockets 
				for(int l = 0; l < this.getPockets().size(); l++) {
					poc1 = this.getPockets().get(l);
					ball2 = this.getBalls().get(j);
					for(int o = 0; o < this.getBalls().size(); o++) {
						ball2 = this.getBalls().get(o);
						if(l == o)	// Do not check a ball against itself
							continue;
						//Using the given function to detect collision
						if (poc1.isCollidingPocket(ball1)){
							//ball2.setMassZero(ball2); <-- Make the ball mass zero
							//balls.remove(j); <- This can remove the ball from the list 
							ball1.getView().setVisible(false);
							//Implementation of the decorator when collided with pockets
							Changetable.setfriction(table);

						}

					}
				}
			}
		}
	}

	/**
	 * Move all balls on table according to their speeds. This method does not detect to change position due to collision.
	 * Collision is handled in a seperate method with parameter of ball positions in the next frame
	 * @param tableBounds
	 */
	public void moveBalls(Bounds tableBounds) {
		AbstractBall ball;
		// Move every ball on the table
		for(int i = 0; i < this.getBalls().size(); i++) {

			ball = this.getBalls().get(i);
			ball.calculatePosition(tableBounds);
		}
	}
}

