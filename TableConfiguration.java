package application;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.json.simple.JSONObject;

/**
 * This class constructs Table objects.
 *
 */
public class TableConfiguration extends Configuration{

	@Override
	public AbstractBall getBall(JSONObject jsonBall) {
		return null;
	}

	/**
	 * Get table object reading from json config
	 */
	@Override
	public Table getTable(JSONObject jsonTable) {
		Background myBackground; 
		// reading values from the JSON table object
		String tableColour = (String) jsonTable.get("colour");
		Long tableX = (Long) ((JSONObject) jsonTable.get("size")).get("x");
		Long tableY = (Long) ((JSONObject) jsonTable.get("size")).get("y");
		Double tableFriction = (Double) jsonTable.get("friction");

		JSONObject jsonTableImage = (JSONObject) jsonTable.get("image");
	JSONObject jsonTableOffset = (JSONObject) jsonTableImage.get("offset");
		Long imageOffsetX = (Long) jsonTableOffset.get("x");
		Long imageOffsetY = (Long) jsonTableOffset.get("y");
		//This makes sure that there is colour or image
		if(tableColour==null){
			
			myBackground=imageBackground(jsonTableImage);
			return new Table(myBackground,null,tableFriction,tableX,tableY,imageOffsetX,imageOffsetY);		
		}	
		return new Table(null,tableColour,tableFriction,tableX,tableY, 0,0);
	}

	/**
	 * Stub implementation.This class does not build pocket
	 */
	@Override
	public Pocket getPocket(JSONObject jsonPocket) {
		return null;
	}

	/**
	 * Assist to set up the image
	 * @param jsonTableImage
	 * @return back the background image 
	 */
	
	public Background imageBackground(JSONObject jsonTableImage){
	
		String path = (String) jsonTableImage.get("path");
	
		JSONObject jsonTableImageSize = (JSONObject) jsonTableImage.get("size");
		Long imageSizeX = (Long) jsonTableImageSize.get("x");
		Long imageSizeY = (Long) jsonTableImageSize.get("y");
		
		Image img = new Image(path,Math.toIntExact(imageSizeX),Math.toIntExact(imageSizeY),false,false);

		return new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT
				, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT));

	}



}
