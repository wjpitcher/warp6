package ships;

import board.INode;
import board.Node;

public class MediumShip extends Ship {

	private final static int _POINTS = 2;
	private final static int _MAXSPEED = 6;
		
	public MediumShip(INode location){
		super(_MAXSPEED, _POINTS);
		this.location = location;
	}
	
	public MediumShip(){
		super(_MAXSPEED, _POINTS);
	}

	@Override
	public int getMaxSpeed() {
		return _MAXSPEED;
	}

	@Override
	public String getType() {
		return "Medium";
	}
}
