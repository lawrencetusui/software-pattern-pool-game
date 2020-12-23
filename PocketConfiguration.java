package application;

import org.json.simple.JSONObject;
/**
 * Get Pocket configuration  
 * @author Lawrence
 *
 */
public class PocketConfiguration extends Configuration {

	/**
	 * Stub implementation. This class does not build tables
	 */
    @Override
    AbstractBall getBall(JSONObject jsonBall) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
	 * Stub implementation. This class does not build tables
	 */
    @Override
    Table getTable(JSONObject jsonTable) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Implementation for get pockets and access from json file 
     */
    @Override
    Pocket getPocket(JSONObject jsonPocket) {
        // TODO Auto-generated method stub
        Double pocketPosX = (Double) ((JSONObject) jsonPocket.get("position")).get("x");
        Double pocketPosY = (Double) ((JSONObject) jsonPocket.get("position")).get("y");
        Double pocketRadius = (Double)jsonPocket.get("radius");
        System.out.println("Pockets are made at POSX"+pocketPosX+""+ pocketPosY+""+ pocketRadius); //
        //	Double pocketPosX = (Double)  ((HashMap) ((JSONObject) jsonPocket.get("pockets")).get("position")).get("x");

        //	Double pocketPosY = (Double) ((JSONObject) ((HashMap<?, ?>) jsonPocket.get("pockets")).get("position")).get("y");
        //	Double pocketRadius = (Double) ((HashMap<?, ?>) jsonPocket.get("pockets")).get("radius");
        //Read pocket
        return new Pocket(pocketPosX, pocketPosY, pocketRadius);

    }
  
}
