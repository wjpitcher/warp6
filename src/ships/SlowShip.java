package ships;
import board.INode;

public class SlowShip extends Ship {
	private final static int _POINTS = 1;
	private final static int _MAXSPEED = 4;
		
	public SlowShip(INode location){
		super(_MAXSPEED, _POINTS);
		this.location = location;
	}
	
	public SlowShip(){
		super(_MAXSPEED, _POINTS);
	}

	@Override
	public int getMaxSpeed() {
		return _MAXSPEED;
	}

	@Override
	public String getType() {
		return "Slow";
	}
	
	

}
