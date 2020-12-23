package application;

import java.util.ArrayList;

public class BallCollection {
	 protected ArrayList<PoolBall> nodes = new  ArrayList<PoolBall>();

	 public void addBall(PoolBall ball) {
		 nodes.add(ball);
	 }
	 public ArrayList<PoolBall> getBalls(){
		 return nodes;
	 }
}
