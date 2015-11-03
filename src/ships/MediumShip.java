package ships;

import board.Node;

public class MediumShip extends Ship {

	private final static int _POINTS = 2;
	private final static int _MAXSPEED = 6;
		
	public MediumShip(Node location){
		super(_MAXSPEED, _POINTS);
		this.location = location;
	}
	
	public MediumShip(){
		super(_MAXSPEED, _POINTS);
	}
}
