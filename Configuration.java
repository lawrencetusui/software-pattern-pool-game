package application;

import org.json.simple.JSONObject;


/**
 * An abstract class to specify what behaviours concrete readers need to have
 *
 */

public abstract class Configuration {
	abstract AbstractBall getBall(JSONObject jsonBall);
	abstract Table getTable(JSONObject jsonTable);
	abstract Pocket getPocket(JSONObject jsonPocket);

}

