package ships;

import board.Node;
import ship.Ship;

public class FastShip extends Ship {
	private final static int _POINTS = 1;
	private final static int _MAXSPEED = 8;
		
	public FastShip(Node location){
		super(_MAXSPEED, _POINTS);
		this.location = location;
	}
	
	public FastShip(){
		super(_MAXSPEED, _POINTS);
	}
}
