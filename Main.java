package application;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

/**
 * This class has the responsibility to handle user input(mouse events),
 * constructs game, and calculate and update game data by delegating the task to game engine methods.
 *
 */
public class Main extends Application {
	public static String filePath = null;
	protected static boolean dragged = false;
	
	//implementcue stick
	static Ellipse cueStick;
	static boolean usingCueStick;
	static Rotate cueRotate;
	
	
	/**
	 * Create the content to be displayed in the stage. Delegates hitting cue ball and
	 * update on balls to respective Event Handlers and methods
	 * @param filePath: where to read file
	 * @return: built scene with all the information specified in filePath
	 */
	
	DoubleProperty event_position_x  =  new SimpleDoubleProperty() ;
	   DoubleProperty event_position_y  =  new SimpleDoubleProperty() ;
	   
	 

	private Parent createContent(String filePath) {
		GameEngine config = new GameEngine(filePath);
		Pane root = new Pane();
		
		InteractiveCue cue = InteractiveCue.getcue();
		cueRotate = new Rotate();
		cueStick = new Ellipse(cue.getXPosition(), cue.getYPosition(), cue.getLength(), cue.getWidth());
		cueRotate.setAngle(cue.getAngle());
		cueStick.getTransforms().add(cueRotate);
		root.getChildren().add(cueStick);
		
		root.setPrefSize(config.getTable().getX(),config.getTable().getY());
	

		
		// Handles mouse-clicking
		EventHandler<MouseEvent> clickHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(config.getCueBall().atRest() && !config.getCueBall().isSelected()) { 	// If at rest and not selected already
					config.getCueBall().setSelected(true);
					// Create and display visual cue InteractiveCueStick
					Rectangle rect = new Rectangle(e.getX(), e.getY(), 20,20);
					rect.setFill(Color.BROWN);
					root.getChildren().add(rect);
					
					// Allows dragging only when cueball selected
					rect.setOnMouseDragged(new EventHandler<MouseEvent>() {	
						@Override
						// On drag, visually relocate the rect and listen for mouse button release
						public void handle(MouseEvent event) {
							if(config.getCueBall().isSelected()) {
								rect.relocate(event.getSceneX(), event.getSceneY());
								boolean dragged = true;
								rect.setOnMouseReleased(new EventHandler<MouseEvent>(){
									@Override
									public void handle(MouseEvent event) {
										// If cueball is selected, and cueInteractiveCueStick was dragged after selection, register a shot
										if(config.getCueBall().isSelected() && dragged) { 
											config.getCueBall().registerShot(event.getSceneX(), event.getSceneY());
											config.getCueBall().setSelected(false);
											Main.dragged = false;
											
											
											
											root.getChildren().remove(rect);
										}
									}
								});
							}
						}
					});
				}
			}
		};
		
		
		/*
		 * Allows the the interactive stick to move with the mouse
		 */
		  event_position_x.addListener(

			         ( observable_value, value, new_value ) ->
			         {
			        	 cueStick.setCenterX( new_value.doubleValue() +185) ;

			        	
			                     }
			         
			      ) ;

			      event_position_y.addListener(

			         ( observable_value, value, new_value ) ->
			         {
			        	 cueStick.setCenterY( new_value.doubleValue() -270) ;

			           	         }
			         
			      ) ;
			      root.setOnMouseMoved( ( MouseEvent event ) ->
			      {
			         event_position_x.setValue( event.getSceneX() ) ;
			         event_position_y.setValue( event.getSceneY() ) ;
			         cueStick.setRotate(20);
			      } ) ;

			     
			      root.setOnMouseDragged( ( MouseEvent event ) ->
			      {
			         event_position_x.setValue( event.getSceneX() ) ;
			         event_position_y.setValue( event.getSceneY() ) ;
			         cueStick.setRotate(0);
			      } ) ;

			   
		
		root.getChildren().add(config.getTable().getView()); 

		root.setBackground(config.getTable().getBackground()); 

		//Iterate through Pocket to create config.getPockest 
		for(Pocket g : config.getPockets()){ 
			//Get view1 to get javafx pocket circle 
			root.getChildren().add(g.getView1());
		}

		for(AbstractBall i : config.getBalls()) {
			//System.out.println("THe ball is " +i);
			Circle v = i.getView();
			System.out.println(v);
			root.getChildren().add(v);
			if(i.getColour().equals("white")) {
				i.getView().addEventHandler(MouseEvent.MOUSE_CLICKED, clickHandler);
			}
		}

		Button quit = new ResetButton("Click to quit/restore state?");
		root.getChildren().add(quit);

		Bounds Frame = new BoundingBox( 
				config.getTable().getXOffSet()
				,config.getTable().getYOffSet()
				,config.getTable().getX() + config.getTable().getXOffSet()
				,config.getTable().getY()+ config.getTable().getYOffSet());
		

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				config.applyFriction();

				
				config.updateCollision();
			
				config.moveBalls(Frame);
			}

		};
		timer.start();

		return root;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(createContent(filePath));
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Display graphic user interface and delegate handling responsibilities to respective methods
	 * @param args: file path
	 */
	public static void main(String[] args) {
		try {
		
		
			filePath = "src/application/Config.json";
			//filePath = "src/application/Stage_2_example.json";
			launch(args);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("No filepath specified");
		}
		
	}
}