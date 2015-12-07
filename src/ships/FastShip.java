package ships;

import board.INode;
import ships.Ship;

public class FastShip extends Ship {
	private final static int _POINTS = 1;
	private final static int _MAXSPEED = 8;
	
	@Override	
	public String getType(){ return "Fast";}
	
	@Override
	public int getMaxSpeed() {return _MAXSPEED;}
	
	public FastShip(INode location){
		super(_MAXSPEED, _POINTS);
		this.location = location;
	}
	
	public FastShip(){
		super(_MAXSPEED, _POINTS);
	}
	
	
	public int getSpeed() {
		return 8;
	}
}
