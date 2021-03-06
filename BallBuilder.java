package application;

import org.json.simple.JSONObject;
/**
 * An interface that specifies steps in building a ball
 * Added: Component Ball get component result
 */
public interface BallBuilder {
	public void setColour(JSONObject jsonBall);
	public void setpositionX(JSONObject jsonBall);
	public void setpositionY(JSONObject jsonBall);
	public void setvelocityX(JSONObject jsonBall);
	public void setvelocityY(JSONObject jsonBall);
	public void setmass(JSONObject jsonBall);
	public void setView(JSONObject jsonBall);
	public AbstractBall getResult();
	public ComponentBall getComponentResult();

}
