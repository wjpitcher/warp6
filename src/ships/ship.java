package ships;

import board.Node;

public class Ship {
	private int _speed;
	private int _maxSpeed;
	private int _points;
	protected Node location;

	public Ship(int maxSpeed, int points){
		this._maxSpeed = maxSpeed;
		this._points = points;
		roll();
	}

	public Ship(int maxSpeed, int points, Node location){
		this(maxSpeed, points);
		this.location = location;
	}

	public int getSpeed(){
		return _speed;
	}
	
	public int getPoints(){
		return _points;
	}
	
	public boolean incrementable(){	return _speed < _maxSpeed; }
	public boolean decrementable(){ return _speed > 1; }
	
	public boolean movable(){return location.moveable(_speed);}

	public int getIndex(){return location.index();}
	public boolean increment(){
		if(!incrementable())
			return false;
		_speed++;
		return true;
	}

	public boolean decrement(){
		if(!decrementable())
			return false;
		_speed--;
		return true;
	}
	
	public void move(){
		if(!location.moveable(_speed)){
			location = null;
			_points = 0;
		}
		else 
			location = location.move(_speed);
	}
	
	private void roll(){
		_speed = (int)(Math.random() * _maxSpeed + 1);
	}
}
