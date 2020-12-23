package application;

import java.util.HashMap;

import org.json.simple.JSONObject;

/**
 * This class has the responsibility to build balls.
 *
 */
public class BallConfiguration extends Configuration {
	BallDirector director = new BallDirector();

	@Override
	/**
	 * Based on the passed information, this method delegates the ball building
	 * task to respective builder class
	 * 
	 * @param: json
	 *             **Ball config has three parts: One is cue ball, one is normal
	 *             ball, one is component ball that include other balls and leaf
	 *             ball which doesnt contain other balls with 4 different ways
	 *             to define them
	 * 
	 */
	public AbstractBall getBall(JSONObject jsonBall) {
		BallBuilder builder = null;
		String colour = (String) jsonBall.get("colour"); // Get bakk
		Double mass = (Double) jsonBall.get("mass");
		// jsonBall.get(mass);
		// System.out.println(mass);
		// System.out.print(jsonBall.containsValue(mass));
		// Double Cmass = (Double) ((JSONObject)
		// jsonBall.get("balls")).get("mass");

		// This line is changed to suit the json file in order to create the cue
		// ball
		if (colour.equalsIgnoreCase("white")) {
			System.out.println("White ball");
			builder = new CueBallBuilder();
			director.constructCueBall(builder, jsonBall);
			return builder.getResult();
		}
		// For containing the mass means it's a compsosite which can't be a
		// component ball Note *1
		else if (jsonBall.containsValue(mass)) {
			System.out.println("Normal Pool ball");
			builder = new PoolBallBuilder();
			director.constructTargetBall(builder, jsonBall);
			return builder.getResult();
		} else {
			/*
			 * Build composite balls if the values (ie mass ) is found
			 */
			// Double Cmass = (Double) ((JSONObject)
			// jsonBall.get("balls")).get("mass");
			// Double Cmass = (Double) ((HashMap<?, ?>)
			// jsonBall.get("balls")).get("mass");
			// String color = (String) ((JSONObject)
			// jsonBall.get("balls")).get("colour");
			// System.out.println("Components color" + Cmass);
			System.out.println("Component ball" + jsonBall);
			builder = new ComponentBuilder();

			director.constructComponentBall(builder, jsonBall);
			return builder.getResult();

		}

	}

	@Override
	/**
	 * Stub implementation. This class does not build tables
	 */
	public Table getTable(JSONObject jsonTable) {
		return null;
	}

	/**
	 * Stub implementation. This class does not build pockets
	 */
	@Override
	Pocket getPocket(JSONObject jsonPocket) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Stub implementation. This class does not build cuesticks
	 */
	
	

}
