package ships;
import board.Node;

public class SlowShip extends Ship {
	private final static int _POINTS = 1;
	private final static int _MAXSPEED = 4;
		
	public SlowShip(Node location){
		super(_MAXSPEED, _POINTS);
		this.location = location;
	}
	
	public SlowShip(){
		super(_MAXSPEED, _POINTS);
	}

	@Override
	public int getMaxSpeed() {
		return 4;
	}

	@Override
	public String getType() {
		return "Slow";
	}
	
	

}
