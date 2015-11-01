package ships;
import board.Node;

public class Slow extends ship {
	private final static int _POINTS = 3;
	private final static int _MAXSPEED = 4;
		
	public Slow(Node location){
		super(_MAXSPEED, _POINTS);
		this.location = location;
	}
	
	public Slow(){
		super(_MAXSPEED, _POINTS);
	}
	
	

}
