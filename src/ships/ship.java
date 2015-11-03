package ships;

import board.Node;

public class Ship {
	private int speed;
	private int maxSpeed;
	private int points;
	protected Node location;

	public Ship(int maxSpeed, int points){
		this.maxSpeed = maxSpeed;
		this.points = points;
		roll();
	}

	public Ship(int maxSpeed, int points, Node location){
		this(maxSpeed, points);
		this.location = location;
	}

	public int getSpeed(){
		return speed;
	}
	
	public int getPoints(){
		return points;
	}
	
	public int getIndex(){
		return location.index();
	}
	
	public boolean movable() {return location.moveable(speed);}
	public boolean incrementable(){	return speed < maxSpeed; }
	public boolean decrementable(){ return speed > 1; }
	
	public boolean movable(){return location.moveable(speed);}

	public int getIndex(){return location.index();}
	public boolean increment(){
		if(!incrementable())
			return false;
		speed++;
		return true;
	}

	public boolean decrement(){
		if(!decrementable())
			return false;
		speed--;
		return true;
	}
	
	public void move(){
		if(!location.moveable(speed)){
			location = null;
			points = 0;
		}
		else 
			location = location.move(speed);

	}
	
	private void roll(){
		speed = (int)(Math.random() * maxSpeed + 1);
	}
	
	
}
