package ships;

import board.INode;
import board.Node;

public abstract class Ship implements IShip{
	private int _speed;
	private int _maxSpeed;
	private int _points;
	protected INode location;

	protected int index;
	
	public abstract int getMaxSpeed();
	public abstract String getType();
	
	public Ship(int maxSpeed, int points){
		this._maxSpeed = maxSpeed;
		this._points = points;
		roll();
	}

	public Ship(int maxSpeed, int points, INode location){
		this(maxSpeed, points);
		this.location = location;
		location.setOccupied(true);
	}

	@Override
	public int getSpeed(){
		return _speed;
	}
	
	@Override
	public int getPoints(){
		return _points;
	}
	
	@Override
	public boolean incrementable(){	return _speed < _maxSpeed; }
	
	@Override
	public boolean decrementable(){ return _speed > 1; }
	
	@Override
	public boolean movable(){return location.moveable(_speed);}

	@Override
	public int getIndex(){return index /*location.index()*/;}

	@Override
	public void setIndex(int index){this.index = index; }
	
	@Override
	public void setLocation(INode newLocation){ location = newLocation; }
	
	@Override
	public INode getNode(){ return location ; }
	
	@Override
	public boolean increment(){
		if(!incrementable())
			return false;
		_speed++;
		return true;
	}

	@Override
	public boolean decrement(){
		if(!decrementable())
			return false;
		_speed--;
		return true;
	}
	
	@Override
	public void move(){
		if(!location.moveable(_speed)){
			location = null;
			_points = 0;
		}
		else {
			location.setOccupied(false);
			System.out.println("before: " + location);
			location = location.move(_speed);
			System.out.println("After: " + location);
			location.setOccupied(true);
		
		}
	}
	
	private void roll(){
		_speed = (int)(Math.random() * _maxSpeed + 1);
	}
	
	@Override
	public String toString(){
		return getType() + ": " + getMaxSpeed();
	}
}
